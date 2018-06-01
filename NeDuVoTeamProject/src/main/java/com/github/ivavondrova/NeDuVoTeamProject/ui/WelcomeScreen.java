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
import javafx.scene.control.MenuBar;

public class WelcomeScreen {
	
	@FXML private Button rezervace;
	@FXML private Button zamestnanci;
	@FXML private Button sportoviste;
	@FXML private MenuBar menu;
	
	public void prepnirezervace(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/rezervace.fxml"));
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
		          ("/zamestnanec_prihlaseni.fxml"));
		Parent root = loader.load();
		LoginController controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
	}
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}
}
