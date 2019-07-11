package classes;
/***********************************************************************
 * Module:  Porudzbina.java
 * Author:  Vukasin
 * Purpose: Defines the Class Porudzbina
 ***********************************************************************/

import java.util.Date;
import java.util.HashMap;

import states.StanjePorudzbine;

/** @pdOid fbfb16eb-b5ae-4029-9acf-de26d1336b66 */
public class Porudzbina {
   /** @pdOid 8909065e-3c32-4349-b10d-b9566dfd8915 */
   private int brojPor;
   /** @pdOid 1828cb87-4412-4f48-96d0-a65a887b816b */
   private int ukupnaCena;
   /** @pdOid abe8a61c-077d-4b52-9946-7753f4f8b415 */
   private Date datumPorucivanja;
   
   public HashMap<String, Integer> Cene;
   
   /** @pdRoleInfo migr=no name=Stanje assc=association24 mult=1..1 */
   public StanjePorudzbine stanje;
   
   public Porudzbina() {}
   
	public Porudzbina(int brojPor, int ukupnaCena, Date datumPorucivanja, HashMap<String, Integer> cene, StanjePorudzbine stanje) 
	{
	super();
	this.brojPor = brojPor;
	this.ukupnaCena = ukupnaCena;
	this.datumPorucivanja = datumPorucivanja;
	Cene = cene;
	this.stanje = stanje;
	}
	
	public int getBrojPor() {
		return brojPor;
	}
	public void setBrojPor(int brojPor) {
		this.brojPor = brojPor;
	}
	public int getUkupnaCena() {
		return ukupnaCena;
	}
	public void setUkupnaCena(int ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
	public Date getDatumPorucivanja() {
		return datumPorucivanja;
	}
	public void setDatumPorucivanja(Date datumPorucivanja) {
		this.datumPorucivanja = datumPorucivanja;
	}
	
	public StanjePorudzbine getStanje() {
		return stanje;
	}
	public void setStanje(StanjePorudzbine stanje) {
		this.stanje = stanje;
	}
	public HashMap<String, Integer> getCene() {
		return Cene;
	}
	public void setCene(HashMap<String, Integer> cene) {
		Cene = cene;
	}
	
	

   
   
}