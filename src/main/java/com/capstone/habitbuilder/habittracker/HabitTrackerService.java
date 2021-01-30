package com.capstone.habitbuilder.habittracker;

import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.habit.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitTrackerService {
    private final HabitTrackerRepository habitTrackerRepository;
    private final HabitRepository habitRepository;

    @Autowired
    public HabitTrackerService(HabitTrackerRepository habitTrackerRepository, HabitRepository habitRepository) {
        this.habitTrackerRepository = habitTrackerRepository;
        this.habitRepository = habitRepository;
    }


    // index - need to change based on userId
    public Iterable<HabitTracker> getHabitTrackers() {
        return habitTrackerRepository.findAll();
    }

    // show
    public HabitTracker showHabitTracker(Long habitTrackerId)  {
        HabitTracker habitTracker = habitTrackerRepository.findById(habitTrackerId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitTracker with id " + habitTrackerId + " does not exists"
                ));
        return habitTracker;
    }

    // Create
    public void addNewHabitTracker(HabitTracker habitTracker, Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        habitTracker.setHabit(habit);
        habitTrackerRepository.save(habitTracker);
    }

    // Update
    @Transactional
    public void updateHabitTracker(Long habitTrackerId,
                                   Boolean record,
                                   String memo) {
        HabitTracker habitTracker = habitTrackerRepository.findById(habitTrackerId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitTracker with id " + habitTrackerId + " does not exists"
                ));
        if (!record != record ) {
            habitTracker.setRecord(!record);
        }
        if (memo != null && memo.length() > 0 ) {
            habitTracker.setMemo(memo);
        }

        habitTrackerRepository.save(habitTracker);
    }

    // Delete
    public void deleteHabitTracker(Long habitTrackerId) {
        boolean exists = habitTrackerRepository.existsById(habitTrackerId);
        if (!exists) {
            throw new IllegalStateException(
                    "habitTracker with id " + habitTrackerId + " does not exists");
        }
        habitTrackerRepository.deleteById(habitTrackerId);
    }

}
