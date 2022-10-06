
import java.awt.Color;
import java.awt.Point;


public abstract class Fruit extends Point{
	private int myX;
	private int myY;
	private Color myColor;
	
	public Fruit(int x, int y){
		myX = x;
		myY = y;
	}
	
	public abstract void powerUp();
	
	public double getX(){
		return myX;
	}
	
	public double getY(){
		 return myY;
	}
	
	public Point getPoint(){
		return new Point(myX, myY);
	}
	
	public Color getColor(){
		return myColor;
	}

	public void setColor(Color c){
		myColor = c;
	}
	
}
