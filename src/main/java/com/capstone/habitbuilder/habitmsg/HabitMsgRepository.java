package com.capstone.habitbuilder.habitmsg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitMsgRepository extends JpaRepository<HabitMsg, Long> {
}
