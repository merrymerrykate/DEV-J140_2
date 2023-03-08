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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author kateromanova
 */
public class JavaFXTableExample extends Stage {

    private int personid;

    /**
     * @param args the command line arguments
     */
    

    
    public void init() {
    
        Repository repository = new Repository();
        List<Person> persons = repository.getAllPersonWithDomain();
        //List<PersonDto> personDto = new ArrayList<>();
        //persons.forEach(per -> personDto.add(new PersonDto(per)));
        System.out.println(repository.getAllPerson().size());
        List<PersonDto> personDto = persons.stream().map(per -> new PersonDto(per)).collect(Collectors.toList());
        ObservableList list = FXCollections.observableArrayList(personDto);
        System.out.println("list " + list.size());
        
        TableView <PersonDto> table = new TableView<>(list);
        
        /*table.setRowFactory(e -> {
            TableRow<Person> row = new TableRow<>();
            row.setOnMouseClicked(mouse -> {
                if(mouse.getClickCount()== 2){
                    new DomainInfo(row.getItem()).init();
                    
                    
            }
            });
            return row;
        });*/
        
       table.setOnMouseClicked(e -> {
            if(e.getClickCount()== 2){
                PersonDto person = table.getSelectionModel().getSelectedItem();
                System.out.println(person);
                //primaryStage.close();
                new DomainInfo(person.getId()).init();
            }
        });
        
        TableColumn<PersonDto, Integer> idCol = new TableColumn<>("ИД");
        idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        table.getColumns().add(idCol);
        
        TableColumn<PersonDto, String> jobTitle = new TableColumn<>("Позиция");
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("JobTitle"));
        table.getColumns().add(jobTitle);
        
        TableColumn<PersonDto, String> fnln = new TableColumn<>("Фамилия и имя");
        fnln.setCellValueFactory(new PropertyValueFactory<>("FirstNameLastName"));
        table.getColumns().add(fnln);
        
        TableColumn<PersonDto, String> phonenum = new TableColumn<>("Телефон");
        phonenum.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        table.getColumns().add(phonenum);
        
        TableColumn<PersonDto, String> mail = new TableColumn<>("Почта");
        mail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        table.getColumns().add(mail);
        
        TableColumn<PersonDto, Integer> countCol = new TableColumn<>("Количество");
        countCol.setCellValueFactory(new PropertyValueFactory<>("DomainCount"));
        table.getColumns().add(countCol);
        
        StackPane root = new StackPane();
        root.getChildren().add(table);
        
        Scene scene = new Scene(root, 800,900);
        
        setScene(scene);
        setTitle("Table View");
        initModality(Modality.APPLICATION_MODAL);
        showAndWait();
    
        
    }
    
}
