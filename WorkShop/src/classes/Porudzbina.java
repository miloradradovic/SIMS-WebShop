package classes;
/***********************************************************************
 * Module:  Porudzbina.java
 * Author:  Vukasin
 * Purpose: Defines the Class Porudzbina
 ***********************************************************************/

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import states.Odbijena;
import states.Otpremljena;
import states.Prihvacena;
import states.StanjePorudzbine;
import states.ZaOtpremu;
import states.ZaPlacanje;
import view.WindowTemplate;

/** @pdOid fbfb16eb-b5ae-4029-9acf-de26d1336b66 */
public class Porudzbina {
	/** @pdOid 8909065e-3c32-4349-b10d-b9566dfd8915 */
	private int brojPor;
	/** @pdOid 1828cb87-4412-4f48-96d0-a65a887b816b */
	private int ukupnaCena;
	/** @pdOid abe8a61c-077d-4b52-9946-7753f4f8b415 */
	private Date datumPorucivanja;

	private Adresa adresa;

	public HashMap<String, Integer> Cene;

	ArrayList<WindowTemplate> listeners = new ArrayList<WindowTemplate>();

	/** @pdRoleInfo migr=no name=Stanje assc=association24 mult=1..1 */
	public StanjePorudzbine stanje;

	public Porudzbina() {
		this.stanje = new ZaPlacanje(this);
	}

	public Porudzbina(int brojPor, int ukupnaCena, Date datumPorucivanja, HashMap<String, Integer> cene) {
		super();
		this.brojPor = brojPor;
		this.ukupnaCena = ukupnaCena;
		this.datumPorucivanja = datumPorucivanja;
		Cene = cene;
		this.stanje = new ZaPlacanje(this);
		this.adresa = null;
	}

	public int getBrojPor() {
		return brojPor;
	}

	public void setBrojPor(int brojPor) {
		this.brojPor = brojPor;
	}

	public int getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(int ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Date getDatumPorucivanja() {
		return datumPorucivanja;
	}

	public void setDatumPorucivanja(Date datumPorucivanja) {
		this.datumPorucivanja = datumPorucivanja;
	}

	public StanjePorudzbine getStanje() {
		return stanje;
	}
	
	public Adresa getAdresa() {
		return adresa;
	}

	public void setStanje(StanjePorudzbine stanje) {
		this.stanje = stanje;
	}

	public HashMap<String, Integer> getCene() {
		return Cene;
	}

	public void setCene(HashMap<String, Integer> cene) {
		Cene = cene;
	}

	public void setAdresa(Adresa adr) {
		this.adresa = adr;
	}

	public void izmeniStanje(StanjePorudzbine stanje) {
		this.setStanje(stanje);
	}

	public void plati() {
		stanje.plati();
		izmeniStanje(new ZaOtpremu(this));
	}

	public void otpremi() {
		stanje.otpremi();
		izmeniStanje(new Otpremljena(this));
		notifyListeners();
	}

	public void addListeners(WindowTemplate wt) {
		listeners.add(wt);
	}

	public void notifyListeners() {
		for (WindowTemplate wt : listeners) {
			if (wt.isVisible()) {
				wt.osvezi();
			}
		}
	}

	public void prihvati() {
		stanje.prihvati();
		Prihvacena stanje = new Prihvacena(this);
		izmeniStanje(stanje);
		stanje.entry();
		notifyListeners();
	}

	public void odbij() {
		stanje.odbij();
		Odbijena stanje = new Odbijena(this);
		izmeniStanje(stanje);
		stanje.entry();
		notifyListeners();
	}
}