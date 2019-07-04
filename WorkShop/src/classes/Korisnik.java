package classes;
/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Vukasin
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

import java.util.*;

import enums.Pol;


public class Korisnik {

   private String email;
   private String telefon;
   private String ime;
   private String prezime;
   private int jmbg;
   private Pol pol;
   private String korisnickoIme;
   private String sifra;
   private Date datumRodj;
   
   public Adresa adresa;
   public ArrayList<Porudzbina> porudzbina;
   public ArrayList<Artikl> listaZelja;
   public Korpa korpa;
   
   public Korisnik() {}
   
   public Korisnik(String email, String telefon, String ime, String prezime, int jmbg, Pol pol, String korisnickoIme,
		String sifra, Date datumRodj, Adresa adresa, Korpa korpa, ArrayList<Porudzbina> porudzbina,
		ArrayList<Artikl> listaZelja) 
   {
	super();
	this.email = email;
	this.telefon = telefon;
	this.ime = ime;
	this.prezime = prezime;
	this.jmbg = jmbg;
	this.pol = pol;
	this.korisnickoIme = korisnickoIme;
	this.sifra = sifra;
	this.datumRodj = datumRodj;
	this.adresa = adresa;
	this.korpa = korpa;
	this.porudzbina = porudzbina;
	this.listaZelja = listaZelja;
}

public void kupiStavke() 
   {
      // TODO: implement
   }
   
   public void pregledNarudzbina()
   {
      // TODO: implement
   }
   
   public void dodajStavku(Stavka stavka)
   {
      // TODO: implement
   }
   
   public void dodajArtikl(Artikl novArtikl) 
   {
      // TODO: implement
   }
   
   public void pregledKorpe() 
   {
      // TODO: implement
   }
   
   public void ukloniStavku(String sifraArtikla)
   {
      // TODO: implement
   }
   
   public void ukloniArtikl(String sifraArtikla) 
   {
      // TODO: implement
   }
   
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
   public ArrayList<Artikl> getListaZelja() {
      if (listaZelja == null)
    	  listaZelja = new ArrayList<Artikl>();
      return listaZelja;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Artikl> getIteratorListaZelja() {
      if (listaZelja == null)
    	  listaZelja = new ArrayList<Artikl>();
      return listaZelja.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArtikl */
   public void setArtikl(ArrayList<Artikl> newArtikl) {
      removeAllListaZelja();
      for (Iterator<Artikl> iter = newArtikl.iterator(); iter.hasNext();)
    	  addListaZelja((Artikl)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArtikl */
   public void addListaZelja(Artikl newArtikl) {
      if (newArtikl == null)
         return;
      if (this.listaZelja == null)
         this.listaZelja = new ArrayList<Artikl>();
      if (!this.listaZelja.contains(newArtikl))
         this.listaZelja.add(newArtikl);
   }
   
   /** @pdGenerated default remove
     * @param oldArtikl */
   public void removeListaZelja(Artikl oldArtikl) 
   {
      if (oldArtikl == null)
         return;
      if (this.listaZelja != null)
         if (this.listaZelja.contains(oldArtikl))
            this.listaZelja.remove(oldArtikl);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllListaZelja() 
   {
      if (listaZelja != null)
    	  listaZelja.clear();
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