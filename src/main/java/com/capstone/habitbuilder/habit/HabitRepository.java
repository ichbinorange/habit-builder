package com.capstone.habitbuilder.habit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {

}
