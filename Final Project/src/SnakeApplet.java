
import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


public class SnakeApplet extends Applet{
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private SnakeCanvas c;
	
	public void init(){
		c = new SnakeCanvas();
		c.setPreferredSize(new Dimension ((int)screensize.getWidth(),  (int) screensize.getHeight()));
		c.setVisible(true);
		c.setFocusable(true);
		this.add(c);
		this.setVisible(true);
		this.setSize(new Dimension((int)screensize.getWidth(), (int)screensize.getHeight()));
	}
	
	public void paint(Graphics g){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) screensize.getWidth(), (int) screensize.getHeight());
	}
}
