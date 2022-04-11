public class MoveTimer extends javax.swing.Timer {

	private Mover _mover;

	public MoveTimer(int anInterval, Mover aMover) {
		super(anInterval, null);
		_mover = aMover;
		this.addActionListener(new MoveListener());
	}

	private class MoveListener implements java.awt.event.ActionListener {

		public void actionPerformed(java.awt.event.ActionEvent e) {
			_mover.move();
		}
	}
}