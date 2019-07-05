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
		
		Aplikacija app = new Aplikacija(fajlovi);
		
		//samo neki testni slucajevi za proveru rada
		Kategorija kat1 = new Kategorija();
		kat1.setNaziv("Kat1");
		app.dodajKategoriju(kat1);
		Kategorija kat2 = new Kategorija();
		kat2.setNaziv("Kat2");
		app.dodajKategoriju(kat2);
		Kategorija kat3 = new Kategorija();
		kat3.setNaziv("Kat3");
		app.dodajKategoriju(kat3);
		/* ----------------------------------- */
		
		MainWindow ww = new MainWindow(app);
		
		try
		{
			app.sacuvajUFajl(fajlovi);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
