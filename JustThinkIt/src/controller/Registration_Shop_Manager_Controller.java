package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import entity.ShopUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registration_Shop_Manager_Controller implements Initializable {
	

	
	TextField[] textFields;
	
	int tipo;
    @FXML
    private TextField cittaResNeg;

    @FXML
    private TextField provinciaNeg;

    @FXML
    private TextField viaNeg;

    @FXML
    private TextField civicoNeg;

    @FXML
    private TextField telNeg;

    @FXML
    private TextField nomeNegzio;

    @FXML
    private TextField mailNeg;

    @FXML
    private CheckBox typeCiboNeg;

    @FXML
    private CheckBox typeVestNeg;

    @FXML
    private TextField nomeNeg;

    @FXML
    private TextField cognomeNeg;

    @FXML
    private Button registraNegozio;

    @FXML
    private TextField codiceFiscNeg;

    @FXML
    private Button backButtonNeg;

    @FXML
    private PasswordField passwordNeg;

    @FXML
    private Text passwordMatch;
    
    @FXML
    private PasswordField confermaPassNeg;
    

  
    @FXML
    void backButtonNegPressed(ActionEvent event) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) backButtonNeg.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
  int registraNegozioPressed(ActionEvent event) {
    	int resCheck = checker();
    	if (resCheck == 0) {
    	
    		Connector connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    		ShopUser shop = new ShopUser( nomeNegzio.getText(), passwordNeg.getText(),  viaNeg.getText() + " "+civicoNeg.getText() ,  tipo,  telNeg.getText(),  mailNeg.getText(),  cittaResNeg.getText());
    		
        	ShopRepository crep = new  ShopRepository(connector);
        	int id = crep.insertShop(shop);
        	shop.setId(id);
        	}
        	
        	else if ( resCheck == 1) {
        		Connector connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
        		ShopUser shop = new ShopUser( nomeNegzio.getText(), passwordNeg.getText(),  viaNeg.getText() + " "+civicoNeg.getText() ,  tipo,  telNeg.getText(),  mailNeg.getText(),  cittaResNeg.getText());
        		
        		ShopRepository crep = new  ShopRepository(connector);
            	int id = crep.insertShop(shop);
            	shop.setId(id);
        		
        	}
        	else if (resCheck == -1) {
      
        		return -1;
        		
        	}
    	
    	
    	
		
    	//Manda alla home Shop
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
			Parent root = loader.load();
			Shop_home_controller ShopsHomeController = loader.getController();
		
			Stage home = (Stage) registraNegozio.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
    
		return 0;
    }
    		
    	
    
    
    
    public int checker() {
    	
    	//Controlla che non ci siano campi lasciati vuoti
    	for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
		//	else if (type.isSelected() || type2.isSelected()) {
			else if(typeCiboNeg.isSelected()) {
				 tipo = 1;
	    		return 0; //Almeno uno dei tipi deve essere selezionato
	    		
	    		
			}else if(typeVestNeg.isSelected()) {
				tipo = 2;
				
				return 1; //Almeno uno dei tipi deve essere selezionato
			}else {
				passwordMatch.setText("Alcuni campi sono vuoti 2");
				passwordMatch.setVisible(true);
				return -1;
			}
  
		}
    	
    	
    	//Valida che i campi password e conferma password siano uguali
    	
    	if (passwordNeg.getText().equals(confermaPassNeg.getText())) {
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
		textFields = new TextField[] {cittaResNeg,viaNeg,civicoNeg,telNeg,nomeNegzio,mailNeg,nomeNeg,cognomeNeg};
		
		
	}
    


}