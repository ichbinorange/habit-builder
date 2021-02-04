package com.capstone.habitbuilder.habittracker;

import com.capstone.habitbuilder.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitTrackerConfig {
    private final HabitService habitService;
    
    @Autowired
    public HabitTrackerConfig(HabitService habitService) {
        this.habitService = habitService;
    }

    @Bean
    public CommandLineRunner habitTrackerRunner(HabitTrackerRepository repo) {
        return args -> {
//            HabitTracker drinkWater = new HabitTracker(
//                    habitService.showHabit(1L),
//                    true,
//                    "1L in the morning and 2L in the afternoon"
//            );
//            repo.saveAll(
//                    List.of(drinkWater)
//            );
        };
    }
}
