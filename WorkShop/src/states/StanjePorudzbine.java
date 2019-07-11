package states;

import model.Aplikacija;

public abstract class StanjePorudzbine {
	
	protected Aplikacija kontekst;

	public abstract void entry();
	public abstract void exit();
	public abstract void plati();
	public abstract void otpremi();
	
	public StanjePorudzbine(Aplikacija aKontekst) {
		kontekst = aKontekst;		
	}
	
	
}
