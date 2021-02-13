package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path="/friendship")
public class FriendshipController {
    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    // Index - all friends for a user
    @GetMapping(path="{enjoyerId}")
    public Map<String, ArrayList<Friendship>> getFriendships(@PathVariable("enjoyerId") Long enjoyerId) {
        return friendshipService.getFriendships(enjoyerId);
    }

    // Show - may need to delete due to not necessary for friendship
//    @GetMapping(path = "{friendshipId}")
//    public Friendship showFriendship(@PathVariable("friendshipId") Long friendshipId) {
//        return friendshipService.showFriendship(friendshipId);
//    }

    // Create - for requester
    @PostMapping(path = "requester/{requesterId}/receiver/{receiverId}")
    public void registerNewFriendship(@PathVariable("requesterId") Long requesterId,
                                      @PathVariable("receiverId") Long receiverId) {
        friendshipService.addNewFriendship(requesterId, receiverId);
    }

    // Update - for receiver
    @PutMapping(path = "{friendshipId}/receiver/{receiverId}")
    public void activateFriendship(@PathVariable("friendshipId") Long friendshipId,
                                   @PathVariable("receiverId") Long receiverId) {
        friendshipService.activateFriendship(friendshipId, receiverId);
    }

    // Delete - for both requester and receiver
    @DeleteMapping(path = "{friendshipId}")
    public void deleteFriendship(@PathVariable("friendshipId") Long friendshipId) {
        friendshipService.deleteFriendship(friendshipId);
    }
}
