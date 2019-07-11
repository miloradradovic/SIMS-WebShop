package view;


import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import enums.Boja;
import model.Aplikacija;

public class SearchArticleWindow extends WindowTemplate{

	private static final long serialVersionUID = 10L;
	JTree tree;
	JSplitPane splitPane;
	JLabel selected;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();

	public SearchArticleWindow(Aplikacija app, String parametar) {
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
		GridLayout flow = new GridLayout(0, 5, 10, 50);

		JPanel panel = new JPanel(); 
		
		panel.setLayout(flow);
		
		DefaultMutableTreeNode top =  new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode kategorien = new DefaultMutableTreeNode("Kategorien");
		
		for(int i = 0; i < app.artikli.size(); i++)
		{
			if(app.artikli.get(i).getNaziv().contains(parametar)) 
			{
				Container pane =  new Container();
				pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
				JLabel articlePic = new JLabel();
				ImageIcon image2 = new ImageIcon(app.artikli.get(i).getSlika());
				Image image_tmp2 = getScaledImage(image2.getImage(), 200, 300);
				image2.setImage(image_tmp2);
				articlePic.setIcon(image2);
				pane.add(articlePic);
				
				JLabel articleName = new JLabel(app.artikli.get(i).getNaziv());
				articleName.setFont(new Font("Serif", Font.PLAIN,20));
				pane.add(articleName);
				
				JLabel articleId = new JLabel(app.artikli.get(i).getSifra());
				articleId.setFont(new Font("Serif", Font.PLAIN, 23));
				pane.add(articleId);
				
				labels.add(articleId);
				
				panel.add(pane);
				
		/*---------------------------------------------------------------------------*/	
				for(int k = 0; k < app.kategorije.size(); k++)
				{
					if(app.kategorije.get(k).getNaziv().equals(app.artikli.get(i).getKategorija().getNaziv()))
					{	
						for(int j = 0; j < app.kategorije.get(k).getKategorijaB().size(); j++)
						{
							DefaultMutableTreeNode temp = new DefaultMutableTreeNode(app.kategorije.get(k).getKategorijaB().get(j).getNaziv());
							kategorien.add(temp);
						}
					}
				}			
			}
			
		}
	
		DefaultMutableTreeNode farben = new DefaultMutableTreeNode("Farben");
		
		for (Boja color : Boja.values()) { 
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(color);
			farben.add(temp);
		}
		
		 
		top.add(kategorien);
		top.add(farben);
	/*---------------------------------------------------------------------------*/
		tree = new JTree(top);
		
		tree.setFont(new Font("Serif", Font.PLAIN, 20));
		tree.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		
		tree.setRootVisible(false);
		
		Icon leafIcon = new ImageIcon("leaf.jpg");
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	    renderer.setLeafIcon(leafIcon);
	    tree.setCellRenderer(renderer);
		
		for (int i = 0; i < tree.getRowCount(); i++) {
		    tree.expandRow(i);
		}
		
	/*---------------------------------------------------------------------------*/
	    JScrollPane treeView = new JScrollPane(tree);
	    
	    JScrollPane panelView = new JScrollPane(panel);
	    
	    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    splitPane.setLeftComponent(treeView);
	    splitPane.setRightComponent(panelView);
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

        this.addActionListener(app);

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
	
	
	@SuppressWarnings("deprecation")
	@Override
	void attributesDissapear() {
		splitPane.hide();
		selected.hide();
	}
	@SuppressWarnings("deprecation")
	@Override
	void attributesAppear() {
		splitPane.show();
		selected.show();
	}
	
	void addActionListener(Aplikacija app) {
		
		MouseListener mouse = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel lbl = (JLabel) e.getSource();
				dispose();
				ArticleWindow aw = new ArticleWindow(lbl.getText(), app);

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

		for (JLabel lbl : labels) {
			lbl.addMouseListener(mouse);
		}
		
	}

}
