package classes;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Vukasin
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.util.*;

/** @pdOid ed61e050-50e1-4f53-a8bd-fee53213564f */
public class Korisnik {
   /** @pdOid 7a9b5d4b-bb4b-430e-885d-d5245d5031ef */
   private String email;
   /** @pdOid b6f8fef8-8ef3-4ce0-a7e2-39cf4615f10f */
   private String telefon;
   /** @pdOid 2f0a3254-d2e6-41f5-b603-d06a1b0994f5 */
   private String ime;
   /** @pdOid ff24785e-fd34-4f80-9257-4a04032bf7a7 */
   private String prezime;
   /** @pdOid afc4ee9a-b165-40ed-8e27-8adc96f563d2 */
   private int jmbg;
   /** @pdOid 560f9ecf-919d-4bb2-9535-5711959a8523 */
   private Pol pol;
   /** @pdOid 940d5495-6e34-4fcd-89e8-1995abee08b1 */
   private String korisnickoIme;
   /** @pdOid 537a395a-6a4e-49b2-baa7-0f70796b9a93 */
   private String sifra;
   /** @pdOid f4bdba52-5021-4388-8fdd-c94f7eccffa5 */
   private Date datumRodj;
   
   /** @pdRoleInfo migr=no name=Adresa assc=association15 mult=1..1 */
   public Adresa adresa;
   /** @pdRoleInfo migr=no name=Korpa assc=association18 mult=1..1 */
   public Korpa korpa;
   /** @pdRoleInfo migr=no name=Porudzbina assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Porudzbina> porudzbina;
   /** @pdRoleInfo migr=no name=Artikl assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Artikl> artikl;
   
   /** @pdOid 0a024e88-8ec5-44db-ab8f-0b27e6d213ca */
   public void kupiStavke() 
   {
      // TODO: implement
   }
   
   /** @pdOid 97caa223-ef75-4b0f-b853-d1a1c67a3dd0 */
   public void pregledNarudzbina()
   {
      // TODO: implement
   }
   
   /** @param stavka
    * @pdOid 15c0f2a9-4b24-4e87-96ea-ec26e1c7bf3e */
   public void dodajStavku(Stavka stavka)
   {
      // TODO: implement
   }
   
   /** @param novArtikl
    * @pdOid 115894e3-3be8-4b07-81d6-565b5ed8d55b */
   public void dodajArtikl(Artikl novArtikl) 
   {
      // TODO: implement
   }
   
   /** @pdOid 46c30bab-0ba4-4fe9-938c-982a6f11e76a */
   public void pregledKorpe() 
   {
      // TODO: implement
   }
   
   /** @param sifraArtikla
    * @pdOid 95f1155d-30eb-4310-b9f1-567a8c455526 */
   public void ukloniStavku(String sifraArtikla)
   {
      // TODO: implement
   }
   
   /** @param sifraArtikla
    * @pdOid ffe47060-ded1-476a-96c1-2badd59f659a */
   public void ukloniArtikl(String sifraArtikla) 
   {
      // TODO: implement
   }
   
   /** @pdOid b8750909-105b-465c-b84f-acce747c6152 */
   public void pregledZelja() 
   {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public ArrayList<Porudzbina> getPorudzbina() {
      if (porudzbina == null)
         porudzbina = new ArrayList<Porudzbina>();
      return porudzbina;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Porudzbina> getIteratorPorudzbina() {
      if (porudzbina == null)
         porudzbina = new ArrayList<Porudzbina>();
      return porudzbina.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPorudzbina */
   public void setPorudzbina(ArrayList<Porudzbina> newPorudzbina) {
      removeAllPorudzbina();
      for (Iterator<Porudzbina> iter = newPorudzbina.iterator(); iter.hasNext();)
         addPorudzbina((Porudzbina)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPorudzbina */
   public void addPorudzbina(Porudzbina newPorudzbina) {
      if (newPorudzbina == null)
         return;
      if (this.porudzbina == null)
         this.porudzbina = new ArrayList<Porudzbina>();
      if (!this.porudzbina.contains(newPorudzbina))
         this.porudzbina.add(newPorudzbina);
   }
   
   /** @pdGenerated default remove
     * @param oldPorudzbina */
   public void removePorudzbina(Porudzbina oldPorudzbina) {
      if (oldPorudzbina == null)
         return;
      if (this.porudzbina != null)
         if (this.porudzbina.contains(oldPorudzbina))
            this.porudzbina.remove(oldPorudzbina);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPorudzbina() {
      if (porudzbina != null)
         porudzbina.clear();
   }
   /** @pdGenerated default getter */
   public ArrayList<Artikl> getArtikl() {
      if (artikl == null)
         artikl = new ArrayList<Artikl>();
      return artikl;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Artikl> getIteratorArtikl() {
      if (artikl == null)
         artikl = new ArrayList<Artikl>();
      return artikl.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArtikl */
   public void setArtikl(ArrayList<Artikl> newArtikl) {
      removeAllArtikl();
      for (Iterator<Artikl> iter = newArtikl.iterator(); iter.hasNext();)
         addArtikl((Artikl)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArtikl */
   public void addArtikl(Artikl newArtikl) {
      if (newArtikl == null)
         return;
      if (this.artikl == null)
         this.artikl = new ArrayList<Artikl>();
      if (!this.artikl.contains(newArtikl))
         this.artikl.add(newArtikl);
   }
   
   /** @pdGenerated default remove
     * @param oldArtikl */
   public void removeArtikl(Artikl oldArtikl) 
   {
      if (oldArtikl == null)
         return;
      if (this.artikl != null)
         if (this.artikl.contains(oldArtikl))
            this.artikl.remove(oldArtikl);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllArtikl() 
   {
      if (artikl != null)
         artikl.clear();
   }

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public int getJmbg() {
		return jmbg;
	}
	
	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}
	
	public Pol getPol() {
		return pol;
	}
	
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	public String getSifra() {
		return sifra;
	}
	
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public Date getDatumRodj() {
		return datumRodj;
	}
	
	public void setDatumRodj(Date datumRodj) {
		this.datumRodj = datumRodj;
	}
	
	public Adresa getAdresa() {
		return adresa;
	}
	
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	public Korpa getKorpa() {
		return korpa;
	}
	
	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
	}
   
   

}