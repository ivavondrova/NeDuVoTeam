package com.github.ivavondrova.NeDuVoTeamProject.ui;
/*******************************************************************************
 * Třída LoginModel slouží jako controller k zamestnanec_prihlaseni.fxml
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.github.ivavondrova.NeDuVoTeamProject.logika.LoginModel;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;

public class LoginController implements Initializable{
	
	public LoginModel loginModel = new LoginModel();
	
	
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	@FXML private Button logIn;
	@FXML private MenuBar menu;
	
	     public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	    	 if (loginModel.isDbConnected()) {
	    		 databaseCon();	
	    	 } else  {
	    		 databaseDiscon();
	    	 
	    	 }
	     }
	     
	     /**
 		 * Metoda, která při správním přihlášení otevírá nové okno.
 		 */
	     
	    	 public void Login (Event event) throws Exception{
	    		 try {
					if(loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {
						prihlaseniS();
						((Node)event.getSource()).getScene().getWindow().hide();
						Stage primaryStage = new Stage();
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(getClass()
						          .getResource
						          ("/zamestnanec_navigace.fxml"));
						Parent root = loader.load();
						Zam_navigation controller = loader.getController();
						
				      primaryStage.setTitle("Zaměstnanci - hlavní menu");
				      primaryStage.setScene(new Scene(root));
				      primaryStage.show();
					} else {
						prihlaseniF();
					}
				} catch (SQLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	

}
	    	 	/**
	    		 * Metoda, která nastavuje vyskakovací okno s informacemi o připojení databáze.
	    		 */
	    	 
	    		public void databaseCon() {
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        alert.setTitle("Databáze");
	    	        alert.setHeaderText("Databáze připojena");
	    	        alert.setContentText("Databáze je úspěšně připojena k programu.");
	    	        alert.showAndWait();
	    		}
	    		
	    		/**
	    		 * Metoda, která nastavuje vyskakovací okno s informacemi o připojení databáze.
	    		 */
	    		
	    		public void databaseDiscon() {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	        alert.setTitle("Databáze");
	    	        alert.setHeaderText("Databáze nepřipojena!");
	    	        alert.setContentText("Programu se nepodařilo připojit databázi/n potřebnou k správnému chodu programu.");
	    	        alert.showAndWait();
	    		}
	    		
	    		/**
	    		 * Metoda, která nastavuje vyskakovací okno s informacemi o úspěšném přihlášení.
	    		 */
	    		
	    		public void prihlaseniS() {
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        alert.setTitle("Přihlášení");
	    	        alert.setHeaderText("Přihlášení proběhlo úspěšně");
	    	        alert.showAndWait();
	    		}
	    		
	    		/**
	    		 * Metoda, která nastavuje vyskakovací okno s informacemi o neúspěšném přihlášení.
	    		 */
	    		
	    		public void prihlaseniF() {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	        alert.setTitle("Přihlášení");
	    	        alert.setHeaderText("Přihlášení neproběhlo úspěšně");
	    	        alert.setContentText("Zadané jméno nebo heslo jsou chybné!");
	    	        alert.showAndWait();
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