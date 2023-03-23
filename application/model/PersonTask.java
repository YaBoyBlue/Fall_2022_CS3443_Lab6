package application.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import application.controller.MainController;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PersonTask extends Scheduler {

	private MainController controller;
	
	private int persons = 0;
	private int visited = 0;

	public PersonTask(long schedule, int persons, MainController controller) {
		super(schedule);
		this.persons = persons;
		this.controller = controller;
	}

	@Override
	protected void onSchedule() {
		controller.setLabelText(controller.getTime(), String.format("Last Updated: %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss"))));
		
		if (Math.round(Math.random()) == 0) {
			Person person = controller.getPersons().get(visited);
			
			person.getCircle1().removeEventHandler(MouseEvent.MOUSE_CLICKED, person.getOnClick());
			person.getCircle2().removeEventHandler(MouseEvent.MOUSE_CLICKED, person.getOnClick());
			person.getLabel().removeEventHandler(MouseEvent.MOUSE_CLICKED, person.getOnClick());
			
			person.getCircle1().setFill(Color.BLACK);
			person.getCircle2().setFill(Color.BLACK);
			
			controller.setLabelText(controller.getActivity(), "");
			
			visited++;
			
			if (visited > persons) {
				controller.setLabelText(controller.getActivity(), "All persons have been visited, Santa is done!");
				
				this.stop();
			}
		}
	}
}
