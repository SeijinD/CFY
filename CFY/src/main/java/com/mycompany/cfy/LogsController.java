package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class LogsController {
    
    @FXML
    private Button closeButton;
    
        private ListView logs_view; 
     
    public void initialize() throws Exception 
    { 
        String selectString = "SELECT * FROM cfy_user_logs"; 
         
        try 
        { 
            dbConnection = DriverManager.getConnection (url, username, passwd); 
            statement    = dbConnection.createStatement(); 
 
            rs = statement.executeQuery(selectString); 
            while(rs.next()) 
            { 
                String i = rs.getString("log_id"); 
                String a = rs.getString("operation"); 
                String ts = rs.getString("oper_time"); 
                String u = rs.getString("username"); 
                String p=  rs.getString("pass"); 
                String t = rs.getString("type_user"); 
                String n = rs.getString("name"); 
                String s = rs.getString("surname"); 
                String e = rs.getString("email"); 
 
                String User_Log = "Id: " + i  
                                    + " |Action: " + a  
                                    + " |Action Time: " + ts  
                                    + " |Username: " + u  
                                    + " |Password: " + p  
                                    + " |User Type: " + t 
                                    + " |Name: " + n 
                                    + " |Surname: " + s 
                                    + " |Email: " + e; 
                logs_view.getItems().add(User_Log); 
            } 
            statement.close(); 
            dbConnection.close(); 
        } catch(SQLException e) 
        { 
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e); 
        }  
    }
    
    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }   
}
