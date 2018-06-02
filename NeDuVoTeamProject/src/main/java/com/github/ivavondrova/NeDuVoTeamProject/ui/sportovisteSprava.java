package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class sportovisteSprava {
	
	@FXML private MenuBar menu;
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}
	
	public void vytvorit_sportoviste(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/sportoviste_vytvoritSportoviste.fxml"));
		Parent root = loader.load();
		tvorbaSportoviste controller = loader.getController();
		
      primaryStage.setTitle("Vytvořit sportoviště");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void upravit_sportoviste(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/sportoviste_zmenitInfo.fxml"));
		Parent root = loader.load();
		zmenitInformaceSportoviste controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void smazat_sportoviste( ) {
		
	}

}
