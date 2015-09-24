import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria sue;
Bacteria [] colony;
//= {new Bacteria(100,100),new Bacteria(150,150)};
 public void setup()   
 {     
 	size(800,800);
 	sue = new Bacteria (400,400); 
 	colony = new Bacteria[100];
    for (int i=0; i<colony.length; i++)
 	{
 		colony [i] = new Bacteria(400,400);
 	}
 	//initialize bacteria variables here   
 }   
 public void draw()   
 {    
 	background(0);
 	fill(255,255,255,150);
 	ellipse(650,150,100,100);
 	fill(25,0,51);
 	rect(0,400,800,400);
 	fill(250,250,0,80);
 	if (mousePressed ==true)
 		{
 			fill(255,255,0);
 			ellipse(mouseX,mouseY,60,60);
 			background(255);
 			fill(255,255,0);
 			ellipse(650,150,100,100);
 			fill(51,0,102);

 		}
 	fill(255,255,0);
 	ellipse(mouseX,mouseY,60,60);
 	fill(0,0,0);
 	ellipse(mouseX-10,mouseY-10,10,10);
 	ellipse(mouseX+10,mouseY-10,10,10);
 	
 	fill(255,153,153);
 	arc(mouseX,mouseY+30,80,80,PI/8,7*PI/8);
 	fill(255,0,0,60);
 	ellipse(mouseX,mouseY+15,17,12);
 	for (int i=0; i<colony.length; i++)
 	{
 		colony [i].show();
 		colony [i].move();
 	}
     //move and show the bacteria   
 }  
 class Bacteria 
 { 
	 int myX, myY, bacColor; 
	 Bacteria(int x, int y) 
	 {     
	 	myX=x;
	 	myY=y;
	 	bacColor=color(0,(int)(Math.random()*256),(int)(Math.random()*256),150);  
	 } 
	 public void move()
	 {
	 	myX=myX + (int)(Math.random()*10)-5;
	 	myY=myY + (int)(Math.random()*10)-5;
	 	if (myX< mouseX)
	 		myX+=(int)(Math.random()*5)-1;
	 	else
	 	    myX+=(int)(Math.random()*5)-3;
	 	if (myY< mouseY)
	 		myY+=(int)(Math.random()*5)-1;
	 	else
	 	    myY+=(int)(Math.random()*5)-3;
	 		
	 }
	 public void show()
	 {
	 	fill(bacColor);
	 	noStroke();
	 	ellipse(myX, myY, 20,20);
	 }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
