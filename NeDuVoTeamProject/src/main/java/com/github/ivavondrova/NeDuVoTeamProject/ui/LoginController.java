package com.github.ivavondrova.NeDuVoTeamProject.ui;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.github.ivavondrova.NeDuVoTeamProject.logika.LoginModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController implements Initializable{
	
	public LoginModel loginModel = new LoginModel();
	
	
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button logIn;
	
	     public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	    	 if (loginModel.isDbConnected()) {
	    		 databaseCon();	
	    	 } else  {
	    		 databaseDiscon();
	    	 
	    	 }
	     }
	    	 public void Login (ActionEvent event) throws Exception{
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
						zam_navigation controller = loader.getController();
						
				      primaryStage.setTitle("Rezervace");
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
	    		public void databaseCon() {
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        alert.setTitle("Databáze");
	    	        alert.setHeaderText("Databáze připojena");
	    	        alert.setContentText("Databáze je úspěšně připojena k programu.");
	    	        alert.showAndWait();
	    		}
	    		
	    		public void databaseDiscon() {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	        alert.setTitle("Databáze");
	    	        alert.setHeaderText("Databáze nepřipojena!");
	    	        alert.setContentText("Programu se nepodařilo připojit databázi/n potřebnou k správnému chodu programu.");
	    	        alert.showAndWait();
	    		}
	    		
	    		public void prihlaseniS() {
	    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	        alert.setTitle("Přihlášení");
	    	        alert.setHeaderText("Přihlášení proběhlo úspěšně");
	    	        alert.showAndWait();
	    		}
	    		
	    		public void prihlaseniF() {
	    			Alert alert = new Alert(Alert.AlertType.ERROR);
	    	        alert.setTitle("Přihlášení");
	    	        alert.setHeaderText("Přihlášení neproběhlo úspěšně");
	    	        alert.setContentText("Zadané jméno nebo heslo jsou chybné!");
	    	        alert.showAndWait();
	    		}
}