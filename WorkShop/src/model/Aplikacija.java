package model;
import java.util.*;

import classes.*;
import enums.Boja;
import enums.TipKorisnika;

/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  Vukasin
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/


/** @pdOid 749e825d-edf6-4863-a536-7d48c94286ae */
public class Aplikacija {
   /** @pdOid 1926ea38-7e63-46f8-a666-8a442fb7e113 */
   private TipKorisnika aktivniKorisnik;
   /** @pdOid b3de6d4f-0dcc-49fc-ae34-4692b1040ccf */
   private int id;
   
   /** @pdRoleInfo migr=no name=Grad assc=association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Grad> grad;
   /** @pdRoleInfo migr=no name=Artikl assc=association12 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Artikl> artikl;
   /** @pdRoleInfo migr=no name=Korisnik assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Korisnik> korisnik;
   /** @pdRoleInfo migr=no name=Korpa assc=association17 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public ArrayList<Korpa> korpa;
   /** @pdRoleInfo migr=no name=Kategorija assc=association22 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Kategorija> kategorija;
   /** @pdRoleInfo migr=no name=Prodavnica assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Prodavnica> prodavnica;
   
   public Aplikacija() {}
   
   public Aplikacija(ArrayList<String> naziviFajlova)
   {
	   //TODO Mico, good luck
	     
   }
   
   public Aplikacija(TipKorisnika aktivniKorisnik, int id, ArrayList<Grad> grad, ArrayList<Artikl> artikl,
		ArrayList<Korisnik> korisnik, ArrayList<Korpa> korpa, ArrayList<Kategorija> kategorija,
		ArrayList<Prodavnica> prodavnica) 
   {
	super();
	this.aktivniKorisnik = aktivniKorisnik;
	this.id = id;
	this.grad = grad;
	this.artikl = artikl;
	this.korisnik = korisnik;
	this.korpa = korpa;
	this.kategorija = kategorija;
	this.prodavnica = prodavnica;
   }



/** @pdOid 5db79e13-b2e3-48db-bb99-0dc862503e1f */
   public void dodajKorisnika() {
      // TODO: implement
   }
   
   /** @pdOid 36b1d5f8-163a-494b-ad01-a18ad1872738 */
   public void obrisiKorisnika() {
      // TODO: implement
   }
   
   /** @param jmbg
    * @pdOid c0e403fd-d6c2-42b0-bea0-749059bf062a */
   public Korisnik nadjiKorisnika(int jmbg) {
      // TODO: implement
      return null;
   }
   
   /** @pdOid cbbb40c1-6602-4a96-98a0-21b268ac8bf3 */
   public void dodajProdavnicu() {
      // TODO: implement
   }
   
   /** @pdOid ddc841f0-f59e-43b4-a19d-d3d33594b4a5 */
   public void obrisiProdavnicu() {
      // TODO: implement
   }
   
   /** @param sifraArtikla 
    * @param slika 
    * @param naziv 
    * @param kategorija 
    * @param kolicina 
    * @param cena 
    * @param boja
    * @pdOid d6f2c938-d188-4b32-837c-8d0bdc75d355 */
   public void dodajArtikl(String sifraArtikla, String slika, String naziv, Kategorija kategorija, int kolicina, double cena, Boja boja) {
      // TODO: implement
   }
   
   /** @param art
    * @pdOid 8dfb453f-b605-4121-86cd-60beaa22238a */
   public void izmeniArtikl(Artikl art) {
      // TODO: implement
   }
   
   /** @param sifraArtikla
    * @pdOid 11ce1ec1-6d7f-4e27-b429-ba8d87e31eb4 */
   public Artikl nadjiArtikl(String sifraArtikla) {
      // TODO: implement
      return null;
   }
   
   /** @param art
    * @pdOid e40ab4d1-9e53-4300-a8e4-cac0894b7e09 */
   public void obrisiArtikl(Artikl art) {
      // TODO: implement
   }
   
   /** @param naziv
    * @pdOid c4c08fb2-58b3-4ee7-b513-5d0844a13542 */
   public void dodajKategoriju(String naziv) {
      // TODO: implement
   }
   
   /** @param naziv
    * @pdOid 0b506a70-a674-499a-8272-246ad0e0b590 */
   public void obrisiKategoriju(String naziv) {
      // TODO: implement
   }
   
   /** @param naziv 
    * @param noviNaziv
    * @pdOid 99672d4f-51d5-41ac-9d89-57caa2adcaf4 */
   public void izmeniKategoriju(String naziv, String noviNaziv) {
      // TODO: implement
   }
   
   /** @param korpa
    * @pdOid 4caeaf4b-5656-4bfd-aa5a-bdda3bbef4c5 */
   public void dodajKorpu(Korpa korpa) {
      // TODO: implement
   }
   
   /** @param idKorpe
    * @pdOid 645cfc3e-25a5-4998-8271-87f063b40886 */
   public void obrisiKorpu(int idKorpe) {
      // TODO: implement
   }
   
   /** @param idKorpe
    * @pdOid ec44eccf-774e-43cd-ac2d-cb81074363b4 */
   public Korpa nadjiKorpu(int idKorpe) {
      // TODO: implement
      return null;
   }
   
   /** @param mesto 
    * @param postanskiBroj
    * @pdOid 740ce7ba-bf8c-427d-abed-8e9f85d21b3e */
   public void dodajGrad(String mesto, int postanskiBroj) {
      // TODO: implement
   }
   
   /** @param postanskiBroj
    * @pdOid db0ebd6b-5ecb-4fde-8a24-7382167069d2 */
   public Grad nadjiGrad(int postanskiBroj) {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public ArrayList<Grad> getGrad() {
      if (grad == null)
         grad = new ArrayList<Grad>();
      return grad;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Grad> getIteratorGrad() {
      if (grad == null)
         grad = new ArrayList<Grad>();
      return grad.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newGrad */
   public void setGrad(ArrayList<Grad> newGrad) {
      removeAllGrad();
      for (Iterator<Grad> iter = newGrad.iterator(); iter.hasNext();)
         addGrad((Grad)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGrad */
   public void addGrad(Grad newGrad) 
   {
      if (newGrad == null)
         return;
      if (this.grad == null)
         this.grad = new ArrayList<Grad>();
      if (!this.grad.contains(newGrad))
         this.grad.add(newGrad);
   }
   
   /** @pdGenerated default remove
     * @param oldGrad */
   public void removeGrad(Grad oldGrad) 
   {
      if (oldGrad == null)
         return;
      if (this.grad != null)
         if (this.grad.contains(oldGrad))
            this.grad.remove(oldGrad);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllGrad() 
   {
      if (grad != null)
         grad.clear();
   }
   /** @pdGenerated default getter */
   public ArrayList<Artikl> getArtikl() 
   {
      if (artikl == null)
         artikl = new ArrayList<Artikl>();
      return artikl;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Artikl> getIteratorArtikl() 
   {
      if (artikl == null)
         artikl = new ArrayList<Artikl>();
      return artikl.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newArtikl */
   public void setArtikl(ArrayList<Artikl> newArtikl) 
   {
      removeAllArtikl();
      for (Iterator<Artikl> iter = newArtikl.iterator(); iter.hasNext();)
         addArtikl((Artikl)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newArtikl */
   public void addArtikl(Artikl newArtikl) 
   {
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
   /** @pdGenerated default getter */
   public ArrayList<Korisnik> getKorisnik() 
   {
      if (korisnik == null)
         korisnik = new ArrayList<Korisnik>();
      return korisnik;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Korisnik> getIteratorKorisnik() 
   {
      if (korisnik == null)
         korisnik = new ArrayList<Korisnik>();
      return korisnik.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorisnik */
   public void setKorisnik(ArrayList<Korisnik> newKorisnik) 
   {
      removeAllKorisnik();
      for (Iterator<Korisnik> iter = newKorisnik.iterator(); iter.hasNext();)
         addKorisnik((Korisnik)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKorisnik */
   public void addKorisnik(Korisnik newKorisnik) 
   {
      if (newKorisnik == null)
         return;
      if (this.korisnik == null)
         this.korisnik = new ArrayList<Korisnik>();
      if (!this.korisnik.contains(newKorisnik))
         this.korisnik.add(newKorisnik);
   }
   
   /** @pdGenerated default remove
     * @param oldKorisnik */
   public void removeKorisnik(Korisnik oldKorisnik) 
   {
      if (oldKorisnik == null)
         return;
      if (this.korisnik != null)
         if (this.korisnik.contains(oldKorisnik))
            this.korisnik.remove(oldKorisnik);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorisnik() 
   {
      if (korisnik != null)
         korisnik.clear();
   }
   /** @pdGenerated default getter */
   public ArrayList<Korpa> getKorpa()
   {
      if (korpa == null)
         korpa = new ArrayList<Korpa>();
      return korpa;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Korpa> getIteratorKorpa() 
   {
      if (korpa == null)
         korpa = new ArrayList<Korpa>();
      return korpa.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKorpa */
   public void setKorpa(ArrayList<Korpa> newKorpa) 
   {
      removeAllKorpa();
      for (Iterator<Korpa> iter = newKorpa.iterator(); iter.hasNext();)
         addKorpa((Korpa)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKorpa */
   public void addKorpa(Korpa newKorpa) 
   {
      if (newKorpa == null)
         return;
      if (this.korpa == null)
         this.korpa = new ArrayList<Korpa>();
      if (!this.korpa.contains(newKorpa))
         this.korpa.add(newKorpa);
   }
   
   /** @pdGenerated default remove
     * @param oldKorpa */
   public void removeKorpa(Korpa oldKorpa) 
   {
      if (oldKorpa == null)
         return;
      if (this.korpa != null)
         if (this.korpa.contains(oldKorpa))
            this.korpa.remove(oldKorpa);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKorpa()
   {
      if (korpa != null)
         korpa.clear();
   }
   /** @pdGenerated default getter */
   public ArrayList<Kategorija> getKategorija()
   {
      if (kategorija == null)
         kategorija = new ArrayList<Kategorija>();
      return kategorija;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Kategorija> getIteratorKategorija() 
   {
      if (kategorija == null)
         kategorija = new ArrayList<Kategorija>();
      return kategorija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKategorija */
   public void setKategorija(ArrayList<Kategorija> newKategorija) 
   {
      removeAllKategorija();
      for (Iterator<Kategorija> iter = newKategorija.iterator(); iter.hasNext();)
         addKategorija((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public void addKategorija(Kategorija newKategorija) 
   {
      if (newKategorija == null)
         return;
      if (this.kategorija == null)
         this.kategorija = new ArrayList<Kategorija>();
      if (!this.kategorija.contains(newKategorija))
         this.kategorija.add(newKategorija);
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removeKategorija(Kategorija oldKategorija) 
   {
      if (oldKategorija == null)
         return;
      if (this.kategorija != null)
         if (this.kategorija.contains(oldKategorija))
            this.kategorija.remove(oldKategorija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKategorija() 
   {
      if (kategorija != null)
         kategorija.clear();
   }
   /** @pdGenerated default getter */
   public ArrayList<Prodavnica> getProdavnica() 
   {
      if (prodavnica == null)
         prodavnica = new ArrayList<Prodavnica>();
      return prodavnica;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Prodavnica> getIteratorProdavnica() 
   {
      if (prodavnica == null)
         prodavnica = new ArrayList<Prodavnica>();
      return prodavnica.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProdavnica */
   public void setProdavnica(ArrayList<Prodavnica> newProdavnica) 
   {
      removeAllProdavnica();
      for (Iterator<Prodavnica> iter = newProdavnica.iterator(); iter.hasNext();)
         addProdavnica((Prodavnica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProdavnica */
   public void addProdavnica(Prodavnica newProdavnica) 
   {
      if (newProdavnica == null)
         return;
      if (this.prodavnica == null)
         this.prodavnica = new ArrayList<Prodavnica>();
      if (!this.prodavnica.contains(newProdavnica))
         this.prodavnica.add(newProdavnica);
   }
   
   /** @pdGenerated default remove
     * @param oldProdavnica */
   public void removeProdavnica(Prodavnica oldProdavnica) 
   {
      if (oldProdavnica == null)
         return;
      if (this.prodavnica != null)
         if (this.prodavnica.contains(oldProdavnica))
            this.prodavnica.remove(oldProdavnica);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProdavnica()
   {
      if (prodavnica != null)
         prodavnica.clear();
   }

	public TipKorisnika getAktivniKorisnik() 
	{
		return aktivniKorisnik;
	}
	
	public void setAktivniKorisnik(TipKorisnika aktivniKorisnik) 
	{
		this.aktivniKorisnik = aktivniKorisnik;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	   
	public void ucitajIzFajla(ArrayList<String> naziviFajlova)
	{
		//TODO
	}
	
	public void sacuvajUFajl(ArrayList<String> naziviFajlova)
	{
		
		
	}

}