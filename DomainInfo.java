/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxwelcome;

import static java.nio.file.Files.list;
import java.sql.Date;
import java.sql.SQLException;
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author kateromanova
 */
public class DomainInfo extends Stage {
    
    private int personid;

    public DomainInfo(int personid) {
        this.personid = personid;
        System.out.println(personid);
    }

    

    
    
    public void init(){
            ObservableList<Domain> domains = FXCollections.observableArrayList(new Repository().getAllDomain(personid));
            TableView <Domain> table = new TableView<>(domains);
    
            TableColumn<Domain, Integer> idCol = new TableColumn<>("ИД");
            idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
            table.getColumns().add(idCol);
            
            TableColumn<Domain, String> webSite = new TableColumn<>("Сайт");
            webSite.setCellValueFactory(new PropertyValueFactory<>("WebName"));
            table.getColumns().add(webSite);
            
            TableColumn<Domain, String> domen = new TableColumn<>("Домен");
            domen.setCellValueFactory(new PropertyValueFactory<>("DomainName"));
            table.getColumns().add(domen);
            
            TableColumn<Domain, String> ip = new TableColumn<>("IP");
            ip.setCellValueFactory(new PropertyValueFactory<>("Ip"));
            table.getColumns().add(ip);
            
            TableColumn<Domain, Date> datereg = new TableColumn<>("Дата регистрации");
            datereg.setCellValueFactory(new PropertyValueFactory<>("DateReg"));
            table.getColumns().add(datereg);
            
            TableColumn<Domain, String> country = new TableColumn<>("Страна регистрации");
            country.setCellValueFactory(new PropertyValueFactory<>("CountryReg"));
            table.getColumns().add(country);
            
            TableColumn<Domain, Integer> personid = new TableColumn<>("Клиент");
            personid.setCellValueFactory(new PropertyValueFactory<>("PersonId"));
            table.getColumns().add(personid);
            
            
            StackPane root = new StackPane();
            root.getChildren().add(table);

            Scene scene = new Scene(root, 800,900);

            setScene(scene);
            setTitle("Domains");
            initModality(Modality.APPLICATION_MODAL);
            showAndWait();

    

        
        }
    }
    

