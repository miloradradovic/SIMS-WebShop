package classes;

/***********************************************************************
 * Module:  Kategorija.java
 * Author:  Vukasin
 * Purpose: Defines the Class Kategorija
 ***********************************************************************/

import java.util.*;

/** @pdOid 03f6ade7-46ae-4b3c-ba76-40c4c9f3c1bf */
public class Kategorija {
   /** @pdOid 37775a32-3572-4783-b105-d233f8a68b6b */
   private String naziv;
   
   /** @pdRoleInfo migr=no name=Kategorija assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public ArrayList<Kategorija> kategorijaB;
   
   public Kategorija() {}
   
   public Kategorija(String naziv, ArrayList<Kategorija> kategorijaB) 
   {
	super();
	this.naziv = naziv;
	this.kategorijaB = kategorijaB;
   }

   /** @pdGenerated default getter */
   public ArrayList<Kategorija> getKategorijaB() {
      if (kategorijaB == null)
         kategorijaB = new ArrayList<Kategorija>();
      return kategorijaB;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Kategorija> getIteratorKategorijaB()
   {
      if (kategorijaB == null)
         kategorijaB = new ArrayList<Kategorija>();
      return kategorijaB.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKategorijaB */
   public void setKategorijaB(ArrayList<Kategorija> newKategorijaB) 
   {
      removeAllKategorijaB();
      for (Iterator<Kategorija> iter = newKategorijaB.iterator(); iter.hasNext();)
         dodajKategoriju((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public Boolean dodajKategoriju(Kategorija newKategorija) 
   {
      if (newKategorija == null)
         return false;
      if (this.kategorijaB == null)
         this.kategorijaB = new ArrayList<Kategorija>();
      if (!this.kategorijaB.contains(newKategorija))
      {
    	  this.kategorijaB.add(newKategorija);
    	  return true;
      }        
      return false;
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public Boolean obrisiKategoriju(Kategorija oldKategorija) 
   {
      if (oldKategorija == null)
         return false;
      if (this.kategorijaB != null)
         if (this.kategorijaB.contains(oldKategorija))
         {
        	 this.kategorijaB.remove(oldKategorija);
        	 return true;
         }
      return false;
            
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKategorijaB() 
   {
      if (kategorijaB != null)
         kategorijaB.clear();
   }

	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv) 
	{
		this.naziv = naziv;
	}
	   
   

}