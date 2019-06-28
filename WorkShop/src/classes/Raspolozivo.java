package classes;
/***********************************************************************
 * Module:  Raspolozivo.java
 * Author:  Vukasin
 * Purpose: Defines the Class Raspolozivo
 ***********************************************************************/

/** @pdOid 76fa61c8-0b73-4c28-a746-5a255df7be95 */
public class Raspolozivo {
   /** @pdOid 09f6aa84-c667-4a20-a3a0-79373dc4412f */
   private int kolicina;
   
   public Artikl artiklB;

public int getKolicina() {
	return kolicina;
}

public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}

public Artikl getArtiklB() {
	return artiklB;
}

public void setArtiklB(Artikl artiklB) {
	this.artiklB = artiklB;
}
   
   

}