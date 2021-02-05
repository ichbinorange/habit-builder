package com.capstone.habitbuilder.enjoyer;

import com.capstone.habitbuilder.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class EnjoyerService {
    private final EnjoyerRepository enjoyerRepository;
    private final HabitService habitService;

    @Autowired
    public EnjoyerService(EnjoyerRepository enjoyerRepository, HabitService habitService) {
        this.enjoyerRepository = enjoyerRepository;
        this.habitService = habitService;
    }

    // show
    public Enjoyer showEnjoyer(Long enjoyerId)  {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        return enjoyer;
    }

    // Update
    @Transactional
    public void updateEnjoyer(Long enjoyerId, Enjoyer enjoyer) {
        Enjoyer checkEnjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));

        if (checkEnjoyer.getEmail().equals(habitService.authenticateUser())) {
            if (enjoyer.getName() != null && enjoyer.getName().length() > 0) {
                enjoyer.setName(enjoyer.getName());
            }
            if (enjoyer.getAbout() != null && enjoyer.getAbout().length() > 0) {
                enjoyer.setAbout(enjoyer.getAbout());
            }
            if (enjoyer.getImageUrl() != null && enjoyer.getImageUrl().length() > 0) {
                enjoyer.setImageUrl(enjoyer.getImageUrl());
            }
            enjoyerRepository.save(enjoyer);
        } else {
            throw new IllegalStateException(
                "EnjoyerId" + enjoyerId + " is not equal to Authenticated enjoyerId" + habitService.authenticateUser());
        }

    }

    // Delete
    public void deleteEnjoyer(Long enjoyerId) {
        Enjoyer checkEnjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        if (checkEnjoyer.getEmail().equals(habitService.authenticateUser())) {
            enjoyerRepository.deleteById(enjoyerId);
        } else {
            throw new IllegalStateException(
                    "EnjoyerId" + enjoyerId + " is not equal to Authenticated enjoyerId" + habitService.authenticateUser());
        }
    }
}
