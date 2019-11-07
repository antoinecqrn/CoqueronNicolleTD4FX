package Controllers;

import dao.Persistance;
import factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import metier.ClientPOJO;
import metier.PeriodicitePOJO;
import metier.RevuePOJO;

public class VueRevue{

    @FXML
    private FlowPane flowrida;
    
    @FXML
    private CheckBox periodicites;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField TarifField;

    @FXML
    private TextField TitreField;

    @FXML
    private TextArea DescriptionField;

    @FXML
    private ComboBox<PeriodicitePOJO> Periodicites;
    
    @FXML
    private Button Create;

    @FXML
    private Label Result_lbl;
    
    @FXML
    private TableView<RevuePOJO> RevueView;

    @FXML
    private TableColumn<RevuePOJO, String> TableTitre;

    @FXML
    private TableColumn<RevuePOJO, String> TableDescription;

    @FXML
    private TableColumn<RevuePOJO, String> TableIDP;

    @FXML
    private TableColumn<RevuePOJO, String> TableTarif;
    
    DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);

    @FXML
    void TryCreation(ActionEvent event) {
    	
    
    	
    	System.out.println("Creation Pressed   ");
    	FrontRevue();
    	
    }
    
    @FXML
    void DescriptionEntered(ActionEvent event) {
    	
    }
    
    @FXML
    void FindPeriod() {
    	
    	System.out.print("Find P");
    		
    	
    	Periodicites.setItems(FXCollections.observableArrayList(daos.getPeriodiciteDAO().findAll()));
    
    
    }
    
    @FXML
    void initialize() {
    	
    	TableTitre.setCellValueFactory(new PropertyValueFactory<>("title"));
    	TableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    	TableIDP.setCellValueFactory(new PropertyValueFactory<>("id_periode"));
    	TableTarif.setCellValueFactory(new PropertyValueFactory<>("tarifnum"));

    	
    	reset();
    }
    
    @FXML
    void reset() {
    			
    	RevueView.setItems(null);
    	RevueView.setItems(FXCollections.observableArrayList(daos.getRevueDAO().findAll()));
	}
    

	void FrontRevue() {
		
		System.out.println(Periodicites.isShowing());
		
		DescriptionField.setWrapText(true);// A mettre dans un event description
		
		Result_lbl.setTextFill(Color.RED); //Warning par default red
		
		if(TitreField.getText().isBlank()){
			
			Result_lbl.setText("Veuillez saisir le Titre de la Revue.");
			
		}
		else if(TarifField.getText().isBlank()){
			
			
			Result_lbl.setText("Veuillez saisir un prix en valeur numérique. (exemple : 2.4)");
			
		}
		else if(isNumeric(TarifField.getText().trim()) == false){
			
			Result_lbl.setText("Veuillez sélectionner un vrai prix. (exemple : 2.4)");
			
		}else{
			
		}
		
		
	}

	
    @FXML
    void AjouterRevue(ActionEvent event) {
    	
    	
    	FrontRevue();
    	Boolean noneabove;
    	
    	if(isStringOnlyAlphabet(TitreField.getText()) == true){
    		
    		noneabove = true;
    		if(isStringOnlyAlphabet(DescriptionField.getText()) == true && noneabove == true){
    			
    			
    				if(isNumeric(TarifField.getText().strip()) == true && noneabove == true) {
    					CreateRevue();
    					
    				}else {System.out.println("une vraie description stp");}
    		    	
    					
    		}else {System.out.println("une vraie description stp");}
    	
    	}else {System.out.println("un vrai titre stp");}
    	
    	
    	
    	
    		
    }

    
    @FXML
	private void CreateRevue() {
		
		PeriodicitePOJO p = Periodicites.getSelectionModel().getSelectedItem();
		
		
		
		RevuePOJO newrevue = new RevuePOJO(TitreField.getText(),
											DescriptionField.getText(),
											Double.parseDouble(TarifField.getText()),
											2);

try {

daos.getRevueDAO().create(newrevue);
initialize();
ClearFields();

}catch(Exception e) {

String Stack = e.getStackTrace().toString();
System.out.println(Stack);

Alert alert = new Alert(Alert.AlertType.ERROR);

alert.setTitle("Erreur lors de la saisie");
alert.setHeaderText("Exceptions rencontrée");
alert.setContentText(Stack);
alert.showAndWait();
}
		
	}

	private void ClearFields() {
		
		TitreField.clear();
		DescriptionField.clear();
		Periodicites.getSelectionModel().clearSelection();
		
	}
	
	 @FXML
	    void Empty() {

	    	//Lance fonction qui permet de voir si tt les champs sont rempli pour activer ajouter / le desativer 
	    	if(EmptyBool() == true) {
	    		Create.setDisable(false);
	    	}
	    	else{
	    		Create.setDisable(true);
	    	}

	    }

		private boolean EmptyBool() {
			
			
			if(TitreField.getText().isBlank() == false){
				if(DescriptionField.getText().isBlank() == false) {
					if(TarifField.getText().isBlank() == false){
						if(Periodicites.getSelectionModel().isEmpty() == false) {
							return true;
						}	
					}
				}
			}
			return false;
		}

	private boolean isStringOnlyAlphabet(String str) {
		
		return ((!str.equals("")) 
	            && (str != null) 
	            && (str.chars().allMatch(Character::isLetter)));
	}
	
	

	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}

}