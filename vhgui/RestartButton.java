package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class RestartButton extends MyButton{
	 ProgrammFrame fr;
	 GameModel model;
	 DialogFrame fr1;
	 public RestartButton(String text, int x,int y, int width, int height,ProgrammFrame fr,GameModel model,DialogFrame fr1){
	   super(text,x,y,width,height);
	   setBackground(new Color(0,0,0));
	   this.fr = fr;
	   this.fr1 = fr1;
	   this.model = model;
	   setForeground(new Color(255,255,255));
     }
     public void actionPerformed(ActionEvent e){
		 fr.enable();
		 model.randomizer();
		 fr1.setVisible(false);
         fr1.dispose();
	 }
}
