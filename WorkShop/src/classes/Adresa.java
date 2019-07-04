package classes;

/***********************************************************************
 * Module:  Adresa.java
 * Author:  Vukasin
 * Purpose: Defines the Class Adresa
 ***********************************************************************/

/** @pdOid d2b77b07-d17b-4423-a1e7-2a3ea4a6ac9d */
public class Adresa {
   /** @pdOid c45bdfc0-cc95-4cad-a062-b40a1cc43240 */
   private String ulica;
   /** @pdOid a79a8a56-5d6f-4502-8da9-e735a48e3a38 */
   private int broj;
   
   /** @pdRoleInfo migr=no name=Grad assc=association19 mult=1..1 */
   public Grad grad;
   
   public Adresa() {}

	public Adresa(String ulica, int broj, Grad grad) 
	{
	super();
	this.ulica = ulica;
	this.broj = broj;
	this.grad = grad;
	}

   
   
	public String getUlica() 
	{
		return ulica;
	}
	
	public void setUlica(String ulica) 
	{
		this.ulica = ulica;
	}
	
	public int getBroj() 
	{
		return broj;
	}
	
	public void setBroj(int broj) 
	{
		this.broj = broj;
	}
	
	public Grad getGrad()
	{
		return grad;
	}
	
	public void setGrad(Grad grad) 
	{
		this.grad = grad;
	}
   
   

}