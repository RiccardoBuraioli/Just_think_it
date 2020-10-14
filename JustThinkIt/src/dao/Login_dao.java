package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import connector.Connector;
import controller.Login_Controller;

public class Login_dao<login_Controller> {

    private  Connector connector = new Connector("jdbc:mysql://localhost:3306/justthinkit", "Login", "password");
   

    public Login_dao() {
       
       
    }


    public boolean login(String email, String password) {
    	
      if (checkEmail(email).equals("")) {
         System.out.println("\t***** ERROR: EMAIL IS NOT CORRECT *****");
         return false;
        } else {
            if (checkPassword(email, password)) {
                System.out.println("\t***** LOGGED SUCCESSFULLY *****");
                
                return true;
            } else {
                System.out.println("\t***** ERROR: PASSWORD IS NOT CORRECT *****");
                return false;
            }
        }
    }
    


    
    
    
    public String checkEmail(String email) {
        String sql = "SELECT Email FROM utenti WHERE Email = ?";
        ResultSet res = null;
        String returnedEmail = "";


        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
  
            res = stmt.executeQuery();

            while (res.next()) {
                String mail = res.getString("Email");
                if (mail.equals(email)) {
                    returnedEmail = email;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return returnedEmail;
    }
    
    public boolean checkPassword(String email, String password) {
        String sql = "SELECT Password, Codice FROM utenti WHERE Email = ?";
        ResultSet res = null;
        boolean check = false;
      
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);


            res = stmt.executeQuery();

            while (res.next()) {
                String psw = res.getString("Password");
                if (psw.equals(password)) {
                    check = true;
                    String cdc = res.getString("Codice");
                   Login_Controller Plogin = new Login_Controller();
                   Plogin.aprimenu(cdc);
                } else check = false;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return check;
    }
}
