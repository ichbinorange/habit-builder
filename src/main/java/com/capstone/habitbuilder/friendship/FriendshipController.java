package com.capstone.habitbuilder.friendship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/friendship")
public class FriendshipController {
    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    // Index - need to delete due to not necessary for enjoyer
    @GetMapping
    public Iterable<Friendship> getFriendships() {
        return friendshipService.getFriendships();
    }

    // Show
    @GetMapping(path = "{friendshipId}")
    public Friendship showFriendship(@PathVariable("friendshipId") Long friendshipId) {
        return friendshipService.showFriendship(friendshipId);
    }

    // Create
    @PostMapping
    public void registerNewFriendship(@RequestBody Friendship friendship) {
        friendshipService.addNewFriendship(friendship);
    }

    // Delete
    @DeleteMapping(path = "{friendshipId}")
    public void deleteFriendship(@PathVariable("friendshipId") Long friendshipId) {
        friendshipService.deleteFriendship(friendshipId);
    }
}
