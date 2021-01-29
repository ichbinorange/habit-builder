package com.capstone.habitbuilder.habit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/habit")
public class HabitController {
    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // Index
    @GetMapping
    public Iterable<Habit> getHabits() {
        return habitService.getHabits();
    }

    // Show
    @GetMapping(path = "{habitId}")
    public void showHabit(
        @PathVariable("habitId") Long habitId,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String goal,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String streak,
        @RequestParam(required = false) String reminder,
        @RequestParam(required = false) String createdDate,
        @RequestParam(required = false) String updatedDate) {

        habitService.showHabit(habitId, title, goal, description, streak, reminder, createdDate, updatedDate);
    }

    // Create
    @PostMapping
    public void registerNewHabit(@RequestBody Habit habit) {
        HabitService.addNewHabit(habit);
    }

    // Update
    @PutMapping(path = "{habitId}")
    public void updateStudent(
            @PathVariable("habitId") Long habitId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String goal,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String streak,
            @RequestParam(required = false) String reminder,
            @RequestParam(required = false) String createdDate,
            @RequestParam(required = false) String updatedDate) {

        habitService.updateHabit(habitId, title, goal, description, streak, reminder, createdDate, updatedDate);
    }

    // Delete
    @DeleteMapping(path = "{habitId}")
    public void deleteHabit(@PathVariable("habitId") Long habitId) {
        habitService.deleteHabit(habitId);
    }
}
