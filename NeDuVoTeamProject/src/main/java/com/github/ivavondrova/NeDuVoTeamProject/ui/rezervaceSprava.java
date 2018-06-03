package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.github.ivavondrova.NeDuVoTeamProject.logika.Rezervace;
import com.github.ivavondrova.NeDuVoTeamProject.logika.sqliteConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class rezervaceSprava {
	ObservableList<com.github.ivavondrova.NeDuVoTeamProject.logika.Rezervace> data=FXCollections.observableArrayList();
	@FXML private MenuBar menu;
	@FXML private TableView<com.github.ivavondrova.NeDuVoTeamProject.logika.Rezervace> rezervace;
	@FXML private TableColumn<?, ?> id;
	@FXML private TableColumn<?, ?> jmeno;
	@FXML private TableColumn<?, ?> mail;
	@FXML private TableColumn<?, ?> telefon;
	@FXML private TableColumn<?, ?> datum;
	@FXML private TableColumn<?, ?> hodinaRezervace;
	@FXML private TableColumn<?, ?> sportoviste;
	@FXML private TextField vyplnit;
	
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	/**
	 * Metoda, která do tabulky vypíše všechna sportoviště.
	 */
	public void zobrazit(ActionEvent event) {
		 
		 rezervace.getItems().clear();
		 connection = sqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
	 try {
		
		 id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
		 telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
		datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
		hodinaRezervace.setCellValueFactory(new PropertyValueFactory<>("hodinaRezervace"));
		sportoviste.setCellValueFactory(new PropertyValueFactory<>("sportoviste"));
		String query="select * from rezervace";
		preparedStatement=connection.prepareStatement(query);
		rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				data.add(new Rezervace(
						rs.getString("jmeno"),
						rs.getInt("telefon"),
						rs.getString("mail"),
						rs.getInt("id"),
						rs.getString("datum"),
						rs.getString("hodinaRezervace"),
						rs.getString("sportoviste")
						));
						rezervace.setItems(data);
					
			 }
	 preparedStatement.close();
	 rs.close();
	 }
	 catch (SQLException e) 
	 { 
	 System.err.println(e);
	 }		
	 }  
	
	/**
	 * Metoda, která vymaže smaže danou rezervaci a ukáže hlášku o jeho smazání.
	 */
	 public void smazat(ActionEvent event) {
		 connection = sqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="delete from rezervace where id='"+vyplnit.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
				JOptionPane.showMessageDialog(null, "Rezervace byla smazána");
					pst.close();
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
