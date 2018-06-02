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
import javafx.scene.control.Alert;

public class zamZmenaOU {
	
	@FXML private MenuBar menu;
	@FXML private TextField jmeno;
	@FXML private TextField prijmeni;
	@FXML private TextField heslo;
	@FXML private TextField telefon;
	@FXML private TextField mail;
	
	
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	
	 public void editace(ActionEvent event) {
		 connection = sqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="Update Zamestnanec set prijmeni='"+prijmeni.getText()+ "' ,jmeno='"+jmeno.getText()+"' ,heslo='"+heslo.getText()+"' ,telefon='"+telefon.getText()+"' ,mail='"+mail.getText()+"' where uzivatelske.jmeno='"+n.vstup+"' "; 
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data byla aktualizována");
					pst.close();
					
					
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void oNas() {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Zahraj si");
	        alert.setHeaderText("Zahraj si \n4IT115 - Týmová semestrální práce");
	        alert.setContentText("Vladimír Dušek, Petr Netolický, Iva Vondrová \nLS 2017/2018 \nFIS VŠE v Praze");
	        alert.showAndWait();
		}
	
	
}

