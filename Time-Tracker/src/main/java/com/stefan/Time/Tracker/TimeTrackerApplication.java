package com.stefan.Time.Tracker;

import com.stefan.Time.Tracker.DataService.ActionService;
import com.stefan.Time.Tracker.Domain.Action;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TimeTrackerApplication {
	private final ActionService actionService;
	private static Action newActions = null;
	private static List<Action> fetchedActions = null;

	public static List<Action>getFetchedActions(){
		return fetchedActions;
	}

	public static void setNewActions(Action newAction) {
		newActions = newAction;
	}

	public TimeTrackerApplication(ActionService actionService) {
		this.actionService = actionService;
	}

	public static void main(String[] args) {

		SpringApplication.run(TimeTrackerApplication.class, args);

	}

	public static void run(){
		SpringApplication.run(TimeTrackerApplication.class);
	}

	@Bean
	CommandLineRunner commandLineRunner(ActionService actionService){
		return args -> {
			if(newActions != null){
				actionService.save(newActions);
			}

			fetchedActions = actionService.findAll();
		};
	}

}
