import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private Timer timer;
	private Craft craft;

	AffineTransform identity = new AffineTransform();
	private GameMapOne gameMap;

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		craft = new Craft();
		timer = new Timer(5, this);
		timer.start();
		gameMap = new GameMapOne();
		add(gameMap);
		// r1 = new Rectangle2D.Double(0, 0, 10, RType.GAME_HEIGHT);
	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		AffineTransform reset = g2d.getTransform();

		g2d.rotate(Math.toRadians(craft.getR()), craft.getX() + 10, craft.getY() + 10);
		g2d.drawImage(craft.getImage(), (int) craft.getX(), (int) craft.getY(), this);

		g2d.setTransform(reset);

		gameMap.paint(g2d);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (moveValid(craft))
			craft.move();
		else {
			craft.setmDr(0);
			craft.setmDx(0);
			craft.setmDy(0);
		}
		// checkCollisions();
		repaint();
	}

	private boolean moveValid(Craft craft) {
		Craft temp = (Craft) craft.clone();
		temp.move();
		for (Rectangle2D wall : gameMap.getWalls()) {
			if (temp.intersects(wall)) {
				System.out.println("Intersection");
				System.out.println(wall);
				System.out.println(craft);
				System.out.println(temp);
				return false;
			}
		}
		return true;
	}

	private void checkCollisions() {
		if (craft.getX() >= RType.GAME_WIDTH - 30) {
			craft.setX(0);
		} else if (craft.getX() <= 0) {
			craft.setX(RType.GAME_WIDTH - 30);
		}

		if (craft.getY() <= 0) {
			craft.setY(500);
		} else if (craft.getY() > 500) {
			craft.setY(0);
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
