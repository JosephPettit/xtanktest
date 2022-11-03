import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private ArrayList<Craft> crafts = new ArrayList<Craft>();
	//private Craft craft;

	AffineTransform identity = new AffineTransform();

	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		//craft = new Craft();
		timer = new Timer(5, this);
		timer.start();
	}

	public void addCraft(Craft c) {
		crafts.add(c);
	}

	public void paint(Graphics g) {
		super.paint(g);

		while(!crafts.isEmpty()) {
			for(int i = 0; i < crafts.size(); i++) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.rotate(Math.toRadians(crafts.get(i).getR()), crafts.get(i).getX()+10, crafts.get(i).getY()+10);
				g2d.drawImage(crafts.get(i).getImage(), (int)crafts.get(i).getX(), (int)crafts.get(i).getY(), this);
			}
		}

		//Graphics2D g2d = (Graphics2D) g;
		//g2d.rotate(Math.toRadians(craft.getR()), craft.getX()+10, craft.getY()+10);
		//g2d.drawImage(craft.getImage(), (int)craft.getX(), (int)craft.getY(), this);

		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		while(!crafts.isEmpty()) {
			for(int i = 0; i < crafts.size(); i++) {
				crafts.get(i).move();
				repaint();
			}
		}
		//craft.move();
		//repaint();
	}

	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			//craft.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			//craft.keyPressed(e);
		}
	}
}
