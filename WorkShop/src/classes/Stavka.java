package classes;
/***********************************************************************
 * Module:  Stavka.java
 * Author:  Vukasin
 * Purpose: Defines the Class Stavka
 ***********************************************************************/

/** @pdOid 7743f6c8-2e7e-441c-812b-2e95a927c32b */
public class Stavka {
   /** @pdOid 217e1b96-f21b-49b7-be64-ad1806381432 */
   private int kolicina;
   
   /** @pdRoleInfo migr=no name=Artikl assc=association8 mult=1..1 */
   Artikl artikl;
   
   public Stavka() {}

	public Stavka(int kolicina, Artikl artikl) 
	{
	super();
	this.kolicina = kolicina;
	this.artikl = artikl;
	}

	public int getKolicina() {
		return kolicina;
	}
	
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	public Artikl getArtikl() {
		return artikl;
	}
	
	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

   
}