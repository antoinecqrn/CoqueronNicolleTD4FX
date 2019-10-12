package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class SampleController {

    @FXML
    private FlowPane flowrida;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField TarifField;

    @FXML
    private TextField TitreField;

    @FXML
    private TextArea DescriptionField;

    @FXML
    private Button Create;

    @FXML
    private Label Result_lbl;

    @FXML
    void TryCreation(ActionEvent event) {
    	
    	System.out.println("Creation Pressed");
    	MakeRevue();
    	
    
    }

	private void MakeRevue() {
		
		if(TitreField.getText().isBlank() || TarifField.getText().trim() == ""){
			
			Result_lbl.setText("Veuillez au minimum saisir un prix et un nom");
			
		}
		if(isNumeric(TarifField.getText().trim()) == false){
			
			Result_lbl.setText("Veuillez sélectionner un vrai prix.");
			
		}else{
			
			Result_lbl.setText(TitreField.getText()+" ("+TarifField.getText()+" euros)");
			TitreField.clear();
			TarifField.clear();
		}
		
		
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
