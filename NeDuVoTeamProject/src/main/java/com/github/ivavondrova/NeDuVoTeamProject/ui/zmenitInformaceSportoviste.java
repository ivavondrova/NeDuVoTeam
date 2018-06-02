package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.github.ivavondrova.NeDuVoTeamProject.logika.sqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class zmenitInformaceSportoviste {
	
	@FXML private MenuBar menu;
	@FXML private TextField nazev;
	@FXML private TextField popis;
	@FXML private TextField adresa;
	@FXML private TextField kapacita;
	@FXML private TextField cena;
	@FXML private TextField otevreno_od;
	@FXML private TextField otevreno_do;
	
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	public static String n = null;
	
	/**
	 * Metoda, díky které se upravují informace o sportovištích.
	 */
	
	 public void editace_sportoviste(ActionEvent event) {
		 connection = sqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="Update Sportoviste set nazev='"+nazev.getText()+ "' ,popis='"+popis.getText()+"' ,adresa='"+adresa.getText()+"' ,kapacita='"+kapacita.getText()+"' ,cena='"+cena.getText()+"' ,otevreno_od='"+otevreno_od.getText()+"' ,otevreno_do='"+otevreno_do.getText()+"'where nazev='"+n+"' "; 
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data byla aktualizována");
					pst.close();
					((Node)event.getSource()).getScene().getWindow().hide();
					
					
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

}
