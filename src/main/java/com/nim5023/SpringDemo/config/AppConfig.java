package com.nim5023.SpringDemo.config;

import com.nim5023.SpringDemo.model.Coach;
import com.nim5023.SpringDemo.model.FootballCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public Coach myCoach() {
        return new Coach() {
            @Override
            public String getDailyWorkout() {
                return "anonymous coach";
            }
        };
    }
}
