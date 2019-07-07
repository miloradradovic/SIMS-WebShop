package model;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import classes.*;
import enums.Boja;
import enums.Pol;
import enums.TipKorisnika;
import states.Stanje;

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
   public ArrayList<Porudzbina> porudzbine;
   
   public SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
   
   public Aplikacija() 
   {
	   this.gradovi = new ArrayList<Grad>();
	   this.artikli = new ArrayList<Artikl>();
	   this.korisnici = new ArrayList<Korisnik>();
	   this.korpe = new ArrayList<Korpa>();
	   this.kategorije = new ArrayList<Kategorija>();
	   this.prodavnice = new ArrayList<Prodavnica>();
	   this.porudzbine = new ArrayList<Porudzbina>();
	   try{
		   ucitajIzFajla(); 
	   }
	   catch(IOException e){
		   e.printStackTrace();
	   }catch(ParseException e){
		   e.printStackTrace();
	   }
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
	   
	public void ucitajIzFajla() throws IOException, ParseException
	{
		//CITANJE GRADOVA
		BufferedReader br = new BufferedReader(new FileReader(".\\Files\\Grad.txt"));
		String temp;
		while((temp = br.readLine())!= null){
			Grad grad = new Grad();
			String[] delimiter = temp.split("\\|");
			grad.setMesto(delimiter[0]);
			grad.setPostanskiBroj(Integer.parseInt(delimiter[1]));
			gradovi.add(grad);
		}
		br.close();
		
		//CITANJE KATEGORIJA
		BufferedReader br2 = new BufferedReader(new FileReader(".\\Files\\Kategorija.txt"));
		String temp2;
		HashMap<Kategorija,String[]> mapa = new HashMap<Kategorija,String[]>();
		while((temp2=br2.readLine())!=null){
			Kategorija kategorija = new Kategorija();
			String[]delimiter = temp2.split("\\|");
			kategorija.setNaziv(delimiter[0]);
			kategorije.add(kategorija);
			try{
				String[] delimiter2 = delimiter[1].split("\\,");
				mapa.put(kategorija, delimiter2);
			}catch(Exception e){
				String[] prazna = {};
				mapa.put(kategorija, prazna);
			}
		}
		br2.close();
		for(Kategorija k:kategorije){
			String[] subcat = mapa.get(k);
			for(String st:subcat){
				for(Kategorija k1:kategorije){
					if(k1.getNaziv().equals(st)){
						k.getKategorijaB().add(k1);
						break;
					}
				}
			}
		}
		
		
		br2.close();
		
		//CITANJE ARTIKALA
		BufferedReader br3 = new BufferedReader(new FileReader(".\\Files\\Artikl.txt"));
		String temp3;
		while((temp3=br3.readLine())!=null){
			Artikl artikl = new Artikl();
			String[] delimiter = temp3.split("\\|");
			artikl.setSifra(delimiter[0]);
			artikl.setSlika(delimiter[1]);
			artikl.setNaziv(delimiter[2]);
			artikl.setStanje(Integer.parseInt(delimiter[3]));
			artikl.setCena(Integer.parseInt(delimiter[4]));
			artikl.setBoja(Boja.valueOf(delimiter[5]));
			artikl.setAktivan(Boolean.parseBoolean(delimiter[6]));
			for(Kategorija k:kategorije){
				if(k.getNaziv().equals(delimiter[7])){
					artikl.setKategorija(k);
				}
			}
			artikli.add(artikl);
		}
		br3.close();
		
		//CITANJE PORUDZBINA
		BufferedReader br4 = new BufferedReader(new FileReader(".\\Files\\Porudzbina.txt"));
		
		String temp4;
		while((temp4=br4.readLine())!=null){
			Porudzbina p = new Porudzbina();
			String[] delimiter = temp4.split("\\|");
			p.setBrojPor(Integer.parseInt(delimiter[0]));
			p.setUkupnaCena(Integer.parseInt(delimiter[1]));
			p.setDatumPorucivanja(format.parse(delimiter[2]));
			String[] delimiter2 = delimiter[3].split("\\,");
			HashMap<String,Integer> mapa2 = new HashMap<String,Integer>();
			for(int i = 0;i<delimiter2.length;i++){
				String[] delimiter3 = delimiter2[i].split("\\%");
				mapa2.put(delimiter3[0], Integer.parseInt(delimiter3[1]));
			}
			p.setCene(mapa2);
			//NISAM DODAO STANJE JER NZM :)
		}
		br4.close();
		
		//CITANJE PRODAVNICA
		BufferedReader br5 = new BufferedReader(new FileReader(".\\Files\\Prodavnica.txt"));
		
		String temp5;
		while((temp5=br5.readLine())!=null){
			Prodavnica p = new Prodavnica();
			String[] delimiter = temp5.split("\\|");
			p.setPocetakRadVr(delimiter[0]);
			p.setKrajRadVr(delimiter[1]);
			p.setNaziv(delimiter[2]);
			p.setEmail(delimiter[3]);
			String[] delimiter2 = delimiter[4].split("\\,");
			HashMap<Artikl,Integer> raspolozivost = new HashMap<Artikl,Integer>();
			for(int i = 0;i<delimiter2.length;i++){
				String[]delimiter3 = delimiter2[i].split("\\%");
				for(Artikl a3:artikli){
					if(a3.getSifra().equals(delimiter3[0])){
						raspolozivost.put(a3, Integer.parseInt(delimiter3[1]));
					}
				}
			}
			p.setRaspolozivo(raspolozivost);
			String[] delimiter4 = delimiter[5].split("\\%");
			Adresa adresa = new Adresa();
			adresa.setUlica(delimiter4[0]);
			adresa.setBroj(Integer.parseInt(delimiter4[1]));
			for(Grad g:gradovi){
				if(g.getPostanskiBroj()==Integer.parseInt(delimiter4[2])){
					adresa.setGrad(g);
				}
			}
			p.setAdresa(adresa);
		}
		br5.close();
		
		//CITANJE KORISNIKA
		BufferedReader br6 = new BufferedReader(new FileReader(".\\Files\\Korisnik.txt"));
		String temp6;
		while((temp6=br6.readLine())!=null){
			Korisnik k = new Korisnik();
			String[] delimiter = temp6.split("\\|");
			k.setEmail(delimiter[0]);
			k.setTelefon(delimiter[1]);
			k.setIme(delimiter[2]);
			k.setPrezime(delimiter[3]);
			k.setJmbg(Integer.parseInt(delimiter[4]));
			k.setPol(Pol.valueOf(delimiter[5]));
			k.setKorisnickoIme(delimiter[6]);
			k.setSifra(delimiter[7]);
			k.setDatumRodj(format.parse(delimiter[8]));
			String[] delimiter2 = delimiter[9].split("\\%");
			Adresa a = new Adresa();
			a.setUlica(delimiter2[0]);
			a.setBroj(Integer.parseInt(delimiter2[1]));
			for(Grad g:gradovi){
				if(g.getPostanskiBroj()==Integer.parseInt(delimiter2[2])){
					a.setGrad(g);
				}
			}
			k.setAdresa(a);
			ArrayList<Porudzbina> porudzbineK = new ArrayList<Porudzbina>();
			String[] delimiter3 = delimiter[10].split("\\,");
			for(int i = 0;i<delimiter3.length;i++){
				for(Porudzbina p:porudzbine){
					if(p.getBrojPor()==Integer.parseInt(delimiter3[i])){
						porudzbineK.add(p);
					}
				}
			}
			k.setPorudzbina(porudzbineK);
			String[] delimiter4 = delimiter[11].split("\\,");
			ArrayList<Artikl> listaZeljaK = new ArrayList<Artikl>();
			for(int i = 0;i<delimiter4.length;i++){
				for(Artikl a1:artikli){
					if(a1.getSifra().equals(delimiter4[i])){
						listaZeljaK.add(a1);
					}
				}
			}
			k.setArtikl(listaZeljaK);
			String[] delimiter5 = delimiter[12].split("\\,");
			ArrayList<Stavka> stavkeK = new ArrayList<Stavka>();
			for(int i = 0;i<delimiter5.length;i++){
				String[] delimiter6 = delimiter5[i].split("\\%");
				for(Artikl a2:artikli){
					if(a2.getSifra().equals(delimiter6[0])){
						Stavka s1 = new Stavka();
						s1.setArtikl(a2);
						s1.setKolicina(Integer.parseInt(delimiter6[1]));
						stavkeK.add(s1);
					}
				}
			}
			Korpa korpa = new Korpa();
			korpa.setStavka(stavkeK);
			k.setKorpa(korpa);
		}
		br6.close();
	}
	
	public boolean proveraKat(Kategorija k){
		if(k.getKategorijaB().isEmpty()){
			return true; 
		}else{
			return false;
		}
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
			Grad gr = itGrad.next();
			unos = gr.getMesto() + "|" + gr.getPostanskiBroj();
			pwGrad.println(unos);
			pwGrad.flush();
		}
		 
		while(itArtikl.hasNext())
		{
			Artikl ar = itArtikl.next();
			unos = ar.getSifra() + "|" + ar.getSlika() + "|" + ar.getNaziv() + "|" + ar.getStanje() + "|" 
			+ ar.getCena() + "|" +ar.getBoja() + "|" + ar.getAktivan() + "|" + ar.getKategorija().getNaziv();
			pwArtikl.println(unos);
			pwArtikl.flush();
		}
		
		String unosPor;
		while(itKorisnik.hasNext())
		{
			Korisnik kor = itKorisnik.next();
			StringBuilder sbKorPor = new StringBuilder();
			StringBuilder sbKorLisZ = new StringBuilder();
			StringBuilder sbKorKorpa = new StringBuilder();
			Iterator<Porudzbina> itPor = kor.getIteratorPorudzbina();
			Iterator<Artikl> itLisZ = kor.getIteratorListaZelja();
			Iterator<Stavka> itKorpa = kor.getKorpa().getIteratorStavka();
			
			while(itPor.hasNext())
			{
				Porudzbina por = itPor.next();
				sbKorPor.append(por.getBrojPor() + ",");
				
				StringBuilder sbPor = new StringBuilder();
				
				for (Map.Entry<String, Integer> entry : por.getCene().entrySet())  
				{
					sbPor.append(entry.getKey() + ":" + entry.getValue() + ",");
				}
				sbPor.deleteCharAt(sbPor.length() - 1);
		
				unosPor = por.getBrojPor() + "|" + por.getUkupnaCena() + "|" + 
						format.format(por.getDatumPorucivanja()) + "|" + sbPor.toString() + "|" + por.getStanje();
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
				Stavka st = itKorpa.next();
				sbKorKorpa.append(st.getArtikl().getSifra() + "%" +st.getKolicina() + ",");
			}
			sbKorKorpa.deleteCharAt(sbKorKorpa.length() - 1);
			
			unos = kor.getEmail() + "|" + kor.getTelefon() + "|" + kor.getIme() + "|" + kor.getPrezime() + "|" 
					+ kor.getJmbg() + "|" + kor.getPol() + "|" + kor.getKorisnickoIme() + "|" + kor.getSifra() + "|" 
					+ format.format(kor.getDatumRodj()) + "|" + kor.getAdresa().getUlica() + "%" 
					+ kor.getAdresa().getBroj() + kor.getAdresa().getGrad().getPostanskiBroj() + "|" 
					+ sbKorPor.toString() + "|" + sbKorLisZ.toString() + "|" + sbKorKorpa.toString();
			pwKorisnik.println(unos);
			pwKorisnik.flush();
		}
		
		while(itKategorija.hasNext())
		{
			Kategorija kat = itKategorija.next();
			StringBuilder sbKat = new StringBuilder();
			Iterator<Kategorija> itKatKat = kat.getIteratorKategorijaB();
			
			while(itKatKat.hasNext())
			{
				sbKat.append(itKatKat.next().getNaziv() + ",");
			}
			if(sbKat.length() > 0)
				sbKat.deleteCharAt(sbKat.length() - 1);
			
			unos = kat.getNaziv() + "|" + sbKat.toString();
			pwKategorija.println(unos);
			pwKategorija.flush();
		}
		
		while(itProdavnica.hasNext())
		{
			Prodavnica pro = itProdavnica.next();
			StringBuilder sbPro = new StringBuilder();
			
			for (Map.Entry<Artikl, Integer> entry : pro.getRaspolozivo().entrySet())  
			{
				sbPro.append(entry.getKey() + ":" + entry.getValue() + ",");
			}
			//if(sbPro.length() > 0)
				sbPro.deleteCharAt(sbPro.length() - 1);
			
			unos = pro.getPocetakRadVr() + "|" + pro.getKrajRadVr() + "|" +
					pro.getNaziv() + "|" + pro.getEmail() + "|" + sbPro.toString() + "|" + 
					pro.getAdresa().getUlica() + "%" + pro.getAdresa().getBroj() + "%" +
					pro.getAdresa().getGrad().getPostanskiBroj();
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