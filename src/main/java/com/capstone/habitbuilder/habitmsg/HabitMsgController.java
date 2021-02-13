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
    @GetMapping(path="/habitMsgs/{enjoyerId}")
    public Iterable<HabitMsg> getHabitMsgs(@PathVariable("enjoyerId") Long enjoyerId) {
        return habitMsgService.getHabitMsgs(enjoyerId);
    }

    // Show
    @GetMapping(path = "/habitMsg/{habitMsgId}")
    public HabitMsg showHabitMsg(@PathVariable("habitMsgId") Long habitMsgId) {
        return habitMsgService.showHabitMsg(habitMsgId);
    }

    // Create
    @PostMapping(path = "/habit/{habitId}/habitMsg/{friendId}")
    public void registerNewHabitMsg(@RequestBody HabitMsg habitMsg,
                                    @PathVariable("habitId") Long habitId,
                                    @PathVariable("friendId") Long friendId) {
        habitMsgService.addNewHabitMsg(habitMsg, habitId, friendId);
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
