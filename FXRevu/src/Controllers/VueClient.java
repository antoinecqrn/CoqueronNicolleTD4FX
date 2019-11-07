package Controllers;

import java.sql.SQLException;

import dao.Persistance;
import factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import metier.ClientPOJO;

public class VueClient{

    @FXML
    private FlowPane flowrida;

    @FXML
    private TextField NomField;

    @FXML
    private TextField PrenomField;

    @FXML
    private TextField VoieField;

    @FXML
    private TextField RueField;

    @FXML
    private TextField VilleField;

    @FXML
    private TextField CPField;

    @FXML
    private Button Create;

    @FXML
    private TableView<ClientPOJO> ClientView;

    @FXML
    private TableColumn<ClientPOJO, String> TableNom;

    @FXML
    private TableColumn<ClientPOJO, String> TablePrenom;

    @FXML
    private TableColumn<ClientPOJO, String> TableVille;

    @FXML
    private TableColumn<ClientPOJO, String> TableVoie;

    @FXML
    private TableColumn<ClientPOJO, String> TableRue;

    @FXML
    private TableColumn<ClientPOJO, String> TableCP;

    @FXML
    private TextField NomSearch;

    @FXML
    private TextField PrenomSearch;

    @FXML
    private TextField VilleSearch;

    @FXML
    private TextField VoieSearch;

    @FXML
    private TextField RueSearch;

    @FXML
    private TextField CPSearch;
    
    @FXML
    private TextField PaysSearch;
    @FXML
    private TextField PaysField;
    
    @FXML
    private Label persitance;
    
    @FXML
    private Button Supp;
    
    @FXML
    private Button Reset;
    
    @FXML
    private Button Launch;
    
    @FXML
    private Button Modif;

    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.MYSQL);

    @FXML
    void Search(ActionEvent event) {
    	System.out.println("searched");
    	
    	
    	Reset.setDisable(false);
    }
    
   
    @FXML
    void initialize() {
    	
    	TableNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    	TablePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	TableVille.setCellValueFactory(new PropertyValueFactory<>("city"));
    	TableVoie.setCellValueFactory(new PropertyValueFactory<>("num_rue"));
    	TableRue.setCellValueFactory(new PropertyValueFactory<>("rue"));
    	TableCP.setCellValueFactory(new PropertyValueFactory<>("cp"));
    	
    	reset();
    }
    
    @FXML
    void reset() {
		
    	ClientView.setItems(null);
    	ClientView.setItems(FXCollections.observableArrayList(dao.getClientDAO().findAll()));
	}
    
    @FXML
    void SearchClicked() {
		
    	System.out.print("preseedd");
	}
    
    @FXML
    void SearchReleased() {
		
    	System.out.println("realalld");
	}

	private void AllUncheck(String not) {
		
		NomSearch.setDisable(true);
		PrenomSearch.setDisable(true);
		
	}


	@FXML
    void CheckSelection() {
    	
    	if(ClientView.getSelectionModel().getSelectedIndex() < 0) {
    		
    	}else {
    		Supp.setDisable(false);
    		Modif.setDisable(false); 
    	}
    }
    
    
    @FXML
    void SupprimerClient(ActionEvent event) {
    	
    	ClientPOJO sup = ClientView.getSelectionModel().getSelectedItem();
    	int index = ClientView.getSelectionModel().getSelectedIndex();
    	
    	
    	dao.getClientDAO().delete(sup);
    	ClientView.getItems().remove(index);
    	
		Supp.setDisable(true);
		Modif.setDisable(true); 
    }
    
    @FXML
    void ModifierClient() {
    	
    	ClientPOJO sup = ClientView.getSelectionModel().getSelectedItem();
    	int index = ClientView.getSelectionModel().getSelectedIndex();
    	
    	
    	
    		
    	ClientPOJO changer = GetClient();
    	
    	if(changer.getNom().isBlank() == false){
    		sup.setNom(changer.getNom());
    	}
    	if(changer.getCity().isBlank() == false){
    		sup.setCity(changer.getCity());	
    	}
    	if(changer.getPrenom().isBlank() == false){
    		sup.setPrenom(changer.getPrenom());	
    	}
    	if(changer.getCountry().isBlank() == false){
    		sup.setCountry(changer.getCountry());	
    	}
    	if(changer.getCp().isBlank() == false){
    		sup.setCp(changer.getCp());	
    	}
    	if(changer.getRue().isBlank() == false){
    		sup.setRue(changer.getRue());	
    	}
    	if(changer.getNum_rue().isBlank() == false){
    		sup.setNum_rue(changer.getNum_rue());	
    	}
    	
    	
    	try {
    		dao.getClientDAO().delete(sup);
        	ClientView.getItems().set(index, sup);
        	dao.getClientDAO().create(sup);
        
        	
        	ClearFields();
    	}catch(Exception e){
    		
    	}
    
    	
		Supp.setDisable(true);
		Modif.setDisable(true); 
    }
    
    @FXML
    void AjouterClient(ActionEvent event) {
    	
    	Boolean noneabove;
    	
    	if(isStringOnlyAlphabet(NomField.getText()) == true){
    		
    		noneabove = true;
    		if(isStringOnlyAlphabet(PrenomField.getText()) == true && noneabove == true){
    			
    			noneabove = true;
    			if(isStringOnlyAlphabet(VilleField.getText())  == true && noneabove == true){
    				
    					CreateClient();
    					
    	
    			}else {System.out.println("une vraie ville stp");}
    					
    		}else {System.out.println("un vrai prenom stp");}
    	
    	}else {System.out.println("un vrai nom stp");}
    	
    	
    	
    	
    		
    }
    
    void ClearFields() {
    	
    	NomField.clear();
		   PrenomField.clear();
		   VoieField.clear();
		   RueField.clear();
		   VilleField.clear();
		   CPField.clear();
    	
    }
    
    ClientPOJO GetClient(){
    	
    	return new ClientPOJO( NomField.getText().strip(),
				   PrenomField.getText().strip(),
				   VoieField.getText().strip(),
				   RueField.getText().strip(),
				   VilleField.getText().strip(),
				   CPField.getText().strip(),
				   "CA MARCHE LAND");
    	
    }
    
    void CreateClient() {
    	ClientPOJO newclient = GetClient();


try {

dao.getClientDAO().create(newclient);
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
		
		
		if(NomField.getText().isBlank() == false){
			if(PrenomField.getText().isBlank() == false) {
				if(VoieField.getText().isBlank() == false){
					if(RueField.getText().isBlank() == false) {
						if(VilleField.getText().isBlank() == false){
							if(CPField.getText().isBlank() == false) {
								
								return true;
							}
						}
					}	
				}
			}
		}
		return false;
	}
	

public static boolean isStringOnlyAlphabet(String str) 
{ 
    return ((!str.equals("")) 
            && (str != null) 
            && (str.chars().allMatch(Character::isLetter))); 
} 



}
