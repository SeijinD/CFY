package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResetUsernameController {
    
    @FXML
    private Label messageResetUsername;

    @FXML
    private TextField oldUsername, NewUsername, ConfirmUsername;

    @FXML
    private Button SaveResetUsername, closeButton;

    @FXML
    void Save_Reset_Username(ActionEvent event) 
    {      
        if(userEdit.equals(oldUsername.getText()))
        {
            if (NewUsername.getText().equals(ConfirmUsername.getText()))
            {
                String user = NewUsername.getText();
                try
                {
                    dbConnection = DriverManager.getConnection (url, username, passwd);
                    statement    = dbConnection.createStatement();
                    statement.executeUpdate("SELECT cfy_accounts_reset_username('" + user + "','" + userEdit + "')");
                    statement.close();
                    dbConnection.close();
                } catch(SQLException e)
                {
                    com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
                }
                messageResetUsername.setText("Username Changed");
            }
            else
            {
                messageResetUsername.setText("Different Usernames");
            }
        }
        else
        {
            messageResetUsername.setText("Old Username is false");
        }
    }

    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
