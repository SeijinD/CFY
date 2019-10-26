package com.mycompany.cfy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class BasketController {
    
    @FXML
    private Button help,buy_products, remove_product,closeButton;

    @FXML
    private TableColumn<?, ?> TableView2Remove, TableView2Image, TableView2Name, TableView2Price;

    @FXML
    private TableView<?> TableViewBasket;

    @FXML
    void Remove_product(ActionEvent event) throws Exception
    {

    }

    @FXML
    void Buy_Products(ActionEvent event) throws Exception
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
