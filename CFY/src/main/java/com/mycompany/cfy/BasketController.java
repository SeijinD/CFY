package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;

import java.sql.DriverManager;
import java.sql.SQLException;
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
    static TableColumn<ProductsModel, String> TableView2Size, TableView2Name;
    
    @FXML
    static TableColumn<ProductsModel, Integer> TableView2Price;
    
    @FXML
    static TableColumn<ProductsModel, ImageView> TableView2Image;

    @FXML
    static TableView<ProductsModel> TableViewBasket;
    
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
    
    public void initialize()
    {   
       TableView2Name.setCellValueFactory(new PropertyValueFactory<>("name"));
       TableView2Size.setCellValueFactory(new PropertyValueFactory<>("size")); 
       TableView2Price.setCellValueFactory(new PropertyValueFactory<>("price")); 
       TableView2Image.setCellValueFactory(new PropertyValueFactory<>("image"));
             
       ImageView imageView;
       
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            rs = statement.executeQuery("SELECT name, size, price, url_image FROM cfy_products WHERE category='" + categoryProduct +"'");
            while(rs.next())
            {
                listviewBasket.add(new ProductsModel(
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getInt("price"),
                        imageView = new ImageView(rs.getString("url_image")),
                        rs.getString("url_image")
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
       TableViewProducts.setItems(listview);
    }
}
