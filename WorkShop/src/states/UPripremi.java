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
	      if (!kontekst.stavka.contains(newStavka))
	         kontekst.stavka.add(newStavka);
	      else
	      {
	    	 Iterator<Stavka> it = getIteratorStavka();
	    	 while(it.hasNext())
	    	 {
	    		 if(it.next().getArtikl().equals(newStavka.getArtikl()))
	    		 {
	    			 it.next().setKolicina(it.next().getKolicina() + newStavka.getKolicina());
	    			 break;
	    		 }
	    	 }
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

}
