
import java.awt.Color;
import java.awt.Point;


public class GrowFruit extends Fruit{
	
	private int x;
	private int y;
	private Color c;
	
	public GrowFruit(int x, int y){
		super(x,y);
		int rand = (int)(Math.random()*2);
		if(rand==0){
			setColor(Color.GREEN);
		}else{
			setColor(Color.GREEN.darker());
		}
	}

	@Override
	public void powerUp() {
		if (this.getColor().equals(Color.GREEN)){
			//SnakeCanvas.grow();
		}
		else if (this.getColor().equals(Color.GREEN.darker())){
			//SnakeCanvas.grow();
			//SnakeCanvas.grow();	
		}
			
		
	}

}
