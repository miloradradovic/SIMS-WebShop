package view;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import classes.Grad;
import model.Aplikacija;

public class AcceptPaymentWindow extends JFrame {

	JComboBox gradovi;
	JTextField ulica;
	JTextField broj;
	JComboBox nacin_placanja;
	JTextField broj_kartice;
	JTextField pin;
	String[] gradovi_string = new String[20];

	public AcceptPaymentWindow(Aplikacija app) {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("TinyHouse");
		// this.setSize(screenWidth/4,screenHeight/4);
		this.setBounds(screenWidth / 4, screenHeight / 4, screenWidth / 2, screenHeight / 2);
		app.gradovi.add(new Grad("Novi Sad",23000));
		for (int i = 0; i < app.gradovi.size(); i++) {
			gradovi_string[i] = app.gradovi.get(i).getMesto();
		}
		gradovi = new JComboBox(gradovi_string);
		gradovi.setBounds(100, 100, 100, 20);
		gradovi.setSelectedIndex(0);
		this.setLayout(null);
		this.add(gradovi);
		
		this.setVisible(true);
	}

}
