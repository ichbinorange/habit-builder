package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
    Optional<Friendship> findEnjoyerByRequester(Enjoyer enjoyer);
    Optional<Friendship> findEnjoyerByReceiver(Enjoyer enjoyer);
}
