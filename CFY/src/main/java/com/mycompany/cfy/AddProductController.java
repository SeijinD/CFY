package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddProductController {
    
    @FXML
    private TextField TextField_Size, TextField_Name, TextField_Price;

    @FXML
    private Button help, add_product, closeButton;

    @FXML
    private ComboBox<String> Category_to_add;
    
    @FXML
    private Label messageAddProduct;
    
    @FXML
    private Button upload_image_product;
     
    String url_image = "";
    
    
    @FXML
    void Upload_Image_Product(ActionEvent event) throws FileNotFoundException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Product Image");
        File file = fileChooser.showOpenDialog(null);
        
        if (file != null) {
            url_image = file.toURI().toString();
        }
    }  

    @FXML
    void Add_Product(ActionEvent event) throws Exception
    {
        String name = TextField_Name.getText();
        String size = TextField_Size.getText();
        String price = TextField_Price.getText();
        String category = Category_to_add.getValue();
        
        if(name != null && size != null && price != null && category != null && url_image != null)
        {
            try
            {
                dbConnection = DriverManager.getConnection (url, username, passwd);
                statement = dbConnection.createStatement();
                rs = statement.executeQuery("SELECT * FROM cfy_products_add_check('" + name +"','"+ size +"',"+ price +",'"+ category +"','"+ url_image +"')");            
                
            } catch(SQLException e)
            {
                com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
            }
            
            if(rs.next() == false)
            {
                try
                {
                    dbConnection = DriverManager.getConnection (url, username, passwd);
                    statement    = dbConnection.createStatement();
                    statement.executeUpdate("SELECT * FROM cfy_products_add('" + name +"','"+ size +"',"+ price +",'"+ category +"','"+ url_image +"')");    
                    messageAddProduct.setText("The Product added!");
                
                    statement.close();
                    dbConnection.close();
                } 
                catch(SQLException e)
                {
                    com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
                }
                TextField_Name.clear();
                TextField_Size.clear();
                TextField_Price.clear();
            }
            else
            {
                messageAddProduct.setText("Τhe product already exists!");
            }
            
        }
        else
        {
            messageAddProduct.setText("Υou must complete all fields!");
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
}
