package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import classes.Porudzbina;
import model.Aplikacija;

public class ContentManagerWindow extends WindowTemplate{

	private static final long serialVersionUID = 1L;
	
	int i;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<String> sifre = new ArrayList<String>();
	
	public ContentManagerWindow(Aplikacija app) {
		super(app);
	
		int height = 200;
		int width = 100;
		for (Porudzbina por: app.porudzbine) {
			JButton button = new JButton("Sledece stanje");
			button.setBounds(width+600, height+80, 200 ,30);
			JLabel jl = new JLabel("Sifra porudzbine: " + Integer.toString(por.getBrojPor()));
			sifre.add(Integer.toString(por.getBrojPor()));
			JLabel jl2 = new JLabel("Stanje porudzbine: " + por.stanje.toString());
			jl.setBounds(width,height,200,200);
			jl2.setBounds(width+300,height,200,200);
			super.background.add(jl);
			super.background.add(jl2);
			JSeparator jsep = new JSeparator();
			jsep.setBounds(5,height+120,Toolkit.getDefaultToolkit().getScreenSize().width , 1);
			super.background.add(jsep);
			super.background.add(button);
			buttons.add(button);
			height+=50;
			
		}
		
		for (i = 0; i < buttons.size(); i++) {
			buttons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					int pos = buttons.indexOf(arg0.getSource());
					System.out.println("Sifra je: " + sifre.get(pos));
				}
				
			});
		}

		
		
		
	}
	

}
