
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SnakeCanvas extends Canvas implements Runnable, KeyListener{
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private final int BOX_HEIGHT = 15;
	private final int BOX_WIDTH = 15;
	private final int GRID_HEIGHT = (int)(screensize.getHeight() - screensize.getHeight()*.95);
	private final int GRID_WIDTH = (int) (screensize.getWidth() - screensize.getWidth()*.9330);
	
	private Snake snake;
	private Snake snake2;
	
	private Fruit fruit1;
	private Fruit fruit2;
	private Fruit fruit3;
	private Fruit fruit4;
	
	private int direction = Direction.NO_DIRECTION;
	private int direction2 = Direction.NO_DIRECTION;
	
	private Thread runThread;
	
	private Graphics globalGraphics;
	
	private boolean isPlaying = true;
	
	public void init(){
		fruit1 = new FreezeFruit(32, 13);
		fruit2 = new GrowFruit(64, 13);
		fruit3 = new ShrinkFruit(32, 26);
		fruit4 = new SpeedFruit(64, 26);
	}
	
	public void paint(Graphics g){
		System.out.println("paint method");
		
		if(runThread == null){
			System.out.println("first if in paint");
			this.setPreferredSize(new Dimension(640, 480));
			this.addKeyListener(this);
			runThread = new Thread(this);
			runThread.start();
		}
		globalGraphics = g.create();
		g.clearRect(0,0, BOX_WIDTH * GRID_WIDTH, BOX_HEIGHT * GRID_HEIGHT);

		//g.create(0,0, BOX_WIDTH * GRID_WIDTH, BOX_HEIGHT * GRID_HEIGHT);
		//g.clearRect(0,0, BOX_WIDTH * GRID_WIDTH, BOX_HEIGHT * GRID_HEIGHT);
		if (snake == null || snake2 == null){
			System.out.println("second if in paint");
			//snake = new ArrayList<Point>();
			//snake2 = new ArrayList<Point>();
			snake = new Snake(Color.GREEN);
			snake2 = new Snake(Color.BLUE);
			//thread1 = new Thread();
			System.out.println("generate? 1");
			GenerateDefaultSnake();
			System.out.println("generate? 2");
		}
		System.out.println("Painting");
		drawGrid(g);
		drawSnake(g);
		//drawFruit(g, placeFruit());
	}

	public void GenerateDefaultSnake(){
		System.out.println("generate default snake method");
		snake2.getBody().clear(); 
		//System.out.println("Snake's size = " + snake.size());
		//System.out.println("Snake2's size = " + snake2.size());
		snake2.addTo(new Point(0,4));
		snake2.addTo(new Point(0,3));
		snake2.addTo(new Point(0,2));
		snake2.addTo(new Point(0,1));
		snake2.addTo(new Point(0,0));
		System.out.println(snake2.getBody());
		//System.out.println("Snake's new size = " + snake.size());
		//System.out.println("Snake's body = " + snake.getBody());
		//System.out.println("First Point in Snake = " + snake.getPoint(0));
		snake.getBody().clear(); 
		snake.addTo(new Point(20, 29));
		snake.addTo(new Point(20, 30));
		snake.addTo(new Point(20, 31));
		snake.addTo(new Point(20, 32));
		snake.addTo(new Point(20, 33));
		System.out.println(snake.getBody());
		/*
		snake.addTo(new Point(127, 49));
		snake.addTo(new Point(127, 50));
		snake.addTo(new Point(127, 51));
		snake.addTo(new Point(127, 52));
		snake.addTo(new Point(127, 53));*/
		//System.out.println("Snake2's new size = " + snake2.size());
		//System.out.println("Snake2's middle Point = " + snake2.getPoint(1));
		direction = Direction.NO_DIRECTION;
		direction2 = Direction.NO_DIRECTION;
	}
	
	/*public Fruit placeFruit(){
		Color defaultC = Color.BLACK;
		int cr = (int) (Math.random() * 4);
		int xr = (int) (Math.random() * GRID_WIDTH);
		int yr = (int) (Math.random() * GRID_HEIGHT);
		
		Fruit[] fruits = {new GrowFruit(xr, yr, defaultC), new ShrinkFruit(xr, yr, defaultC), new FreezeFruit(xr, yr, defaultC), new SpeedFruit(xr, yr, defaultC)};
		
		Fruit f = fruits[cr];
		while (snake.getBody().contains(f) || snake2.getBody().contains(f)){
			 cr = (int) (Math.random() * 4);
			 xr = (int) (Math.random() * GRID_WIDTH);
			 yr = (int) (Math.random() * GRID_HEIGHT);
			 f = fruits[cr];
		}
		return f;
	}*/
	private Point randPoint(){
		int xr = (int) (Math.random() * GRID_WIDTH);
		int yr = (int) (Math.random() * GRID_HEIGHT);
		Point p = new Point(xr, yr);
		return p;
	}
	
	private boolean isPointEmpty(Point p){
		if(snake.getBody().contains(p) || snake2.getBody().contains(p))
			return false;
		else if(p.equals(fruit1.getPoint()) || p.equals(fruit2.getPoint()) || p.equals(fruit3.getPoint()) || p.equals(fruit4.getPoint()))
			return false;
		else
			return true;
	}
	
	public void drawGrid(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(0,0, GRID_WIDTH * BOX_WIDTH, GRID_HEIGHT * BOX_HEIGHT);
		for (int x = BOX_WIDTH; x < GRID_WIDTH * BOX_WIDTH; x += BOX_WIDTH){
			g.drawLine(x, 0 , x, BOX_HEIGHT * GRID_HEIGHT);
		}
		for (int y = BOX_HEIGHT; y < GRID_HEIGHT * BOX_HEIGHT; y += BOX_HEIGHT){
			g.drawLine(0, y, GRID_WIDTH * BOX_WIDTH, y);
		}
	}
	
	 public void drawSnake(Graphics g){
		 g.setColor(snake.getColor());
		 for (Point p : snake.getBody()){
			 g.fillRect(p.x * BOX_WIDTH, p.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);	
		 }
		 g.setColor(snake2.getColor());
		 for (Point p : snake2.getBody()){
			 g.fillRect(p.x * BOX_WIDTH, p.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);	
		 }
		 g.setColor(Color.BLACK); 
	 }
	 
	public void drawFruit(Graphics g, Fruit f){
		g.setColor(f.getColor());
		g.fillOval(f.x * BOX_WIDTH, f.y * BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
		g.setColor(Color.BLACK);
	}
	public void move(){
		System.out.println("move method");
		if(direction == Direction.NO_DIRECTION && direction2 == Direction.NO_DIRECTION)
			return;
		else if(direction == Direction.NO_DIRECTION){
			if(direction2 == Direction.SOUTH)
				direction = Direction.NORTH;
			else
				direction = Direction.WEST;
		}
		else if(direction2 == Direction.NO_DIRECTION){
			if(direction == Direction.NORTH)
				direction2 = Direction.SOUTH;
			else
				direction2 = Direction.EAST;
		}
		Point head = snake.getPoint(0);
		Point newPoint = head;
		Point head2 = snake2.getPoint(0);
		Point newPoint2 = head2;
		switch (direction) {
		case Direction.NORTH:
			newPoint = new Point(head.x, head.y - 1);
			break;
		case Direction.SOUTH:
			newPoint = new Point(head.x, head.y + 1);
			break;
		case Direction.EAST:
			newPoint = new Point(head.x + 1, head.y);
			break;
		case Direction.WEST:
			newPoint = new Point(head.x - 1, head.y);
			break;
		}
		switch (direction2) {
		case Direction.NORTH:
			newPoint2 = new Point(head2.x, head2.y - 1);
			break;
		case Direction.SOUTH:
			newPoint2 = new Point(head2.x, head2.y + 1);
			break;
		case Direction.EAST:
			newPoint2 = new Point(head2.x + 1, head2.y);
			break;
		case Direction.WEST:
			newPoint2 = new Point(head2.x - 1, head2.y);
			break;
		}
		if (this.direction != Direction.NO_DIRECTION)  
			snake.getBody().remove(snake.size() - 1);
		if (this.direction2 != Direction.NO_DIRECTION)  
			snake2.getBody().remove(snake2.size() - 1);
		
		//snake.getBody().add(0, newPoint);
		//snake2.getBody().add(0, newPoint2);
		

		//for (Fruit f: fruits){
		//	if(newPoint.equals(f))
		//		placeFruit();
		//}
		/*if(newPoint.equals(fruit))
			grow(snake);
		if(newPoint2.equals(fruit))
			grow(snake2);
			*/
		if ((newPoint.x < 0 || newPoint.x > GRID_WIDTH - 1) || (newPoint2.x < 0 || newPoint2.x > GRID_WIDTH - 1)){
			//we went out of bounds, reset the game
			System.out.println("1st if");
			isPlaying = false;
			return;
		}
		else if ((newPoint.y < 0 || newPoint.y > GRID_HEIGHT - 1) || (newPoint2.y < 0 || newPoint2.y > GRID_HEIGHT - 1)){
			//we went out of bounds, reset the game
			System.out.println("2nd if");
			isPlaying = false;
			return;
		}
		//else if ((snake.getBodyMinusHead().contains(newPoint)) || (snake2.getBodyMinusHead().contains(newPoint2))){
		else if ((snake.getBody().contains(newPoint)) || (snake2.getBody().contains(newPoint2))){
			//we ran into ourselves, reset the game
			if (direction != Direction.NO_DIRECTION || direction2 != Direction.NO_DIRECTION){
			System.out.println("3rd if");
			System.out.println(isPlaying);
			isPlaying = false;
			System.out.println(isPlaying);
			return;
			}
		}
		else if (newPoint.equals(newPoint2)){
			System.out.print("4th if. Tie Game");
			isPlaying = false;
			return;
		}
		else if ((snake.getBody().contains(newPoint2))){
			System.out.println("5th if");
			isPlaying = false;
			return;
		}
		else if (snake2.getBody().contains(newPoint)){
			System.out.println("6th if");
			isPlaying = false;
			return;
		}
		
		//if we reach this point in code, we're still good.
		snake.getBody().add(0, newPoint);
		snake2.getBody().add(0, newPoint2);
		System.out.println("move done");
	}
	
	/*public void update(Graphics g){
		//this it the default update method which will contain our double buffering
		Graphics offScreenGraphics; // these are the graphics we will use to draw offscreen.
		BufferedImage offscreen = null;
		Dimension d = this.getSize();
		
		offscreen = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
		offScreenGraphics = offscreen.getGraphics();
		offScreenGraphics.setColor(this.getBackground());
		offScreenGraphics.fillRect(0,0, d.width, d.height);
		offScreenGraphics.setColor(this.getForeground());
		paint(offScreenGraphics);
		
		//flip
		g.drawImage(offscreen, 0 , 0, this);
	}*/
	
	public void grow(Snake sss){
		Point newPoint = sss.getPoint(sss.size() - 1);
		Point addPoint = (Point) newPoint.clone();
		
		switch (direction) {
		case Direction.NORTH:
			newPoint = new Point(newPoint.x, newPoint.y - 1);
			break;
		case Direction.SOUTH:
			newPoint = new Point(newPoint.x, newPoint.y + 1);
			break;
		case Direction.EAST:
			newPoint = new Point(newPoint.x + 1, newPoint.y);
			break;
		case Direction.WEST:
			newPoint = new Point(newPoint.x - 1, newPoint.y);
			break;
		}
		sss.addTo(addPoint);
	}
	
	public void shrink(){
		
	}
	
	public void run() {
		/*BufferedImage graphics = null;
		graphics = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
		globalGraphics = graphics.getGraphics();
		//globalGraphics.drawRect(0,0,BOX_WIDTH, BOX_HEIGHT);
		 */
		repaint();
		//init();
		System.out.println("About to loop");
		while (true){
			if (isPlaying){
			System.out.println("beginning of while loop: " + isPlaying);
			//paint(globalGraphics);
			//update(globalGraphics);
			repaint();
			move();
			try{
				Thread.currentThread();
				Thread.sleep(100);
			} catch(Exception exc){
				exc.printStackTrace();
			}
		}
			else {
				System.out.println("at the end of while loop: " + isPlaying);
				continue;
		}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
		case KeyEvent.VK_UP:
			if (direction != Direction.SOUTH)
				direction = Direction.NORTH;
			break;
		case KeyEvent.VK_DOWN:
			if (direction != Direction.NORTH)
				direction = Direction.SOUTH;
			break;
		case KeyEvent.VK_RIGHT:
			if (direction != Direction.WEST)
				direction = Direction.EAST;
			break;
		case KeyEvent.VK_LEFT:
			if (direction != Direction.EAST)
				direction = Direction.WEST;
			break;
		case KeyEvent.VK_SPACE:
			if (!isPlaying){
			GenerateDefaultSnake();
			repaint();
			isPlaying = true;
			break;
			}
		}
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			if (direction2 != Direction.SOUTH)
				direction2 = Direction.NORTH;
			break;
		case KeyEvent.VK_S:
			if (direction2 != Direction.NORTH)
				direction2 = Direction.SOUTH;
			break;
		case KeyEvent.VK_D:
			if (direction2 != Direction.WEST)
				direction2 = Direction.EAST;
			break;
		case KeyEvent.VK_A:
			if (direction2 != Direction.EAST)
				direction2 = Direction.WEST;
			break;	
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
