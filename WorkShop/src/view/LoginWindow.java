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
import javax.swing.JTextField;

import model.Aplikacija;

public class LoginWindow extends JFrame {
	
	private static final long serialVersionUID = 2L;
	JLabel login_label;
	JLabel username_label;
	JLabel password_label;
	JTextField username_field;
	JTextField password_field;
	
	public LoginWindow(Aplikacija app) 
	{
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setTitle("Login");
		
		
		ImageIcon image = new ImageIcon("white_background.jpg");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth, screenHeight + 400);
		image.setImage(image_tmp);

		JLabel background = new JLabel(image);
		
		login_label = new JLabel("LOGIN");
		login_label.setFont(new Font("Serif", Font.BOLD, 30));
		login_label.setBounds(screenWidth / 2 - 100, 20, 280, 30);
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		username_label = new JLabel("Username: ");
		username_label.setBounds(screenWidth - 215, 10, 60, 30);
		username_label.setFont(new Font("Serif", Font.PLAIN, 20));
		username_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		username_field = new JTextField();
		username_field.setBounds(screenWidth / 2 - 250, 70, 500, 50);
		username_field.setFont(new Font("Serif", Font.PLAIN, 20));
		username_field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		password_label = new JLabel("Password: ");
		password_label.setBounds(screenWidth - 215, 10, 60, 30);
		password_label.setFont(new Font("Serif", Font.PLAIN, 20));
		password_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		background.add(username_field);
		background.add(username_label);
		background.add(login_label);
		
		this.pack();
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
