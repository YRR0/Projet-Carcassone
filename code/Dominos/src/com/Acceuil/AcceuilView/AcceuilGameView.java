package com.Acceuil.AcceuilView;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AcceuilGameView extends JFrame {
	
	    // Declare two panels
	    private ImagePanel panel1, panel2;
	    private JButton button1 , button2;
	    
	    public AcceuilGameView() {
	        setTitle("Panel Example");
	        setLayout(new GridLayout(1, 2));
	        setUndecorated(true);
	   
	        panel1 = new ImagePanel("Ressources/images/R.jpg",0,0); panel1.setLayout(null); 
	        panel2 = new ImagePanel("Ressources/images/c2.jpg",70,70); panel2.setLayout(null);
	        
	        BufferedImage image = null , image2 = null;
	        try {
				image = ImageIO.read(new File("Ressources/images/button1.png"));
				image2 = ImageIO.read(new File("Ressources/images/button3.png"));
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur dans le chargement images pour les bouttons");
			}
	        
	        panel1.setBackground(new Color(0, 0, 0));
	        panel2.setBackground(new Color(255, 255, 255));
	          
	        button1 = new JButton(new ImageIcon(image)); button1.setBackground(new Color(0, 0, 0)); button1.setOpaque(false); button1.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	        button2 = new JButton(new ImageIcon(image2)); button2.setBackground(new Color(255, 255, 255)); button2.setOpaque(false); button2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	       
	        panel1.add(button1); 
	        panel2.add(button2);
	        
	        add(panel1);
	        add(panel2);
	        
	        setSize(800, 500);
	        setVisible(true);
	
	        button1.setBounds(this.getWidth()/9,this.getHeight()-160, 210 , 58);
	        button2.setBounds(this.getWidth()/10, 10 , 250 , 60);
	        
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Dimension frameSize = this.getSize();
	        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	    }
	    
	    public JButton getButton1() {
	    	return this.button1;
	    }
	    public JButton getButton2() {
	    	return this.button2;
	    }
		
		public class ImagePanel extends JPanel {
		  private BufferedImage image;
		  private int x,y;
		  public ImagePanel(String path, int x, int y) {
			  this.x = x; this.y = y;
		    try {
		      image = ImageIO.read(new File(path));
		    } catch (IOException ex) {
		      System.out.println("Erreur dans le chargement");
		    }
		  }

		  @Override
		  public Dimension getPreferredSize() {
		    return image == null ? new Dimension(100, 100) : new Dimension(image.getWidth(), image.getHeight());
		  }

		  @Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(image, x, y, this);
		  }
		}
}
