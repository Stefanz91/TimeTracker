package com.stefan.Time.Tracker;

import com.stefan.Time.Tracker.DataService.TimeTrackingService;
import com.stefan.Time.Tracker.Domain.TimeIntervall;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimeTrackingController {
    TimeTrackingService timeTrackingService;
    private static TimeIntervall timeIntervall = null;

    public static void setTimeIntervall(TimeIntervall newTimeIntervall){
        timeIntervall = newTimeIntervall;
    }

    public TimeTrackingController(TimeTrackingService timeTrackingService){
        this.timeTrackingService = timeTrackingService;
    }

    public static void run(){
        SpringApplication.run(TimeTrackingController.class);
    }

    @Bean
    CommandLineRunner commandLineRunner2(TimeTrackingService timeTrackingService){
        return args -> {
            if(timeIntervall != null){
                System.out.println("1");
                timeTrackingService.saveTime(timeIntervall);
                System.out.println("2");
            }

        };
    }
}
