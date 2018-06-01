package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída Rezervace slouží ke správě rezervací.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

public class Rezervace {

	private String jmeno;
	private int telefon;
	private String mail;
	private int id;
	private String datum;
	private String hodinaRezervace;
	
	/**
	    * Konstruktor pro vytvoření rezervace
	    * 
	    * @param jmeno 			jméno zákazníka
	    * @param telefon			telefon na zákazníka
	    * @param mail			mail na zákazníka
	    * @param id				id rezervace, bude generované automaticky
	    * @param datum			datum rezervace
	    * @param hodinaRezervace	hodina, od které bude probíhat rezervace
	    * 
	    */
	
		public Zakaznik (String jmeno, int telefon, String mail, int id, String datum, String hodinaRezervace) 
		{
			this.jmeno = jmeno;
			this.telefon = telefon;
			this.mail = mail;
			this.id = id;
			this.datum = datum;
			this.hodinaRezervace = hodinaRezervace;
		}
		
		/**
		 * Metoda get vrací příslušnou hodnotu.
		 * 
		 * getJmeno				@return 		vrací jméno zákazníka
		 * getTelefon			@return		vrací telefon zákazníka
		 * getMail				@return		vrací mail na zákazníka
		 * getId					@return		vrací id rezervace
		 * getDatum				@return		vrací datum rezervace
		 * getHodinaRezervace	@return		vrací čas rezervace
		 *	
		 */
		
		public String getJmeno() 
		{
			return jmeno;
		}
		
		public int getTelefon() 
		{
			return telefon;
		}
		
		public String getMail() 
		{
			return mail;
		}
		
		public int getId() 
		{
			return id;
		}
		
		public String getDatum() 
		{
			return datum;
		}
		
		public String getHodinaRezervace() 
		{
			return hodinaRezervace;
		}
		
		
		/**
		 * Metoda set nastaví příslušnou hodnotu.
		 * 
		 * setJmeno					@return 		nastaví jméno zákazníka
		 * setTelefon				@return 		nastaví telefon zákazníka
		 * setMail					@return 		nastaví mail zákazníka
		 * setId						@return		nastaví id rezervace
		 * setDatum					@return		nastaví datum rezervace
		 * setHodinaRezervace		@return		nastaví hodinu rezervace
		 * 
		 */
		
		public void setJmeno(String jmeno) 
		{
			this.jmeno = jmeno;
		}
		
		public void setTelefon(int telefon) 
		{
			this.telefon = telefon;
		}
		
		public void setMail(String mail) 
		{
			this.mail = mail;
		}
		
		public void setId(int id) 
		{
			this.id = id;
		}
		
		public void setDatum(String datum) 
		{
			this.datum = datum;
		}
		
		public void setHodinaRezervace(String hodinaRezervace) 
		{
			this.hodinaRezervace = hodinaRezervace;
		}


}
