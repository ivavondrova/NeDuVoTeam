package com.github.ivavondrova.NeDuVoTeamProject.logika;

/*******************************************************************************
 * Třída Zamestnanec slouží ke správě zaměstnanců.
 *
 * @author     Vladimír Dušek, Petr Netolický, Iva Vondrová
 * @version    LS 2017/2018 
 */

public class Zamestnanec

{
	private String jmeno;
	private String prijmeni;
	private String uzivatelske_jmeno;
	private String heslo;
	private int telefon;
	private String mail;

	/**
	    * Konstruktor pro vytvoření osoby s přístupem (zaměstnance, admina)
	    * 
	    * @param jmeno 				jméno zaměstnance	
	    * @param prijmeni			příjmení zaměstnance
	    * @param uzivatelske_jmeno	uživatelské jméno zaměstnance
	    * @param heslo	 			heslo zaměstnance
	    * @param telefon				telefon zaměstnance
	    * @param mail				mail zaměstnance
	    */
	
		public Zamestnanec (String jmeno, String prijmeni, String uzivatelske_jmeno, String heslo, int telefon, int mail) 
		{
			this.jmeno = jmeno;
			this.prijmeni = prijmeni;
			this.uzivatelske_jmeno = uzivatelske_jmeno;
			this.heslo = heslo;
			this.telefon = telefon;
			this.mail = mail;
		}
		
		/**
		 * Metoda get vrací příslušnou hodnotu.
		 * 
		 * getJmeno					@return 		vrací jméno zaměstnance
		 * getPrijmeni				@return		vrací příjmení zaměstnance
		 * getUzivatelske_jmeno		@return		vrací uživatelské jméno zaměstnance
		 * getHeslo					@return		vrací heslo zaměstnance
		 * getTelefon				@return		vrací telefon zaměstnance
		 * getMail					@return		vrací mail zaměstnance
		 * 
		*/
		
		public String getJmeno() 
		{
			return jmeno;
		}
		
		public String getPrijmeni() 
		{
			return prijmeni;
		}
		
		public String getUzivatelske_jmeno() 
		{
			return uzivatelske_jmeno;
		}
		
		public String getHeslo() 
		{
			return heslo;
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
		 * Metoda set nastaví příslušnou hodnotu.
		 * 
		 * setJmeno					@return 		nastaví jméno zaměstnance
		 * setPrijmeni				@return 		nastaví příjmení zaměstnance
		 * setUzivatelske_jmeno		@return 		nastaví uživatelské jméno zaměstnance
		 * setHeslo					@return 		nastaví heslo zaměstnance
		 * setTelefon				@return 		nastaví telefon zaměstnance
		 * setMail					@return 		nastaví mail zaměstnance
		 * 
		 */
		
		public void setJmeno(String jmeno) 
		{
			this.jmeno = jmeno;
		}
		
		public void setPrijmeni(String prijmeni) 
		{
			this.prijmeni = prijmeni;
		}
		
		public void setUzivatelske_jmeno(String uzivatelske_jmeno) 
		{
			this.uzivatelske_jmeno = uzivatelske_jmeno;
		}
		
		public void setHeslo(String heslo) 
		{
			this.heslo = heslo;
		}
		
		public void setTelefon(int telefon) 
		{
			this.telefon = telefon;
		}
		
		public void setMail(String mail) 
		{
			this.mail = mail;
		}
		

}
