package com.capstone.habitbuilder.friendship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    // index - need to delete due to not necessary for friendship
    public Iterable<Friendship> getFriendships() {
        return friendshipRepository.findAll();
    }

    // show
    public Friendship showFriendship(Long friendshipId)  {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalStateException(
                        "friendship with id " + friendshipId + " does not exists"
                ));
        return friendship;
    }

    // Create
    public void addNewFriendship(Friendship friendship) {
        // Need to re-write the friendship checkout method
        Optional<Friendship> requesterIdOptional1 = friendshipRepository.findEnjoyerByRequester(friendship.getRequester());
        Optional<Friendship> receiverIdOptional1 = friendshipRepository.findEnjoyerByReceiver(friendship.getReceiver());
        if (requesterIdOptional1.isPresent() && receiverIdOptional1.isPresent()) {
            throw new IllegalStateException("You two are friends already!");
        }
        Optional<Friendship> requesterIdOptional2 = friendshipRepository.findEnjoyerByRequester(friendship.getReceiver());
        Optional<Friendship> receiverIdOptional2 = friendshipRepository.findEnjoyerByReceiver(friendship.getRequester());
        if (requesterIdOptional2.isPresent() && receiverIdOptional2.isPresent()) {
            throw new IllegalStateException("You two are friends already!");
        }
        friendship.setActivated(true);
        friendshipRepository.save(friendship);
    }

    // Delete
    public void deleteFriendship(Long friendshipId) {
        boolean exists = friendshipRepository.existsById(friendshipId);
        if (!exists) {
            throw new IllegalStateException(
                    "friendship with id " + friendshipId + " does not exists");
        }
        friendshipRepository.deleteById(friendshipId);
    }
}
