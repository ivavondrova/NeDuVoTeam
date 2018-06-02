package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída Sportoviste slouží ke správě sportoviště.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

public class Sportoviste {

	private String nazev;
	private String popis;
	private String adresa;
	private int kapacita;
	private int cena;
	private int otevreno_do;
	private int otevreno_od;

	/**
	    * Konstruktor pro vytvoření sportoviště
	    * 
	    * @param nazev 			název sportoviště	
	    * @param popis			popis sportoviště
	    * @param adresa			adresa sportoviště
	    * @param kapacita 		maximální kapacita sportoviště
	    * @param cena			cena sportoviště za hodinu
	    * @param otevreno_do		časový údaj o době provozu sportoviště
	    * @param otevreno_od		časový pdaj o době provozu sportoviště
	    * 
	    */
		public Sportoviste (String nazev, String popis, String adresa, int kapacita, int cena, int otevreno_od, int otevreno_do) 
		{
			this.nazev = nazev;
			this.popis = popis;
			this.adresa = adresa;
			this.kapacita = kapacita;
			this.cena = cena;
			this.otevreno_od = otevreno_od;
			this.otevreno_do = otevreno_do;
		}
		
		/**
		 * Metoda get vrací příslušnou hodnotu.
		 * 
		 * getNazev				@return 		vrací název sportoviště
		 * getPopis				@return		vrací popis sportoviště
		 * getAdresa				@return		vrací adresu sportoviště
		 * getKapacita			@return		vrací maximální kapacitu sportoviště
		 * getCena				@return		vrací cenu za hodinu
		 * getOtevreno_do		@return		vrací informaci o otevírací době sportoviště
		 * getOtevreno_od		@return		vrací informaci o otevírací době sportoviště
		*/
		
		public String getNazev() 
		{
			return nazev;
		}
		
		public String getPopis() 
		{
			return popis;
		}
		
		public String getAdresa() 
		{
			return adresa;
		}
		
		public int getKapacita() 
		{
			return kapacita;
		}
		
		public int getCena() 
		{
			return cena;
		}
		
		public int getOtevreno_do() 
		{
			return otevreno_do;
		}
		
		public int getOtevreno_od() 
		{
			return otevreno_od;
		}
		
		/**
		 * Metoda set nastaví příslušnou hodnotu.
		 * 
		 * setNazev				@return 		nastaví název sportoviště
		 * setPopis				@return 		nastaví popis sportoviště
		 * setAdresa				@return 		nastaví adresu sportoviště
		 * setKapacita			@return 		nastaví maximální kapacitu sportoviště
		 * setCena				@return 		nastaví cenu za pronájem sportoviště
		 * setOtevreno_do		@return 		nastaví informace o otevírací době sportoviště
		 * setOtevreno_od		@return 		nastaví informace o otevírací době sportoviště
		 * 
		 */
		
		public void setNazev(String nazev) 
		{
			this.nazev = nazev;
		}
		
		public void setPopis(String popis) 
		{
			this.popis = popis;
		}
		
		public void setAdresa(String adresa) 
		{
			this.adresa = adresa;
		}
		
		public void setKapacita(int kapacita) 
		{
			this.kapacita = kapacita;
		}
		
		public void setCena(int cena) 
		{
			this.cena = cena;
		}
		
		public void setOtevreno_od(int otevreno_od) 
		{
			this.otevreno_od = otevreno_od;
		}
		
		public void setOtevreno_do(int otevreno_do) 
		{
			this.otevreno_do = otevreno_do;
		}

}
