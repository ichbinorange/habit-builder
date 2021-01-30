package com.capstone.habitbuilder.habitfriend;

import com.capstone.habitbuilder.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitFriendConfig {
    private final HabitService habitService;

    @Autowired
    public HabitFriendConfig(HabitService habitService) {
        this.habitService = habitService;
    }

    @Bean
    public CommandLineRunner habitFriendRunner(HabitFriendRepository repo) {
        return args -> {
            HabitFriend drinkWater = new HabitFriend(
                    habitService.showHabit(1L),
                    true
            );
            repo.saveAll(
                List.of(drinkWater)
            );
        };
    }
}
