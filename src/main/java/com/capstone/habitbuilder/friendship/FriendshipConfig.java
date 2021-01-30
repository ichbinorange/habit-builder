package com.capstone.habitbuilder.friendship;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FriendshipConfig {
    @Bean
    public CommandLineRunner friendshipRunner(FriendshipRepository friendshipRepository, EnjoyerRepository enjoyerRepository) {
        return args -> {
            Enjoyer fire = new Enjoyer(
                    "fire",
                    "fire@gmail.com",
                    "http://",
                    "I'm on Fire"
            );
            Enjoyer earth = new Enjoyer(
                    "earth",
                    "earth@gmail.com",
                    "http://",
                    "I'm on Earth"
            );
            Enjoyer water = new Enjoyer(
                    "water",
                    "waterfriendship@gmail.com",
                    "http://",
                    "I'm in Water"
            );
            enjoyerRepository.saveAll(
                    List.of(fire, earth, water)
            );

            Friendship friendship1 = new Friendship();
            friendship1.setRequester(fire);
            friendship1.setReceiver(earth);
            Friendship friendship2 = new Friendship();
            friendship1.setRequester(fire);
            friendship1.setReceiver(water);
            Friendship friendship3 = new Friendship();
            friendship1.setRequester(water);
            friendship1.setReceiver(earth);
            friendshipRepository.saveAll(
                    List.of(friendship1, friendship2, friendship3)
            );

        };
    }

}
