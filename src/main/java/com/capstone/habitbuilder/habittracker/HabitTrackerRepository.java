package com.capstone.habitbuilder.habittracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HabitTrackerRepository extends JpaRepository<HabitTracker, Long> {
    ArrayList findByHabitId(Long habitId);
}
