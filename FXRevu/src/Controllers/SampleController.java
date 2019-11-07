package Controllers;

import java.io.IOException;
import java.net.URL;

import dao.ClientDAO;
import dao.Connexion;
import dao.Persistance;
import factory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class SampleController {

    @FXML
    private TabPane Tabs;

    @FXML
    private AnchorPane Grevue;

    @FXML
    private Button Gperio;

    @FXML
    private Button Gclients;

    @FXML
    private CheckBox ClientSQL;

    @FXML
    private CheckBox ClientListe;

    @FXML
    private Button Gabo;
    
    

    @FXML
    void ClickListe(ActionEvent event) {
    	
    	System.out.print("happens");
    	
    	ClientSQL.setSelected(false);
    	ClientListe.setSelected(true);
    }

    @FXML
    void ClickSQL(ActionEvent event) {

    	ClientListe.setSelected(false);
    	ClientSQL.setSelected(true);
    }

    @FXML
    void VueAbonnements(ActionEvent event) {

    }

    @FXML
    void VueClients(ActionEvent event) {
    	try {
			URL fxmlURL = getClass().getResource("../application/SampleClient.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Gestion de Clients");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void VuePerio(ActionEvent event) {
    	try {
			URL fxmlURL = getClass().getResource("../application/SamplePeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Gestion de Revues");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void VueRevue(ActionEvent event) {
    	try {
			URL fxmlURL = getClass().getResource("../application/SampleRevue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Gestion de Revues");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public Persistance getpersistance() {

    	if(ClientSQL.isSelected() == true){
    		return Persistance.MYSQL;
    	}
    	else {
    		return Persistance.LISTE_MEMOIRE;
    	}
    	
    	
    }

}