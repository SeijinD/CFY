package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {
    
    @FXML
    private TextField TextField_Size, TextField_Name, TextField_Price;

    @FXML
    private Button help, add_product, closeButton;

    @FXML
    private ComboBox<?> Category_to_add;
    
    @FXML
    private Label messageAddProduct;

    @FXML
    void Add_Product(ActionEvent event) 
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
