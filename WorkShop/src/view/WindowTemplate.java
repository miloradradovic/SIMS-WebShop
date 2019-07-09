package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Kategorija;
import model.Aplikacija;

public abstract class WindowTemplate extends JFrame {

	JLabel globus_label;
	JScrollPane js;
	JTextField search_field;
	JLabel login_label;
	JLabel register_label;
	JLabel shops_label;
	JLabel cart_label;
	JPanel panel;
	ArrayList<JLabel> subcategories = new ArrayList<JLabel>();
	ArrayList<JLabel> subcategories2 = new ArrayList<JLabel>();
	// labele - kategorije
	ArrayList<JLabel> kategorijeLabele = new ArrayList<JLabel>();
	JLabel background;

	// Aplikacija je jedini parametar kao model iz kog se vade podaci
	// Ne stoji u parametru dok se ne napravi konstruktor klase Aplikacija
	// Aplikacija treba da skladisti u svoje liste sve podatke iz txt fileove
	// i to treba da se desi u main-u, a zatim se prosledjuje ta aplikacija u kojoj
	// su podaci
	// mainwindowu koji preko te aplikacije radi sa podacima i prikazuje ih po
	// potrebi

	public WindowTemplate(Aplikacija app) {

		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("TinyHouse");
		this.setMinimumSize(new Dimension(500, 500));

		// podesavanja pozadine
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image3 = new ImageIcon("white_background.jpg");
		Image image_tmp3 = getScaledImage(image3.getImage(), screenWidth, screenHeight + 400);
		image3.setImage(image_tmp3);

		background = new JLabel(image3);
		// *----------------------------------------*//
		JSeparator jsep = new JSeparator();
		jsep.setBounds(5, 110 , screenWidth , 100);
		
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

	

		// dodavanje stvari u background
		background.add(jsep);
		background.add(location_pic);
		background.add(shops_label);
		background.add(cart_pic);
		background.add(cart_label);
		background.add(tmp_slash);
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
		// listener za mouse drag preko kategorije - labele iz atributa
		MouseListener category_press = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				JOptionPane.showMessageDialog(null, "treba proslediti argument trazenja: " + lbl.getText());

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
				background.remove(panel);
				attributesAppear();
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
				attributesDissapear();
				// ArrayList<JLabel> subcategoriesLabels = new ArrayList<JLabel>();
				panel = new JPanel();
				panel.setBounds(0, 120, Toolkit.getDefaultToolkit().getScreenSize().width, 450);
				panel.setCursor(Cursor.getDefaultCursor());
				panel.addMouseListener(panel_moved);
				panel.setLayout(null);

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

				background.add(panel);
				repaint();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!((e.getX() > -2 && e.getX() < 81) && (e.getY() >= 35 && e.getY() < 45))) {
					background.remove(panel);
					attributesAppear();
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

	}
	// *--------------------------------------------------------------*//
	
	void attributesDissapear() {
		
	}
	
	void attributesAppear() {

	}
}
