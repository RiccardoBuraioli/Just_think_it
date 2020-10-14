package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;






public class ShopMenuController {
	Stage primary;
	
	@FXML
    private Label NomeLocale;

    @FXML
    private Button ModificaInformazioni;

    @FXML
    private Button GestisciEventi;

    @FXML
    private Button CercaCaritas;

    @FXML
    private Button Indietro;

    @FXML
    void CercaCaritas(ActionEvent event) {
    	RicercaCaritasNegozioController Rcnc = new RicercaCaritasNegozioController();
    	Rcnc.showStage();
    }

    @FXML
    void GestEventi(ActionEvent event) {

    }

    @FXML
    void Indietro(ActionEvent event) {

    }

    @FXML
    void ModInfo(ActionEvent event) {

    }

	
public ShopMenuController() {
	primary = new Stage();
	
	try {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/ShopMenuBoundary.fxml"));

            // Set this class as the controller
      

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
