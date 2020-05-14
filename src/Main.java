
//Step 1: import packages
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Step 2: Create subclass of frame
public class Main extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x = 40, y = 40, x1 = 40, y1 = 40, counter = 1, widthR = 600, heightR = 500, widthS = 40, heightS = 40;
	double finishdown = Math.round((double) heightR / (double) heightS);
	int stepdown = 1;
	int stepside = 1;
	double finishside = Math.round((double) widthR / (double) widthS);

	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawString("x=" + x + "  y=" + y, 45, 20);
		g.drawString("counter:" + counter, 200, 20);
		g.drawString("Stepdown:" + stepdown, 300, 20);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.blue);
		g.drawRect(x1, y1, widthR, heightR);
		Rectangle2D square = new Rectangle2D.Double(x, y, widthS, widthS);
		g2.setColor(Color.white);
		g2.fill(square);

	}

	public void left() {

		for (int i = 1; i < finishside; i++) {

			counter++;
			x = x - widthS;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			repaint();
		}
	}

	public void right() {

		for (int i = 1; i < finishside; i++) {

			counter++;
			x = x + widthS;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}
			repaint();
		}
	}

	public void down() {
		y = y + heightS;
		
		counter++;
		stepdown++;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		repaint();
	}

	public void Animation() {
		while (stepdown <= finishdown) {

			if (stepdown == finishdown) {

				y = y - 20;
				right();
				return;
			}
			if (stepdown % 2 == 0) {

				left();
				down();

			} else {

				right();
				down();

			}
		}
	}

	public static void main(String[] args) {

		Main s = new Main();
		JFrame f = new JFrame();
		f.add(s);

		f.setVisible(true);
		f.setSize(800, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		s.Animation();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
