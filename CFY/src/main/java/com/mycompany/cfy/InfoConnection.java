package com.mycompany.cfy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InfoConnection {
    // Standar info connection
    static String     driverClassName = "org.postgresql.Driver" ;
    static String     url             = "jdbc:postgresql://dblabs.it.teithe.gr:5432/it175058" ;
    static Connection dbConnection    = null;
    static String     username        = "it175058";
    static String     passwd          = "nikopoli";
    static Statement  statement       = null;
    static ResultSet  rs              = null;
    //End
    static double xOffset = 0;
    static double yOffset = 0;
    
    public static void OpenWindow(String title, String fxml, int weight, int height) throws Exception
    {        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));       
        stage.initStyle(StageStyle.TRANSPARENT);       
        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });  
        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });       
        stage.setTitle(title);
        Scene scene = new Scene(root,weight,height);
        stage.setScene(scene);   
        stage.show();  
    }
    
    public static void OpenProduct(String title, String fxml) throws Exception
    {        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));       
        stage.initStyle(StageStyle.TRANSPARENT);       
        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });  
        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });       
        stage.setTitle(title);
        Scene scene = new Scene(root,800,500);
        stage.setScene(scene);   
        stage.show();  
    }
    
}
