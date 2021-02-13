package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.habit.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Optional<Friendship> findByRequesterAndReceiver(Enjoyer requester, Enjoyer receiver);
    ArrayList findByRequesterId(Long enjoyerId);
    ArrayList findByReceiverId(Long enjoyerId);
}
