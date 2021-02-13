package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import com.capstone.habitbuilder.habit.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository, EnjoyerRepository enjoyerRepository) {
        this.friendshipRepository = friendshipRepository;
        this.enjoyerRepository = enjoyerRepository;
    }

    // index
    public Map<String, ArrayList<Friendship>> getFriendships(Long enjoyerId) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        ArrayList<Friendship> requesterList = friendshipRepository.findByRequesterId(enjoyerId);
        ArrayList<Friendship> receiverList = friendshipRepository.findByReceiverId(enjoyerId);

        Map<String,ArrayList<Friendship>> map = new HashMap();
        map.put("requester", requesterList);
        map.put("receiver", receiverList);

        return map;
    }

    // show - may need to delete due to not necessary for friendship
    public Friendship showFriendship(Long friendshipId)  {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalStateException(
                        "friendship with id " + friendshipId + " does not exists"
                ));
        return friendship;
    }

    // Create - for requester
    public void addNewFriendship(Long requesterId, Long receiverId) {
        Enjoyer requester = enjoyerRepository.findById(requesterId)
                .orElseThrow(() -> new IllegalStateException(
                        "Requester with enjoyer id " + requesterId + " does not exists"
                ));
        Enjoyer receiver = enjoyerRepository.findById(receiverId)
                .orElseThrow(() -> new IllegalStateException(
                        "Requester with enjoyer id " + receiverId + " does not exists"
                ));
        Optional<Friendship> friendshipOptional1 = friendshipRepository.findByRequesterAndReceiver(requester, receiver);
        Optional<Friendship> friendshipOptional2 = friendshipRepository.findByRequesterAndReceiver(receiver, requester);
        if (friendshipOptional1.isPresent()) {
            if (friendshipOptional1.get().getActivated()) {
                throw new IllegalStateException("You two are friends already!");
            } else {
                throw new IllegalStateException("Wait for your friend to accept your request");
            }
        } else if (friendshipOptional2.isPresent()) {
            if (friendshipOptional2.get().getActivated()) {
                throw new IllegalStateException("You two are friends already!");
            } else {
                throw new IllegalStateException("Wait for your friend to accept your request");
            }
        }

        Friendship friendship = new Friendship();
        friendship.setRequester(requester);
        friendship.setReceiver(receiver);
        friendshipRepository.save(friendship);
    }

    // Update - for receiver
    @Transactional
    public void activateFriendship(Long friendshipId, Long receiverId) {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalStateException(
                        "friendship with id " + friendshipId + " does not exists"
                ));
        Enjoyer receiver = enjoyerRepository.findById(receiverId)
                .orElseThrow(() -> new IllegalStateException(
                        "Requester with enjoyer id " + receiverId + " does not exists"
                ));
        if (friendship.getReceiver().getId() != receiverId) {
            throw new IllegalStateException("You're not this friendship's receiver and can't do confirm action.");
        } else {
            if (friendship.getActivated()) {
                throw new IllegalStateException("You two are friends already!");
            } else {
                friendship.setActivated(true);
                friendshipRepository.save(friendship);
            }
        }
    }

    // Delete - for both requester and receiver
    public void deleteFriendship(Long friendshipId) {
        boolean exists = friendshipRepository.existsById(friendshipId);
        if (!exists) {
            throw new IllegalStateException(
                    "friendship with id " + friendshipId + " does not exists");
        }
        friendshipRepository.deleteById(friendshipId);
    }
}
