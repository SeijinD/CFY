package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    private Label messageLogin;
    @FXML
    private TextField userNameLogin;  
    @FXML
    private PasswordField passwordLogin;
    @FXML
    private Button loginButton;
 
    static String userEdit = "";
    static String userType = "";
    static String passEdit = "";
    static String url_image = "";
    
    @FXML
    public void Login(ActionEvent event) throws Exception
    {
        try
        {
            dbConnection = DriverManager.getConnection (url, username, passwd);
            statement    = dbConnection.createStatement();
            String user = userNameLogin.getText();
            String pass = passwordLogin.getText();
            String selectString = "Select * from cfy_accounts_login_check('"+user+"','"+pass+"')";
            rs = statement.executeQuery(selectString); 
            if(user.equals("") || pass.equals(""))
                messageLogin.setText("Username or Password is empty!");
            else if(rs.next())
            {
                int type_user = Integer.parseInt(rs.getString("t"));
                Stage main = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
                main.initStyle(StageStyle.TRANSPARENT);       
                root.setOnMousePressed((MouseEvent event1) -> {
                    xOffset = event1.getSceneX();
                    yOffset = event1.getSceneY();
                });  
                root.setOnMouseDragged((MouseEvent event1) -> {
                    main.setX(event1.getScreenX() - xOffset);
                    main.setY(event1.getScreenY() - yOffset);
                });       
                main.setTitle("Main");
                Scene scene = new Scene(root,800,500);
                main.setScene(scene);          
                main.show();                
                userEdit = user;
                passEdit = pass;
                if (type_user == 1)
                    userType = "Admin";
                else
                    userType = "User";
                
                if(type_user == 1)
                {
                    ((Button) scene.lookup("#add_product")).setVisible(true);
                    ((Button) scene.lookup("#remove_product")).setVisible(true);
                }   
                //---------------------------------------------------------------------------------
                try
                {
                    dbConnection = DriverManager.getConnection (url, username, passwd);
                    statement    = dbConnection.createStatement();

                    rs = statement.executeQuery("SELECT * FROM cfy_accounts_login_url_image('" + userEdit + "')");
                    while(rs.next())
                    {
                        url_image = rs.getString("cfy_accounts_login_url_image");
                    }
                    statement.close();
                    dbConnection.close();
                } catch(SQLException e)
                {
                    com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
                }

                if (!url_image.equals("") &&  url_image != null)
                {
                    Image img = new Image(url_image);
                    ((ImageView) ((Button) scene.lookup("#profile")).lookup("#imageProfile")).setImage(img);                
                }

                //---------------------------------------------------------------------------------
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close(); 
            }
            else
            {
               messageLogin.setText("User not found!");
            }
            statement.close();
            dbConnection.close();
        } catch(SQLException e)
        {
            com.mycompany.cfy.Handlers.sqlExceptionHandler(e);
        }
    }
    
    @FXML
    public void Create(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Create Account","SignIn",400,315);
    }

    @FXML
    public void Exit(ActionEvent event) throws Exception
    {
        com.mycompany.cfy.InfoConnection.OpenWindow("Exit","Exit",400,260);
    }
}