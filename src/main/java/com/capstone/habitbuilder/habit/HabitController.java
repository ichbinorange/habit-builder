package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitController {
    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // Index - all habits for a user
    @GetMapping(path="/habits/{enjoyerId}")
    public Iterable<Habit> getHabits(@PathVariable("enjoyerId") Long enjoyerId) {
        return habitService.getHabits(enjoyerId);
    }

    // Show - single habit
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
    public void updateHabit(@PathVariable("habitId") Long habitId,
                            @RequestBody Habit habit) {
            habitService.updateHabit(habitId, habit);
    }

    // Delete
    @DeleteMapping(path = "/habit/{habitId}")
    public void deleteHabit(@PathVariable("habitId") Long habitId) {
            habitService.deleteHabit(habitId);
    }
}
