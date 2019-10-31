package com.mycompany.cfy;

import static com.mycompany.cfy.InfoConnection.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitController {

    @FXML
    private Button noExitButton;
    @FXML
    private Button yesExitButton;
    
    @FXML
    public void NoExit(ActionEvent event)
    {
        Stage stage = (Stage) noExitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void YesExit(ActionEvent event)
    {
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
        System.exit(0);
    }
}
