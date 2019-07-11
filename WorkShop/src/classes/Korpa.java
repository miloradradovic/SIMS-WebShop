package classes;
/***********************************************************************
 * Module:  Korpa.java
 * Author:  Vukasin
 * Purpose: Defines the Class Korpa
 ***********************************************************************/

import java.util.ArrayList;
import java.util.Iterator;

import states.StanjeKorpe;

/** @pdOid f37af365-20a5-4d98-8658-a5bfca0ff05d */
public class Korpa {
   /** @pdOid c01ca2ae-dfc8-427b-9cc2-8add3e1271f7 */
   private int idNeulog;
   StanjeKorpe trenutnoStanje;
   
   /** @pdRoleInfo migr=no name=Stavka assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Stavka> stavka;
   
   public Porudzbina porudzbina;
   //porudzbina koja se pravi od ove korpe, dok se porudzbina ne napravi ona je null
   
   public Korpa() {}   
   
   public Korpa(int idNeulog, ArrayList<Stavka> stavka)
   {
	super();
	this.idNeulog = idNeulog;
	this.stavka = stavka;
	this.porudzbina = null;
   }
   
   public Boolean umanjiStavku(Stavka stavka)
   {
	   Iterator<Stavka> it = getIteratorStavka();
  	 while(it.hasNext())
  	 {
  		 if(it.next().getArtikl().equals(stavka.getArtikl()))
  		 {
  			 it.next().setKolicina(it.next().getKolicina() - 1);
  			 return true;
  		 }
  	 }
  	 return false;
   }

/** @pdGenerated default getter */
   public ArrayList<Stavka> getStavka() {
      if (stavka == null)
         stavka = new ArrayList<Stavka>();
      return stavka;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Stavka> getIteratorStavka() {
      if (stavka == null)
         stavka = new ArrayList<Stavka>();
      return stavka.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavka */
   public void setStavka(ArrayList<Stavka> newStavka) {
      removeAllStavka();
      for (Iterator<Stavka> iter = newStavka.iterator(); iter.hasNext();)
    	  dodajStavku((Stavka)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavka */
   public Boolean dodajStavku(Stavka newStavka) {
      this.trenutnoStanje.dodajStavku(newStavka);
      if (this.stavka.contains(newStavka)) {
    	  return true;
      }
      return false;
   }
   
   /** @pdGenerated default remove
     * @param oldStavka */
   public Boolean obrisiStavku(Stavka oldStavka) {
      if (oldStavka == null)
         return false;
      if (this.stavka != null)
         if (this.stavka.contains(oldStavka))
         {
        	 this.stavka.remove(oldStavka);
        	 return true;
         }           
      return false;
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavka() {
      if (stavka != null)
         stavka.clear();
   }

	public int getIdNeulog() {
		return idNeulog;
	}
	
	public void setIdNeulog(int idNeulog) {
		this.idNeulog = idNeulog;
	}
	
	public void izmeniStanje(StanjeKorpe novoStanje) {
		
	}
	
	public void napraviPorudzbinu() {
		
	}
	
   
}