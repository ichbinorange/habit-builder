package com.capstone.habitbuilder.habit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path="/habit")
public class HabitController {
    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // Index - need to change based on userId
    @GetMapping(path="/habit")
    public Iterable<Habit> getHabits() {
        return habitService.getHabits();
    }

    // Show
    @GetMapping(path = "/habit/{habitId}")
    public Habit showHabit(@PathVariable("habitId") Long habitId) {
        return habitService.showHabit(habitId);
    }

    // Create
    @PostMapping(path = "/enjoyer/{enjoyerId}/habit")
    public void registerNewHabit(@RequestBody Habit habit,
                                 @PathVariable("enjoyerId") Long enjoyerId) {
        habitService.addNewHabit(habit, enjoyerId);
    }

    // Update
    @PutMapping(path = "/habit/{habitId}")
    public void updateHabit(
            @PathVariable("habitId") Long habitId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String goal,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String streak,
            @RequestParam(required = false) Boolean reminder) {

        habitService.updateHabit(habitId, title, goal, description, streak, reminder);
    }

    // Delete
    @DeleteMapping(path = "/habit/{habitId}")
    public void deleteHabit(@PathVariable("habitId") Long habitId) {
        habitService.deleteHabit(habitId);
    }
}
