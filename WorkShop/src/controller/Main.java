package controller;
import java.io.IOException;
import java.util.ArrayList;

import model.Aplikacija;

import view.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> fajlovi = new ArrayList<String>();
		
		fajlovi.add("Grad"); fajlovi.add("Artikl"); fajlovi.add("Korisnik"); 
		fajlovi.add("Kategorija"); fajlovi.add("Prodavnica"); fajlovi.add("Porudzbina");
		
		Aplikacija app = new Aplikacija(fajlovi);
		
		MainWindow ww = new MainWindow();
		
		try
		{
			app.sacuvajUFajl(fajlovi);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
