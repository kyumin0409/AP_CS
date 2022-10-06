import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;


public class Snake {
	private ArrayList<Point> body = new ArrayList<Point>();
	private int direction;
	private Color color;
	
	public Snake(Color c){
		this.body.clear();
		color = c;
		//body.add(p);
	}
	
	public void addTo(Point p){
		body.add(p);
	}
	
	public Point getPoint(int index){
		return body.get(index);
	}
	
	public ArrayList<Point> getBody(){
		return body;
	}
	
	public int size(){
		return body.size();
	}
	
	public Color getColor(){
		return color;
	}
	
	public ArrayList<Point> getBodyMinusHead(){
		ArrayList<Point> headless = new ArrayList<Point>();
		for(int i=1; i<body.size(); i++){
			headless.add(body.get(i));
		}
		return headless;
	}
}
