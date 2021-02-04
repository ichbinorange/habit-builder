package com.capstone.habitbuilder.habit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HabitRepository extends CrudRepository<Habit, Long> {
    ArrayList findByEnjoyerId(Long enjoyerId);
}
