package com.github.ivavondrova.NeDuVoTeamProject.main;


import com.github.ivavondrova.NeDuVoTeamProject.ui.LoginController;
import com.github.ivavondrova.NeDuVoTeamProject.ui.WelcomeScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/uvod_hlavniMenu.fxml"));
		Parent root = loader.load();
		WelcomeScreen controller = loader.getController();
		
        primaryStage.setTitle("Rezervace");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

}
