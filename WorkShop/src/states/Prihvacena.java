package states;

import javax.swing.JOptionPane;

import classes.Porudzbina;

public class Prihvacena extends StanjePorudzbine {

	public Prihvacena(Porudzbina aKontekst) {
		super(aKontekst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entry() {
		JOptionPane.showMessageDialog(null, "Prihvacena!");
		

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plati() {
		// TODO Auto-generated method stub

	}

	@Override
	public void otpremi() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Prihvacena";
	}

	@Override
	public void prihvati() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void odbij() {
		// TODO Auto-generated method stub
		
	}
	

}
