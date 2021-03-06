package com.github.ivavondrova.NeDuVoTeamProject.ui;

/*******************************************************************************
 * Třída zamestnanecZmenaOU slouží jako controller k zamestnanec_zmanOU.fxml
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.github.ivavondrova.NeDuVoTeamProject.logika.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;

public class ZamZmenaOU {
	
	@FXML private MenuBar menu;
	@FXML private TextField jmeno;
	@FXML private TextField prijmeni;
	@FXML private TextField heslo;
	@FXML private TextField telefon;
	@FXML private TextField mail;
	
	
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	public static String n = null;
	
	/**
	 * Metoda, díky které se upravují informace o zaměstnancích.
	 */
	
	 public void editace(ActionEvent event) {
		 connection = SqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="Update Zamestnanec set prijmeni='"+prijmeni.getText()+ "' ,jmeno='"+jmeno.getText()+"' ,heslo='"+heslo.getText()+"' ,telefon='"+telefon.getText()+"' ,mail='"+mail.getText()+"' where uzivatelske_jmeno='"+n+"' "; 
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

