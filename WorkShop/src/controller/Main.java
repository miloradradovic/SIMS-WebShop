package controller;
import java.io.IOException;
import java.util.ArrayList;

import classes.Kategorija;
import model.Aplikacija;

import view.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<String> fajlovi = new ArrayList<String>();
		
		fajlovi.add("Grad"); fajlovi.add("Artikl"); fajlovi.add("Korisnik"); 
		fajlovi.add("Kategorija"); fajlovi.add("Prodavnica"); fajlovi.add("Porudzbina");
		
		Aplikacija app = new Aplikacija();
	    
		
		//samo neki testni slucajevi za proveru rada
		/*
		Kategorija kat1 = new Kategorija();
		kat1.setNaziv("Sale");
		app.dodajKategoriju(kat1);
		Kategorija kat2 = new Kategorija();
		kat2.setNaziv("Damen");
		app.dodajKategoriju(kat2);
		Kategorija kat3 = new Kategorija();
		kat3.setNaziv("Herren");
		app.dodajKategoriju(kat3);
		Kategorija kat4 = new Kategorija();
		kat4.setNaziv("Kutsche");
		app.dodajKategoriju(kat4);
		Kategorija kat5 = new Kategorija();
		kat5.setNaziv("Wohnen");
		app.dodajKategoriju(kat5);
		Kategorija kat6 = new Kategorija();
		kat6.setNaziv("Kinder");
		app.dodajKategoriju(kat6);
		/*
		/* ----------------------------------- */
		
		MainWindow ww = new MainWindow(app);
		
		//LoginWindow lw = new LoginWindow(app);
		
		try
		{
			app.sacuvajUFajl(fajlovi);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
