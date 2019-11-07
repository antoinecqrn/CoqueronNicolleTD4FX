package application;

import java.net.URL;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import dao.*;

public class Main extends Application{
	
	Persistance p;
	
	
	public void setp(Persistance p) {
		this.p = p;
	}
	
	public Persistance getp() {
		return p;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Projet CPOA");
			
			primaryStage.setResizable(false);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		Persistance p;
		
		launch(args); 
		
		
	}
	

}
