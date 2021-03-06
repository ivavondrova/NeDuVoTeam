package com.github.ivavondrova.NeDuVoTeamProject.ui;

/*******************************************************************************
 * Třída RezervationScreen slouží jako controller k rezervace.fxml
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */
import javafx.scene.control.MenuBar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.github.ivavondrova.NeDuVoTeamProject.logika.Rezervace;
import com.github.ivavondrova.NeDuVoTeamProject.logika.Sportoviste;
import com.github.ivavondrova.NeDuVoTeamProject.logika.SqliteConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RezervationScreen{
	
	@FXML private MenuBar menu;
	@FXML private ChoiceBox sport;
	@FXML private ChoiceBox cas;
	@FXML private DatePicker kalendar;
	@FXML private TextField jmeno;
	@FXML private TextField mail;
	@FXML private TextField telefon;
	@FXML private CheckBox volbaano;
	@FXML private CheckBox volbane;
	ObservableList<String> sportoviste = FXCollections.observableArrayList();
	ObservableList<String> casy;
	Connection connection;
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	int count =0;
	
	

	
	/**
	 * Metoda, která nastavuje obsahy Checkboxů.
	 */
	
	@FXML
	private void initialize() {
		connection = SqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		sportoviste.clear();
		
		try {
			String query="select * from sportoviste";
					 preparedStatement=connection.prepareStatement(query);
					 rs=preparedStatement.executeQuery();
					while(rs.next())
						{
						sportoviste.add(rs.getString("nazev"));
						}
					preparedStatement.close();
					rs.close();
					
		 	} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	casy = FXCollections.observableArrayList("6:00","7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00");
	cas.setItems(casy);
	sport.setItems(sportoviste);
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
	 * Metoda, která v novém okně vypisuje hodinové sazby pro existujcí sportoviště.
	 */

	public void cenik(ActionEvent event) throws Exception {
		connection = SqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		String seznam = "";
		
		try {
			String query="select nazev, cena from sportoviste";
					 preparedStatement=connection.prepareStatement(query);
					 rs=preparedStatement.executeQuery();
					while(rs.next())
						{
						seznam = seznam + rs.getString("nazev") + " " + rs.getInt("cena") + " Kč/hod.\n";
						}
					preparedStatement.close();
					rs.close();
					
		 	} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ceník");
        alert.setHeaderText("Hodinové sazby pro jednotlivá sportoviště");
        alert.setContentText(seznam);
        alert.showAndWait();
	
	}
	/**
	 * Metoda, která po vyplnění příslušných údajů vytvoří novou rezervaci.
	 */
	
	public void vytvorit(ActionEvent event) throws Exception {
		 connection = SqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
		
		LocalDate date = kalendar.getValue();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String datum = date.format(formatter);
		String time = String.valueOf(cas.getValue());
		String room = String.valueOf(sport.getValue());
		
		
		if(date.isAfter(LocalDate.now()))
		{	
	
		if(kontroladostupnosti(datum, time, room))
			{
		
		try {
		
						
			String query="insert into rezervace (jmeno,telefon,mail,datum,hodinaRezervace,sportoviste) values (?,?,?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setString(1,jmeno.getText());
			pst.setString(2,telefon.getText());
			pst.setString(3,mail.getText());	
			pst.setString(4,datum);
			pst.setString(5,time);
			pst.setString(6,room);
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Rezervace vytvořena");
			pst.close();
			if (volbaano.isSelected()) {
				kalendar.setValue(null);
				cas.setValue(null);
				sport.setValue(null);
				volbaano.setSelected(false);
			}
			else
			{
				((Node)event.getSource()).getScene().getWindow().hide();	
			}
			
			
} catch (SQLException e) {
	
	// TODO Auto-generated catch block
	e.printStackTrace();
}
			
			}
	
		else
		{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Rezervace neúspěšná");
	        alert.setHeaderText("Požadovanou rezervaci se nedopařilo vytvořit");
	        alert.setContentText("V požadovém čase je sportovitě zarezervováno jiným klientem,/nvyberte prosím pro svou rezervaci jiný čas");
	        alert.showAndWait();
		}
		}
		else
{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Rezervace neúspěšná");
	        alert.setHeaderText("Požadovanou rezervaci se nedopařilo vytvořit");
	        alert.setContentText("Rezervace v aktuální nebo starším datu není možná");
	        alert.showAndWait();
}
	}
	/**
	 * Metoda, která ověřuje, zda pro dané sportoviště již neexistuje rezervace ve stanoveném čase.
	 */
	
	public boolean kontroladostupnosti(String datum, String time, String room) {
	 try {
		String query="select * from rezervace where datum='"+ datum +"' and hodinaRezervace='" + time + "' and sportoviste='" + room + "'";
				 preparedStatement=connection.prepareStatement(query);
				 rs=preparedStatement.executeQuery();
				count = 0;
				while(rs.next())
					{
					count = count +1;
					}
				preparedStatement.close();
				rs.close();
				
	 	} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	/**
	 * Metoda, která zajišťuje, aby nebyla označena rezervace dalšího sportoviště ANO i NE.
	 */
	
	public void checksymetryY() {
		if(volbaano.isSelected()) {
			volbane.setSelected(false);
		}
	}
	
	
	/**
	 * Metoda, která zajišťuje, aby nebyla označena rezervace dalšího sportoviště ANO i NE.
	 */
	
	public void checksymetryN() {
		if(volbane.isSelected()) {
			volbaano.setSelected(false);
		}
	}
	
	/**
	 * Metoda, která vrátí uživatele zpět na úvodní obrazovku.
	 */
	
	public void uvod(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		loader.setLocation(getClass().getResource("/uvod_hlavniMenu.fxml"));
		Parent root = loader.load();
		WelcomeScreen controller = loader.getController();
		
        primaryStage.setTitle("Zahraj si");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
	}

		}
	
