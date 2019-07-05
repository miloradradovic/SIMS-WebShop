package model;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import classes.*;
import enums.TipKorisnika;

/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  Vukasin
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/


public class Aplikacija {
	
   private TipKorisnika aktivniKorisnik;
   private int id;
   
   public ArrayList<Grad> gradovi;
   public ArrayList<Artikl> artikli;
   public ArrayList<Korisnik> korisnici;
   public ArrayList<Korpa> korpe;
   public ArrayList<Kategorija> kategorije;
   public ArrayList<Prodavnica> prodavnice;
   
   public SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
   
   public Aplikacija() {}
   
   public Aplikacija(ArrayList<String> naziviFajlova)
   {
	   //TODO Mico, good luck
	   //Mico, ovde samo pozivas metodu koju dole implementiras, napisao sam ti gde
	   //ucitajIzFajla();
   }
   
   public Aplikacija(TipKorisnika aktivniKorisnik, int id, ArrayList<Grad> grad, ArrayList<Artikl> artikl,
		ArrayList<Korisnik> korisnik, ArrayList<Korpa> korpa, ArrayList<Kategorija> kategorija,
		ArrayList<Prodavnica> prodavnica) 
   {
	super();
	this.aktivniKorisnik = aktivniKorisnik;
	this.id = id;
	this.gradovi = grad;
	this.artikli = artikl;
	this.korisnici = korisnik;
	this.korpe = korpa;
	this.kategorije = kategorija;
	this.prodavnice = prodavnica;
   }   
   

   public void dodajKorisnika(Korisnik korisnik) {
	   if (korisnik == null)
	         return;
	      if (this.korisnici == null)
	         this.korisnici = new ArrayList<Korisnik>();
	      if (!this.korisnici.contains(korisnik))
	         this.korisnici.add(korisnik);
   }
   

   public void obrisiKorisnika(Korisnik korisnik) {
	   if (korisnik == null)
	         return;
	      if (this.korisnici != null)
	         if (this.korisnici.contains(korisnik))
	            this.korisnici.remove(korisnik);
   }
   

   public Korisnik nadjiKorisnika(int jmbg) {
      for (Korisnik korisnik : korisnici) {
    	  if (korisnik.getJmbg() == jmbg) {
    		  return korisnik;
    	  }
      }
      return null;
   }
  
   
   public void dodajProdavnicu(Prodavnica prodavnica) {
	   if (prodavnica == null)
	         return;
	      if (this.prodavnice == null)
	         this.prodavnice = new ArrayList<Prodavnica>();
	      if (!this.prodavnice.contains(prodavnica))
	         this.prodavnice.add(prodavnica);
   }
   
   public void obrisiProdavnicu(Prodavnica prodavnica) {
	   if (prodavnica == null)
	         return;
	      if (this.prodavnice != null)
	         if (this.prodavnice.contains(prodavnica))
	            this.prodavnice.remove(prodavnica);   
	      
   }
   
   public Prodavnica nadjiProdavnicu(int idProdavnice) {
	      for (Prodavnica prodavnica : prodavnice) {
	    	  if (prodavnica.getIdProd() == idProdavnice) {
	    		  return prodavnica;
	    	  }
	      }
	      return null;
	   }
   
   
   public void dodajArtikl(Artikl artikl) {
	   if (artikl == null)
	         return;
	      if (this.artikli == null)
	         this.artikli = new ArrayList<Artikl>();
	      if (!this.artikli.contains(artikl))
	         this.artikli.add(artikl);
   }
   
   public Artikl nadjiArtikl(String sifraArtikla) {
      for (Artikl artikl : artikli) {
    	  if (artikl.getSifra() == sifraArtikla) {
    		  return artikl;
    	  }
      }
      return null;
   }
   
   public void obrisiArtikl(Artikl art) {
	   if (art == null)
	         return;
	      if (this.artikli != null)
	         if (this.artikli.contains(art))
	            this.artikli.remove(art);   
	  }
   
   public void dodajKategoriju(Kategorija kategorija) {
	   if (kategorija == null)
	         return;
	      if (this.kategorije == null)
	         this.kategorije = new ArrayList<Kategorija>();
	      if (!this.kategorije.contains(kategorija))
	         this.kategorije.add(kategorija);
   }
   
   public void obrisiKategoriju(Kategorija kategorija) {
	   if (kategorija == null)
	         return;
	      if (this.kategorije != null)
	         if (this.kategorije.contains(kategorija))
	            this.kategorije.remove(kategorija);   }
   
   
   public void izmeniKategoriju(String naziv, String noviNaziv) {
      for (Kategorija kategorija: kategorije) {
    	  if (kategorija.getNaziv().equalsIgnoreCase(naziv)) {
    		  kategorija.setNaziv(noviNaziv);
    		  return;
    	  }
      }
   }
   
   
   public void dodajKorpu(Korpa korpa) {
	   if (korpa == null)
	         return;
	      if (this.korpe == null)
	         this.korpe = new ArrayList<Korpa>();
	      if (!this.korpe.contains(korpa))
	         this.korpe.add(korpa);   }
   
   
   public void obrisiKorpu(Korpa korpa) {
	   if (korpa == null)
	         return;
	      if (this.korpe != null)
	         if (this.korpe.contains(korpa))
	            this.korpe.remove(korpa);
   }
   
   //Metoda koja pronalazi korpu neulogovanog korisnika
   public Korpa nadjiKorpu(int vlasnikId) {
      for (Korpa korpa: korpe) {
    	  if (korpa.getIdNeulog() == vlasnikId) {
    		  return korpa;
    	  }
      }
      return null;
   }
   
   public void dodajGrad(Grad grad) {
	   if (grad == null)
	         return;
	      if (this.gradovi == null)
	         this.gradovi = new ArrayList<Grad>();
	      if (!this.gradovi.contains(grad))
	         this.gradovi.add(grad);   
	   }
   
   
   public Grad nadjiGrad(int postanskiBroj) {
      for (Grad grad: gradovi) {
    	  if (grad.getPostanskiBroj() == postanskiBroj) {
    		  return grad;
    	  }
      }
      return null;
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
		//TODO: Mico ovde ide tvoja implementacija ucitavanja iz fajla.
	}
	
	public void sacuvajUFajl(ArrayList<String> naziviFajlova) throws IOException
	{
		File fajlGrad = new File(".\\Files\\" + naziviFajlova.get(0) +".txt");
		File fajlArtikl = new File(".\\Files\\" + naziviFajlova.get(1) +".txt");
		File fajlKorisnik = new File(".\\Files\\" + naziviFajlova.get(2) +".txt");
		File fajlKategorija = new File(".\\Files\\" + naziviFajlova.get(3) +".txt");
		File fajlProdavnica = new File(".\\Files\\" + naziviFajlova.get(4) +".txt");
		File fajlPorudzbina = new File(".\\Files\\" + naziviFajlova.get(5) +".txt");
		
		fajlGrad.createNewFile();
		fajlArtikl.createNewFile();
		fajlKorisnik.createNewFile();
		fajlKategorija.createNewFile();
		fajlProdavnica.createNewFile();
		fajlPorudzbina.createNewFile();
		
		PrintWriter pwGrad = new PrintWriter(new FileWriter(fajlGrad));
		PrintWriter pwArtikl = new PrintWriter(new FileWriter(fajlArtikl));
		PrintWriter pwKorisnik = new PrintWriter(new FileWriter(fajlKorisnik));
		PrintWriter pwKategorija = new PrintWriter(new FileWriter(fajlKategorija));
		PrintWriter pwProdavnica = new PrintWriter(new FileWriter(fajlProdavnica));
		PrintWriter pwPorudzbina = new PrintWriter(new FileWriter(fajlPorudzbina));
		
		Iterator<Grad> itGrad = gradovi.iterator();
		Iterator<Artikl> itArtikl = artikli.iterator();
		Iterator<Korisnik> itKorisnik = korisnici.iterator();
		Iterator<Kategorija> itKategorija = kategorije.iterator();
		Iterator<Prodavnica> itProdavnica = prodavnice.iterator();
		
		String unos;
		
		while(itGrad.hasNext())
		{
			unos = itGrad.next().getMesto() + "|" + itGrad.next().getPostanskiBroj();
			pwGrad.println(unos);
			pwGrad.flush();
		}
		 
		while(itArtikl.hasNext())
		{
			unos = itArtikl.next().getSifra() + "|" + itArtikl.next().getSlika() + "|" + itArtikl.next().getNaziv() + "|" + 
					itArtikl.next().getStanje() + "|" + itArtikl.next().getCena() + "|" + itArtikl.next().getBoja() + "|" + 
					itArtikl.next() + "|" + itArtikl.next().getAktivan() + "|" + itArtikl.next().getKategorija().getNaziv();
			pwArtikl.println(unos);
			pwArtikl.flush();
		}
		
		String unosPor;
		while(itKorisnik.hasNext())
		{
			StringBuilder sbKorPor = new StringBuilder();
			StringBuilder sbKorLisZ = new StringBuilder();
			StringBuilder sbKorKorpa = new StringBuilder();
			Iterator<Porudzbina> itPor = itKorisnik.next().getIteratorPorudzbina();
			Iterator<Artikl> itLisZ = itKorisnik.next().getIteratorListaZelja();
			Iterator<Stavka> itKorpa = itKorisnik.next().getKorpa().getIteratorStavka();
			
			while(itPor.hasNext())
			{
				sbKorPor.append(itPor.next().getBrojPor() + ",");
				
				StringBuilder sbPor = new StringBuilder();
				
				for (Map.Entry<String, Integer> entry : itPor.next().getCene().entrySet())  
				{
					sbPor.append(entry.getKey() + ":" + entry.getValue() + ",");
				}
				sbPor.deleteCharAt(sbPor.length() - 1);
		
				unosPor = itPor.next().getBrojPor() + "|" + itPor.next().getUkupnaCena() + "|" + 
						format.format(itPor.next().getDatumPorucivanja()) + "|" + sbPor.toString() + "|" + itPor.next().getStanje();
				pwPorudzbina.println(unosPor);
				pwPorudzbina.flush();
				
			}
			sbKorPor.deleteCharAt(sbKorPor.length() - 1);
			
			while(itLisZ.hasNext())
			{
				sbKorLisZ.append(itLisZ.next().getSifra() + ",");
			}
			sbKorLisZ.deleteCharAt(sbKorLisZ.length() - 1);
			
			while(itKorpa.hasNext())
			{
				sbKorKorpa.append(itKorpa.next().getArtikl().getSifra() + "%" + itKorpa.next().getKolicina() + ",");
			}
			sbKorKorpa.deleteCharAt(sbKorKorpa.length() - 1);
			
			unos = itKorisnik.next().getEmail() + "|" + itKorisnik.next().getTelefon() + "|" + itKorisnik.next().getIme() + "|" + 
					itKorisnik.next().getPrezime() + "|" + itKorisnik.next().getJmbg() + "|" + itKorisnik.next().getPol() + "|" + 
					itKorisnik.next().getKorisnickoIme() + "|" + itKorisnik.next().getSifra() + "|" + format.format(itKorisnik.next().getDatumRodj())
					+ "|" + itKorisnik.next().getAdresa().getUlica() + "%" + itKorisnik.next().getAdresa().getBroj() + itKorisnik.next().getAdresa().getGrad().getPostanskiBroj()
					+ "|" + sbKorPor.toString() + "|" + sbKorLisZ.toString() + "|" + sbKorKorpa.toString();
			pwKorisnik.println(unos);
			pwKorisnik.flush();
		}
		
		while(itKategorija.hasNext())
		{
			StringBuilder sbKat = new StringBuilder();
			Iterator<Kategorija> itKatKat = itKategorija.next().getIteratorKategorijaB();
			
			while(itKatKat.hasNext())
			{
				sbKat.append(itKatKat.next().getNaziv() + ",");
			}
			sbKat.deleteCharAt(sbKat.length() - 1);
			
			unos = itKategorija.next().getNaziv() + "|" + sbKat.toString();
			pwKategorija.println(unos);
			pwKategorija.flush();
		}
		
		while(itProdavnica.hasNext())
		{
			StringBuilder sbPro = new StringBuilder();
			
			for (Map.Entry<Artikl, Integer> entry : itProdavnica.next().getRaspolozivo().entrySet())  
			{
				sbPro.append(entry.getKey() + ":" + entry.getValue() + ",");
			}
			sbPro.deleteCharAt(sbPro.length() - 1);
			
			unos = itProdavnica.next().getPocetakRadVr() + "|" + itProdavnica.next().getKrajRadVr() + "|" +
					itProdavnica.next().getNaziv() + "|" + itProdavnica.next().getEmail() + "|" + sbPro.toString() + "|" + 
					itProdavnica.next().getAdresa().getUlica() + "%" + itProdavnica.next().getAdresa().getBroj() + "%" +
					itProdavnica.next().getAdresa().getGrad().getPostanskiBroj();
			pwProdavnica.println(unos);
			pwProdavnica.flush();
		}
		
		
		pwGrad.close();
		pwArtikl.close();
		pwKorisnik.close();
		pwKategorija.close();
		pwProdavnica.close();
		pwPorudzbina.close();	
	}

}