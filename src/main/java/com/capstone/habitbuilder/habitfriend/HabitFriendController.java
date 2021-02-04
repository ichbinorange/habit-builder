package com.capstone.habitbuilder.habitfriend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitFriendController {
    private final HabitFriendService habitFriendService;

    @Autowired
    public HabitFriendController(HabitFriendService habitFriendService) {
        this.habitFriendService = habitFriendService;
    }

    // Index - need to change based on userId
    @GetMapping(path="/habitFriends")
    public Iterable<HabitFriend> getHabitFriends() {
        return habitFriendService.getHabitFriends();
    }

    // Show
    @GetMapping(path = "/habitFriend/{habitFriendId}")
    public HabitFriend showHabitFriend(@PathVariable("habitFriendId") Long habitFriendId) {
        return habitFriendService.showHabitFriend(habitFriendId);
    }

    // Create
    @PostMapping(path = "/habit/{habitId}/habitFriend")
    public void registerNewHabitFriend(@RequestBody HabitFriend habitFriend,
                                        @PathVariable("habitId") Long habitId) {
        habitFriendService.addNewHabitFriend(habitFriend, habitId);
    }

    // Update
    @PutMapping(path = "/habitFriend/{habitFriendId}")
    public void updateHabitFriend(
            @PathVariable("habitFriendId") Long habitFriendId,
            @RequestParam(required = false) Boolean liked) {

        habitFriendService.updateHabitFriend(habitFriendId, liked);
    }

    // Delete
    @DeleteMapping(path = "/habitFriend/{habitFriendId}")
    public void deleteHabitFriend(@PathVariable("habitFriendId") Long habitFriendId) {
        habitFriendService.deleteHabitFriend(habitFriendId);
    }
}
