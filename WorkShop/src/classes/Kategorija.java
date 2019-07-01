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

/** @param nazivKategorije
    * @pdOid d3e1f464-25a5-4298-9cfc-09da64a1bbb7 */
   public void dodajKategoriju(String nazivKategorije) 
   {
      // TODO: implement
   }
   
   /** @param naziv 
    * @param noviNaziv
    * @pdOid 96103085-6e0e-42b1-a74b-8d66a2a3d3f0 */
   public void izmeniKategoriju(String naziv, String noviNaziv) 
   {
      // TODO: implement
   }
   
   /** @param naziv
    * @pdOid 9434b0ea-5095-41d4-b34c-4dee3f4af921 */
   public void obrisiKategoriju(String naziv) {
      // TODO: implement
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
         addKategorijaB((Kategorija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKategorija */
   public void addKategorijaB(Kategorija newKategorija) 
   {
      if (newKategorija == null)
         return;
      if (this.kategorijaB == null)
         this.kategorijaB = new ArrayList<Kategorija>();
      if (!this.kategorijaB.contains(newKategorija))
         this.kategorijaB.add(newKategorija);
   }
   
   /** @pdGenerated default remove
     * @param oldKategorija */
   public void removeKategorijaB(Kategorija oldKategorija) 
   {
      if (oldKategorija == null)
         return;
      if (this.kategorijaB != null)
         if (this.kategorijaB.contains(oldKategorija))
            this.kategorijaB.remove(oldKategorija);
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