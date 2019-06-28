package classes;
/***********************************************************************
 * Module:  Porudzbina.java
 * Author:  Vukasin
 * Purpose: Defines the Class Porudzbina
 ***********************************************************************/

import java.util.*;

/** @pdOid fbfb16eb-b5ae-4029-9acf-de26d1336b66 */
public class Porudzbina {
   /** @pdOid 8909065e-3c32-4349-b10d-b9566dfd8915 */
   private int brojPor;
   /** @pdOid 1828cb87-4412-4f48-96d0-a65a887b816b */
   private int ukupnaCena;
   /** @pdOid abe8a61c-077d-4b52-9946-7753f4f8b415 */
   private Date datumPorucivanja;
   
   public Cene association23;
   /** @pdRoleInfo migr=no name=Stanje assc=association24 mult=1..1 */
   public Stanje stanje;
   
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
	public Cene getAssociation23() {
		return association23;
	}
	public void setAssociation23(Cene association23) {
		this.association23 = association23;
	}
	public Stanje getStanje() {
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

   
   
}