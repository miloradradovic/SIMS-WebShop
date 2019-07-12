package controller;
import java.util.ArrayList;

import model.Aplikacija;
import view.MainWindow;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Aplikacija app = new Aplikacija();
		
		
		//samo neki testni slucajevi za proveru rada
		/*Kategorija kat1 = new Kategorija();
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
		
	
		
		//MainWindow ww = new MainWindow(app);
		
		/*Porudzbina poru = new Porudzbina();
		poru.setBrojPor(0);
		Porudzbina poru1 = new Porudzbina();
		poru1.setBrojPor(1);
		poru.setStanje(new ZaOtpremu(poru));
		poru1.setStanje(new ZaOtpremu(poru));

		app.porudzbine.add(poru);
		app.porudzbine.add(poru1);*/

		MainWindow ww = new MainWindow(app);
		//new AcceptPaymentWindow(app);
		//ContentManagerWindow cmw = new ContentManagerWindow(app);
		
		//RegisterWindow rw = new RegisterWindow(app);

		//LoginWindow lw = new LoginWindow(app);

		//ArticleWindow aw = new ArticleWindow("123",app);
		
		//SearchWindow sw = new SearchWindow(app, "Kinder");
		
	
	}

}