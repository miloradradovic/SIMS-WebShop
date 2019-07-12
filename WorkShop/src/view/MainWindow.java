package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Kategorija;
import enums.TipKorisnika;
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
	JLabel sale_pic;
	JPanel panel;
	JLabel orders;
	JLabel logout_label, profile_label;
	ArrayList<JLabel> subcategories = new ArrayList<JLabel>();
	ArrayList<JLabel> subcategories2 = new ArrayList<JLabel>();
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
		this.setTitle("TinyHouse");
		this.setMinimumSize(new Dimension(500, 500));

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

		// dodavanje profile_labela za registraciju
		profile_label = new JLabel("Profile");
		profile_label.setBounds(screenWidth - 215, 10, 60, 30);
		profile_label.setFont(new Font("Serif", Font.PLAIN, 17));
		profile_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//
		
		// inicijalizacija slike da bude na sredini
		ImageIcon image = new ImageIcon("sale1.png");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth - 40, 600);
		image.setImage(image_tmp);

		sale_pic = new JLabel(image);
		sale_pic.setBounds(20, 110, screenWidth - 40, 600);
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

		// dodavanje logout_labela za registraciju
		logout_label = new JLabel("Logout");
		logout_label.setBounds(screenWidth - 285, 10, 60, 30);
		logout_label.setFont(new Font("Serif", Font.PLAIN, 17));
		logout_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje login_labela za registraciju
		login_label = new JLabel("Log in");
		login_label.setBounds(screenWidth - 215, 10, 60, 30);
		login_label.setFont(new Font("Serif", Font.PLAIN, 17));
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje profile_labela za registraciju
		profile_label = new JLabel("Profile");
		profile_label.setBounds(screenWidth - 215, 10, 60, 30);
		profile_label.setFont(new Font("Serif", Font.PLAIN, 17));
		profile_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		shops_label.setBounds(30, 10, 50, 30);
		shops_label.setFont(new Font("Serif", Font.PLAIN, 17));
		shops_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// *------------------------------------------*//

		// dodavanje labele za porudzbine
		orders = new JLabel("Orders");
		orders.setBounds(120, 10, 80, 30);
		orders.setFont(new Font("Serif", Font.PLAIN, 17));
		orders.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

		/*
		 * JPanel panel1 = new JPanel(); panel1.setBounds(120,120,200,200); JLabel
		 * testlabel = new JLabel("Put some text in here");
		 * testlabel.setBounds(150,150,100,20); panel1.add(testlabel);
		 * panel1.setBackground(Color.gray);
		 */

		// dodavanje stvari u background
		sale_pic.add(search_field);
		background.add(orders);
		background.add(profile_label);
		background.add(logout_label);
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
		// sale_pic.add(panel1);

		// postavljanje scroll panea i stavljanje backgrounda u njega
		JScrollPane js = new JScrollPane(background, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setContentPane(js);
		// *----------------------------------------*//

		this.setVisible(true);

		addActionListeners(app);

		checkUser(app);

	}

	public void checkUser(Aplikacija app) {
		if (!(app.getAktivniKorisnik() == TipKorisnika.neulogovanKorisnik)) {
			login_label.hide();
			register_label.hide();

		} else {
			orders.hide();
			profile_label.hide();
			logout_label.hide();
		}
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

	void addActionListeners(Aplikacija app) {

		MouseListener logout_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				app.setAktivniKorisnik(TipKorisnika.neulogovanKorisnik);
				dispose();
				new MainWindow(app);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		logout_label.addMouseListener(logout_clicked);

		MouseListener orders_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new ContentManagerWindow(app);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		orders.addMouseListener(orders_clicked);

		Action search_field_enter = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SearchArticleWindow(app, search_field.getText());
			}
		};

		search_field.addActionListener(search_field_enter);

		// listener za mouse drag preko kategorije - labele iz atributa
		MouseListener category_press = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				dispose();
				new SearchWindow(app, lbl.getText());

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		for (JLabel lbl : kategorijeLabele) {
			lbl.addMouseListener(category_press);
		}

		MouseListener panel_moved = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				java.awt.Point p = new java.awt.Point(e.getLocationOnScreen());
				SwingUtilities.convertPointFromScreen(p, e.getComponent());
				if (e.getComponent().contains(p)) {
					return;
				}
				sale_pic.remove(panel);
				search_field.show();
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		// listener za omogucavanje otvaranja panela pri prolasku misa
		MouseListener mouse_moved = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				search_field.hide();
				// ArrayList<JLabel> subcategoriesLabels = new ArrayList<JLabel>();
				panel = new JPanel();
				panel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, 450);
				panel.setCursor(Cursor.getDefaultCursor());
				panel.addMouseListener(panel_moved);

				for (Kategorija kat : app.kategorije) {
					if (kat.getNaziv().equalsIgnoreCase(lbl.getText())) {
						int width_movement = 70;
						for (Kategorija kat_ : kat.kategorijaB) {
							int height_movement = 20;
							JLabel subcategoryLabel = new JLabel(kat_.getNaziv());
							subcategoryLabel.setBounds(width_movement, height_movement, 150, 35);
							subcategoryLabel.setFont(new Font("Serif", Font.PLAIN, 20));
							subcategoryLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							subcategories.add(subcategoryLabel);
							for (Kategorija kat__ : kat_.kategorijaB) {
								height_movement += 40;
								JLabel subcategoryLabel2 = new JLabel(kat__.getNaziv());
								subcategoryLabel2.setBounds(width_movement, height_movement, 150, 25);
								subcategoryLabel2.setFont(new Font("Serif", Font.PLAIN, 15));
								subcategoryLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								subcategories2.add(subcategoryLabel2);
								panel.add(subcategoryLabel2);
							}
							panel.add(subcategoryLabel);
							width_movement += 200;
						}
					}
				}

				for (JLabel lbl_ : subcategories) {
					lbl_.addMouseListener(category_press);
				}

				for (JLabel lbl_ : subcategories2) {
					lbl_.addMouseListener(category_press);
				}

				sale_pic.add(panel);
				repaint();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!(e.getX() > -2 && e.getX() < 81 && e.getY() >= 35 && e.getY() < 45)) {
					sale_pic.remove(panel);
					search_field.show();
					repaint();
				}

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		MouseListener login_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				LoginWindow loginWin = new LoginWindow(app);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		MouseListener register_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				RegisterWindow regWin = new RegisterWindow(app);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		MouseListener tiny_house_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new MainWindow(app);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		globus_label.addMouseListener(tiny_house_clicked);

		register_label.addMouseListener(register_clicked);

		login_label.addMouseListener(login_clicked);

		for (JLabel lbl : kategorijeLabele) {
			lbl.addMouseListener(mouse_moved);
		}
		
		MouseListener cart_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new CartView(app);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};
		cart_label.addMouseListener(cart_clicked);

	}
	// *--------------------------------------------------------------*//
}
