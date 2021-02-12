package com.capstone.habitbuilder.habitmsg;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import com.capstone.habitbuilder.habit.Habit;
import com.capstone.habitbuilder.habit.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitMsgService {
    private final HabitMsgRepository habitMsgRepository;
    private final HabitRepository habitRepository;
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public HabitMsgService(HabitMsgRepository habitMsgRepository, HabitRepository habitRepository, EnjoyerRepository enjoyerRepository) {
        this.habitMsgRepository = habitMsgRepository;
        this.habitRepository = habitRepository;
        this.enjoyerRepository = enjoyerRepository;
    }

    // index - need to change based on userId
    public Iterable<HabitMsg> getHabitMsgs() {
        return habitMsgRepository.findAll();
    }

    // show
    public HabitMsg showHabitMsg(Long habitMsgId)  {
        HabitMsg habitMsg = habitMsgRepository.findById(habitMsgId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitMsg with id " + habitMsgId + " does not exists"
                ));
        return habitMsg;
    }

    // Create
    public void addNewHabitMsg(HabitMsg habitMsg, Long habitId, Long friendId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        Enjoyer enjoyer = enjoyerRepository.findById(friendId)
                .orElseThrow(() -> new IllegalStateException(
                        "friend with id " + friendId + " does not exists"
                ));
        habitMsg.setHabit(habit);
        habitMsg.setFriend(enjoyer);
        habitMsgRepository.save(habitMsg);
    }

    // Update
    @Transactional
    public void updateHabitMsg(Long habitMsgId, String text) {
        HabitMsg habitMsg = habitMsgRepository.findById(habitMsgId)
                .orElseThrow(() -> new IllegalStateException(
                        "habitMsg with id " + habitMsgId + " does not exists"
                ));
        if (text != null && text.length() > 0 ) {
            habitMsg.setText(text);
        }

        habitMsgRepository.save(habitMsg);
    }

    // Delete
    public void deleteHabitMsg(Long habitMsgId) {
        boolean exists = habitMsgRepository.existsById(habitMsgId);
        if (!exists) {
            throw new IllegalStateException(
                    "habitMsg with id " + habitMsgId + " does not exists");
        }
        habitMsgRepository.deleteById(habitMsgId);
    }
}
