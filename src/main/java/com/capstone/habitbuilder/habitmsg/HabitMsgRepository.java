package com.capstone.habitbuilder.habitmsg;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitMsgRepository extends CrudRepository<HabitMsg, Long> {
}
