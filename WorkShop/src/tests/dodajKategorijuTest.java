package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Artikl;
import classes.Kategorija;
import enums.Boja;
import model.Aplikacija;

public class dodajKategorijuTest {

	Aplikacija app;

	@Test
	public void test() {
		app = new Aplikacija();
		int brojArtikalaFajla = app.artikli.size();
		app.dodajArtikl((new Artikl("124", "image1.png", "sto", 1, 60, Boja.braon, true, new Kategorija())));
		System.out.println(app.artikli.size());
		assertEquals(brojArtikalaFajla + 1, app.artikli.size());
	}

}
