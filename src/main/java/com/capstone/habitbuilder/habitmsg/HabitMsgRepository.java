package com.capstone.habitbuilder.habitmsg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HabitMsgRepository extends JpaRepository<HabitMsg, Long> {
    ArrayList findByHabitId(Long habitId);
}
