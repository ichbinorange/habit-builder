package com.capstone.habitbuilder.enjoyer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EnjoyerConfig {
    @Bean
    public CommandLineRunner enjoyerRunner(EnjoyerRepository repo) {
        return args -> {
//            Enjoyer water = new Enjoyer(
//                "water",
//                "water@gmail.com",
//                "http://",
//                "I'm water"
//            );
//            repo.saveAll(
//                List.of(water)
//            );
        };
    }
}
