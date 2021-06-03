package com.TETOSOFT.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.*;

public class Background extends JPanel {
	private JPanel contentPane;
	

	 public void paint(Graphics g){
		    Image img1 = Toolkit.getDefaultToolkit().getImage("images/backgrounds1.jpg");
		    g.drawImage(img1, 10, 100, this);
		    
		    Image img2 = Toolkit.getDefaultToolkit().getImage("images/backgrounds2.jpg");
		    g.drawImage(img2, 900, 100, this);
		    
		    Image img3 = Toolkit.getDefaultToolkit().getImage("images/backgrounds3.jpg");
		    g.drawImage(img3, 10, 350, this);
		    
		    Image img4 = Toolkit.getDefaultToolkit().getImage("images/backgrounds4.jpg");
		    g.drawImage(img4, 900, 350, this);
		    g.drawString("fermer la fenetre apres avoir choisi votre numero de background", 400, 400);
		  }
}