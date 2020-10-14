package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Registration_Controller {

	Stage primary;
	
	private Login_Controller loginController;
	
	public Registration_Controller(Login_Controller loginController) {
		this.loginController = loginController;
		primary = new Stage();
		
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/RegistrazioneCaritas.fxml"));

	            // Set this class as the controller
	            loader.setController(this);

	            // Load the scene
	            primary.setScene(new Scene(loader.load()));

	            // Setup the window/stage
	            primary.setTitle("Passing Controllers Example - Layout2");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			
		
	}
	
	public void showStage() {
		primary.showAndWait();
	}
	
}
