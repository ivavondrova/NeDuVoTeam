package com.github.ivavondrova.NeDuVoTeamProject.ui;
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

/*******************************************************************************
 * Třída tvorbaSportoviste slouží jako controller k sportoviste_vytvoritSportoviste.fxml
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */
public class TvorbaSportoviste {
	
	@FXML private MenuBar menu;
	@FXML private TextField nazev;
	@FXML private TextField popis;
	@FXML private TextField adresa;
	@FXML private TextField kapacita;
	@FXML private TextField cena;
	@FXML private TextField otevreno_do;
	@FXML private TextField otevreno_od;

	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	
	/**
	 * Metoda, která po vyplnění údajů vytvoří příslušné sportoviště.
	 */
	
	public void vytvorit_sportoviste(ActionEvent event) throws Exception {
		 connection = SqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
		 try {String query="insert into Sportoviste (nazev,popis,adresa,kapacita,cena,otevreno_od,otevreno_do) values (?,?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,nazev.getText());
			pst.setString(2,popis.getText());
			pst.setString(3,adresa.getText());
			pst.setString(4,kapacita.getText());
			pst.setString(5,cena.getText());
			pst.setString(6,otevreno_od.getText());
			pst.setString(7,otevreno_do.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Sportoviště vytvořeno");
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
