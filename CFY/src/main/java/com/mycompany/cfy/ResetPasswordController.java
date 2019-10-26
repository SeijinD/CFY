package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResetPasswordController {

    @FXML
    private Label messageResetPassword;
    
    @FXML
    private TextField NewPassword, oldPassword, ConfirmPassword;

    @FXML
    private Button SaveResetPassword, closeButton;

    @FXML
    void Save_Reset_Password(ActionEvent event) {

    }   

    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
