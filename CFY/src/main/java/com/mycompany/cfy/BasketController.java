package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.ProductsController.price;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BasketController {
    
    @FXML
    private Button help,buy_products, remove_product,closeButton;

    @FXML
    private TableColumn<ProductsModel, String> TableView2Size, TableView2Name;
    
    @FXML
    private TableColumn<ProductsModel, Integer> TableView2Price;
    
    @FXML
    private TableColumn<ProductsModel, ImageView> TableView2Image;

    @FXML
    private TableView<ProductsModel> TableViewBasket;
    
    @FXML
    void Remove_product(ActionEvent event) throws Exception
    {
        ProductsModel productsModel = TableViewBasket.getSelectionModel().getSelectedItem();
        
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            statement.executeUpdate("DELETE FROM cfy_basket WHERE product_id='"+ productsModel.getId() +"'");

            price -= productsModel.getPrice();
            
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        }
        Stage stage = (Stage) remove_product.getScene().getWindow();
        stage.close();
        com.mycompany.cfy.InfoConnection.OpenWindow("Basket","Basket",800,500);
    }

    @FXML
    void Buy_Products(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Buy Products","Buy",500,400);
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
        ObservableList<ProductsModel> listviewBasket = FXCollections.observableArrayList();
        
       TableView2Name.setCellValueFactory(new PropertyValueFactory<>("name"));
       TableView2Size.setCellValueFactory(new PropertyValueFactory<>("size")); 
       TableView2Price.setCellValueFactory(new PropertyValueFactory<>("price")); 
       TableView2Image.setCellValueFactory(new PropertyValueFactory<>("image"));
             
       ImageView imageView;
       
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            rs = statement.executeQuery("SELECT name, size, price, url_image, product_id FROM cfy_basket");
            while(rs.next())
            {
                listviewBasket.add(new ProductsModel(
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getInt("price"),
                        imageView = new ImageView(rs.getString("url_image")),
                        rs.getString("url_image"),
                        rs.getString("product_id")
                ));
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                
            }
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        }         
       TableViewBasket.setItems(listviewBasket);
    }
}
