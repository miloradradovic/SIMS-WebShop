package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Kategorija;
import classes.Korisnik;
import enums.TipKorisnika;
import model.Aplikacija;

public class LoginWindow extends WindowTemplate {

	private static final long serialVersionUID = 2L;
	JLabel login_label;
	JLabel username_label;
	JLabel password_label;
	JTextField username_field;
	JPasswordField password_field;
	JButton next_button;
	JButton cancel_button;

	@SuppressWarnings("unused")
	public LoginWindow(Aplikacija app) {
		super(app);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("Login");

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image = new ImageIcon("white_background.jpg");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth, screenHeight);
		image.setImage(image_tmp);

		JLabel background = super.background;
		super.background.setIcon(image);
		
		login_label = new JLabel("LOGIN");
		login_label.setFont(new Font("Serif", Font.ITALIC, 30));
		login_label.setBounds(screenWidth / 2 - 50, 200, 280, 40);
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		username_label = new JLabel("Username: ");
		username_label.setBounds(screenWidth / 2 - 350, 320, 150, 30);
		username_label.setFont(new Font("Serif", Font.PLAIN, 25));
		username_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		password_label = new JLabel("Password: ");
		password_label.setBounds(screenWidth / 2 - 350, 400, 150, 30);
		password_label.setFont(new Font("Serif", Font.PLAIN, 25));
		password_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		username_field = new JTextField();
		username_field.setBounds(screenWidth / 2 - 150, 320, 400, 30);
		username_field.setFont(new Font("Serif", Font.PLAIN, 30));
		username_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		password_field = new JPasswordField();
		password_field.setBounds(screenWidth / 2 - 150, 400, 400, 30);
		password_field.setFont(new Font("Serif", Font.PLAIN, 30));
		password_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		password_field.setEchoChar('*');

		next_button = new JButton("Next");
		next_button.setBounds(screenWidth / 2 + 50, 500, 150, 30);
		next_button.setFont(new Font("Serif", Font.PLAIN, 25));
		next_button.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		next_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String user = username_field.getText();
				@SuppressWarnings("deprecation")
				String pass = password_field.getText();
				Boolean found = false;

				Iterator<Korisnik> it = app.korisnici.iterator();
				while (it.hasNext()) {
					Korisnik kor = it.next();
					if (kor.getKorisnickoIme().equals(user) && kor.getSifra().equals(pass)) {
						found = true;
						break;
					}
				}

				if (found) {
					dispose();
					app.setAktivniKorisnik(TipKorisnika.ulogovanKorisnik);
					MainWindow ww = new MainWindow(app);
				} else {
					JOptionPane.showMessageDialog(null, "Korisnik ne postoji");
				}

			}
		});

		cancel_button = new JButton("Cancel");
		cancel_button.setBounds(screenWidth / 2 - 300, 500, 150, 30);
		cancel_button.setFont(new Font("Serif", Font.PLAIN, 25));
		cancel_button.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				MainWindow ww = new MainWindow(app);
			}
		});

		background.add(username_field);
		background.add(username_label);
		background.add(password_field);
		background.add(password_label);
		background.add(login_label);
		background.add(next_button);
		background.add(cancel_button);

		//this.add(background);
		//this.setVisible(true);

		/*
		 * addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(WindowEvent e) { dispose(); MainWindow ww
		 * = new MainWindow(app); } });
		 */

	}

	// Pronasao sam na internetu ovu zgodnu metodicu za skaliranje slike na
	// odredjenu velicinu
	@SuppressWarnings("unused")
	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	// *--------------------------------------------------------------*//

	@Override
	void attributesDissapear() {
		login_label.hide();
		password_label.hide();
		username_label.hide();
		username_field.hide();
		password_field.hide();
		next_button.hide();
		cancel_button.hide();
	}
	
	@Override
	void attributesAppear() {
		login_label.show();
		password_label.show();
		username_label.show();
		username_field.show();
		password_field.show();
		next_button.show();
		cancel_button.show();
	}
	
}
