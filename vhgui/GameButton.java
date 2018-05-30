package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class GameButton extends MyButton{
   GameModel model;
   String num;
   Image img;
   int sx;
   int sy;
   int number;
   ProgrammFrame fr;
   public GameButton(int num, int x,int y, int width, int height, GameModel model,Image img){
	   super(new Integer(num).toString(),x,y,width,height);
	   this.model = model;
	   this.img = img;
	   this.number = num;
	   this.sx = x/(600/model.size);
	   this.sy = y/(600/model.size);
	   this.num = new Integer(num).toString();
	   this.fr = null;
   }
   public void setControl(ProgrammFrame fr){
       this.fr = fr;
   }
   public void actionPerformed(ActionEvent e){
	   if (this.animationFlag)
          model.tryGo(this.num);
       if (model.isWin() && fr != null){
          fr.disable(); 
          new DialogFrame("You Win",fr,model);
	   }
   }
   public void paint(Graphics g){
     g.drawImage(img,0,0,(600/model.size),(600/model.size),sx*(1000/model.size),sy*(1000/model.size),sx*(1000/model.size)+(1000/model.size),sy*(1000/model.size)+(1000/model.size),this);
   }
}
