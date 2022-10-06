import java.awt.Color;


public class FreezeFruit extends Fruit{
	public FreezeFruit(int x,  int y){
		super(x, y);
		int rand = (int)(Math.random()*2);
		if(rand==0){
			setColor(Color.BLUE);
		}else{
			setColor(Color.CYAN);
		}
	}

	@Override
	public void powerUp() {
		if (this.getColor().equals(Color.CYAN)){
			
		}
		else if (this.getColor().equals(Color.BLUE)){
			
		}
	}
}
