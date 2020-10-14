package controller;

import java.io.IOException;

import entity.CaritasUser;
import entity.Login;
import entity.ShopUser;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_Controller {
	
	@FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;
    
   
    @FXML
    void loginPressed(ActionEvent event) {
    	
    	Connector connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	Login login = new Login(connector);
    	int loginResult = login.checkLogin(usernameField.getText(), passwordField.getText());
    	if (loginResult>0) {
    		
    		//OK MANDA ALLA HOME CORRETTA
    		System.out.println("Login succesfull");
    		System.out.println(login.getTableUser());
    		
    		//Volontario
    		if (login.getTableUser() == 1) {
    			
    			VolunteerRepository vrep = new VolunteerRepository(connector);
    			
    			int userID = login.returnID(usernameField.getText(), 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			VolunteerUser loggedUser = vrep.getVolunteerByID(userID);
    			System.out.println(loggedUser.getCognome());
    			
    			//Manda alla home user
    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
        			Parent root = loader.load();
        			User_Home_Controller userHomeController = loader.getController();
        			userHomeController.initData(loggedUser);
        			Stage home = (Stage) loginButton.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    		}
    		
    		//Caritas
    		else if (login.getTableUser() == 2) {
    			
    			ShopRepository srep = new ShopRepository(connector); 

    			int userID = login.returnID(usernameField.getText(), 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			ShopUser loggedShop = srep.getShopByID(userID);
    			System.out.println(loggedShop.getNomeShop());
    			
    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
        			Parent root = loader.load();
        			Shop_home_controller ShopHomeController = loader.getController();
        			ShopHomeController.initData(loggedShop);
        			Stage home = (Stage) loginButton.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    			
    		}
    		
    		//Negozio
    		else if (login.getTableUser() == 3) {
     			CaritasRepository srep = new CaritasRepository(connector); 

    			int userID = login.returnID(usernameField.getText(), 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			CaritasUser loggedShop = srep.getCaritasByID(userID);
    			System.out.println(loggedShop.getNomeCaritas());
    			
    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
        			Parent root = loader.load();
        			Caritas_home_controller CaritasHomeController = loader.getController();
        			CaritasHomeController.initData(loggedShop);
        			Stage home = (Stage) loginButton.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    			
    		}
    		
    		
    		    		
    	
    	else  {
    		System.out.println("Login Error");
    	}	

    	}
    }

    @FXML
    void registrazionePressed(ActionEvent event) {
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) loginButton.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

	public void aprimenu(String cdc) {
		// TODO Auto-generated method stub
		
	}

}
