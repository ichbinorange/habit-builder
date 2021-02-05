package com.capstone.habitbuilder.habitfriend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitFriendRepository extends JpaRepository<HabitFriend, Long> {
}
