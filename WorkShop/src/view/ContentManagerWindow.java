package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import classes.Porudzbina;
import enums.TipKorisnika;
import model.Aplikacija;
import states.Odbijena;
import states.Otpremljena;
import states.Prihvacena;
import states.StanjePorudzbine;
import states.ZaOtpremu;

public class ContentManagerWindow extends WindowTemplate {

	private static final long serialVersionUID = 1L;

	int i;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<String> sifre = new ArrayList<String>();
	
	Aplikacija appli;

	public ContentManagerWindow(Aplikacija app) {
		super(app);
		appli = app;
		int height = 200;
		int width = 100;
		if (app.getAktivniKorisnik() == TipKorisnika.menadzer) {
			for (Porudzbina por : app.porudzbine) {
				JButton button = new JButton("Sledece stanje");
				button.setBounds(width + 600, height + 80, 200, 30);
				JLabel jl = new JLabel("Sifra porudzbine: " + Integer.toString(por.getBrojPor()));
				sifre.add(Integer.toString(por.getBrojPor()));
				JLabel jl2 = new JLabel("Stanje porudzbine: " + por.stanje.toString());
				jl.setBounds(width, height, 200, 200);
				jl2.setBounds(width + 300, height, 200, 200);
				super.background.add(jl);
				super.background.add(jl2);
				JSeparator jsep = new JSeparator();
				jsep.setBounds(5, height + 120, Toolkit.getDefaultToolkit().getScreenSize().width, 1);
				super.background.add(jsep);
				super.background.add(button);
				buttons.add(button);
				height += 50;

			}

			for (i = 0; i < buttons.size(); i++) {
				buttons.get(i).addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						int pos = buttons.indexOf(arg0.getSource());
						Porudzbina por = app.getPorudzbina(pos);
						if (por.getStanje().getClass() == ZaOtpremu.class) {
							por.addListeners(ContentManagerWindow.this);
							por.otpremi();
							return;
						}
						if(por.getStanje().getClass() == Otpremljena.class) {
							por.addListeners(ContentManagerWindow.this);
							Random rand = new Random();
							if (rand.nextInt(5)%2 == 0) {
								por.prihvati();
							}
							else {
								por.odbij();
							}
						}
					}

				});
			}

		} else {
			for (Porudzbina por : app.getFromJmbg(app.getId()).getPorudzbina()) {
				JLabel jl = new JLabel("Sifra porudzbine: " + Integer.toString(por.getBrojPor()));
				sifre.add(Integer.toString(por.getBrojPor()));
				JLabel jl2 = new JLabel("Stanje porudzbine: " + por.stanje.toString());
				jl.setBounds(width, height, 200, 200);
				jl2.setBounds(width + 300, height, 200, 200);
				super.background.add(jl);
				super.background.add(jl2);
				JSeparator jsep = new JSeparator();
				jsep.setBounds(5, height + 120, Toolkit.getDefaultToolkit().getScreenSize().width, 1);
				super.background.add(jsep);
				height += 50;

			}


		}

	}
	
	@Override
	public void osvezi() {
		dispose();
		new ContentManagerWindow(appli);
	}

}
