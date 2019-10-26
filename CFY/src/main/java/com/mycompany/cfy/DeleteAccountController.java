package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class DeleteAccountController {
    
    @FXML
    private Button DeleteAccountButton, closeButton;

    @FXML
    private CheckBox sureBox;

    @FXML
    void Delete_Account(ActionEvent event) throws Exception
    {

    }   

    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
