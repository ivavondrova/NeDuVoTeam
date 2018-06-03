package com.github.ivavondrova.NeDuVoTeamProject;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.sql.*;
import java.sql.Connection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.ivavondrova.NeDuVoTeamProject.logika.SqliteConnection;

import junit.framework.TestCase;

public class LoginModelTest extends TestCase {
	  private String query;
	
	 /* Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
	 @Before
	    public void setUp()
	    {
	    }


	    /***************************************************************************
	     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
	     */
	    @After
	    public void tearDown()
	    {
	    }

	    @Test
	    public void testPripojeni()
	    
	    {
	    	String query = "select * from Zamestnanec where uzivatelske_jmeno = ? and heslo = ?";
	        assertNotNull(query);
	        
	    }  
	 
	    
	    

}