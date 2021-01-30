package com.capstone.habitbuilder.habitmsg;

import com.capstone.habitbuilder.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitMsgConfig {
    private final HabitService habitService;

    @Autowired
    public HabitMsgConfig(HabitService habitService) {
        this.habitService = habitService;
    }

    @Bean
    public CommandLineRunner habitMsgRunner(HabitMsgRepository repo) {
        return args -> {
            HabitMsg drinkWater = new HabitMsg(
                    habitService.showHabit(1L),
                    "1L in the morning and 2L in the afternoon"
            );
            repo.saveAll(
                List.of(drinkWater)
            );
        };
    }
}
