package com.github.ivavondrova.NeDuVoTeamProject.ui;
import com.github.ivavondrova.NeDuVoTeamProject.logika.Zamestnanec;

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

public class zamestnanecTvorbaUctu {
	
	@FXML private MenuBar menu;
	@FXML private TextField jmeno;
	@FXML private TextField prijmeni;
	@FXML private TextField heslo;
	@FXML private TextField telefon;
	@FXML private TextField mail;
	@FXML private TextField uzivatelske_jmeno;
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	
	public void vytvorit(ActionEvent event) throws Exception {
		 connection = sqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
		 try {String query="insert into Zamestnanec (jmeno,prijmeni,uzivatelske_jmeno,heslo,telefon,mail) values (?,?,?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setString(1,jmeno.getText());
			pst.setString(2,prijmeni.getText());
			pst.setString(3,uzivatelske_jmeno.getText());
			pst.setString(4,heslo.getText());
			pst.setString(5,telefon.getText());
			pst.setString(6,mail.getText());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Zaměstnanec vytvořen");
			pst.close();
			((Node)event.getSource()).getScene().getWindow().hide();
			
			
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
