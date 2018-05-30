package vhgui;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class AnimationThread extends Thread{
	public int x;
	public int y;
	MyButton b;
    public AnimationThread(MyButton b,int x,int y){
		super();
		this.b = b;
		this.x = x;
		this.y = y;
	}
	public void run(){
		b.setAnimationAllow(false);
		int tx = b.getX();
		int ty = b.getY();
		int dx = 5;
		int dy = 5;
		while((tx != x || ty != y) && (Math.abs(tx-x) > dx || Math.abs(ty-y) > dy)){                 
		    if (tx < x)
		      tx+=dx;
		    if (tx > x)
		      tx-=dx;
		    if (ty < y)
		      ty+=dx;
		    if (ty > y)
		      ty-=dx;
		    b.setLocation(tx,ty);
		    try{
				sleep(30);
			}catch(Exception e){
			  
			}
		}
		b.setLocation(x,y);
		b.setAnimationAllow(true);
	}
}
