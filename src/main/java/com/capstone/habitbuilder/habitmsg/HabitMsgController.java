package com.capstone.habitbuilder.habitmsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitMsgController {
    private final HabitMsgService habitMsgService;

    @Autowired
    public HabitMsgController(HabitMsgService habitMsgService) {
        this.habitMsgService = habitMsgService;
    }

    // Index - need to change based on userId
    @GetMapping(path="/habitMsgs")
    public Iterable<HabitMsg> getHabitMsgs() {
        return habitMsgService.getHabitMsgs();
    }

    // Show
    @GetMapping(path = "/habitMsg/{habitMsgId}")
    public HabitMsg showHabitMsg(@PathVariable("habitMsgId") Long habitMsgId) {
        return habitMsgService.showHabitMsg(habitMsgId);
    }

    // Create
    @PostMapping(path = "/habit/{habitId}/habitMsg")
    public void registerNewHabitMsg(@RequestBody HabitMsg habitMsg,
                                    @PathVariable("habitId") Long habitId) {
        habitMsgService.addNewHabitMsg(habitMsg, habitId);
    }

    // Update
    @PutMapping(path = "/habitMsg/{habitMsgId}")
    public void updateHabitMsg(
            @PathVariable("habitMsgId") Long habitMsgId,
            @RequestParam(required = false) String text) {

        habitMsgService.updateHabitMsg(habitMsgId, text);
    }

    // Delete
    @DeleteMapping(path = "/habitMsg/{habitMsgId}")
    public void deleteHabitMsg(@PathVariable("habitMsgId") Long habitMsgId) {
        habitMsgService.deleteHabitMsg(habitMsgId);
    }
}
