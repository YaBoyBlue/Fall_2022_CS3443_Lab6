package application.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class Controller {

	public void setLabelText(Label label, String text) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				label.setText(text);
			}
		});
	}
	
	@FXML
	protected abstract void initialize();
}