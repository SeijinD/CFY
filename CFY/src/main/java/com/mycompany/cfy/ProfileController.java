package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;
import static com.mycompany.cfy.LoginController.userEdit;
import static com.mycompany.cfy.LoginController.userType;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProfileController {
    
    @FXML
    private Button closeButton, closeButton1, help, saveChanges, change_profile, open_logs,upload_image_profile;
    
    @FXML
    private ImageView image;

    @FXML
    private TextField change_age, change_name, change_email, change_surname;
    
    @FXML
    private ComboBox<String> change_gender;

    @FXML
    private Label gender, age, email, name, surname;
    
    @FXML
    private Pane profile_view, profile_change;
    
    String url_image = "";
    
    @FXML
    void Upload_Image_Profile(ActionEvent event) throws FileNotFoundException
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Product Image");
        File file = fileChooser.showOpenDialog(null);
        
        if (file != null) {
            url_image = file.toURI().toString();
        }
    }  
    
    @FXML
    void Save_Profile(ActionEvent event) 
    { 
      String s_name = change_name.getText();
      String s_surname = change_surname.getText();
      String s_email = change_email.getText();
      int s_age = 0;
      if (!change_age.getText().equals("") && !change_age.getText().equals(null))
      {
        s_age = Integer.parseInt(change_age.getText());
      }
      
      int s_gender = 0;
        switch (change_gender.getValue()) {
            case "Male":
                s_gender = 1;
                break;
            case "Female":
                s_gender = 2;
                break;
            case "Other":
                s_gender = 3;
                break;
            default:
                break;
        }
     
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();
            statement.executeUpdate("UPDATE cfy_accounts SET name='" + s_name 
                                                        + "',surname='" + s_surname 
                                                        + "',gender='" + s_gender 
                                                        + "',age='" + s_age 
                                                        + "',email='" + s_email
                                                        + "',url_image='" + url_image 
                                                        + "'  WHERE username='" + userEdit + "'");
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        }

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Change_Profile(ActionEvent event) 
    {
        profile_view.setVisible(false);
        profile_change.setVisible(true);
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
    
    @FXML
    public void Open_Logs(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Logs","Logs",800,500);
    }
    
    public void initialize() 
    {
        if(userType.equals("Admin"))
        {
            open_logs.setVisible(true);
        }
            
        String v_gender = "";
        String v_age = "";
        String v_email = "";
        String v_name = "";
        String v_surname = "";
        
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();

            rs = statement.executeQuery("SELECT gender, age, email, name, surname, url_image FROM cfy_accounts WHERE username='" + userEdit + "'");
            while(rs.next())
            {
                v_gender = rs.getString("gender");
                v_age = rs.getString("age");
                v_email = rs.getString("email");
                v_name =  rs.getString("name");
                v_surname = rs.getString("surname");
                url_image = rs.getString("url_image");
            }
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        } 
        if (v_gender != null)
        {
            switch (v_gender) {
                case "1":
                    gender.setText("Male");
                    break;
                case "2":
                    gender.setText("Female");
                    break;
                default:
                    gender.setText("Other");
                    break;
            }
        }
        
        if (v_age != null)    
        {
            age.setText(v_age);
            change_age.setText(v_age);
        }
        if (v_email != null)
        {
            email.setText(v_email);
            change_email.setText(v_email);
        }
        if (v_name != null)
        {
            name.setText(v_name);
            change_name.setText(v_name);
        }
        if (v_surname != null)
        {
            surname.setText(v_surname);
            change_surname.setText(v_surname);
        } 
        
        Image img = new Image(url_image);
        image.setImage(img);
        
    }  
}
