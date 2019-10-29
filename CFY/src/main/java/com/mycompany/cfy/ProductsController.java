package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;
import com.mycompany.cfy.ProductsModel;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProductsController {
    
    @FXML
    private Button help, closeButton, add_product;
    
    @FXML
    private TableColumn<ProductsModel, Integer> TableViewPrice;
    
    @FXML
    private TableColumn<ProductsModel, ImageView> TableViewImage;
    
    @FXML
    private TableColumn<ProductsModel, String> TableViewSize, TableViewName;
    
    @FXML
    private TableView<ProductsModel> TableViewProducts;

    ObservableList<ProductsModel> listview = FXCollections.observableArrayList();
    
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
       TableViewName.setCellValueFactory(new PropertyValueFactory<>("name"));
       TableViewSize.setCellValueFactory(new PropertyValueFactory<>("size")); 
       TableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price")); 
       TableViewImage.setCellValueFactory(new PropertyValueFactory<>("image"));
             
       ImageView imageView;
       
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            rs = statement.executeQuery("SELECT name, size, price, url_image FROM cfy_products WHERE category='" + categoryProduct +"'");
            while(rs.next())
            {
                listview.add(new ProductsModel(
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getInt("price"),
                        imageView = new ImageView(rs.getString("url_image"))
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
