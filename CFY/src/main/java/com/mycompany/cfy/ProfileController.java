package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProfileController {
    
    @FXML
    private Button closeButton, closeButton1, help, saveChanges, change_profile;
    
     @FXML
    private ImageView image, change_image;

    @FXML
    private TextField change_age, change_name, change_email, change_surname, change_gender;

    @FXML
    private Label gender, age, email, name, surname;

    @FXML
    void Save_Profile(ActionEvent event) 
    {

    }

    @FXML
    void Change_Profile(ActionEvent event) 
    {
        
    }
       
    @FXML
    void Help(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Help","Help",800,500);
    }
    
    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
