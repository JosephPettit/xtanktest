import javax.swing.JFrame;

public class xTank extends JFrame {
	public xTank() {
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("xTank");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new xTank();
	}
}
