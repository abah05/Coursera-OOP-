package GUIPackage;
import processing.core.*;

public class MyDisplay extends PApplet {
	PImage img;
	public void setup() 
	{
		size(600,600);
		this.background(33, 208, 150);
		//img = loadImage("IMG_1853.jpg");
		
	}
	public void draw() 
	{
		//img.resize(100, 100);
		//image(img, 0,0);
		ellipse(width/4,height/4,width/5,height/5);
		
	}
}
