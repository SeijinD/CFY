package com.mycompany.cfy;

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

    }

    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
