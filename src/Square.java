import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;


public class Square extends JComponent{
	 public int x = 40, y = 80, x1 = 40, y1 = 80, counter = 1, widthR = 600, heightR = 500, widthS = 40, heightS = 40;
	int  finishdown = heightR / heightS;
	int stepdown = 1;
	int stepside=1;
	int finishside = widthR / widthS;
	public Rectangle square;
	 
	
	public  Square() {
		
		square= new Rectangle(x,y,widthS,heightS);
	} 
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawString("x=" + x + "  y=" + y, 40, 70);
		g.drawString("counter:" + counter, 200, 70);
		g.setColor(Color.blue);		
		
		g.drawRect(x1, y1, widthR, heightR);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fill(square);
		g2d.draw(square); // this method will update our square each time move is called
	}
	
	public void move() {
		repaint();
		if(stepdown<=finishdown) {
			
			if(stepdown%2==0) {
				
				
				if(stepdown==12) {
					y=y-20;
				}
				counter++;
				y=y+heightS;
				
				left();
				
			}
					
			else {
				
				right();
				counter++;y=y+heightS;
				
				//If the movement is squared
//				if(stepdown>=finishdown)
//				{
//					counter--;y=y-heightS;
//				}
				
			}
			
			
			
		}
		
		
	}
public void left() {
		
		for(int i=1; i<finishside; i++) {
			counter++;
			x=x-widthS;	
		
		}
		stepdown++;	
		
	}
	public void right() {
		
		for(int i=1; i<finishside; i++) {
			
			x=x+widthS;
			counter++;	
		
		}
		stepdown++;
		
	}

}


