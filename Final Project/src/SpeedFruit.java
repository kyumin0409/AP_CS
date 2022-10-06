import java.awt.Color;


public class SpeedFruit extends Fruit{
	public SpeedFruit(int x,  int y){
		super(x, y);
		int rand = (int)(Math.random()*2);
		if(rand==0){
			setColor(Color.ORANGE);
		}else{
			setColor(Color.MAGENTA);
		}
	}

	@Override
	public void powerUp() {
		if (this.getColor().equals(Color.ORANGE)){
			
		}
		else if (this.getColor().equals(Color.MAGENTA)){
			
		}
	}
}
