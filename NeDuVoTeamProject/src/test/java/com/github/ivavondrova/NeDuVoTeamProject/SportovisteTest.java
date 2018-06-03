package com.github.ivavondrova.NeDuVoTeamProject;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.github.ivavondrova.NeDuVoTeamProject.logika.Sportoviste;

import junit.framework.TestCase;

public class SportovisteTest extends TestCase {

	
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
	     * Testuje metody getPopis, getNazev, getAdresa, getKapacita,getCena,getOtevreno_od, getOtevereno_do a vytvareni sportoviste
	     */
	    @Test	    	
	    	   public void testVytvareniSportoviste()
	    	    {
	    	        Sportoviste sportoviste1 = new Sportoviste("Tenis","otevreno","Behounkova 14",4,120,10,18);
	    	        
	    	        
	    	        assertEquals("Tenis", sportoviste1.getNazev());
	    	        assertEquals("otevreno", sportoviste1.getPopis());
	    	        assertEquals("Behounkova 14", sportoviste1.getAdresa());
	    	        assertEquals(4, sportoviste1.getKapacita());
	    	        assertEquals(120, sportoviste1.getCena());
	    	        assertEquals(10, sportoviste1.getOtevreno_od());
	    	        assertEquals(18, sportoviste1.getOtevreno_do());
	    	    }
	    	    
	    	    
	    	    


	    	   
	    
	    }  
	 
	    
	    

