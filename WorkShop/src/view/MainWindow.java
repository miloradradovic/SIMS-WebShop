package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel globus_label;

	//Aplikacija je jedini parametar kao model iz kog se vade podaci
	//Ne stoji u parametru dok se ne napravi konstruktor klase Aplikacija
	//Aplikacija treba da skladisti u svoje liste sve podatke iz txt fileove
	//i to treba da se desi u main-u, a zatim se prosledjuje ta aplikacija u kojoj su podaci
	//mainwindowu koji preko te aplikacije radi sa podacima i prikazuje ih po potrebi

	public MainWindow() {
		
		setTitle("Globus");
		
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JLabel background = new JLabel(new ImageIcon("background1.jpg"));
		
		globus_label = new JLabel("G L O B U S");
		globus_label.setFont(new Font("Serif", Font.BOLD, 40));
		globus_label.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 100,20,300,30);
		
		add(background);
		
		background.setLayout(null);
		background.add(globus_label);
		
		this.setVisible(true);
		
	}

}
