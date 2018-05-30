package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class DialogFrame extends JFrame implements WindowListener{
   Image img;
   public DialogFrame(String title,ProgrammFrame fr,GameModel model){
	   super(title);
	   setLocation(100,100);
	   setSize(400,400);
	   addWindowListener(this);
	   setLayout(null);
	   setBackground(new Color(225,225,225));
	   MenuButton m = new MenuButton("You Win",0,50,200,50,0);
	   add(m);
	   m.changeLocation(100,80);
	   RestartButton b1 = new RestartButton("Restart",50,0,300,50,fr,model,this);
	   add(b1);
	   b1.changeLocation(50,160);
	   
	   CloseButton b2 = new CloseButton("Close",50,0,300,50,fr,model,this);
	   add(b2);
	   b2.changeLocation(50,220);
	   
	   
	   setVisible(true);
   }
   public void paint(Graphics g){
    
   }
   public void windowActivated(WindowEvent e) {
		
	}
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {
		
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
