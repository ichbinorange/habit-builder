package com.capstone.habitbuilder.habittracker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitTrackerRepository extends CrudRepository<HabitTracker, Long> {
}
