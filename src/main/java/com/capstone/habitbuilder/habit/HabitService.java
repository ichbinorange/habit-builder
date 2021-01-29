package com.capstone.habitbuilder.habit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitService {
    private final HabitRepository habitRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    // index - need to change based on userId
    public Iterable<Habit> getHabits() {
        return habitRepository.findAll();
    }

    // show
    public Habit showHabit(Long habitId)  {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        return habit;
    }

    // Create
    public void addNewHabit(Habit habit) {
        habitRepository.save(habit);
    }

    // Update
    @Transactional
    public void updateHabit(Long habitId,
                            String title,
                            String goal,
                            String description,
                            String streak,
                            Boolean reminder) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        if (title != null && title.length() > 0 ) {
            habit.setTitle(title);
        }
        if (goal != null && goal.length() > 0 ) {
            habit.setGoal(goal);
        }
        if (description != null && description.length() > 0 ) {
            habit.setDescription(description);
        }
        if (streak != null && streak.length() > 0 ) {
            habit.setStreak(streak);
        }

        habit.setReminder(reminder);
        habit.setUpdatedDate(LocalDateTime.now());
        habitRepository.save(habit);
    }

    // Delete
    public void deleteHabit(Long habitId) {
        boolean exists = habitRepository.existsById(habitId);
        if (!exists) {
            throw new IllegalStateException(
                    "habit with id " + habitId + " does not exists");
        }
        habitRepository.deleteById(habitId);
    }
}
