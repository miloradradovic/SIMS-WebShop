package states;

import java.util.ArrayList;
import java.util.Iterator;

import classes.Korpa;
import classes.Stavka;

public class UPripremi extends StanjeKorpe {

	public UPripremi(Korpa aKontekst) {
		super(aKontekst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entry() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}


	@Override
	public void dodajStavku(Stavka newStavka) {
	      if (kontekst.stavka == null)
	         kontekst.stavka = new ArrayList<Stavka>();
	      int ind = 0;
	      for (Stavka stv : kontekst.stavka) {
	    	  if (stv.getArtikl().getSifra().equals(newStavka.getArtikl().getSifra())) {
	    		 ind = 1;
	    		 stv.setKolicina(stv.getKolicina() + newStavka.getKolicina());
	    	  }
	    	  
	      }
	      if (ind == 0) {
	    	  kontekst.stavka.add(newStavka);
	      }

	}

	@Override
	public void obrisiStavku(Stavka oldStavka) {
		// TODO Auto-generated method stub
		
	}
	
	public Iterator<Stavka> getIteratorStavka() {
	      if (kontekst.stavka == null)
	         kontekst.stavka = new ArrayList<Stavka>();
	      return kontekst.stavka.iterator();
	   }

	@Override
	public String toString() {
		return "UPripremi []";
	}
	
}
