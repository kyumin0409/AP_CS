
import java.awt.Color;

public class ShrinkFruit extends Fruit{
	
	//private int x;
	//private int y;
	//private Color c;
	
	
	
	public ShrinkFruit(int x,  int y){
		super(x, y);
		int rand = (int)(Math.random()*2);
		if(rand==0){
			setColor(Color.RED);
		}else{
			setColor(Color.PINK);
		}
	}

	@Override
	public void powerUp() {
		if (this.getColor().equals(Color.PINK)){
			//SnakeCanvas.shrink();
		}
		else if (this.getColor().equals(Color.RED)){
			//SnakeCanvas.shrink();
			//SnakeCanvas.shrink();
		}
	}
	
	
}
