package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída LoginModel slouží k ověřování připojení do databáze
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */
import java.sql.*;
public class SqliteConnection {
	
	
	/**
	 * Metoda, která ověří připojení do databáze
	 */	
	public static Connection dbConnector()
	{	
		try {
			Class.forName("org.sqlite.JDBC"); 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/petr/git/NeDuVoTeam/NeDuVoTeamProject/src/main/resources/Rezervacnisystem.sqlite");
			return conn;
}catch(Exception e)
		{
	System.out.println(e);
	return null;
		}
}
}

