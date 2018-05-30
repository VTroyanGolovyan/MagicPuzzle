package vhgui;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class MyButton extends JButton implements ActionListener{
   AnimationThread anim;
   public MyButton(String text, int x,int y, int width, int height){
	   super(text);
	   setLocation(x,y);
	   setSize(width,height);
	   this.animationFlag = true;
	   addActionListener(this);
   }
   public boolean animationFlag;
   public void setAnimationAllow(boolean f){
     this.animationFlag = f;
   }
   public void changeLocation(int x,int y){
         anim = new AnimationThread(this,x,y);
         anim.start();     
   }
   public void actionPerformed(ActionEvent e){
       
   }
}
