package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import classes.Kategorija;
import model.Aplikacija;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel globus_label;
	//labele - kategorije
	ArrayList<JLabel> kategorijeLabele = new ArrayList<JLabel>();

	//Aplikacija je jedini parametar kao model iz kog se vade podaci
	//Ne stoji u parametru dok se ne napravi konstruktor klase Aplikacija
	//Aplikacija treba da skladisti u svoje liste sve podatke iz txt fileove
	//i to treba da se desi u main-u, a zatim se prosledjuje ta aplikacija u kojoj su podaci
	//mainwindowu koji preko te aplikacije radi sa podacima i prikazuje ih po potrebi

	public MainWindow(Aplikacija app) {
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		setTitle("TinyHouse");
		
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel background = new JLabel(new ImageIcon("background1.jpg"));
		
		//ucitavanje svih kategorija u labele
		//dodavanje u background radi prikaza
		//TODO: mozda bi bilo pametno ograditi se na maksimalan broj prvih kategorija
		int x_offset = 220;
		int y_offset = 100;
		for (Kategorija kat: app.kategorije) {
			JLabel label = new JLabel(kat.getNaziv());
			label.setFont(new Font("Serif", Font.BOLD, 20));
			label.setBounds(x_offset,y_offset,60,50);
			kategorijeLabele.add(label);
			background.add(label);
			x_offset = x_offset + 150;
		}

		
		//inicijalizacija naslova
		globus_label = new JLabel("TINY  HOUSE");
		globus_label.setFont(new Font("Serif", Font.BOLD, 40));
		globus_label.setBounds(screenWidth/2 - 100,20,300,30);
		/*----------------------*/
		
		add(background);
		background.setLayout(null);
		background.add(globus_label);

		this.setVisible(true);
		
	}

}
