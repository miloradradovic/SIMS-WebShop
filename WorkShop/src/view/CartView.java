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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Kategorija;
import classes.Korisnik;
import classes.Korpa;
import classes.Stavka;
import enums.TipKorisnika;
import model.Aplikacija;

public class CartView extends WindowTemplate {

	private static final long serialVersionUID = 5L;
	ArrayList<JLabel> labeleArtikliSlike = new ArrayList<JLabel>();
	ArrayList<JLabel> labeleArtikliNaziv = new ArrayList<JLabel>();
	ArrayList<JLabel> labeleArtikliBoja = new ArrayList<JLabel>();
	JLabel artikl;
	JLabel cenaJedinicna;
	JLabel cenaUkupna;
	JLabel kolicina;
	JLabel korpa;
	ArrayList<JButton> labeleArtikliPlus = new ArrayList<JButton>();
	ArrayList<JButton> labeleArtikliMinus = new ArrayList<JButton>();
	ArrayList<JTextField> labeleArtikliVrednost = new ArrayList<JTextField>();
	ArrayList<JButton> labeleArtikliBrisanje = new ArrayList<JButton>();
	ArrayList<JLabel> labeleArtikliDinari = new ArrayList<JLabel>();
	ArrayList<JLabel> labeleArtikliDinari2 = new ArrayList<JLabel>();
	ArrayList<JLabel> labeleArtikliCenaJedinicna = new ArrayList<JLabel>();
	ArrayList<JLabel> labeleArtikliCenaKonacna = new ArrayList<JLabel>();
	JRadioButton credit_card, cash;
	JButton poruci;
	
	
	public CartView(Aplikacija app) {
		super(app);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("Cart view");
		this.setMinimumSize(new Dimension(500, 500));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image3 = new ImageIcon("white_background.jpg");
		Image image_tmp3 = getScaledImage(image3.getImage(), screenWidth, screenHeight + 400);
		image3.setImage(image_tmp3);
		
		JLabel background = super.background;
		super.background.setIcon(image3);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//DODAVANJE LABELA
		if(app.getAktivniKorisnik()==TipKorisnika.neulogovanKorisnik){
			for(Korpa k:app.korpe){
				if(k.getIdNeulog()==app.getId()){
					int dimenzijaSlike1 = screenWidth/2 - 700;
				    int dimenzijaSlike2 = 200;
					for(Stavka s:k.getStavka()){
						JLabel labelaSlika = new JLabel(s.getArtikl().getSlika());
						JLabel labelaNaziv = new JLabel(s.getArtikl().getNaziv());
						JLabel labelaBoja = new JLabel(s.getArtikl().getBoja().toString());
						JLabel labelaCenaJedinicna = new JLabel(Integer.toString(s.getArtikl().getCena()));
						JLabel labelaDinar = new JLabel("RSD ");
						JButton minus = new JButton("-");
						JTextField vrednost = new JTextField(Integer.toString(s.getKolicina()));
						JButton plus = new JButton("+");
						JLabel labelaDinar2 = new JLabel("RSD ");
						JLabel labelaCenaUkupno = new JLabel(Integer.toString(s.getKolicina()*s.getArtikl().getCena()));
						JButton obrisi = new JButton("Obrisi stavku");
						
						//FORMIRANJE LABELE SLIKA
						labelaSlika.setBounds(dimenzijaSlike1, dimenzijaSlike2,200,300);
						ImageIcon image2 = new ImageIcon(s.getArtikl().getSlika());
						Image image_tmp2 = getScaledImage(image2.getImage(),200,300);
						image2.setImage(image_tmp2);
						labelaSlika.setIcon(image2);
						labeleArtikliSlike.add(labelaSlika);
						
						//FORMIRANJE LABELE NAZIV
						labelaNaziv.setFont(new Font("Serif",Font.PLAIN,17));
						labelaNaziv.setBounds(dimenzijaSlike1+200,dimenzijaSlike2,150,150);
						labeleArtikliNaziv.add(labelaNaziv);
						
						//FORMIRANJE LABELE BOJA
						labelaBoja.setFont(new Font("Serif",Font.PLAIN,15));
						labelaBoja.setBounds(dimenzijaSlike1+200,dimenzijaSlike2+25,150,150);
						labeleArtikliBoja.add(labelaBoja);
						
						//FORMIRANJE LABELE DINAR1
						
						labelaDinar.setFont(new Font("Serif",Font.PLAIN,17));
						labelaDinar.setBounds(dimenzijaSlike1+200+200,dimenzijaSlike2+50,100,100);
						labeleArtikliDinari.add(labelaDinar);
						
						//FORMIRANJE LABELE JEDINICNA CENA
						
						labelaCenaJedinicna.setFont(new Font("Serif",Font.PLAIN,17));
						labelaCenaJedinicna.setBounds(dimenzijaSlike1+200+200+50, dimenzijaSlike2+50, 100, 100);
						labeleArtikliCenaJedinicna.add(labelaCenaJedinicna);
						
						//FORMIRANJE BUTTONA MINUS
						
						minus.setFont(new Font("Serif",Font.PLAIN,17));
						minus.setBounds(dimenzijaSlike1+200+200+150+100,dimenzijaSlike2+50,70,70);
						labeleArtikliMinus.add(minus);
						
						//FORMIRANJE VREDNOSTI IZMEDJU MINUSA I PLUSA
						
						vrednost.setFont(new Font("Serif",Font.PLAIN,17));
						vrednost.setBounds(dimenzijaSlike1+200+200+150+150,dimenzijaSlike2+50,70,70);
						vrednost.setHorizontalAlignment(JTextField.CENTER);
						vrednost.setEditable(false);
						labeleArtikliVrednost.add(vrednost);
						
						//FORMIRANJE BUTTONA PLUS
						
						plus.setFont(new Font("Serif",Font.PLAIN,17));
						plus.setBounds(dimenzijaSlike1+700+50, dimenzijaSlike2+50, 70, 70);
						labeleArtikliPlus.add(plus);
						
						//FORMIRANJE BUTTONA BRISANJA
						
						obrisi.setFont(new Font("Serif",Font.PLAIN,17));
						obrisi.setBounds(dimenzijaSlike1+700,dimenzijaSlike2+150,200,70);
						labeleArtikliBrisanje.add(obrisi);
						
						//FORMIRANJE DINARA 2
						
						labelaDinar2.setFont(new Font("Serif",Font.PLAIN,17));
						labelaDinar2.setBounds(dimenzijaSlike1+890+200,dimenzijaSlike2,100,100);
						labeleArtikliDinari2.add(labelaDinar2);
						
						//FORMIRANJE UKUPNE CENE
						
						labelaCenaUkupno.setFont(new Font("Serif",Font.PLAIN,17));
						labelaCenaUkupno.setBounds(dimenzijaSlike1+1090+150, dimenzijaSlike2, 70, 70);
						labeleArtikliCenaKonacna.add(labelaCenaUkupno);
						
						//POVECAVANJE DIMENZIJA ZBOG SLEDECE SLIKE
						
						dimenzijaSlike2 = dimenzijaSlike2 + 300;
					
					}
				}
			}
		}else{
			for(Korisnik k:app.korisnici){
				if(k.getJmbg()==app.getId()){
					int dimenzijaSlike1 = screenWidth/2 - 700;
				    int dimenzijaSlike2 = 120;
				    //int dimenzijaSlike3 = 500
				    //int dimenzijaSlike4 = 600
					for(Stavka s:k.getKorpa().getStavka()){
						JLabel labelaSlika = new JLabel(s.getArtikl().getSlika());
						JLabel labelaNaziv = new JLabel(s.getArtikl().getNaziv());
						JLabel labelaBoja = new JLabel(s.getArtikl().getBoja().toString());
						JLabel labelaCenaJedinicna = new JLabel(Integer.toString(s.getArtikl().getCena()));
						JLabel labelaDinar = new JLabel("RSD ");
						JButton minus = new JButton("-");
						JTextField vrednost = new JTextField(Integer.toString(s.getKolicina()));
						JButton plus = new JButton("+");
						JLabel labelaDinar2 = new JLabel("RSD ");
						JLabel labelaCenaUkupno = new JLabel(Integer.toString(Integer.parseInt(vrednost.getText())*Integer.parseInt(cenaJedinicna.getText())));
						JButton obrisi = new JButton("Obrisi stavku");
						
						//FORMIRANJE LABELE SLIKA
						labelaSlika.setBounds(dimenzijaSlike1, dimenzijaSlike2,100,200);
						ImageIcon image2 = new ImageIcon(s.getArtikl().getSlika());
						Image image_tmp2 = getScaledImage(image2.getImage(),70,150);
						image2.setImage(image_tmp2);
						labelaSlika.setIcon(image2);
						labeleArtikliSlike.add(labelaSlika);
						
						//FORMIRANJE LABELE NAZIV
						labelaNaziv.setFont(new Font("Serif",Font.PLAIN,17));
						labelaNaziv.setBounds(dimenzijaSlike1+200,dimenzijaSlike2,150,150);
						labeleArtikliNaziv.add(labelaNaziv);
						
						//FORMIRANJE LABELE BOJA
						labelaBoja.setFont(new Font("Serif",Font.PLAIN,15));
						labelaBoja.setBounds(dimenzijaSlike1+200,dimenzijaSlike2+170,150,150);
						labeleArtikliBoja.add(labelaBoja);
						
						//FORMIRANJE LABELE DINAR1
						
						labelaDinar.setFont(new Font("Serif",Font.PLAIN,17));
						labelaDinar.setBounds(dimenzijaSlike1+200+200,dimenzijaSlike2,100,100);
						labeleArtikliDinari.add(labelaDinar);
						
						//FORMIRANJE LABELE JEDINICNA CENA
						
						labelaCenaJedinicna.setFont(new Font("Serif",Font.PLAIN,17));
						labelaCenaJedinicna.setBounds(dimenzijaSlike1+200+200+150, dimenzijaSlike2, 100, 100);
						labeleArtikliCenaJedinicna.add(labelaCenaJedinicna);
						
						//FORMIRANJE BUTTONA MINUS
						
						minus.setFont(new Font("Serif",Font.PLAIN,17));
						minus.setBounds(dimenzijaSlike1+200+200+150+200,dimenzijaSlike2,70,70);
						labeleArtikliMinus.add(minus);
						
						//FORMIRANJE VREDNOSTI IZMEDJU MINUSA I PLUSA
						
						vrednost.setFont(new Font("Serif",Font.PLAIN,17));
						vrednost.setBounds(dimenzijaSlike1+200+200+150+200+70,dimenzijaSlike2,70,70);
						vrednost.setHorizontalAlignment(JTextField.CENTER);
						vrednost.setEditable(false);
						labeleArtikliVrednost.add(vrednost);
						
						//FORMIRANJE BUTTONA PLUS
						
						plus.setFont(new Font("Serif",Font.PLAIN,17));
						plus.setBounds(dimenzijaSlike1+820+70, dimenzijaSlike2, 70, 70);
						labeleArtikliPlus.add(plus);
						
						//FORMIRANJE BUTTONA BRISANJA
						
						obrisi.setFont(new Font("Serif",Font.PLAIN,17));
						obrisi.setBounds(dimenzijaSlike1+820,dimenzijaSlike2+150,70,70);
						labeleArtikliBrisanje.add(obrisi);
						
						//FORMIRANJE DINARA 2
						
						labelaDinar2.setFont(new Font("Serif",Font.PLAIN,17));
						labelaDinar2.setBounds(dimenzijaSlike1+890+200,dimenzijaSlike2,100,100);
						labeleArtikliDinari2.add(labelaDinar2);
						
						//FORMIRANJE UKUPNE CENE
						
						labelaCenaUkupno.setFont(new Font("Serif",Font.PLAIN,17));
						labelaCenaUkupno.setBounds(dimenzijaSlike1+1090+150, dimenzijaSlike2, 70, 70);
						labeleArtikliCenaKonacna.add(labelaCenaUkupno);
						
						//POVECAVANJE DIMENZIJA ZBOG SLEDECE SLIKE
						
						dimenzijaSlike2 = dimenzijaSlike2 + 300;
					}
				}	
			}
		}
		
		for(int i = 0;i<labeleArtikliVrednost.size();i++){
			background.add(labeleArtikliSlike.get(i));
			background.add(labeleArtikliNaziv.get(i));
			background.add(labeleArtikliBoja.get(i));
			background.add(labeleArtikliPlus.get(i));
			background.add(labeleArtikliMinus.get(i));
			background.add(labeleArtikliVrednost.get(i));
			background.add(labeleArtikliBrisanje.get(i));
			background.add(labeleArtikliDinari.get(i));
			background.add(labeleArtikliDinari2.get(i));
			background.add(labeleArtikliCenaJedinicna.get(i));
			background.add(labeleArtikliCenaKonacna.get(i));
		}
		background.setLayout(null);
		
		JScrollPane js = new JScrollPane(background, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setContentPane(js);
		this.setVisible(true);
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