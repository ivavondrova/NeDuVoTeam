package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class zam_navigation {
	
	@FXML private MenuBar menu;
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}
	
	public void prepnout_zamestnanci(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_zamestnanciSprava.fxml"));
		Parent root = loader.load();
		zamestnanciSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa zaměstnanců");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void prepnout_sportoviste(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_sportovisteSprava.fxml"));
		Parent root = loader.load();
		sportovisteSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa sportovišť");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}

	public void prepnout_rezervace(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_rezervaceSprava.fxml"));
		Parent root = loader.load();
		rezervaceSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa rezervací");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
}
