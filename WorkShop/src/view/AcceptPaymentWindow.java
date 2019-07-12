package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Adresa;
import classes.Porudzbina;
import enums.TipKorisnika;
import model.Aplikacija;

public class AcceptPaymentWindow extends JFrame {

	JComboBox gradovi;
	JTextField ulica;
	JTextField broj;
	JComboBox nacin_placanja;
	JTextField broj_kartice;
	JTextField serialNum;
	String[] gradovi_string = new String[20];
	JButton next;
	JButton cancel;
	Adresa adr;
	JRadioButton moja_adresa;
	
	public AcceptPaymentWindow(Aplikacija app,Porudzbina por) {
		adr = null;
		JLabel checkout_payment = new JLabel("Payment checkout");
		checkout_payment.setFont(new Font("Serif", Font.PLAIN, 45));
		checkout_payment.setBounds(220,20,350,50);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("TinyHouse");
		// this.setSize(screenWidth/4,screenHeight/4);
		this.setBounds(screenWidth / 4, screenHeight / 4, screenWidth / 2, screenHeight / 2);
		for (int i = 0; i < app.gradovi.size(); i++) {
			gradovi_string[i] = app.gradovi.get(i).getMesto();
		}
		gradovi = new JComboBox(gradovi_string);
		gradovi.setBounds(50, 200, 200, 30);
		gradovi.setSelectedIndex(0);
		this.setLayout(null);
		this.add(gradovi);
		this.add(checkout_payment);
		/*gradovi.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println(gradovi.getSelectedItem().getClass());
		    }
		});*/
		
		ulica = new JTextField("Ulica");
		ulica.setBounds(50, 100, 200, 30);
		this.add(ulica);
		broj = new JTextField("Broj");
		broj.setBounds(50, 150, 200, 30);
		this.add(broj);
		
		String nacini[] = new String[4];
		nacini[0] = "Paypall";
		nacini[1] = "Visa";
		nacini[2] = "MasterCard";
		nacin_placanja = new JComboBox(nacini);
		nacin_placanja.setBounds(450,200,200,30);
		this.add(nacin_placanja);
		
		broj_kartice = new JTextField("Broj kartice");
		broj_kartice.setBounds(450,150,200,30);
		
		serialNum = new JTextField("Serijski broj kartice");
		serialNum.setBounds(450,100,200,30);
		
		this.add(broj_kartice);
		this.add(serialNum);
		
		next = new JButton("Next");
		next.setBounds(480,300,150,30);
		this.add(next);
		
		moja_adresa = new JRadioButton("Koristi vec postojecu adresu");
		moja_adresa.setBounds(250,250,150,30);
		if(app.getAktivniKorisnik() == TipKorisnika.ulogovanKorisnik) {
			this.add(moja_adresa);
		}
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (moja_adresa.isSelected()) {
					adr = app.nadjiKorisnika(app.getId()).getAdresa();
					por.setAdresa(adr);
					//ako je ovde sigurno je ulogovan
					app.getFromJmbg(app.getId()).addPorudzbina(por);
					app.porudzbine.add(por);
					por.plati();
					dispose();
					new MainWindow(app);
				}
				else {
					adr = new Adresa(ulica.getText(),Integer.parseInt(broj.getText()),app.nadjiImeGrada(gradovi.getSelectedItem().toString()));
					if (app.getAktivniKorisnik() == TipKorisnika.ulogovanKorisnik) {
						por.setAdresa(adr);
						//ako je ovde sigurno je ulogovan
						app.getFromJmbg(app.getId()).addPorudzbina(por);
						app.porudzbine.add(por);
						por.plati();
						dispose();
						new MainWindow(app);
					}
					else {
						por.setAdresa(adr);
						//ako je ovde sigurno je ulogovan
						app.porudzbine.add(por);
						por.plati();
						dispose();
						new MainWindow(app);

					}
				}
			}
			
		});
		
		cancel = new JButton("Cancel");
		cancel.setBounds(80,300,150,30);
		this.add(cancel);
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
	
		this.setVisible(true);
	}
	
	

}
