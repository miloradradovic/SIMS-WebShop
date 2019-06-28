package classes;
/***********************************************************************
 * Module:  Cene.java
 * Author:  Vukasin
 * Purpose: Defines the Class Cene
 ***********************************************************************/


/** @pdOid 74d72e4c-eff5-4799-8524-2957f148d5d8 */
public class Cene {
   /** @pdOid 493afc4b-daaa-4719-96ad-7bacc0a50eb7 */
   private double cena;
   /** @pdOid 40c7974f-9e4d-495c-9bf7-ff42a314139b */
   private String sifraArtikla;
   
   public Korpa korpaB;

public double getCena() {
	return cena;
}

public void setCena(double cena) {
	this.cena = cena;
}

public String getSifraArtikla() {
	return sifraArtikla;
}

public void setSifraArtikla(String sifraArtikla) {
	this.sifraArtikla = sifraArtikla;
}

public Korpa getKorpaB() {
	return korpaB;
}

public void setKorpaB(Korpa korpaB) {
	this.korpaB = korpaB;
}
   
   

}