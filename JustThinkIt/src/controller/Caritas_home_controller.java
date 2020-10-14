package controller;



import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import entity.CaritasUser;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Sample Skeleton for "CaritasHomePage.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/



public class Caritas_home_controller {

	  @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="CreaPacco"
	    private Button CreaPacco; // Value injected by FXMLLoader

	    @FXML // fx:id="arrowLeft"
	    private ImageView arrowLeft; // Value injected by FXMLLoader

	    @FXML // fx:id="arrowRight"
	    private ImageView arrowRight; // Value injected by FXMLLoader

	    @FXML // fx:id="deleteAccountButton"
	    private Button deleteAccountButton; // Value injected by FXMLLoader

	    @FXML // fx:id="helpButton"
	    private Button helpButton; // Value injected by FXMLLoader

	    @FXML // fx:id="imagePresentation"
	    private ImageView imagePresentation; // Value injected by FXMLLoader

	    @FXML // fx:id="leftArrowButton"
	    private Button leftArrowButton; // Value injected by FXMLLoader

	    @FXML // fx:id="logoutButton"
	    private Button logoutButton; // Value injected by FXMLLoader

	    @FXML // fx:id="nomeCognome"
	    private Text nomeCognome; // Value injected by FXMLLoader

	    @FXML // fx:id="profileButton"
	    private Button profileButton; // Value injected by FXMLLoader

	    @FXML // fx:id="profileImage"
	    private ImageView profileImage; // Value injected by FXMLLoader

	    @FXML // fx:id="rightArrowButton"
	    private Button rightArrowButton; // Value injected by FXMLLoader

	    @FXML // fx:id="searchCaritasButton"
	    private Button searchCaritasButton; // Value injected by FXMLLoader

	    @FXML // fx:id="textOverImages"
	    private Text textOverImages; // Value injected by FXMLLoader


	    // Handler for Button[Button[id=null, styleClass=button]] onAction
	    @FXML
	    void Gestisci_donazioni(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[Button[id=null, styleClass=button]] onAction
	    @FXML
	    void Gestisci_eventi(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="CreaPacco"] onAction
	    @FXML
	    void Gestisci_turni(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="searchCaritasButton"] onAction
	    @FXML
	    void Visualizza_bacheca(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="deleteAccountButton"] onAction
	    @FXML
	    void deleteAccountButtonPressed(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="helpButton"] onAction
	    @FXML
	    void helpButtonPressed(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="leftArrowButton"] onAction
	    @FXML
	    void leftArrowPressed(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="logoutButton"] onAction
	    @FXML
	    void logoutButtonPressed(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="profileButton"] onAction
	    @FXML
	    void profileButtonPressed(ActionEvent event) {
	        // handle the event here
	    }

	    // Handler for Button[fx:id="rightArrowButton"] onAction
	    @FXML
	    void rightArrowPressed(ActionEvent event) {
	        // handle the event here
	    }



	private Image img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
	private Image img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
	private Image img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
	private Image[] images = {img1, img2, img3};
	private int currentImage = 0;
	
	CaritasUser currentUser;
	
	
	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}
	
    
    
  
    @FXML
    void initialize() {
        assert CreaPacco != null : "fx:id=\"CreaPacco\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert arrowLeft != null : "fx:id=\"arrowLeft\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert arrowRight != null : "fx:id=\"arrowRight\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert deleteAccountButton != null : "fx:id=\"deleteAccountButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert helpButton != null : "fx:id=\"helpButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert imagePresentation != null : "fx:id=\"imagePresentation\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert leftArrowButton != null : "fx:id=\"leftArrowButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert nomeCognome != null : "fx:id=\"nomeCognome\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert profileImage != null : "fx:id=\"profileImage\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert rightArrowButton != null : "fx:id=\"rightArrowButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert searchCaritasButton != null : "fx:id=\"searchCaritasButton\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";
        assert textOverImages != null : "fx:id=\"textOverImages\" was not injected: check your FXML file 'CaritasHomePage.fxml'.";


    }

	public void initData(CaritasUser user) {
		setCurrentUser(user);
    	nomeCognome.setText(user.getNomeCaritas());
    	final Circle clip = new Circle();
    	clip.setCenterX(25);
    	clip.setCenterY(58);
    	clip.setRadius(200);
        profileImage.setClip(clip);
    	long delay = 3000; //update once per 3 seconds.
    	new Timer().schedule(new TimerTask() {

    	    @Override
    	    public void run() {
    	        imagePresentation.setImage(images[currentImage++]);
    	        if (currentImage >= images.length) {
    	            currentImage = 0;
    	        }
    	    }
    	}, 0, delay);
		
	}

}
