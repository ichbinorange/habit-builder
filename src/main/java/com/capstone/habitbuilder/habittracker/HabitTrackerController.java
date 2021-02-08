package com.capstone.habitbuilder.habittracker;

import com.capstone.habitbuilder.habit.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitTrackerController {
    private final HabitTrackerService habitTrackerService;

    @Autowired
    public HabitTrackerController(HabitTrackerService habitTrackerService) {
        this.habitTrackerService = habitTrackerService;
    }

    // Index - all habits' records for a user
    @GetMapping(path="/habitTrackers/{enjoyerId}")
    public Iterable<HabitTracker> getHabitTrackers(@PathVariable("enjoyerId") Long enjoyerId) {
        return habitTrackerService.getHabitTrackers(enjoyerId);
    }

    // Show - one habit's records
    @GetMapping(path = "/habitTracker/{habitId}")
    public Iterable<HabitTracker> showHabitTrackers(@PathVariable("habitId") Long habitId) {
        return habitTrackerService.showHabitTrackers(habitId);
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
            @RequestBody HabitTracker habitTracker) {
        habitTrackerService.updateHabitTracker(habitTrackerId, habitTracker);
    }

    // Delete
    @DeleteMapping(path = "/habitTracker/{habitTrackerId}")
    public void deleteHabitTracker(@PathVariable("habitTrackerId") Long habitTrackerId) {
        habitTrackerService.deleteHabitTracker(habitTrackerId);
    }
}
