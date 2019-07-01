package classes;
/***********************************************************************
 * Module:  Artikl.java
 * Author:  Rocika
 * Purpose: Defines the Class Artikl
 ***********************************************************************/

import enums.Boja;

/** @pdOid ba58dd52-f07d-4cb4-9279-809b664cd646 */
public class Artikl {
   /** @pdOid aefad9e2-9860-44d0-b582-96d507373475 */
   private String sifra;
   /** @pdOid 57038d5c-3735-4a0e-8149-0613007f0b02 */
   private String slika;
   /** @pdOid 0a22c1ce-2849-462d-8678-95fcdb1e33e1 */
   private String naziv;
   /** @pdOid 1e5a1dba-0a5c-4476-89d7-5ffb0776d95f */
   private int stanje;
   /** @pdOid 2b8aac35-6606-4cf0-a5a9-82fe429ab3c1 */
   private int cena;
   /** @pdOid a07010c0-12ed-4887-b453-9d1cfe25c1d8 */
   private Boja boja;
   /** @pdOid a45c7306-099e-4ccc-bba9-865c57e20b2d */
   private Boolean aktivan;
   
   /** @pdRoleInfo migr=no name=Kategorija assc=association21 mult=1..1 */
   public Kategorija kategorija;
   
   public Artikl() {}

	public Artikl(String sifra, String slika, String naziv, int stanje, int cena, Boja boja, Boolean aktivan,
		Kategorija kategorija) 
	{
	super();
	this.sifra = sifra;
	this.slika = slika;
	this.naziv = naziv;
	this.stanje = stanje;
	this.cena = cena;
	this.boja = boja;
	this.aktivan = aktivan;
	this.kategorija = kategorija;
	}

	public String getSifra() 
	{
		return sifra;
	}
	
	public void setSifra(String sifra)
	{
		this.sifra = sifra;
	}
	
	public String getSlika() 
	{
		return slika;
	}
	
	public void setSlika(String slika) 
	{
		this.slika = slika;
	}
	
	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv) 
	{
		this.naziv = naziv;
	}
	
	public int getStanje() 
	{
		return stanje;
	}
	
	public void setStanje(int stanje) 
	{
		this.stanje = stanje;
	}
	
	public int getCena() 
	{
		return cena;
	}
	
	public void setCena(int cena) 
	{
		this.cena = cena;
	}
	
	public Boja getBoja() 
	{
		return boja;
	}
	
	public void setBoja(Boja boja) 
	{
		this.boja = boja;
	}
	
	public Boolean getAktivan() 
	{
		return aktivan;
	}
	
	public void setAktivan(Boolean aktivan) 
	{
		this.aktivan = aktivan;
	}
	
	public Kategorija getKategorija() 
	{
		return kategorija;
	}
	
	public void setKategorija(Kategorija kategorija) 
	{
		this.kategorija = kategorija;
	}

   
}