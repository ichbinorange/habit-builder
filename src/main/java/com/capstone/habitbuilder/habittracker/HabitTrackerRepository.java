package com.capstone.habitbuilder.habittracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitTrackerRepository extends JpaRepository<HabitTracker, Long> {
}
