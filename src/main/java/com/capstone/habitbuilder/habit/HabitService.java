package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitService {
    private final HabitRepository habitRepository;
    private final EnjoyerRepository enjoyerRepository;
    @Autowired
    public HabitService(HabitRepository habitRepository, EnjoyerRepository enjoyerRepository) {
        this.habitRepository = habitRepository;
        this.enjoyerRepository = enjoyerRepository;
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
    public void addNewHabit(Habit habit, Long enjoyerId) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        habit.setEnjoyer(enjoyer);
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
