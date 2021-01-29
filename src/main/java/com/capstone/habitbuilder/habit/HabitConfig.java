package com.capstone.habitbuilder.habit;

import com.capstone.habitbuilder.enjoyer.EnjoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitConfig {

    private final EnjoyerService enjoyerService;
    @Autowired
    public HabitConfig(EnjoyerService enjoyerService) {
        this.enjoyerService = enjoyerService;
    }

    @Bean
    public CommandLineRunner habitRunner(HabitRepository repo) {
        return args -> {
            Habit drinkWater = new Habit(
                    enjoyerService.showEnjoyer(1L),
                    "drink water",
                    "drink 2L everyday",
                    "1L in the morning and 2L in the afternoon",
                    "daily",
                    true
            );
            repo.saveAll(
                    List.of(drinkWater)
            );
        };
    }
}
