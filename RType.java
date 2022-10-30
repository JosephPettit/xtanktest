import javax.swing.JFrame;

public class RType extends JFrame {

	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * 0.5555);

	public RType() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("R-Type");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RType();
	}
}
