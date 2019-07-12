package states;

import classes.Porudzbina;
import model.Aplikacija;

public abstract class StanjePorudzbine {
	
	protected Porudzbina kontekst;

	public abstract void entry();
	public abstract void exit();
	public abstract void plati();
	public abstract void otpremi();
	public abstract void prihvati();
	public abstract void odbij();
	
	public StanjePorudzbine(Porudzbina aKontekst) {
		kontekst = aKontekst;		
	}
	@Override
	public String toString() {
		return "StanjePorudzbine []";
	}
	
	
}
