package com.capstone.habitbuilder.user;

import com.capstone.habitbuilder.habit.HabitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    public CommandLineRunner userRunner(UserRepository repo) {
        return args -> {
            User water = new User(
                "water",
                "water@gmail.com",
                "http://",
                "I'm water"
            );
            repo.saveAll(
                List.of(water)
            );
        };
    }
}
