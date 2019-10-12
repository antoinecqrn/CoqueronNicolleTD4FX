package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SampleController {

    @FXML
    private FlowPane flowrida;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField DescriptionField;

    @FXML
    private TextField TarifField;

    @FXML
    private VBox PerioBox;

    @FXML
    private TextField TitreField;

    @FXML
    private Button Create;

    @FXML
    void TryCreation(ActionEvent event) {
    	System.out.println("Create Click");
    }

}
