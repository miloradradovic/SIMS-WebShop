package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import classes.Kategorija;
import model.Aplikacija;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel globus_label;
	JScrollPane js;
	JTextField search_field;
	JLabel login_label;
	JLabel register_label;
	JLabel shops_label;
	JLabel cart_label;
	JLabel slavina_pic;
	JLabel furniture_pic;
	JLabel desk_pic;
	// labele - kategorije
	ArrayList<JLabel> kategorijeLabele = new ArrayList<JLabel>();

	// Aplikacija je jedini parametar kao model iz kog se vade podaci
	// Ne stoji u parametru dok se ne napravi konstruktor klase Aplikacija
	// Aplikacija treba da skladisti u svoje liste sve podatke iz txt fileove
	// i to treba da se desi u main-u, a zatim se prosledjuje ta aplikacija u kojoj
	// su podaci
	// mainwindowu koji preko te aplikacije radi sa podacima i prikazuje ih po
	// potrebi

	public MainWindow(Aplikacija app) {

		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("TinyHouse");

		// podesavanja pozadine
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image3 = new ImageIcon("white_background.jpg");
		Image image_tmp3 = getScaledImage(image3.getImage(), screenWidth, screenHeight + 400);
		image3.setImage(image_tmp3);

		JLabel background = new JLabel(image3);
		// *----------------------------------------*//

		// ucitavanje svih kategorija u labele
		// dodavanje u background radi prikaza
		// TODO: mozda bi bilo pametno ograditi se na maksimalan broj prvih kategorija
		int x_offset = 220;
		int y_offset = 70;
		for (Kategorija kat : app.kategorije) {
			JLabel label = new JLabel(kat.getNaziv());
			label.setFont(new Font("Serif", Font.PLAIN, 20));
			label.setBounds(x_offset, y_offset, 80, 40);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label.setHorizontalAlignment(JLabel.CENTER);
			kategorijeLabele.add(label);
			background.add(label);
			x_offset = x_offset + 100;
		}
		// *-----------------------------------------*//

		// inicijalizacija naslova
		globus_label = new JLabel("TINY  HOUSE");
		globus_label.setFont(new Font("Serif", Font.BOLD, 40));
		globus_label.setBounds(screenWidth / 2 - 100, 20, 280, 30);
		globus_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/*----------------------*/

		// inicijalizacija slike da bude na sredini
		ImageIcon image = new ImageIcon("sale1.png");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth - 40, 600);
		image.setImage(image_tmp);

		JLabel sale_pic = new JLabel(image);
		sale_pic.setBounds(20, 120, screenWidth - 40, 600);
		sale_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *-----------------------------------------*//

		// dodavanje text_fielda za search
		search_field = new JTextField("Search");
		search_field.setBounds(screenWidth / 2 - 250, 70, 500, 50);
		search_field.setFont(new Font("Serif", Font.PLAIN, 20));
		search_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		// *------------------------------------------*//

		// dodavanje register_labela za registraciju
		register_label = new JLabel("Register");
		register_label.setBounds(screenWidth - 285, 10, 60, 30);
		register_label.setFont(new Font("Serif", Font.PLAIN, 17));
		register_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje register_labela za registraciju
		login_label = new JLabel("Log in");
		login_label.setBounds(screenWidth - 215, 10, 60, 30);
		login_label.setFont(new Font("Serif", Font.PLAIN, 17));
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// izmedju register i login
		JLabel tmp_slash = new JLabel("\\");
		tmp_slash.setBounds(screenWidth - 225, 10, 5, 30);
		tmp_slash.setFont(new Font("Serif", Font.PLAIN, 17));
		// *------------------------------------------*//

		// dodavanje basket labela za korpu
		cart_label = new JLabel("Cart");
		cart_label.setBounds(screenWidth - 130, 10, 40, 30);
		cart_label.setFont(new Font("Serif", Font.PLAIN, 17));
		cart_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje slike korpice pored korpe
		ImageIcon image1 = new ImageIcon("korpica.png");
		Image image_tmp1 = getScaledImage(image1.getImage(), 20, 20);
		image1.setImage(image_tmp1);

		JLabel cart_pic = new JLabel(image1);
		cart_pic.setBounds(screenWidth - 95, 10, 30, 30);
		cart_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje basket labela za korpu
		shops_label = new JLabel("Shops");
		shops_label.setBounds(30, 10, 40, 30);
		shops_label.setFont(new Font("Serif", Font.PLAIN, 17));
		shops_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje slike korpice pored korpe
		ImageIcon image2 = new ImageIcon("location_icon.png");
		Image image_tmp2 = getScaledImage(image2.getImage(), 20, 20);
		image2.setImage(image_tmp2);

		JLabel location_pic = new JLabel(image2);
		location_pic.setBounds(72, 15, 20, 20);
		location_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje slike korpice pored korpe
		ImageIcon image4 = new ImageIcon("slavina.jpg");
		Image image_tmp4 = getScaledImage(image4.getImage(), 300, 500);
		image4.setImage(image_tmp4);

		slavina_pic = new JLabel(image4);
		slavina_pic.setBounds(20, 730, 300, 500);
		slavina_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje slike kreveta ispod SALE
		ImageIcon image5 = new ImageIcon("furniture.jpg");
		Image image_tmp5 = getScaledImage(image5.getImage(), 700, 475);
		image5.setImage(image_tmp5);

		furniture_pic = new JLabel(image5);
		furniture_pic.setBounds(340, 743, 700, 475);
		furniture_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje slike stolova ispod sale
		ImageIcon image6 = new ImageIcon("desk.png");
		Image image_tmp6 = getScaledImage(image6.getImage(), 450, 475);
		image6.setImage(image_tmp6);

		desk_pic = new JLabel(image6);
		desk_pic.setBounds(1060, 743, 450, 475);
		desk_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje stvari u background
		sale_pic.add(search_field);
		background.add(desk_pic);
		background.add(furniture_pic);
		background.add(slavina_pic);
		background.add(location_pic);
		background.add(shops_label);
		background.add(cart_pic);
		background.add(cart_label);
		background.add(tmp_slash);
		background.add(sale_pic);
		background.add(register_label);
		background.add(login_label);
		background.setLayout(null);
		background.add(globus_label);

		// postavljanje scroll panea i stavljanje backgrounda u njega
		JScrollPane js = new JScrollPane(background, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setContentPane(js);
		// *----------------------------------------*//

		this.setVisible(true);

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
}
