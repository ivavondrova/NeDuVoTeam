package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class RezervationScreen {
	
	@FXML private MenuBar menu;
	
	public void oNas() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Zahraj si");
        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
        alert.showAndWait();
	}

	public void cenik() {
	}
}
