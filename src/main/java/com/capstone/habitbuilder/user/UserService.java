package com.capstone.habitbuilder.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // index - need to delete due to not necessary for user
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    // show
    public User showUser(Long userId)  {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exists"
                ));
        return user;
    }

    // Create
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        user.setCreatedDate(LocalDateTime.now());
        user.setUpdatedDate(LocalDateTime.now());
        userRepository.save(user);
    }

    // Update
    @Transactional
    public void updateUser(Long userId,
                           String name,
                            String photoUrl,
                            String about) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exists"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }
        if (about != null && about.length() > 0 ) {
            user.setAbout(about);
        }
        user.setPhotoUrl(photoUrl);
        user.setUpdatedDate(LocalDateTime.now());
        userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }
}
