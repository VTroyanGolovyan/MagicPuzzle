package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class MenuButton extends MyButton{
	 int size;
	 public MenuButton(String text, int x,int y, int width, int height,int size){
	   super(text,x,y,width,height);
	   setBackground(new Color(0,0,0));
	   setForeground(new Color(255,255,255));
	   this.size = size;
     }
     public void actionPerformed(ActionEvent e){
		 if (size != 0)
		   new ProgrammFrame("MagicPuzzle",new GameModel(size));
	 }
}
