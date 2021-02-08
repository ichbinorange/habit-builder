package com.capstone.habitbuilder.habittracker;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.habit.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class HabitTrackerService {
    private final HabitTrackerRepository habitTrackerRepository;
    private final HabitRepository habitRepository;
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public HabitTrackerService(HabitTrackerRepository habitTrackerRepository, HabitRepository habitRepository, EnjoyerRepository enjoyerRepository) {
        this.habitTrackerRepository = habitTrackerRepository;
        this.habitRepository = habitRepository;
        this.enjoyerRepository = enjoyerRepository;
    }


    // index - all habits' records for a user
    public Iterable<HabitTracker> getHabitTrackers(Long enjoyerId) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        ArrayList<Habit> habitList = habitRepository.findByEnjoyerId(enjoyerId);
        ArrayList<HabitTracker> habitTrackerList = new ArrayList<>();
        for (Habit habit: habitList) {
            habitTrackerList.addAll(habitTrackerRepository.findByHabitId(habit.getId()));
        }
        return habitTrackerList;
    }

    // show - one habit's records
    public Iterable<HabitTracker> showHabitTrackers(Long habitId)  {
        Habit checkHabit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        return habitTrackerRepository.findByHabitId(habitId);
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
    public void updateHabitTracker(Long habitTrackerId, HabitTracker habitTracker) {
        HabitTracker checkhabitTracker = habitTrackerRepository.findById(habitTrackerId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitTracker with id " + habitTrackerId + " does not exists"
                ));
        if (habitTracker.getMemo() != null && habitTracker.getMemo().length() > 0 ) {
            habitTracker.setMemo(habitTracker.getMemo());
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
