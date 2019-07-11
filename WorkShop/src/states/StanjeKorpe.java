package states;

import classes.Korpa;
import classes.Stavka;
import model.Aplikacija;

public abstract class StanjeKorpe {

	protected Korpa kontekst;
	
	public abstract void entry();
	public abstract void exit();
	public abstract void obrisiStavku(Stavka oldStavka);
	public abstract void dodajStavku(Stavka newStavka);
	
	public StanjeKorpe(Korpa aKontekst) {
		kontekst = aKontekst;		
	}
	
}
