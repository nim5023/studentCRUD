package com.nim5023.SpringDemo.rest.controller;

import com.nim5023.SpringDemo.model.Coach;
import com.nim5023.SpringDemo.model.FootballCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class WorkoutController {
    @Autowired

    private Coach coach2;

    public void setMyCoach(Coach myCoach) {
        this.coach2 = myCoach;
    }

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/workout")
    public String workout() {
        String name = applicationContext.getApplicationName();
        return coach2.getDailyWorkout();
    }
}
