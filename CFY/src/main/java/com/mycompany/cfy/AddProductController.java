package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    private ImageView productImage;

    @FXML
    void Add_Product(ActionEvent event) throws Exception
    {
        String name = TextField_Name.getText();
        String size = TextField_Size.getText();
        String price = TextField_Price.getText();
        String category = Category_to_add.getValue();
        
        if(name != null && size != null && price != null && category != null)
        {
            try
            {
                dbConnection = DriverManager.getConnection (url, username, passwd);
                statement = dbConnection.createStatement();
                rs = statement.executeQuery("SELECT * FROM cfy_products WHERE name='" + name + 
                                                          "' AND size='" + size +
                                                          "' AND price='" + price +
                                                          "' AND category='" + category +
                                                          "'");                
                
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
                    statement.executeUpdate("insert INTO cfy_products (name, size, price, category) VALUES ('" + name +
                                                                                                                 "','" + size + 
                                                                                                                 "','" + price + 
                                                                                                                 "','" + category + 
                                                                                                                 "')");
                    messageAddProduct.setText("The Product added!");
                
                    statement.close();
                    dbConnection.close();
                } 
                catch(SQLException e)
                {
                    com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
                }  
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
