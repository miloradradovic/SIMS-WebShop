package view;

import java.awt.Cursor;
import java.awt.Dimension;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Artikl;
import classes.Kategorija;
import classes.Korisnik;
import classes.Korpa;
import classes.Stavka;
import model.Aplikacija;
import enums.Boja;
import enums.TipKorisnika;

public class ArticleWindow extends JFrame {
	
	private static final long serialVersionUID = 4L;
	JLabel globus_label;
	JLabel globus_label2;
	JPanel panel;
	JScrollPane js;
	JLabel shops_label;
	JLabel login_label;
	JLabel register_label;
	JLabel cart_label;
	ArrayList<JLabel> subcategories = new ArrayList<JLabel>();
	ArrayList<JLabel> subcategories2 = new ArrayList<JLabel>();
	// labele - kategorije
	ArrayList<JLabel> kategorijeLabele = new ArrayList<JLabel>();
	JLabel articlePic, articleName, articleId, articlePrice, articleColor;
	JButton addCart, addWishList;
	JLabel number;
	JLabel naziv;
	JLabel cena;
	JLabel sifra;
	JLabel boja;
	JLabel uzeto;
	JLabel brojUzetih;
	JTextField vrednost;
	JButton plus;
	JButton minus;
	JButton pozoviProdavnice;
	
	
	public ArticleWindow(String articleid, Aplikacija app){
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("Article view");
		this.setMinimumSize(new Dimension(500, 500));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image3 = new ImageIcon("white_background.jpg");
		Image image_tmp3 = getScaledImage(image3.getImage(), screenWidth, screenHeight + 400);
		image3.setImage(image_tmp3);
		
		JLabel background = new JLabel(image3);
		
		//DODAVANJE KATEGORIJA U LABELE
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
		
		//DODAVANJE NASLOVA
		globus_label = new JLabel("TINY  HOUSE");
		globus_label.setFont(new Font("Serif", Font.BOLD, 40));
		globus_label.setBounds(screenWidth / 2 - 100, 20, 280, 30);
		globus_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE NASLOVA2
		globus_label2 = new JLabel("TINY  HOUSE");
		globus_label2.setFont(new Font("Serif", Font.BOLD, 30));
		globus_label2.setBounds(screenWidth-350,200,250,50);
		globus_label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE NAZIVA ARTIKLA
		Artikl trazeni = new Artikl();
		for(Artikl a:app.artikli){
			if(a.getSifra().equals(articleid)){
				trazeni = a;
				naziv = new JLabel("Ime artikla: ");
				naziv.setFont(new Font("Serif",Font.BOLD,20));
				naziv.setBounds(screenWidth/2 + 20, 200, 300, 40);
				
				articleName = new JLabel(a.getNaziv());
				articleName.setFont(new Font("Serif", Font.PLAIN,20));
				articleName.setBounds(screenWidth/2 + 150, 200, 300, 40);
				
				cena = new JLabel("Cena artikla: ");
				cena.setFont(new Font("Serif", Font.BOLD, 20));
				cena.setBounds(screenWidth/2 + 20, 250, 300, 40);
				
				articlePrice  = new JLabel("RSD " + Integer.toString(a.getCena()));
				articlePrice.setFont(new Font("Serif",Font.PLAIN,20));
				articlePrice.setBounds(screenWidth/2+150,250,300,40);
				
				sifra = new JLabel("Sifra artikla: ");
				sifra.setFont(new Font("Serif", Font.ITALIC,15));
				sifra.setBounds(screenWidth/2 + 20, 300, 300, 40);
				
				articleId = new JLabel(a.getSifra());
				articleId.setFont(new Font("Serif", Font.ITALIC, 15));
				articleId.setBounds(screenWidth/2+150, 300, 300, 40);
				
				boja = new JLabel("Boja: ");
				boja.setFont(new Font("Serif", Font.PLAIN, 17));
				boja.setBounds(screenWidth/2 + 20, 350, 300, 40);
				
				articleColor = new JLabel(a.getBoja().toString());
				articleColor.setFont(new Font("Serif",Font.PLAIN,17));
				articleColor.setBounds(screenWidth/2 + 150,350,300,40);
				
				uzeto = new JLabel("Izabrana kolicina: ");
				uzeto.setFont(new Font("Serif", Font.PLAIN,17));
				uzeto.setBounds(screenWidth/2 + 20, 400, 300, 40);
				
				brojUzetih = new JLabel("1");
				brojUzetih.setFont(new Font("Serif", Font.PLAIN,17));
				brojUzetih.setBounds(screenWidth/2 + 150,400,300,40);
				
				minus = new JButton("-");
				minus.setFont(new Font("Serif",Font.BOLD,20));
				minus.setBounds(screenWidth/2 + 20, 450, 100, 40);
				
				vrednost = new JTextField("1");
				vrednost.setFont(new Font("Serif", Font.PLAIN,20));
				vrednost.setBounds(screenWidth/2 + 120, 450, 100, 40);
				vrednost.setHorizontalAlignment(JTextField.CENTER);
				vrednost.setEditable(false);
				
				plus = new JButton("+");
				plus.setFont(new Font("Serif", Font.BOLD, 20));
				plus.setBounds(screenWidth/2 + 200, 450, 100, 40);
				
				addCart = new JButton("Dodaj u korpu");
				addCart.setFont(new Font("Serif", Font.BOLD,20));
				addCart.setBounds(screenWidth/2 + 20, 500, 200,40);
				
				addWishList = new JButton();
				addWishList.setBounds(screenWidth/2 + 220, 500, 100,40);
				ImageIcon image = new ImageIcon("wishlist.png");
				Image image_tmp = getScaledImage(image.getImage(), 60, 30);
				image.setImage(image_tmp);
				addWishList.setIcon(image);
				
				pozoviProdavnice = new JButton("Pregled prodavnica u kojim se moze naci ovaj artikl");
				pozoviProdavnice.setFont(new Font("Serif", Font.BOLD,20));
				pozoviProdavnice.setBounds(screenWidth/2 + 20, 550, 500,40);
				
				articlePic = new JLabel();
				articlePic.setBounds(screenWidth/2 - 500, 120, 500, 600);
				ImageIcon image2 = new ImageIcon(a.getSlika());
				Image image_tmp2 = getScaledImage(image2.getImage(),400,500);
				image2.setImage(image_tmp2);
				articlePic.setIcon(image2);
				
				break;
			}
		}
		
		
		//DODAVANJE LABELE ZA REGISTRACIJU
		register_label = new JLabel("Register");
		register_label.setBounds(screenWidth - 285, 10, 60, 30);
		register_label.setFont(new Font("Serif", Font.PLAIN, 17));
		register_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE LOGIN LABELE
		login_label = new JLabel("Log in");
		login_label.setBounds(screenWidth - 215, 10, 60, 30);
		login_label.setFont(new Font("Serif", Font.PLAIN, 17));
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE /
		JLabel tmp_slash = new JLabel("\\");
		tmp_slash.setBounds(screenWidth - 225, 10, 5, 30);
		tmp_slash.setFont(new Font("Serif", Font.PLAIN, 17));
		
		//DODAVANJE LABELE ZA KORPU i NJENE SLIKE
		cart_label = new JLabel("Cart");
		cart_label.setBounds(screenWidth - 130, 10, 40, 30);
		cart_label.setFont(new Font("Serif", Font.PLAIN, 17));
		cart_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ImageIcon image1 = new ImageIcon("korpica.png");
		Image image_tmp1 = getScaledImage(image1.getImage(), 20, 20);
		image1.setImage(image_tmp1);

		JLabel cart_pic = new JLabel(image1);
		cart_pic.setBounds(screenWidth - 95, 10, 30, 30);
		cart_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE LABELE SHOP i SLIKE LOKACIJE
		shops_label = new JLabel("Shops");
		shops_label.setBounds(30, 10, 40, 30);
		shops_label.setFont(new Font("Serif", Font.PLAIN, 17));
		shops_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ImageIcon image2 = new ImageIcon("location_icon.png");
		Image image_tmp2 = getScaledImage(image2.getImage(), 20, 20);
		image2.setImage(image_tmp2);

		JLabel location_pic = new JLabel(image2);
		location_pic.setBounds(72, 15, 20, 20);
		location_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		background.add(location_pic);
		background.add(shops_label);
		background.add(cart_pic);
		background.add(cart_label);
		background.add(register_label);
		background.add(login_label);
		background.setLayout(null);
		background.add(globus_label);
		background.add(globus_label2);
		background.add(articleName);
		background.add(articlePrice);
		background.add(articleId);
		background.add(naziv);
		background.add(cena);
		background.add(sifra);
		background.add(boja);
		background.add(articleColor);
		background.add(uzeto);
		background.add(brojUzetih);
		background.add(minus);
		background.add(plus);
		background.add(vrednost);
		background.add(addWishList);
		background.add(addCart);
		background.add(pozoviProdavnice);
		background.add(articlePic);
		
		this.add(background);
		this.setVisible(true);

		
		addCart.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				Stavka s = new Stavka();
				Artikl a = new Artikl();
				for(Artikl a1:app.artikli){
					if(a1.getSifra().equals(articleid)){
						a = a1;
						break;
					}
				}
				if(a.getStanje() == 0){
					JOptionPane.showMessageDialog(null, "Nema vise artikla u magacinu.");
				}else{
					if(app.getAktivniKorisnik() == TipKorisnika.neulogovanKorisnik){
						s.setArtikl(a);
						s.setKolicina(Integer.parseInt(vrednost.getText()));
						boolean nadjena = false;
						int indeks = 0;
						for(int i = 0;i<app.korpe.size();i++){
							if(app.korpe.get(i).getIdNeulog()==0){
								nadjena = true;
								indeks = i;
								break;
							}
						}
						
						if(nadjena == true){
							if(a.getStanje()<s.getKolicina()){
								JOptionPane.showMessageDialog(null, "Neuspesno dodato. Nedovoljno artikala u magacinu");
							}else{
								app.korpe.get(indeks).dodajStavku(s);
								for(Artikl a1:app.artikli){
									if(a1.getSifra().equals(articleid)){
										a.setStanje(a.getStanje()-Integer.parseInt(vrednost.getText()));
										break;
									}
								}
								JOptionPane.showMessageDialog(null, "Uspesno dodato.");
							}
						}else{
							if(a.getStanje()<s.getKolicina()){
								JOptionPane.showMessageDialog(null, "Neuspesno dodato. Nedovoljno artikala u magacinu");
							}else{
								Korpa k = new Korpa();
								k.setIdNeulog(app.getId());
								k.dodajStavku(s);
								app.korpe.add(k);
								for(Artikl a1:app.artikli){
									if(a1.getSifra().equals(articleid)){
										a.setStanje(a.getStanje()-Integer.parseInt(vrednost.getText()));
										break;
									}
								}
								JOptionPane.showMessageDialog(null, "Uspesno dodato.");
							}
						}
					}else{
						for(Korisnik k:app.korisnici){
							if(k.getJmbg()==app.getId()){
								s.setArtikl(a);
								s.setKolicina(Integer.parseInt(vrednost.getText()));
								boolean nadjena = false;
								int indeks = 0;
								for(int i = 0;i<app.korpe.size();i++){
									if(app.korpe.get(i).getIdNeulog()==k.getJmbg()){
										nadjena = true;
										indeks = i;
										break;
									}
								}
								if(nadjena == true){
									if(a.getStanje()<s.getKolicina()){
										JOptionPane.showMessageDialog(null, "Neuspesno dodato. Nedovoljno artikala u magacinu.");
									}else{
										app.korpe.get(indeks).dodajStavku(s);
										k.setKorpa(app.korpe.get(indeks));
										for(Artikl a1:app.artikli){
											if(a1.getSifra().equals(articleid)){
												a.setStanje(a.getStanje()-Integer.parseInt(vrednost.getText()));
												break;
											}
										}
										JOptionPane.showMessageDialog(null, "Uspesno dodato.");
									}
								}else{
									if(a.getStanje()<s.getKolicina()){
										JOptionPane.showMessageDialog(null, "Neuspesno dodato. Nedovoljno artikala u magacinu");
									}else{
										Korpa k2 = new Korpa();
										k2.setIdNeulog(k.getJmbg());
										k2.dodajStavku(s);
										k.setKorpa(k2);
										app.korpe.add(k2);
										for(Artikl a1:app.artikli){
											if(a1.getSifra().equals(articleid)){
												a.setStanje(a.getStanje()-Integer.parseInt(vrednost.getText()));
												break;
											}
										}
										JOptionPane.showMessageDialog(null, "Uspesno dodato.");
									}
								}
							}
						}
					}
					
				}
			}
				  
	    });  
		
		addWishList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				
				if(app.getAktivniKorisnik()==TipKorisnika.neulogovanKorisnik){
					JOptionPane.showMessageDialog(null, "Neulogovan korisnik nema pravo na ovu opciju.");
				}
				
				for(Korisnik k:app.korisnici){
					if(k.getJmbg()==app.getId()){
						for(Artikl a1:app.artikli){
							if(a1.getSifra().equals(articleid)){
								boolean uspesnost = k.getListaZelja().add(a1);
								if(uspesnost){
									JOptionPane.showMessageDialog(null, "Artikl uspesno dodat");
								}else{
									JOptionPane.showMessageDialog(null, "Neuspesno dodavanje. Artikl vec postoji.");
								}
								break;
							}
						break;
					}
				}	
				}
			}
		});
		
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
		globus_label2.addMouseListener(tiny_house_clicked);
		
		plus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				Artikl trenutni = new Artikl();
				for(Artikl a:app.artikli){
					if(a.getSifra().equals(articleid)){
						trenutni = a;
						break;
					}
				}
				int trenutna = Integer.parseInt(vrednost.getText());
				int trenutna3 = trenutna + 1;
				if(trenutna3 > trenutni.getStanje()){
					JOptionPane.showMessageDialog(null, "Prekoracili ste broj artikla u magacinu.");
				}else{
					trenutna = trenutna + 1;
					int trenutna2 = Integer.parseInt(brojUzetih.getText());
					trenutna2 = trenutna2 + 1;
					vrednost.setText(Integer.toString(trenutna));
					brojUzetih.setText(Integer.toString(trenutna2));
				}
			}
		});
	
		minus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				Artikl trenutni = new Artikl();
				for(Artikl a:app.artikli){
					if(a.getSifra().equals(articleid)){
						trenutni = a;
						break;
					}
				}
				int trenutna = Integer.parseInt(vrednost.getText());
				int trenutna2 = Integer.parseInt(brojUzetih.getText());
				if(trenutna == 1){
					JOptionPane.showMessageDialog(null, "Ne moze manje.");
				}else{
					trenutna = trenutna - 1;
					trenutna2 = trenutna2 - 1;
					vrednost.setText(Integer.toString(trenutna));
					brojUzetih.setText(Integer.toString(trenutna2));
				}
			}
		});
		
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
		
		register_label.addMouseListener(register_clicked);

		login_label.addMouseListener(login_clicked);

		for (JLabel lbl : kategorijeLabele) {
			lbl.addMouseListener(mouse_moved);
		}
		MouseListener cart_clicked = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CartView cv = new CartView(app);

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
	
	void attributesDissapear() {
		articlePic.hide();
		articleName.hide();
		articleId.hide();
		articlePrice.hide();
		articleColor.hide();
		addCart.hide();
		addWishList.hide();
		//number.hide();
		naziv.hide();
		cena.hide();
		sifra.hide();
		boja.hide();
		uzeto.hide();
		brojUzetih.hide();
		vrednost.hide();
		plus.hide();
		minus.hide();
		pozoviProdavnice.hide();
		globus_label2.hide();
	}
	
	void attributesAppear() {
		articlePic.show();
		articleName.show();
		articleId.show();
		articlePrice.show();
		articleColor.show();
		addCart.show();
		addWishList.show();
		//number.show();
		naziv.show();
		cena.show();
		sifra.show();
		boja.show();
		uzeto.show();
		brojUzetih.show();
		vrednost.show();
		plus.show();
		minus.show();
		pozoviProdavnice.show();
		globus_label2.show();
	}
			
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
