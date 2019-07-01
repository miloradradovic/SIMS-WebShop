package classes;
/***********************************************************************
 * Module:  Korpa.java
 * Author:  Vukasin
 * Purpose: Defines the Class Korpa
 ***********************************************************************/

import java.util.*;

/** @pdOid f37af365-20a5-4d98-8658-a5bfca0ff05d */
public class Korpa {
   /** @pdOid c01ca2ae-dfc8-427b-9cc2-8add3e1271f7 */
   private int idNeulog;
   
   /** @pdRoleInfo migr=no name=Stavka assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public ArrayList<Stavka> stavka;
   
   public Korpa() {}   
   
   public Korpa(int idNeulog, ArrayList<Stavka> stavka)
   {
	super();
	this.idNeulog = idNeulog;
	this.stavka = stavka;
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
         addStavka((Stavka)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavka */
   public void addStavka(Stavka newStavka) {
      if (newStavka == null)
         return;
      if (this.stavka == null)
         this.stavka = new ArrayList<Stavka>();
      if (!this.stavka.contains(newStavka))
         this.stavka.add(newStavka);
   }
   
   /** @pdGenerated default remove
     * @param oldStavka */
   public void removeStavka(Stavka oldStavka) {
      if (oldStavka == null)
         return;
      if (this.stavka != null)
         if (this.stavka.contains(oldStavka))
            this.stavka.remove(oldStavka);
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

   
}