
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;

public class Main {
	
	public static void main (String args[]) {
		new MenuFrame("Menu");
	}
}

class MenuButton extends MyButton{
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
class RestartButton extends MyButton{
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
class CloseButton extends MyButton{
	 ProgrammFrame fr;
	 GameModel model;
	 DialogFrame fr1;
	 public CloseButton(String text, int x,int y, int width, int height,ProgrammFrame fr,GameModel model,DialogFrame fr1){
	   super(text,x,y,width,height);
	   setBackground(new Color(0,0,0));
	   this.fr = fr;
	   this.fr1 = fr1;
	   this.model = model;
	   setForeground(new Color(255,255,255));
     }
     public void actionPerformed(ActionEvent e){
		 fr.dispose();
		 fr1.setVisible(false);
         fr1.dispose();
	 }
}
class DialogFrame extends JFrame implements WindowListener{
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
class MenuFrame extends JFrame implements WindowListener{
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


class MyButton extends JButton implements ActionListener{
   AnimationThread anim;
   public MyButton(String text, int x,int y, int width, int height){
	   super(text);
	   setLocation(x,y);
	   setSize(width,height);
	   this.animationFlag = true;
	   addActionListener(this);
   }
   boolean animationFlag;
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
class GameButton extends MyButton{
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
class MyPoint{
  int x;
  int y;
  public MyPoint(int x,int y){
    this.x = x;
    this.y = y;
  }
}
class GameModel{
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
class ProgrammFrame extends JFrame implements WindowListener{
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
class AnimationThread extends Thread{
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
