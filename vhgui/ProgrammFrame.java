package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class ProgrammFrame extends JFrame implements WindowListener{
	GameModel model;
	public ProgrammFrame(String title, GameModel model){
		super(title);
		setSize(600,600);
		setLocation(100,100);
		setLayout(null);
		model.render(this);
		addWindowListener(this);
		setResizable(false);
		setVisible(true);
		setBackground(new Color(0,0,0));
		model.randomizer();
		this.model = model;
	}
    public void windowActivated(WindowEvent e) {
		
	}
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {
		setVisible(false);
        dispose();
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
