package states;

import javax.swing.JOptionPane;

import classes.Porudzbina;

public class Odbijena extends StanjePorudzbine {

	public Odbijena(Porudzbina aKontekst) {
		super(aKontekst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entry() {
		JOptionPane.showMessageDialog(null, "Odbijena!");


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
		return "Odbijena []";
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
