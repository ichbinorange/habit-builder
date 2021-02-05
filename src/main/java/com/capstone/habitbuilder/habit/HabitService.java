package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HabitService {
    private final HabitRepository habitRepository;
    private final EnjoyerRepository enjoyerRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository, EnjoyerRepository enjoyerRepository) {
        this.habitRepository = habitRepository;
        this.enjoyerRepository = enjoyerRepository;
    }

    public String authenticateUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        } else {
            throw new IllegalStateException("Can't now find this user");
        }
    }

    // index - need to change based on userId
    public Iterable<Habit> getHabits(Long enjoyerId) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        return habitRepository.findByEnjoyerId(enjoyerId);
    }

    // show
    public Habit showHabit(Long habitId)  {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        Enjoyer enjoyer = enjoyerRepository.findEnjoyerByEmail(authenticateUser())
                .orElseThrow(() -> new IllegalStateException(
                        "User with email " + authenticateUser() + " does not exists"
                ));
        if (habitRepository.findByIdAndEnjoyer(habitId, enjoyer) != null) {
            return habit;
        } else{
            throw new IllegalStateException(
                    "habitId " + habitId + " and enjoyerId" + enjoyer.getId() + " does not exists");
        }
    }

    // Create
    public void addNewHabit(Habit habit, Long enjoyerId) {
        Enjoyer enjoyer = enjoyerRepository.findById(enjoyerId)
                .orElseThrow(() -> new IllegalStateException(
                        "enjoyer with id " + enjoyerId + " does not exists"
                ));
        habit.setEnjoyer(enjoyer);
        habitRepository.save(habit);
    }

    // Update
    @Transactional
    public void updateHabit(Long habitId, Habit habit) {
        Habit checkHabit = habitRepository.findById(habitId)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + habitId + " does not exists"
                ));
        Enjoyer enjoyer = enjoyerRepository.findEnjoyerByEmail(authenticateUser())
                .orElseThrow(() -> new IllegalStateException(
                        "User with email " + authenticateUser() + " does not exists"
                ));

        if (habitRepository.findByIdAndEnjoyer(habitId, enjoyer) != null) {
            if (habit.getTitle() != null && habit.getTitle().length() > 0) {
                habit.setTitle(habit.getTitle());
            }
            if (habit.getGoal() != null && habit.getGoal().length() > 0) {
                habit.setGoal(habit.getGoal());
            }
            if (habit.getDescription() != null && habit.getDescription().length() > 0) {
                habit.setDescription(habit.getDescription());
            }
            if (habit.getStreak() != null && habit.getStreak().length() > 0) {
                habit.setStreak(habit.getStreak());
            }

            habit.setReminder(habit.getReminder());
            habit.setHabitBuilt(habit.getHabitBuilt());
            habitRepository.save(habit);
        } else{
            throw new IllegalStateException(
                    "habitId " + habitId + " and enjoyerId" + enjoyer.getId() + " does not exists");
        }
    }

    // Delete
    public void deleteHabit(Long habitId) {
        boolean exists = habitRepository.existsById(habitId);
        if (!exists) {
            throw new IllegalStateException(
                    "habit with id " + habitId + " does not exists");
        }
        Enjoyer enjoyer = enjoyerRepository.findEnjoyerByEmail(authenticateUser())
                .orElseThrow(() -> new IllegalStateException(
                        "User with email " + authenticateUser() + " does not exists"
                ));
        if (habitRepository.findByIdAndEnjoyer(habitId, enjoyer) != null) {
            habitRepository.deleteById(habitId);
        } else{
            throw new IllegalStateException(
                    "habitId " + habitId + " and enjoyerId" + enjoyer.getId() + " does not exists");
        }
    }
}
