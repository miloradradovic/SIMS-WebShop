package controller;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import classes.Adresa;
import classes.Artikl;
import classes.Grad;
import classes.Kategorija;
import classes.Korisnik;
import classes.Korpa;
import classes.Porudzbina;
import model.Aplikacija;
import enums.Pol;

import view.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<String> fajlovi = new ArrayList<String>();
		
		fajlovi.add("Grad"); fajlovi.add("Artikl"); fajlovi.add("Korisnik"); 
		fajlovi.add("Kategorija"); fajlovi.add("Prodavnica"); fajlovi.add("Porudzbina");
		
		Aplikacija app = new Aplikacija();
		
		//samo neki testni slucajevi za proveru rada
		Kategorija kat1 = new Kategorija();
		kat1.setNaziv("Sale");
		app.dodajKategoriju(kat1);
		Kategorija kat2 = new Kategorija();
		kat2.setNaziv("Damen");
		app.dodajKategoriju(kat2);
		kat1.dodajKategoriju(kat2);
		Kategorija kat3 = new Kategorija();
		kat3.setNaziv("Herren");
		app.dodajKategoriju(kat3);
		kat2.dodajKategoriju(kat3);
		Kategorija kat4 = new Kategorija();
		kat4.setNaziv("Kutsche");
		app.dodajKategoriju(kat4);
		Kategorija kat5 = new Kategorija();
		kat5.setNaziv("Wohnen");
		app.dodajKategoriju(kat5);
		Kategorija kat6 = new Kategorija();
		kat6.setNaziv("Kinder");
		app.dodajKategoriju(kat6);
		kat1.dodajKategoriju(kat6);
		
		try {
			Korisnik kor = new Korisnik("pera.peric@mail.com", "0230-123-123", "Pera", "Peric", 123, 
					Pol.muski, "pera123", "pera123", app.format.parse("10.05.1999."), 
					new Adresa("Gunduliceva", 5, new Grad("Novi Sad", 21000)), new Korpa(), new ArrayList<Porudzbina>(),
					new ArrayList<Artikl>());
			
			System.out.println(kor.getJmbg());
		app.dodajKorisnika(kor);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/* ----------------------------------- */
		
		//MainWindow ww = new MainWindow(app);
		
		
		LoginWindow lw = new LoginWindow(app);
		
		try
		{
			app.sacuvajUFajl(fajlovi);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}