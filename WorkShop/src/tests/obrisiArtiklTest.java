package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Artikl;
import classes.Kategorija;
import enums.Boja;
import model.Aplikacija;

public class obrisiArtiklTest {
	
	Aplikacija app;

	@Before
	public void before() {
		app = new Aplikacija();
		app.dodajArtikl((new Artikl("123", "image.png", "sto", 2, 50, Boja.bela, true, new Kategorija())));
		app.dodajArtikl((new Artikl("124", "image1.png", "sto", 1, 60, Boja.braon, true, new Kategorija())));
		
	}

	@Test
	public void test() {
		Artikl art = app.nadjiArtikl("123");
		int brojArtikalaFajla = app.artikli.size();
		app.obrisiArtikl(art);
		System.out.println(app.artikli.size());
		assertEquals(brojArtikalaFajla - 1, app.artikli.size());
	}

}
