package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RicercaCaritasNegozioController {
	
	Stage primary;
	
	
	
	
	public RicercaCaritasNegozioController() {
		primary = new Stage();
		
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/RicercaCaritasNegozioBoundary.fxml"));

	            // Set this class as the controller
	            loader.setController(this);

	            // Load the scene
	            primary.setScene(new Scene(loader.load()));

	            // Setup the window/stage
	            primary.setTitle("Shop Menù");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	
	public void showStage() {
		primary.showAndWait();
	}
}
