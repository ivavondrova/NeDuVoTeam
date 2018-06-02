package com.github.ivavondrova.NeDuVoTeamProject.ui;

import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import java.sql.*;
import com.github.ivavondrova.NeDuVoTeamProject.logika.Sportoviste;
import com.github.ivavondrova.NeDuVoTeamProject.logika.sqliteConnection;
import com.github.ivavondrova.NeDuVoTeamProject.ui.zmenitInformaceSportoviste;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class sportovisteSprava implements Initializable {
	
	ObservableList<com.github.ivavondrova.NeDuVoTeamProject.logika.Sportoviste> data=FXCollections.observableArrayList();
	
	@FXML private MenuBar menu;
	@FXML private TableView<com.github.ivavondrova.NeDuVoTeamProject.logika.Sportoviste> vypis;
	@FXML private TableColumn<?, ?> nazev;
	@FXML private TableColumn<?, ?> popis;
	@FXML private TableColumn<?, ?> adresa;
	@FXML private TableColumn<?, ?> kapacita;
	@FXML private TableColumn<?, ?> cena;
	@FXML private TableColumn<?, ?> otevreno_od;
	@FXML private TableColumn<?, ?> otevreno_do;
	@FXML private TextField vstup;
		
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	
	
	/**
	 * Metoda, která do tabulky vypíše všechna sportoviště.
	 */
	
	public void vypsat(ActionEvent event) {
		 
		vypis.getItems().clear();
		connection = sqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
	 try {
		
		 nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
		 popis.setCellValueFactory(new PropertyValueFactory<>("popis"));
		 adresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
		 kapacita.setCellValueFactory(new PropertyValueFactory<>("kapacita"));
		 cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
		 otevreno_od.setCellValueFactory(new PropertyValueFactory<>("otevreno_od"));
		 otevreno_do.setCellValueFactory(new PropertyValueFactory<>("otevreno_do"));
		
		 String query="select * from sportoviste";
		 preparedStatement=connection.prepareStatement(query);
		 rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				data.add(new Sportoviste(
						rs.getString("nazev"),
						rs.getString("popis"),
						rs.getString("adresa"),
						rs.getInt("kapacita"),
						rs.getInt("cena"),
						rs.getInt("otevreno_od"),
						rs.getInt("otevreno_do")
						));
						vypis.setItems(data);
					
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
	 * Metoda, která vymaže dané sportoviště a ukáže hlášku o jeho smazání.
	 */
	
	 public void smazat_sportoviste(ActionEvent event) {
		 connection = sqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="delete from Sportoviste where nazev='"+vstup.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
				JOptionPane.showMessageDialog(null, "Sportoviště smazáno");
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
	
	/**
	 * Metoda, která při volbě "vytvořit sportoviště" otevírá nové okno.
	 */
	
	public void vytvorit_sportoviste(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/sportoviste_vytvoritSportoviste.fxml"));
		Parent root = loader.load();
		tvorbaSportoviste controller = loader.getController();
		
      primaryStage.setTitle("Vytvořit sportoviště");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	/**
	 * Metoda, která při volbě "upravit sportoviště" otevírá nové okno.
	 */
	
	public void upravit_sportoviste(ActionEvent event) throws Exception{
		zmenitInformaceSportoviste.n = vstup.getText();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/sportoviste_zmenitInfo.fxml"));
		Parent root = loader.load();
		zmenitInformaceSportoviste controller = loader.getController();
		
      primaryStage.setTitle("Upravit sportoviště");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
