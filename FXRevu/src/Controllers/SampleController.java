package Controllers;

import dao.Persistance;
import factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import metier.PeriodicitePOJO;
import metier.RevuePOJO;

public class SampleController{

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
    void TryCreation(ActionEvent event) {
    	
    
    	
    	System.out.println("Creation Pressed   ");
    	FrontRevue();
    	
    }
    
    @FXML
    void DescriptionEntered(ActionEvent event) {
    	
    }
    
    @FXML
    void FindPeriod() {
    		
    	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
    	
    	Periodicites.setItems(FXCollections.observableArrayList(daos.getPeriodiciteDAO().findAll()));
    
    
    }
    
    @FXML
    void initialize(){
    	
    	System.out.print("time");
 
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
			
			
			BackRevue(TitreField.getText().strip(),TarifField.getText().strip(),Periodicites.getValue());
		
			TitreField.clear();
			TarifField.clear();
		}
		
		
	}

	private void BackRevue(String strip, String strip2, PeriodicitePOJO periodicitePOJO) {
		

		Result_lbl.setTextFill(Color.BLACK);
		Result_lbl.setText(strip+" ("+strip2+" euros)");
		
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		daos.getRevueDAO().create(new RevuePOJO((int) Math.random()*50+1, strip, DescriptionField.toString(),Integer.parseInt(strip2), null, 0));
		
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
