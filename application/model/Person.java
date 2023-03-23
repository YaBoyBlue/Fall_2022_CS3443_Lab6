package application.model;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Person {

	private EventHandler<MouseEvent> onClick;
	
	private Circle circle1;
	private Circle circle2;
	private Label label;
	
	private String name;
	private String activity;
	private String color;
	private int latitude;
	private int longitude;
	
	public Person(String name, String activity, String color, int latitude, int longitude) {
		this.name = name;
		this.activity = activity;
		this.color = color;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public EventHandler<MouseEvent> getOnClick() {
		return this.onClick;
	}
	
	public void setOnClick(EventHandler<MouseEvent> onClick) {
		this.onClick = onClick;
	}
	
	public Circle getCircle1() {
		return this.circle1;
	}
	
	public void setCircle1(Circle circle1) {
		this.circle1 = circle1;
	}
	
	public Circle getCircle2() {
		return this.circle2;
	}
	
	public void setCircle2(Circle circle2) {
		this.circle2 = circle2;
	}
	
	public Label getLabel() {
		return this.label;
	}
	
	public void setLabel(Label label) {
		this.label = label;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getActivity() {
		return this.activity;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	public int getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public String formatString() {
		return String.format("Person: %s\nName: %s\nActivity: %s\nColor: %s\nLatitude: %d\nLongitude: %d", this.toString(), this.name, this.activity, this.color, this.latitude, this.longitude);
	}
}
