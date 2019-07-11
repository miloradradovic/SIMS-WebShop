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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Aplikacija;

public class SearchWindow extends WindowTemplate{

	private static final long serialVersionUID = 5L;
	JTree tree;
	JSplitPane splitPane;
	JLabel selected;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	

	public SearchWindow(Aplikacija app, String parametar) {
		super(app);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		ImageIcon image = new ImageIcon("white_background.jpg");
		Image image_tmp = getScaledImage(image.getImage(), screenWidth, screenHeight);
		image.setImage(image_tmp);

		JLabel background = super.background;
		super.background.setIcon(image);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
   /*---------------------------------------------------------------------------*/
		selected = new JLabel(parametar);
		selected.setBounds(screenWidth/2, 125, 150, 25);
		selected.setFont(new Font("Serif", Font.PLAIN, 25));
		selected.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel p = new JPanel(); 
		JTextArea t2 = new JTextArea(10, 10); 
		t2.setText("Proba");
		
		p.add(t2);
		
		
		
		DefaultMutableTreeNode top =  new DefaultMutableTreeNode("Root");
		
		DefaultMutableTreeNode kategorien = new DefaultMutableTreeNode("Kategorien");
		
		for(int i = 0; i < app.kategorije.size(); i++)
		{
			if(app.kategorije.get(i).getNaziv().equals(parametar));
			{
				System.out.println(app.kategorije.get(i).getNaziv() + " " + parametar);
				for(int j = 0; j < app.kategorije.get(i).getKategorijaB().size(); j++)
				{
					DefaultMutableTreeNode temp = new DefaultMutableTreeNode(app.kategorije.get(i).getKategorijaB().get(j).getNaziv());
					kategorien.add(temp);
				}
			}
		}
	
		DefaultMutableTreeNode farben = new DefaultMutableTreeNode("Farben");
		 
		top.add(kategorien);
		top.add(farben);
		
		tree = new JTree(top);
		
		tree.setFont(new Font("Serif", Font.PLAIN, 20));
		tree.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		tree.setRootVisible(false);
		
		
	    JScrollPane treeView = new JScrollPane(tree);
	    
	    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(treeView);
	    splitPane.setRightComponent(p);
	    splitPane.setBounds(0, 170, screenWidth, screenHeight-170);
        
	   
	    //namesten divider i da ne moze da se pomera
	    splitPane.setDividerLocation(screenWidth/9); 
        Dimension minimumSizeL = new Dimension(screenWidth/9, 50);
        Dimension minimumSizeR = new Dimension(screenWidth - screenWidth/9, 50);
        splitPane.getLeftComponent().setMinimumSize(minimumSizeL);
        splitPane.getRightComponent().setMinimumSize(minimumSizeR);
        
    /*---------------------------------------------------------------------------*/
        background.add(selected);
        background.add(splitPane);
        
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
	
	
	@Override
	void attributesDissapear() {
		splitPane.hide();
		selected.hide();
	}
	@Override
	void attributesAppear() {
		splitPane.show();
		selected.show();
	}
}
