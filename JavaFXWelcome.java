/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxwelcome;

import org.apache.derby.client.am.Connection;
import java.sql.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author kateromanova
 */
public class JavaFXWelcome extends Application {

    /**
     * @param args the command line arguments
     */
    
    
    
    
        public TextField usernameField;
        public TextField passwordField;
        public Properties properties;
        public String dbUrlFields;
        public String dbLogFields;
        public String dbPassFields;
        public Label passCheck;
        public Button logIn;
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        properties = new Properties();
        File propertyFile = new File("property.prop");
        
        readProperties(propertyFile);
        
        Label userName = new Label("User Name");
        usernameField = new TextField();
        
        Label password = new Label("Password");
        passwordField = new TextField();
        
        logIn = new Button("Sign in");
        logIn.setOnAction(e -> getUserData());
        
        passCheck = new Label("");
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setGridLinesVisible(false);
        root.setMinWidth(1.0);
        root.setVgap(10);
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.setHgap(10);
        
       
        
        root.add(userName, 0, 0, 1, 1);
        root.add(usernameField, 1, 0, 3, 1);
        
        root.add(password, 0, 1, 1, 1);
        root.add(passwordField, 1, 1, 3, 1);
        
        root.add(passCheck, 3, 3, 1, 1);
        
        
        
        root.add(logIn, 3, 3, 1, 1);
        
        
        
        Scene scene = new Scene(root, 700,800);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
        public void getUserData(){
            String userName = usernameField.getText();
            String passwordIn = passwordField.getText();
            boolean dataExist = false;
            
            try(Connection conn =  (Connection) DriverManager.getConnection(dbUrlFields, dbLogFields, dbPassFields)){
             Statement stm = conn.createStatement();{
                ResultSet rs = stm.executeQuery("SELECT NAME, PASSWORD FROM USERS");
                while(rs.next()){
                    String checkUser = rs.getString(1);
                    String checkPass = rs.getString(2);
                    if(userName.equals(checkUser) && passwordIn.equals(checkPass)){
                        dataExist = true;
                        break;
                    } 
                }
                
                if(dataExist == true){
                    //passCheck.setText("Successfull!");
                    //    logIn.setVisible(false);
                    
                    new JavaFXTableExample().init();
                    
                    
                        
                }
                else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Проверка");
                        alert.setHeaderText("Проверка имени и пароля");
                        alert.setContentText("Указанный логин и пароль не существуют");
                        alert.showAndWait();
                        usernameField.setText("");
                        passwordField.setText("");
                        
                }
                

            }
            
            } catch (SQLException ex) {
                Logger.getLogger(JavaFXWelcome.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
        
    
        public void readProperties(File propertyFile){
            
            try{
                
            properties.load(new FileReader(propertyFile));
            
            
            dbUrlFields = properties.getProperty("db.url");
            dbLogFields = properties.getProperty("db.user");
            dbPassFields = properties.getProperty("db.password");
          
            
            
            
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXWelcome.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
