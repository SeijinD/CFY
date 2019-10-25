package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddProductController {
    
       
    
    @FXML
    private Button closeButton;
    
    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
