package com.nim5023.SpringDemo.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {

        return "run 5 miles";

    }

    @PostConstruct
    public String postConst() {
        System.out.println("POST CONSTRUTION");
        return "SUP";
    }

    @PreDestroy
    public String preDest() {
        System.out.println("Pre DESTRUCTION!!!");
        return "...";
    }
}
