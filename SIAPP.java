public class SIAPP extends javax.swing.JFrame {
	public SIAPP (String title) {
		super(title);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

		this.add(new SIPanel());

		this.setVisible(true);

	}

	public static void main (String[] args) {
		SIAPP app = new SIAPP("Space Invaders");
	}
}
