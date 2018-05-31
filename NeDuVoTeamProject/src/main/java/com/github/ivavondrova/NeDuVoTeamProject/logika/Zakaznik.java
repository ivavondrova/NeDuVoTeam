package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída Zákazník slouží ke správě zákazníků.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

public class Zakaznik {

	private String jmeno;
	private int telefon;
	private String mail;
	private boolean staly_zakaznik;

	/**
	    * Konstruktor pro vytvoření zákazníka
	    * 
	    * @param jmeno 			jméno zákazníka
	    * @param telefon			telefon na zákazníka
	    * @param mail			mail na zákazníka
	    * @param staly_zakaznik	kritérium zákazníka
	    * 
	    */
		public Zakaznik (String jmeno, int telefon, String mail, boolean staly_zakaznik) 
		{
			this.jmeno = jmeno;
			this.telefon = telefon;
			this.mail = mail;
			this.staly_zakaznik = staly_zakaznik;
		}
		
		/**
		 * Metoda get vrací příslušnou hodnotu.
		 * 
		 * getJmeno			@return 		vrací jméno zákazníka
		 * getTelefon		@return		vrací telefon zákazníka
		 * getMail			@return		vrací mail na zákazníka
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
		
		/**
		 * Metoda zjišťuje nastavení kritéria "stálý zákazník".
		 * 
		 * @param	staly_zakaznik
		 * @return	vrací nastavení kritéria "stálý zákazník"
		 * 
		 */
		
		public boolean isStaly_zakaznik() 
		{
			return staly_zakaznik;
		}
		
		/**
		 * Metoda set nastaví příslušnou hodnotu.
		 * 
		 * setJmeno					@return 		nastaví jméno zákazníka
		 * setTelefon				@return 		nastaví telefon zákazníka
		 * setMail					@return 		nastaví mail zákazníka
		 * setStaly_zakaznik			@return		nastaví kritérium "stálý zákazník"
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
		
		public void setStaly_zakaznik(boolean staly_zakaznik) 
		{
			this.staly_zakaznik = staly_zakaznik;
		}
}
