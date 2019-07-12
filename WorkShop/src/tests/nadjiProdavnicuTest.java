package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import classes.Adresa;
import classes.Artikl;
import classes.Kategorija;
import classes.Prodavnica;
import enums.Boja;
import model.Aplikacija;

public class nadjiProdavnicuTest {

	Aplikacija app;

	@Before
	public void before() {
		app = new Aplikacija();
		app.dodajProdavnicu(new Prodavnica(0, "09:00", "15:00", "radnja1", "email1", new HashMap<Artikl, Integer>(), new Adresa()));
		app.dodajProdavnicu(new Prodavnica(1, "09:00", "15:00", "radnja2", "email2", new HashMap<Artikl, Integer>(), new Adresa()));	
	}

	@Test
	public void test() {
		Prodavnica pro = app.nadjiProdavnicu(1);
		System.out.println(pro.getIdProd());
		assertEquals(1, pro.getIdProd());
	}
}
