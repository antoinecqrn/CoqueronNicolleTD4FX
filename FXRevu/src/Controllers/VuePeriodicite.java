package Controllers;

import dao.Persistance;
import factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import metier.PeriodicitePOJO;

public class VuePeriodicite {

    @FXML
    private FlowPane flowrida;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField LibelleField;

    @FXML
    private Button Create;

    @FXML
    private Label Result_lbl;

    @FXML
    private TableView<PeriodicitePOJO> PerioView;

    @FXML
    private TableColumn<PeriodicitePOJO, Integer> TableTitre;

    @FXML
    private TableColumn<PeriodicitePOJO, String> TableLibelle;

    @FXML
    private Button Modif;

    @FXML
    private Button Supp;

    @FXML
    private TextField IDSearch;

    @FXML
    private TextField LibelleSearch;

    @FXML
    private Button Search;

    @FXML
    private Button Reset;
    
    DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);

    @FXML
    void CreatePerio(ActionEvent event) {

    	
    	
    }
    
    @FXML
    void initialize() {

    	System.out.println(daos.getPeriodiciteDAO().findAll());
    	TableLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));


    	
    	reset();
    }
    
    @FXML
    void reset() {
    			
    	PerioView.setItems(null);
    	PerioView.setItems(FXCollections.observableArrayList(daos.getPeriodiciteDAO().findAll()));
	}
    	
    
    

}
