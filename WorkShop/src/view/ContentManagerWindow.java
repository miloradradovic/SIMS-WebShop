package view;

import javax.swing.JLabel;

import classes.Porudzbina;
import model.Aplikacija;

public class ContentManagerWindow extends WindowTemplate{

	public ContentManagerWindow(Aplikacija app) {
		super(app);
	
		
		
		int height = 200;
		int width = 100;
		for (Porudzbina por: app.porudzbine) {
			JLabel jl = new JLabel(Integer.toString(por.getBrojPor()));
			JLabel jl2 = new JLabel(por.stanje.toString());
			jl.setBounds(width,height,100,200);
			jl2.setBounds(width+300,height,200,200);
			super.background.add(jl);
			super.background.add(jl2);
			height+=50;
			
		}
		
		
		
	}
	

}
