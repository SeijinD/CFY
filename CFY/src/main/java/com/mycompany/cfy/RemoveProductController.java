package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;

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

public class RemoveProductController {
    
    @FXML
    private Button help, closeButton, remove_product, refresh_product;
    
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
    void Refresh_Product(ActionEvent event)
    {
        TableViewProducts.getItems().clear();
        this.initialize();
    }
    
    @FXML
    void Remove_Product(ActionEvent event) throws Exception 
    {
       ProductsModel productsModel = TableViewProducts.getSelectionModel().getSelectedItem();
       
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            statement.executeUpdate("Select * from remove_product('"+ productsModel.getName() +"')");

            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        }  
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

            rs = statement.executeQuery("SELECT * FROM cfy_products_view()");
            while(rs.next())
            {
                listview.add(new ProductsModel(
                        rs.getString("n"),
                        rs.getString("s"),
                        rs.getInt("p"),
                        imageView = new ImageView(rs.getString("u")),
                        rs.getString("u"),
                        rs.getString("pi")
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
