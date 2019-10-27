package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;
import static com.mycompany.cfy.LoginController.passEdit;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ResetPasswordController {

    @FXML
    private Label messageResetPassword;
    
    @FXML
    private PasswordField NewPassword, oldPassword, ConfirmPassword;

    @FXML
    private Button SaveResetPassword, closeButton;
               
    @FXML
    void Save_Reset_Password(ActionEvent event)
    {      
        if(passEdit.equals(oldPassword.getText()))
        { 
            if (NewPassword.getText().equals(ConfirmPassword.getText()))
            {
                String pass = NewPassword.getText();
                try
                {
                    dbConnection = DriverManager.getConnection (url, username, passwd);
                    statement    = dbConnection.createStatement();
                    statement.executeUpdate("UPDATE cfy_accounts SET password='" + pass + "' WHERE username='" + userEdit + "'");
                    statement.close();
                    dbConnection.close();
                } catch(SQLException e)
                {
                    com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
                }
                messageResetPassword.setText("Password Changed");
            }
            else
            {
                messageResetPassword.setText("Different Passwords");
            }
        }
        else
        {
            messageResetPassword.setText("Old Password is false");
        }
    }   

    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
