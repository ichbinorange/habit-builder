package com.capstone.habitbuilder.habitfriend;

import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.habit.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitFriendService {
    private final HabitFriendRepository habitFriendRepository;
    private final HabitRepository habitRepository;

    @Autowired
    public HabitFriendService(HabitFriendRepository habitFriendRepository, HabitRepository habitRepository) {
        this.habitFriendRepository = habitFriendRepository;
        this.habitRepository = habitRepository;
    }

    // index - need to change based on userId
    public Iterable<HabitFriend> getHabitFriends() {
        return habitFriendRepository.findAll();
    }

    // show
    public HabitFriend showHabitFriend(Long habitFriendId)  {
        HabitFriend habitFriend = habitFriendRepository.findById(habitFriendId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitFriend with id " + habitFriendId + " does not exists"
                ));
        return habitFriend;
    }

    // Create
    public void addNewHabitFriend(HabitFriend habitFriend, Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        habitFriend.setHabit(habit);
        habitFriendRepository.save(habitFriend);
    }

    // Update
    @Transactional
    public void updateHabitFriend(Long habitFriendId,
                                  Boolean liked) {
        HabitFriend habitFriend = habitFriendRepository.findById(habitFriendId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitFriend with id " + habitFriendId + " does not exists"
                ));
        if (!liked != liked ) {
            habitFriend.setLiked(!liked);
        }

        habitFriendRepository.save(habitFriend);
    }

    // Delete
    public void deleteHabitFriend(Long habitFriendId) {
        boolean exists = habitFriendRepository.existsById(habitFriendId);
        if (!exists) {
            throw new IllegalStateException(
                    "habitFriend with id " + habitFriendId + " does not exists");
        }
        habitFriendRepository.deleteById(habitFriendId);
    }
}
