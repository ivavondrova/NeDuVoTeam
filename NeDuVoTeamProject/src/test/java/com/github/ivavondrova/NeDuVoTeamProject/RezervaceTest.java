package com.github.ivavondrova.NeDuVoTeamProject;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.github.ivavondrova.NeDuVoTeamProject.logika.Rezervace;

import junit.framework.TestCase;

public class RezervaceTest extends TestCase {

	
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
	     * Testuje metody getJmeno, getTelefon, getMail, getId ,getDatum, getHodina, getSportoviste a vytvareni rezervace
	     */
	    @Test	    	
	    	   public void testVytvareniRezervace()
	    	    {
	    	        Rezervace rezervace1 = new Rezervace("Tomas",737429564,"tomas@novak.cz",1,"10.4","18","tenis");
	    	        
	    	        
	    	        assertEquals("Tomas", rezervace1.getJmeno());
	    	        assertEquals(737429564, rezervace1.getTelefon());
	    	        assertEquals("tomas@novak.cz", rezervace1.getMail());
	    	        assertEquals(1, rezervace1.getId());
	    	        assertEquals("10.4", rezervace1.getDatum());
	    	        assertEquals("18", rezervace1.getHodinaRezervace());
	    	        assertEquals("tenis", rezervace1.getSportoviste());
	    	      
	    	    }
	    	    
	    	    
	    	    


	    	   
	    
	    }  