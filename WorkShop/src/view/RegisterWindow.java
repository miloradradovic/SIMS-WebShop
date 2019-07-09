package view;

import java.awt.Choice;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Adresa;
import classes.Artikl;
import classes.Grad;
import classes.Kategorija;
import classes.Korisnik;
import classes.Korpa;
import classes.Porudzbina;
import enums.Pol;
import model.Aplikacija;

public class RegisterWindow extends WindowTemplate {

	private static final long serialVersionUID = 3L;
	JLabel register_label;
	JLabel email_label, phone_label, name_label, last_label, jmbg_label, username_label, password_label, date_label,
			address_label, number_label, town_label, postal_label, gender_label;
	JTextField email_field, phone_field, name_field, last_field, jmbg_field, username_field, password_field,
			address_field, number_field, town_field, postal_field;
	Choice day_choice, month_choice, year_choice;
	ButtonGroup gender;
	JRadioButton male_rb, female_rb;
	JButton next_button, cancel_button;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();

	@SuppressWarnings("unused")
	public RegisterWindow(Aplikacija app) {
		super(app);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("Register");
		
		ImageIcon image = new ImageIcon("white_background.jpg");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth, screenHeight);
		image.setImage(image_tmp);

		JLabel background = super.background;
		super.background.setIcon(image);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		register_label = new JLabel("Register");
		register_label.setFont(new Font("Serif", Font.ITALIC, 30));
		register_label.setBounds(screenWidth / 2 - 100, 130, 280, 50);
		register_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(register_label);
		/*--------------------------*/
		email_label = new JLabel("Email: ");
		email_label.setBounds(screenWidth / 4 - 150, 200, 100, 30);
		email_label.setFont(new Font("Serif", Font.PLAIN, 25));
		email_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(email_label);
		
		email_field = new JTextField();
		email_field.setBounds(screenWidth / 4 - 50, 200, 300, 30);
		email_field.setFont(new Font("Serif", Font.PLAIN, 20));
		email_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(email_field);
		/*--------------------------*/
		phone_label = new JLabel("Phone: ");
		phone_label.setBounds(screenWidth / 4 - 150, 270, 100, 30);
		phone_label.setFont(new Font("Serif", Font.PLAIN, 25));
		phone_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(phone_label);
		
		phone_field = new JTextField();
		phone_field.setBounds(screenWidth / 4 - 50, 270, 300, 30);
		phone_field.setFont(new Font("Serif", Font.PLAIN, 20));
		phone_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(phone_field);
		/*--------------------------*/
		name_label = new JLabel("Name: ");
		name_label.setBounds(screenWidth / 2 + 20, 200, 100, 30);
		name_label.setFont(new Font("Serif", Font.PLAIN, 25));
		name_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(name_label);

		name_field = new JTextField();
		name_field.setBounds(screenWidth / 2 + 150, 200, 300, 30);
		name_field.setFont(new Font("Serif", Font.PLAIN, 20));
		name_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(name_field);
		/*--------------------------*/
		last_label = new JLabel("Last name: ");
		last_label.setBounds(screenWidth / 2 + 20, 270, 150, 30);
		last_label.setFont(new Font("Serif", Font.PLAIN, 25));
		last_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(last_label);

		last_field = new JTextField();
		last_field.setBounds(screenWidth / 2 + 150, 270, 300, 30);
		last_field.setFont(new Font("Serif", Font.PLAIN, 20));
		last_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(last_field);
		/*--------------------------*/
		jmbg_label = new JLabel("JMBG: ");
		jmbg_label.setBounds(screenWidth / 4 - 150, 340, 150, 30);
		jmbg_label.setFont(new Font("Serif", Font.PLAIN, 25));
		jmbg_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		jmbg_field = new JTextField();
		jmbg_field.setBounds(screenWidth / 4 - 50, 340, 300, 30);
		jmbg_field.setFont(new Font("Serif", Font.PLAIN, 20));
		jmbg_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		labels.add(jmbg_label);
		fields.add(jmbg_field);
		/*-------------OVDE POL PO KOOR 370  DATE PO KOOR 420-------------*/
		username_label = new JLabel("Username: ");
		username_label.setBounds(screenWidth / 2 + 20, 410, 150, 30);
		username_label.setFont(new Font("Serif", Font.PLAIN, 25));
		username_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(username_label);
		
		username_field = new JTextField();
		username_field.setBounds(screenWidth / 2 + 150, 410, 300, 30);
		username_field.setFont(new Font("Serif", Font.PLAIN, 20));
		username_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(username_field);
		/*--------------------------*/
		password_label = new JLabel("Password: ");
		password_label.setBounds(screenWidth / 2 + 20, 480, 150, 30);
		password_label.setFont(new Font("Serif", Font.PLAIN, 25));
		password_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(password_label);

		password_field = new JTextField();
		password_field.setBounds(screenWidth / 2 + 150, 480, 300, 30);
		password_field.setFont(new Font("Serif", Font.PLAIN, 30));
		password_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(password_field);
		/*--------------------------*/
		gender_label = new JLabel("Gender: ");
		gender_label.setBounds(screenWidth / 4 + 150, 620, 150, 30);
		gender_label.setFont(new Font("Serif", Font.PLAIN, 25));
		gender_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		male_rb = new JRadioButton("Male");
		male_rb.setBounds(screenWidth / 4 + 250, 620, 100, 30);
		male_rb.setFont(new Font("Serif", Font.PLAIN, 20));
		male_rb.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		female_rb = new JRadioButton("Female");
		female_rb.setBounds(screenWidth / 4 + 350, 620, 100, 30);
		female_rb.setFont(new Font("Serif", Font.PLAIN, 20));
		female_rb.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		gender = new ButtonGroup();
		gender.add(male_rb);
		gender.add(female_rb);
		/*--------------------------*/
		date_label = new JLabel("Birth date: ");
		date_label.setBounds(screenWidth / 2 + 20, 340, 120, 30);
		date_label.setFont(new Font("Serif", Font.PLAIN, 25));
		date_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(date_label);

		day_choice = new Choice();
		day_choice.setBounds(screenWidth / 2 + 150, 340, 100, 22);
		day_choice.setFont(new Font("Serif", Font.PLAIN, 20));
		day_choice.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		for (int i = 1; i < 32; i++)
			day_choice.add(Integer.toString(i));

		month_choice = new Choice();
		month_choice.setBounds(screenWidth / 2 + 250, 340, 100, 22);
		month_choice.setFont(new Font("Serif", Font.PLAIN, 20));
		month_choice.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		for (int i = 1; i < 13; i++)
			month_choice.add(Integer.toString(i));

		year_choice = new Choice();
		year_choice.setBounds(screenWidth / 2 + 350, 340, 200, 22);
		year_choice.setFont(new Font("Serif", Font.PLAIN, 20));
		year_choice.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		for (int i = 1960; i < 2001; i++)
			year_choice.add(Integer.toString(i));
		/*--------------------------*/
		address_label = new JLabel("Address: ");
		address_label.setBounds(screenWidth / 4 - 150, 410, 150, 30);
		address_label.setFont(new Font("Serif", Font.PLAIN, 25));
		address_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(address_label);
		
		address_field = new JTextField();
		address_field.setBounds(screenWidth / 4 - 50, 410, 300, 30);
		address_field.setFont(new Font("Serif", Font.PLAIN, 30));
		address_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(address_field);
		/*--------------------------*/
		number_label = new JLabel("Number: ");
		number_label.setBounds(screenWidth / 4 - 150, 480, 150, 30);
		number_label.setFont(new Font("Serif", Font.PLAIN, 25));
		number_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(number_label);

		number_field = new JTextField();
		number_field.setBounds(screenWidth / 4 - 50, 480, 300, 30);
		number_field.setFont(new Font("Serif", Font.PLAIN, 30));
		number_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(number_field);
		/*--------------------------*/
		town_label = new JLabel("Town: ");
		town_label.setBounds(screenWidth / 4 - 150, 550, 150, 30);
		town_label.setFont(new Font("Serif", Font.PLAIN, 25));
		town_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(town_label);
		
		town_field = new JTextField();
		town_field.setBounds(screenWidth / 4 - 50, 550, 300, 30);
		town_field.setFont(new Font("Serif", Font.PLAIN, 30));
		town_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(town_field);
		/*--------------------------*/
		postal_label = new JLabel("Postal code: ");
		postal_label.setBounds(screenWidth / 2 + 20, 550, 150, 30);
		postal_label.setFont(new Font("Serif", Font.PLAIN, 25));
		postal_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labels.add(postal_label);

		postal_field = new JTextField();
		postal_field.setBounds(screenWidth / 2 + 150, 550, 300, 30);
		postal_field.setFont(new Font("Serif", Font.PLAIN, 30));
		postal_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		fields.add(postal_field);

		/*--------------------------*/
		next_button = new JButton("Next");
		next_button.setBounds(screenWidth / 2 + 50, 700, 150, 30);
		next_button.setFont(new Font("Serif", Font.PLAIN, 25));
		next_button.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		next_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Boolean correct = true;
				String email = email_field.getText();
				String phone = phone_field.getText();
				String name = name_field.getText();
				String last = last_field.getText();
				String jmbg_s = jmbg_field.getText();
				int jmbg = 0;
				if (jmbg_s.matches("[0-9]+")) {
					jmbg = Integer.parseInt(jmbg_s);
				} else {
					correct = false;
				}

				Pol gen = null;
				if (male_rb.isSelected() || female_rb.isSelected()) {
					if (male_rb.isSelected()) {
						gen = Pol.muski;
					} else {
						gen = Pol.zenski;
					}
				} else {
					correct = false;
				}

				Boolean found = false;
				String user = username_field.getText();

				Iterator<Korisnik> itK = app.korisnici.iterator();
				while (itK.hasNext()) {
					Korisnik kor = itK.next();
					if (kor.getKorisnickoIme().equals(user)) {
						JOptionPane.showMessageDialog(null, "Korisnicko ime postoji");
						found = true;
						break;
					}
				}

				String pass = password_field.getText();

				String date_s = day_choice.getSelectedItem() + "." + month_choice.getSelectedItem() + "."
						+ year_choice.getSelectedItem() + ".";
				Date date = null;
				try {
					date = app.format.parse(date_s);
				} catch (ParseException pe) {
					JOptionPane.showMessageDialog(null, "Neki podatak nije dobro unet");
				}

				String date_check = app.format.format(date);
				if (!date_s.equals(date_check)) {
					correct = false;
				}

				String address = address_field.getText();
				String num_s = number_field.getText();
				int num = 0;
				if (num_s.matches("[0-9]+")) {
					num = Integer.parseInt(jmbg_s);
				} else {
					correct = false;
				}
				String town = town_field.getText();
				String postal_code_s = postal_field.getText();
				int postal_code = 0;
				if (postal_code_s.matches("[0-9]+")) {
					postal_code = Integer.parseInt(jmbg_s);
				} else {
					correct = false;
				}

				Iterator<Grad> itG = app.gradovi.iterator();
				while (itG.hasNext()) {
					Grad grad = itG.next();
					if (!town.equals(grad.getMesto()) || postal_code != grad.getPostanskiBroj()) {
						correct = false;
					}
				}

				if (correct && !found) {
					Grad newGrad = new Grad(town, postal_code);
					Adresa newAdd = new Adresa(address, num, newGrad);
					Korisnik newKor = new Korisnik(email, phone, name, last, jmbg, gen, user, pass, date, newAdd,
							new Korpa(), new ArrayList<Porudzbina>(), new ArrayList<Artikl>());
					app.korisnici.add(newKor);
					dispose();
					MainWindow ww = new MainWindow(app);
				} else if (!found) {
					JOptionPane.showMessageDialog(null, "Neki podatak nije dobro unet");
				}

			}
		});

		cancel_button = new JButton("Cancel");
		cancel_button.setBounds(screenWidth / 2 - 300, 700, 150, 30);
		cancel_button.setFont(new Font("Serif", Font.PLAIN, 25));
		cancel_button.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

		cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				MainWindow ww = new MainWindow(app);
			}
		});

		background.add(register_label);
		background.add(email_field);
		background.add(email_label);
		background.add(phone_field);
		background.add(phone_label);
		background.add(name_field);
		background.add(name_label);
		background.add(last_field);
		background.add(last_label);
		background.add(jmbg_field);
		background.add(jmbg_label);
		background.add(username_field);
		background.add(username_label);
		background.add(password_field);
		background.add(password_label);
		background.add(gender_label);
		background.add(male_rb);
		background.add(female_rb);
		background.add(cancel_button);
		background.add(date_label);
		background.add(day_choice);
		background.add(month_choice);
		background.add(year_choice);
		background.add(next_button);
		background.add(address_field);
		background.add(address_label);
		background.add(number_field);
		background.add(number_label);
		background.add(town_field);
		background.add(town_label);
		background.add(postal_field);
		background.add(postal_label);

		JScrollPane js = new JScrollPane(background, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setContentPane(js);

		this.setVisible(true);

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
		for (JLabel lbl: labels) {
			lbl.hide();
		}
		for (JTextField fld: fields) {
			fld.hide();
		}
		day_choice.hide();
		month_choice.hide();
		year_choice.hide();
	}
	@Override
	void attributesAppear() {
		for (JLabel lbl: labels) {
			lbl.show();
		}
		for (JTextField fld: fields) {
			fld.show();
		}
		day_choice.show();
		month_choice.show();
		year_choice.show();
	}
}
