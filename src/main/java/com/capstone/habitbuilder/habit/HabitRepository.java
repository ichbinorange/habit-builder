package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {
    ArrayList findByEnjoyerId(Long enjoyerId);
}
