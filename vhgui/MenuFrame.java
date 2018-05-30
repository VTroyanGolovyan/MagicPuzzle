package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class MenuFrame extends JFrame implements WindowListener{
   Image img;
   public MenuFrame(String title){
	   super(title);
	   setLocation(100,100);
	   setSize(400,600);
	   addWindowListener(this);
	   setBackground(new Color(225,225,225));
	   setLayout(null);
	   MenuButton m = new MenuButton("Menu",0,50,200,50,0);
	   add(m);
	   m.changeLocation(100,80);
	   MenuButton b1 = new MenuButton("4 X 4",50,0,300,50,4);
	   add(b1);
	   b1.changeLocation(50,160);
	   
	   MenuButton b2 = new MenuButton("5 X 5",50,0,300,50,5);
	   add(b2);
	   b2.changeLocation(50,220);
	   
	   MenuButton b3 = new MenuButton("6 X 6",50,0,300,50,6);
	   add(b3);
	   b3.changeLocation(50,290);
	   
	   MenuButton b4 = new MenuButton("8 X 8",50,600,300,50,8);
	   add(b4);
	   b4.changeLocation(50,350);
	   
	   MenuButton b5 = new MenuButton("10 X 10",50,600,300,50,10);
	   add(b5);
	   b5.changeLocation(50,420);
	 
	   MenuButton b6 = new MenuButton("15 X 15",50,600,300,50,15);
	   add(b6);
	   b6.changeLocation(50,480);
	   setVisible(true);
   }
   public void paint(Graphics g){
     // g.drawImage(img,0,0,400,800,0,0,552,552,this);
   }
   public void windowActivated(WindowEvent e) {
		
	}
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) {
		
	}
	public void windowIconified(WindowEvent e)  {
		
	}
	public void windowOpened(WindowEvent e) {
		
	}
	public void windowDeiconified(WindowEvent e) {
		
	}
}
