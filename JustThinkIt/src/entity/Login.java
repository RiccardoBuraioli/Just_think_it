package entity;


import java.sql.*;

import controller.Connector;
import dao.Login_dao;

public class Login {

    private final Connector connector;
    public int tableUser;


    public Login(Connector connector) {
        this.connector = connector;

    }
    
    public int getTableUser() {
        return this.tableUser;
    }
 
    public void setTableUser(int num) {
        this.tableUser = num;
    }

    public int checkLogin(String email, String password) {
        String sqlUser = "SELECT Codice FROM utenti WHERE Email = ? AND Password = ?";
      
        ResultSet res = null;
        int returnePriv = 0;

        //Cerca nei volontari
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUser)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            res = stmt.executeQuery();

            while (res.next()) {
                int priv = res.getInt("Codice");
                returnePriv = priv;
              
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
    
        			
        	 if( returnePriv == 3) {
        			setTableUser(3);
        			
        		}
        		
        	 else if( returnePriv == 2) {
        		setTableUser(2);
        		
        	}
        	
        	
         else if( returnePriv == 1) {
        	setTableUser(1);
        
        }
			return returnePriv;
    }


 
    public int returnID(String email, int table) {
    	
    	String sql;
    	String resID = null;
    	int ID;
    	
       	sql = "SELECT id_utente FROM utenti WHERE Email = ?";
    
    	ResultSet res = null;
    	try (Connection conn = connector.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setString(1, email);
               res = stmt.executeQuery();

               while (res.next()) {
            	   resID = res.getString("id_utente");
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
    	
    	ID = Integer.parseInt(resID);
    	return ID;
    	
    }

    
    //Probabilmente sbagliata
    //Serve a ritornare l'ID della mail corrispondente (nel sistema non ci possono essere due mail uguali)
   

}


