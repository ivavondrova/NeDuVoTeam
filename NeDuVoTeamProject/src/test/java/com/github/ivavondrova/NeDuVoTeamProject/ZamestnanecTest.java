package com.github.ivavondrova.NeDuVoTeamProject;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.github.ivavondrova.NeDuVoTeamProject.logika.Zamestnanec;

import junit.framework.TestCase;

public class ZamestnanecTest extends TestCase {

	
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
	    /**
	     * Testuje metody getJmeno, getNazev, getPrijemeni, getUzivatelske_jmeno,getHeslo,getOtevreno_od, getMail a vytvareni zamestnance
	     */
	    @Test	    	
	    	   public void testVytvareniZamestnance()
	    	    {
	    	        Zamestnanec zamestnanec1 = new Zamestnanec("Honza","Novák","Honza.nov","12345","737429545","honza@nov.cz");
	    	        
	    	        
	    	        assertEquals("Honza", zamestnanec1.getJmeno());
	    	        assertEquals("Novák", zamestnanec1.getPrijmeni());
	    	        assertEquals("Honza.nov", zamestnanec1.getUzivatelske_jmeno());
	    	        assertEquals("12345", zamestnanec1.getHeslo());
	    	        assertEquals("737429545", zamestnanec1.getTelefon());
	    	        assertEquals("honza@nov.cz", zamestnanec1.getMail());
	    	        
	    	    }
	    	    
	    	    
	    	    


	    	   
	    
	    }  