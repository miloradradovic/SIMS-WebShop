package states;

import javax.swing.JOptionPane;

import classes.Porudzbina;

public class ZaOtpremu extends StanjePorudzbine {

	public ZaOtpremu(Porudzbina aKontekst) {
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
	public void plati() {
		// TODO Auto-generated method stub

	}

	@Override
	public void otpremi() {
		JOptionPane.showMessageDialog(null, "Otpremljeno!");

	}

	@Override
	public String toString() {
		return "Za Otpremu";
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
