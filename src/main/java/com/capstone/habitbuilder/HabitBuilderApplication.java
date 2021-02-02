package com.capstone.habitbuilder;

import com.capstone.habitbuilder.oauthapi.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class HabitBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitBuilderApplication.class, args);
	}

}
