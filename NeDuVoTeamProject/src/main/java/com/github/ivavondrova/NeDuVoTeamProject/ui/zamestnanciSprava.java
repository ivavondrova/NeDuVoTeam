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

public class zamestnanciSprava {
	
	@FXML private MenuBar menu;
	
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}

	public void vytvorit_ucet(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_vytvoritUcet.fxml"));
		Parent root = loader.load();
		zamestnanecTvorbaUctu controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void upravit_ucet(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_zmenaOU.fxml"));
		Parent root = loader.load();
		zamZmenaOU controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void smazat_ucet( ) {
		
	}
}
