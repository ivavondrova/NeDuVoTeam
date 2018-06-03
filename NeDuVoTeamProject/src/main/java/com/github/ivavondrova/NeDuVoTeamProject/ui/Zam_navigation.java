package com.github.ivavondrova.NeDuVoTeamProject.ui;

/*******************************************************************************
 * Třída zam_navigation slouží jako controller k zamestnanec_navigace.fxml
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class Zam_navigation {
	
	@FXML private MenuBar menu;
	
	/**
	 * Metoda, která nastavuje vyskakovací okno s informacemi o nás.
	 */
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}
	
	/**
	 * Metoda, která při volbě "Zaměstnanci" otevře příslušné okno "Správa zaměstnanců".
	 */
	
	public void prepnout_zamestnanci(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_zamestnanciSprava.fxml"));
		Parent root = loader.load();
		ZamestnanciSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa zaměstnanců");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	/**
	 * Metoda, která při volbě "Sportoviště" otevře okno "Správa sportoviště".
	 */
	
	public void prepnout_sportoviste(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_sportovisteSprava.fxml"));
		Parent root = loader.load();
		SportovisteSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa sportovišť");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}

	/**
	 * Metoda, která při volbě "Rezervace" otevře okno "Správa rezervací".
	 */
	
	public void prepnout_rezervace(ActionEvent event) throws Exception{
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_rezervaceSprava.fxml"));
		Parent root = loader.load();
		RezervaceSprava controller = loader.getController();
		
      primaryStage.setTitle("Správa rezervací");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	/**
	 * Metoda, která vrátí uživatele zpět na úvodní obrazovku.
	 */
	
	public void uvod(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		loader.setLocation(getClass().getResource("/uvod_hlavniMenu.fxml"));
		Parent root = loader.load();
		WelcomeScreen controller = loader.getController();
		
        primaryStage.setTitle("Zahraj si");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}
	
}
