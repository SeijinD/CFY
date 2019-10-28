package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProductsController {
    
    @FXML
    private Button help, closeButton, add_product;

    @FXML
    private TableColumn<?, ?> TableViewAdd;
    
    @FXML
    private TableColumn<?, ?> TableViewPrice;
    
    @FXML
    private TableColumn<?, ?> TableViewImage;
    
    @FXML
    private TableColumn<?, ?> TableViewSize, TableViewName;
    
    @FXML
    private TableView<?> TableViewProducts;

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
    
    public void initialize() 
    {
        
    }
}
