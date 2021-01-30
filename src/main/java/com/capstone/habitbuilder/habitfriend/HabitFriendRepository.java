package com.capstone.habitbuilder.habitfriend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitFriendRepository extends CrudRepository<HabitFriend, Long> {
}
