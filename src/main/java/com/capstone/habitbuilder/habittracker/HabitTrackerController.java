package com.capstone.habitbuilder.habittracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitTrackerController {
    private final HabitTrackerService habitTrackerService;

    @Autowired
    public HabitTrackerController(HabitTrackerService habitTrackerService) {
        this.habitTrackerService = habitTrackerService;
    }

    // Index - need to change based on userId
    @GetMapping(path="/habitTrackers")
    public Iterable<HabitTracker> getHabitTrackers() {
        return habitTrackerService.getHabitTrackers();
    }

    // Show
    @GetMapping(path = "/habitTracker/{habitTrackerId}")
    public HabitTracker showHabitTracker(@PathVariable("habitTrackerId") Long habitTrackerId) {
        return habitTrackerService.showHabitTracker(habitTrackerId);
    }

    // Create
    @PostMapping(path = "/habit/{habitId}/habitTracker")
    public void registerNewHabitTracker(@RequestBody HabitTracker habitTracker,
                                 @PathVariable("habitId") Long habitId) {
        habitTrackerService.addNewHabitTracker(habitTracker, habitId);
    }

    // Update
    @PutMapping(path = "/habitTracker/{habitTrackerId}")
    public void updateHabitTracker(
            @PathVariable("habitTrackerId") Long habitTrackerId,
            @RequestParam(required = false) Boolean record,
            @RequestParam(required = false) String memo) {

        habitTrackerService.updateHabitTracker(habitTrackerId, record, memo);
    }

    // Delete
    @DeleteMapping(path = "/habitTracker/{habitTrackerId}")
    public void deleteHabitTracker(@PathVariable("habitTrackerId") Long habitTrackerId) {
        habitTrackerService.deleteHabitTracker(habitTrackerId);
    }
}
