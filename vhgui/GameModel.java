package vhgui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class GameModel{
  GameButton a[][];
  int []b;
  int size;
  public GameModel(int size){
	  this.size = size;
    a = new GameButton[size][size];
    Image img = new ImageIcon("img/img"+(int)(Math.random()*5 + 1)+".png").getImage();
    for(int i = 0; i <= size*size-1; i++)
     try{
      a[(i - i%size)/size][i%size] = new GameButton(i+1,(600/size)*((i - i%size)/size),(600/size)*(i%size),(600/size),(600/size),this,img);
    }catch(Exception e){
	}
	int []b = new int[size*size];
	b[size*size-1] = -1;
	for (int i = 0; i < size*size-1;i++)
	  b[i] = i+1;
	this.b= b;
    a[a.length - 1][a.length - 1] = null;
  }
  public boolean isWin(){
	for (int i = 0; i < size*size-1;i++){
	  if (b[i] != i+1){
	    return false;
	   }
   }
	return true;
  }
  public void randomizer(){
	 Vector <MyPoint> v = new Vector(40);
	 int pairs = 0;
	 if (size == 4)
	   pairs = 7;
	 if (size == 5)
	   pairs = 8;
	 if (size == 6)
	   pairs = 10;
	 if (size == 8)
	   pairs = 18;
	 if (size == 10)
	   pairs = 24;
	 if (size == 15)
	   pairs = 30;
	 if (size == 20){
	    pairs = 40;
     }
     v.add(new MyPoint(a.length - 1,a.length - 1));
	 for (int c = 0; c < pairs; c++){
		 int x1 = (int)(Math.random()*size);
		 int y1 = (int)(Math.random()*size);
		 int x2 = (int)(Math.random()*size);
		 int y2 = (int)(Math.random()*size);
		 boolean f;
		 do{
			 f = false;
			 for (int j = 0; j < v.size(); j++){
			    if (v.get(j).x == x1 && v.get(j).y == y1){
			      x1 = (int)(Math.random()*size);
			      y1 = (int)(Math.random()*size);
			      f = true;
			    }
			    if (v.get(j).x == x2 && v.get(j).y == y2){
			      x2 = (int)(Math.random()*size);
			      y2 = (int)(Math.random()*size);
			      f = true;
			    }
			 }
		 }while(f);
		 
		 v.add(new MyPoint(x1,y1));
		 v.add(new MyPoint(x2,y2));
		 System.out.println(v.size());
		 swap(x1,y1,x2,y2);
	 }
  }
  public void render(ProgrammFrame fr){

    for (int i = 0; i < a.length; i++)
       for (int j = 0; j < a[i].length; j++){
          if (a[i][j]!=null){
            fr.add(a[i][j]);
            a[i][j].setControl(fr);
		  }
		}
  }
  public void swap(int i, int j, int i1, int j1){
	  
	  int t1 = b[i*(a.length) + j];
	  b[i*(a.length) + j] = b[i1*(a.length) + j1];
	  b[i1*(a.length) + j1] = t1;
	  
	  if (a[i][j] != null)
	    a[i][j].changeLocation(i1*600/size,j1*600/size);
	  if (a[i1][j1] != null)
	    a[i1][j1].changeLocation(i*600/size,j*600/size);
      GameButton t = a[i][j];
      a[i][j] = a[i1][j1];
      a[i1][j1] = t;     
  }
  public boolean tryGo(String num){
     for (int i = 0; i < a.length; i++){
	   for (int j = 0; j < a[i].length; j++){
	      if(a[i][j] != null && a[i][j].getLabel().equals(num)){
			  if(i > 0){
			    if (a[i - 1][j] == null){
					swap(i,j,i-1,j);
				}
			  }
			  if(j > 0){
			    if (a[i][j - 1] == null){
					swap(i,j,i,j - 1);
				}
			  }
			  if(j < a[i].length - 1){
			    if (a[i][j + 1] == null){
					swap(i,j,i,j + 1);
				}
			  }
			  if(i < a.length - 1){
			    if (a[i+1][j] == null){
					swap(i,j,i + 1,j);
				}
			  }
			  return true;
		  }
	   }
	 }
	 return false;
  }
}
