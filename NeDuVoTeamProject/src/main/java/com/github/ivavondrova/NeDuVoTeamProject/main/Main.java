package com.github.ivavondrova.NeDuVoTeamProject.main;
/*******************************************************************************
 * Třída Main spouští celou aplikaci.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

import com.github.ivavondrova.NeDuVoTeamProject.ui.LoginController;
import com.github.ivavondrova.NeDuVoTeamProject.ui.WelcomeScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Metoda, která spouští celou aplikaci
 */	
public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
		
	}
	/**
	 * Metoda, která nahrává úvodní fxml obrazovku.
	 */	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/uvod_hlavniMenu.fxml"));
		Parent root = loader.load();
		WelcomeScreen controller = loader.getController();
		
        primaryStage.setTitle("Zahraj si");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

}
