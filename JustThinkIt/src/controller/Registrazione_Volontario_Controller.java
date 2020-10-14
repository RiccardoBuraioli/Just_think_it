package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Date;

public class Registrazione_Volontario_Controller implements Initializable {


	TextField[] textFields;
	
	
    @FXML // fx:id="cittadiResidenza"
    private TextField cittadiResidenza; // Value injected by FXMLLoader

    @FXML // fx:id="via"
    private TextField via; // Value injected by FXMLLoader

    @FXML // fx:id="civico"
    private TextField civico; // Value injected by FXMLLoader

    @FXML // fx:id="telefono"
    private TextField telefono; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="email"
    private TextField email; // Value injected by FXMLLoader

    @FXML // fx:id="nome"
    private TextField nome; // Value injected by FXMLLoader

    @FXML // fx:id="cognome"
    private TextField cognome; // Value injected by FXMLLoader

    @FXML // fx:id="completaButton"
    private Button completaButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordCaritas"
    private PasswordField passwordVolontario; // Value injected by FXMLLoader

    @FXML // fx:id="confermaPassCaritas"
    private PasswordField confermaPassVolontario; // Value injected by FXMLLoader

    @FXML // fx:id="passwordMatch"
    private Text passwordMatch; // Value injected by FXMLLoader

    @FXML
    private DatePicker Date;

    





    @FXML
    void backButtonPressed(ActionEvent event) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) backButton.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void completaButtonPressed(ActionEvent event) {

    	
    	if (checker() == 0) {
    		Connector connector = new Connector("jdbc:mysql://127.0.0.1:3306/justthinkit", "root", "password");
    		//Crea nuova istanza VolunteerUser?? 
    		Date date2 = java.sql.Date.valueOf( Date.getValue());
        	VolunteerUser newUser = new VolunteerUser(nome.getText(), cognome.getText(), passwordVolontario.getText(), via.getText(), telefono.getText(), email.getText(), null,date2,cittadiResidenza.getText() );
        	VolunteerRepository vrep = new VolunteerRepository(connector);
        	int id = vrep.insertVolunteer(newUser);
        	newUser.setID(id);
        	
        	//Manda alla home dopo la registrazione
        	try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
    			Parent root = loader.load();
    			User_Home_Controller userHomeController = loader.getController();
    			userHomeController.initData(newUser);
    			Stage home = (Stage) completaButton.getScene().getWindow();
    			home.setScene(new Scene(root, 800, 600));
    			
    			home.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	

    }
    
    public int checker() {
    	
    	//Controlla che non ci siano campi lasciati vuoti
    	for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
		}
    	
    	//Valida che i campi password e conferma password siano uguali
    	
    	if (passwordVolontario.getText().equals(confermaPassVolontario.getText())) {
    		passwordMatch.setVisible(false);
    		System.out.println("Password confirmed");
    		return 0;
    	}
    	else {
    		passwordMatch.setText("Le password non corrispondono");
    		passwordMatch.setVisible(true);
    		return -1;
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		passwordMatch.setVisible(false);
		textFields = new TextField[] {nome,email,cittadiResidenza,cognome,civico,via,telefono};
		//Per rendere opzionale un campo basta rimuoverlo da questa lista
	}

}