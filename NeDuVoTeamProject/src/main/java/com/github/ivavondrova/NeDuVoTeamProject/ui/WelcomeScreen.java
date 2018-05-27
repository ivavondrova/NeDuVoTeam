package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class WelcomeScreen {
	
	@FXML private Button rezervace;
	@FXML private Button zamestnanci;
	@FXML private Button sportoviste;
	
	public void prepnirezervace(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/Navrh_registrace.fxml"));
		Parent root = loader.load();
		RezervationScreen controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
	}
	
	public void prepnizamestnanci(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/Navrh_prihlaseni.fxml"));
		Parent root = loader.load();
		LoginController controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
	}
	
	public void prepnisportoviste() {
		
	}
}
