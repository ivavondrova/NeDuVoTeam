package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída LoginModel slouží k ověřování správných přihlašovacích údajů do databáze.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */
import java.sql.*;
public class LoginModel {
	Connection connection;
	
	public LoginModel () {
		connection = SqliteConnection.dbConnector();
		if (connection==null)System.exit(1);
}
	/**
	 * Metoda, která ověří připojení do databáze
	 */	
	public boolean isDbConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metoda, která ověří, že byly přihlašovací údaje správné
	 */
		public boolean isLogin(String user, String pass) throws SQLException {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet= null;
			String query = "select * from Zamestnanec where uzivatelske_jmeno = ? and heslo = ?";
		
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, user);
				preparedStatement.setString(2, pass);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return true;
				}
					else {
						return false;
					}
			} catch (SQLException e) {
				return false;
				// TODO Auto-generated catch block
			} finally {
				preparedStatement.close();
				resultSet.close();
					
			}
		}
		
		
	}
