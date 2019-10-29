package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;

import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController {
    

    @FXML
    private Button mplouzes, eksesouar, pappotsia, foustes, eswrouxa, pantelonia, tsantes, foremata, panoforia, kapela;

    @FXML
    private Button reset_password, reset_username, delete_account, closeButton, help, profile, settings, add_product;
    
    @FXML
    private ImageView imageProfile;
    
    //Products
    @FXML
    void Open_Mplouzes(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("T-Shirts","Products","T-Shirts");
    }

    @FXML
    void Open_Pantelonia(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Pants","Products","Pants");
    }

    @FXML
    void Open_Pappotsia(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Shoes","Products","Shoes");
    }

    @FXML
    void Open_Eswrouxa(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Underclothes","Products","Underclothes");
    }

    @FXML
    void Open_Tsantes(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Bags","Products","Bags");
    }

    @FXML
    void Open_Kapela(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Hats","Products","Hats");
    }

    @FXML
    void Open_Panoforia(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Coats","Products","Coats");
    }

    @FXML
    void Open_Foustes(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Skirts","Products","Skirts");
    }

    @FXML
    void Open_Foremata(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Dresses","Products","Dresses");
    }

    @FXML
    void Open_Eksesouar(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenProduct("Accessories","Products","Accessories");
    }
    //End Products
    
    @FXML
    void Reset_Password(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Reset Password","ResetPassword",500,400);
    }


    @FXML
    void Reset_Username(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Reset Username","ResetUsername",500,400);
    }

    @FXML
    void Delete_Account(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Delete Account","DeleteAccount",500,400);
    }
       
    @FXML
    void Add_Product_Database(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Add Product","AddProduct",600,500);
    }

    @FXML
    void Open_Basket(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Basket","Basket",800,500);
    }

    @FXML
    void Open_Settings(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Main Settings","MainSettings",500,400);
    }

    @FXML
    void Profile(ActionEvent event) throws Exception 
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Profile","Profile",800,310);
    }
    
    @FXML
    public void Help(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Help","Help",800,500);
    }
      
    @FXML
    public void Exit(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Exit","Exit",400,260);
    }
    
     public void initialize() 
    {
        /*
        String url_image = "";
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            rs = statement.executeQuery("SELECT url_image FROM cfy_accounts WHERE username='" + userEdit + "'");
            while(rs.next())
            {
                url_image = rs.getString("url_image");
            }
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        } 
                
        Image img = new Image(url_image);
        imageProfile.setImage(img);
        */
    }
}
