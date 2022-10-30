import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private Craft craft;

	AffineTransform identity = new AffineTransform();

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		craft = new Craft();
		timer = new Timer(5, this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(craft.getR()), craft.getX()+10, craft.getY()+10);
		g2d.drawImage(craft.getImage(), (int)craft.getX(), (int)craft.getY(), this);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		craft.move();
		checkCollisions(false);
		repaint();
	}

	private void checkCollisions(boolean scoobyDooLogic) {
		if(scoobyDooLogic){
			if(craft.getX() >= RType.GAME_WIDTH -30){
				craft.setX(RType.GAME_WIDTH - 30);
			}
			else if(craft.getX() <= 0){
				craft.setX(0);
			}

			if(craft.getY() <= 0){
				craft.setY(0);
			}
			else if(craft.getY() > 500){
				craft.setY(500 );
			}
		}
		else{
			if(craft.getX() >= RType.GAME_WIDTH -30){
				craft.setX(0);
			}
			else if(craft.getX() <= 0){
				craft.setX(RType.GAME_WIDTH - 30);
			}

			if(craft.getY() <= 0){
				craft.setY(500);
			}
			else if(craft.getY() > 500){
				craft.setY(0 );
			}
		}
	}

	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
	}
}
