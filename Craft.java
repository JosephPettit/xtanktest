import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.awt.Image;

public class Craft implements Serializable{
	private String craft = "resources/craft.png";

	private double mDy;
	private double mX;
	private double mY;
	private int mR;
	private int mDr;
	transient Image mImage;
	transient ImageIcon ii = new ImageIcon(getClass().getResource(craft));

	public Craft() {
		mImage = ii.getImage();
		mX = 40;
		mY = 60;
		mR = 0;
	}

	public void move() {

		mR = (mR + (mDy < 0 ? -1 * mDr : mDr)) % 360;

		mX += ((mDy) * Math.cos(Math.toRadians(mR)));
		mY += ((mDy) * Math.sin(Math.toRadians(mR)));
		
		//System.out.println("mx = " + mX + ", my = " + mY + ", mr = " + mR);
	}

	public double getX() {
		return mX;
	}

	public double getY() {
		return mY;
	}

	public void setX(double val) {
		mX = val;
	}

	public void setY(double val) {
		mY = val;
	}

	public int getR() {
		return mR;
	}

	public Image getImage() {
		return mImage;
	}

	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			mDy = 1;
			System.out.println("up");
		}

		if (key == KeyEvent.VK_DOWN) {
			mDy = -1;
		}

		if (key == KeyEvent.VK_LEFT) {
			mDr = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			mDr = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
			mDr = 0;
		}
		if ((key == KeyEvent.VK_UP) || (key == KeyEvent.VK_DOWN)) {
			mDy = 0;
		}
	}
}
