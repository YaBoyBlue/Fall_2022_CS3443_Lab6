package application.controller;

import java.util.ArrayList;

import application.model.FileInput;
import application.model.Person;
import application.model.PersonTask;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MainController extends Controller {

	private ArrayList<Person> persons = new ArrayList<Person>();

	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Label title;
	@FXML
	private Pane pane;
	@FXML
	private VBox visiting;
	@FXML
	private Label activity;
	@FXML
	private Label time;
	
	public ArrayList<Person> getPersons() {
		return this.persons;
	}
	
	public Label getActivity() {
		return this.activity;
	}
	
	public Label getTime() {
		return this.time;
	}

	@Override
	protected void initialize() {
		ArrayList<String> activities = FileInput.getContent("src/data/activities.txt");
		ArrayList<ArrayList<String>> data = FileInput.getContent("src/data/data.csv", ",");
		
		for (ArrayList<String> info : data) {
			Person person = new Person(info.get(0), activities.get((int)Math.round(Math.random() * (activities.size() - 1))), info.get(1), Integer.valueOf(info.get(2)), Integer.valueOf(info.get(3)));
			
			persons.add(person);
			
			Circle circle1 = new Circle(Integer.valueOf(info.get(2)), Integer.valueOf(info.get(3)), 10, Color.valueOf(info.get(1)));
			Circle circle2 = new Circle(0, 0, 5, Color.valueOf(info.get(1)));
			Label label = new Label(info.get(0));
			
			EventHandler<MouseEvent> onClick = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent e) {
					activity.setText(person.getActivity());
				}
			};
			
			circle1.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
			circle2.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
			label.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
			
			persons.get(persons.size() - 1).setOnClick(onClick);
			persons.get(persons.size() - 1).setCircle1(circle1);
			persons.get(persons.size() - 1).setCircle2(circle2);
			persons.get(persons.size() - 1).setLabel(label);
			
			HBox hBox = new HBox();
						
			hBox.setAlignment(Pos.CENTER);
			hBox.setSpacing(3);
			hBox.getChildren().addAll(circle2, label);
			visiting.getChildren().add(hBox);
			
			pane.getChildren().add(circle1);
		}
		
		PersonTask personTask = new PersonTask(2, persons.size() - 1, this);
		personTask.start();
	}
}
