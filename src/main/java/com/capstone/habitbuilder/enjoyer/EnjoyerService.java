package com.capstone.habitbuilder.enjoyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class EnjoyerService {
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public EnjoyerService(EnjoyerRepository enjoyerRepository) {
        this.enjoyerRepository = enjoyerRepository;
    }

    // index - need to delete due to not necessary for enjoyer
    public Iterable<Enjoyer> getEnjoyers() {
        return enjoyerRepository.findAll();
    }

    // show
    public Enjoyer showEnjoyer(Long enjoyerId)  {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        return enjoyer;
    }

    // Create
    public void addNewEnjoyer(Enjoyer enjoyer) {
        Optional<Enjoyer> enjoyerOptional = enjoyerRepository.findEnjoyerByEmail(enjoyer.getEmail());
        if (enjoyerOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        enjoyerRepository.save(enjoyer);
    }

    // Update
    @Transactional
    public void updateEnjoyer(Long enjoyerId,
                              String name,
                              String imageUrl,
                              String about) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(enjoyer.getName(), name)) {
            enjoyer.setName(name);
        }
        if (about != null && about.length() > 0 ) {
            enjoyer.setAbout(about);
        }
        enjoyer.setImageUrl(imageUrl);
        enjoyerRepository.save(enjoyer);
    }

    // Delete
    public void deleteEnjoyer(Long enjoyerId) {
        boolean exists = enjoyerRepository.existsById(enjoyerId);
        if (!exists) {
            throw new IllegalStateException(
                    "enjoyer with id " + enjoyerId + " does not exists");
        }
        enjoyerRepository.deleteById(enjoyerId);
    }
}
