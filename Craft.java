import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Image;

public class Craft {
	private String craft = "resources/craft.png";

	private double mDx;
	private double mDy;
	private double mX;
	private double mY;
	private int mR;
	private int mDr;
	private Image mImage;

	public Craft() {
		ImageIcon ii = new ImageIcon(getClass().getResource(craft));
		mImage = ii.getImage();
		mX = 40;
		mY = 60;
		mR = 0;
	}

	public void move() {

		mR = (mR + (mDy < 0 ? -1 * mDr : mDr)) % 360;

		mX += ((mDy) * Math.cos(Math.toRadians(mR)));
		mY += ((mDy) * Math.sin(Math.toRadians(mR)));

		// System.out.println("mx = " + mX + ", my = " + mY + ", mr = " + mR);
	}

	public double getX() {
		return mX;
	}

	public void setX(double x) {
		this.mX = x;
	}

	public double getY() {
		return mY;
	}

	public void setY(double y){
		this.mY = y;
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
			mDx = 0;
			mDy = 0;
		}
	}
}
