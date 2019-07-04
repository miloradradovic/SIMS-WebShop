package controller;
import java.io.IOException;
import java.util.ArrayList;

import model.Aplikacija;

import view.*;

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
=======
		ArrayList<String> fajlovi = new ArrayList<String>();
		
		fajlovi.add("Grad"); fajlovi.add("Artikl"); fajlovi.add("Korisnik"); 
		fajlovi.add("Kategorija"); fajlovi.add("Prodavnica"); fajlovi.add("Porudzbina");
		
		Aplikacija app = new Aplikacija(fajlovi);
>>>>>>> 565de8e40b3cc9f2e84e716864c2b375e5592f66
		
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
