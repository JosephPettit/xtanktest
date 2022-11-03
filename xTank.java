import javax.swing.JFrame;

public class xTank extends JFrame {

	private Board board;

	public xTank() {
		add(board = new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setTitle("xTank");
		setResizable(false);
		setVisible(true);
	}

	

	public static void main(String[] args) {
		//new xTank();
	}



	public Board getBoard() {
		return board;
	}



	public void setBoard(Board board) {
		this.board = board;
	}
}
