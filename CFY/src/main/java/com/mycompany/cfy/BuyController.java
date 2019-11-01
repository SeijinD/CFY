package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;
import static com.mycompany.cfy.ProductsController.price;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BuyController {
    
    @FXML
    private CheckBox sureBox;   
    
    @FXML
    private Button closeButton, finished_buy;
    
    @FXML
    private Label messageBuy, priceLabel;
    
    
    @FXML
    public void Finished_Buy() throws IOException
    {
        if (sureBox.isSelected())
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/Logs/Buy_Logs.txt", true));
            writer.write("==============================\n");
            writer.write(LocalDateTime.now() + "\n");
            writer.write("==============================\n");
            writer.write("User: " + userEdit + "\n");
            writer.write("==============================\n");
            writer.write("Price: " + price + "\n");
            writer.write("==============================\n");
            writer.close();
            
            try
            {
                dbConnection = DriverManager.getConnection (url, username, passwd);
                statement    = dbConnection.createStatement();

                statement.executeUpdate("DELETE FROM cfy_basket");

                statement.close();
                dbConnection.close();
            } catch(SQLException e)
            {
                com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
            }
                     
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            
        }
        else
        {
            messageBuy.setText("The checkBox is unselected.");
        }
    }
    
    @FXML
    public void Close(ActionEvent event)
    {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    public void initialize()
    {
        priceLabel.setText(String.valueOf(price));
    }
}
