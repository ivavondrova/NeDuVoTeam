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
import com.github.ivavondrova.NeDuVoTeamProject.logika.Zamestnanec;
import com.github.ivavondrova.NeDuVoTeamProject.logika.sqliteConnection;

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






public class zamestnanciSprava implements Initializable {
	ObservableList<com.github.ivavondrova.NeDuVoTeamProject.logika.Zamestnanec> data=FXCollections.observableArrayList();
	@FXML private MenuBar menu;
	@FXML private TableView<com.github.ivavondrova.NeDuVoTeamProject.logika.Zamestnanec> vypis;
	@FXML private TableColumn<?, ?> jmeno;
	@FXML private TableColumn<?, ?> prijmeni;
	@FXML private TableColumn<?, ?> uzivatelske_jmeno;
	@FXML private TableColumn<?, ?> heslo;
	@FXML private TableColumn<?, ?> telefon;
	@FXML private TableColumn<?, ?> mail;
	@FXML private TextField vstup;
		
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	public String n = null;
	
	public void vypsat(ActionEvent event) {
		 
		 vypis.getItems().clear();
		 connection = sqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
	
	 try {
		
		 jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
		 prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
		uzivatelske_jmeno.setCellValueFactory(new PropertyValueFactory<>("uzivatelske_jmeno"));
		heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
		telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
		String query="select * from zamestnanec";
		preparedStatement=connection.prepareStatement(query);
		rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				data.add(new Zamestnanec(
						rs.getString("jmeno"),
						rs.getString("prijmeni"),
						rs.getString("uzivatelske_jmeno"),
						rs.getString("heslo"),
						rs.getString("telefon"),
						rs.getString("mail")
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
	 public void smazat_ucet(ActionEvent event) {
		 connection = sqliteConnection.dbConnector();
			if (connection==null)System.exit(1);
		
		 try {
			String query="delete from Zamestnanec where uzivatelske_jmeno='"+vstup.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					
					pst.execute();
					
				JOptionPane.showMessageDialog(null, "Uživatel smazán");
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

	public void vytvorit_ucet(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_vytvoritUcet.fxml"));
		Parent root = loader.load();
		zamestnanecTvorbaUctu controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void upravit_ucet(ActionEvent event) throws Exception{
		n = vstup.getText()+"' ";
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource
		          ("/zamestnanec_zmenaOU.fxml"));
		Parent root = loader.load();
		zamZmenaOU controller = loader.getController();
		
      primaryStage.setTitle("Rezervace");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
		
	}
	
	public void smazat_ucet( ) {
		
	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
