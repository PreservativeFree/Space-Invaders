
public class SIPanel extends javax.swing.JPanel implements Mover {
	private final int INIT_X = 75;
	private final int INIT_Y = 75;
	private final int DIAMETER = 60;
	private final int INTERVAL = 40;

	private SI _SI, _SI2, _SI3, _SI4, _SI5, _SI6;

	private boolean isAlive = true;
	private boolean isAlive2 = true;
	private boolean isAlive3 = true;
	private boolean isAlive4 = true;
	private boolean isAlive5 = true;
	private boolean isAlive6 = true;

	private MoveTimer _timer;

	public SIPanel () {
		super();
		_SI = new SI(java.awt.Color.green, this); //the SI CONSTRUCTOR HAS PARAMETERS OF SI(Color, JPANEL)
		_SI2 = new SI(java.awt.Color.green, this);
		_SI3 = new SI(java.awt.Color.green, this);
		_SI4 = new SI(java.awt.Color.green, this);
		_SI5 = new SI(java.awt.Color.green, this);
		_SI6 = new SI(java.awt.Color.green, this);

		_timer =  new MoveTimer(INTERVAL, this); //You don't need to know how MoveTimer works just apply it

		this.setBackground(java.awt.Color.black);

		_SI.setLocation(INIT_X + 120, INIT_Y + 32);
		_SI2.setLocation(INIT_X + 350, INIT_Y +234);
		_SI3.setLocation(INIT_X + 3, INIT_Y + 5);
		_SI4.setLocation(INIT_X + 150, INIT_Y + 150);
		_SI5.setLocation(INIT_X + 123, INIT_Y +240);
		_SI6.setLocation(INIT_X + 100, INIT_Y + 100);

		_SI.setSize(DIAMETER + 10, DIAMETER - 35);
		_SI2.setSize(DIAMETER + 10, DIAMETER - 35);
		_SI3.setSize(DIAMETER + 10, DIAMETER - 35);
		_SI4.setSize(DIAMETER + 10, DIAMETER - 35);
		_SI5.setSize(DIAMETER + 10, DIAMETER - 35);
		_SI6.setSize(DIAMETER + 10, DIAMETER - 35);

		_timer.start();

		addMouseListener(new MyMouseListener()); //Calls this one move() function can run off an interval you set.
	}

	public void move() {

		_SI.move();
		_SI2.move();
		_SI3.move();
		_SI4.move();
		_SI5.move();
		_SI6.move();
		this.repaint();
	}

	public void paintComponent(java.awt.Graphics aBrush) {
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush; //You have to typecast or it doesn't draw
		if (isAlive) {
			_SI.fill(betterBrush); //Methods that come directly from Java directory need a super call
		}
		if(_SI.AWALL()) {
			isAlive = false;
		}

		if (isAlive2) {
			_SI2.fill(betterBrush);
		}
		if(_SI2.AWALL()) {
			isAlive2 = false;
		}

		if (isAlive3) {
			_SI3.fill(betterBrush);
		}
		if(_SI3.AWALL()) {
			isAlive3 = false;
		}

		if (isAlive4) {
			_SI4.fill(betterBrush);
		}
		if(_SI4.AWALL()) {
			isAlive4 = false;
		}

		if (isAlive5) {
			_SI5.fill(betterBrush);
		}
		if(_SI5.AWALL()) {
			isAlive5 = false;
		}

		if (isAlive6) {
			_SI6.fill(betterBrush);
		}
		if(_SI6.AWALL()) {
			isAlive6 = false;
		}
	}

	private class MyMouseListener extends javax.swing.event.MouseInputAdapter {

		private SIPanel _SIpanel; 							 //Need to make a private instance inside your own class

		public void mouseClicked(java.awt.event.MouseEvent e) {
			java.awt.Point p;
			System.out.println("Clicked");
			p = e.getPoint();

			if(_SI.hitBall(p)) {
				_SI.explode();
			}

			if(_SI2.hitBall(p)) {
				_SI2.explode();
			}

			if(_SI3.hitBall(p)) {
				_SI3.explode();
				System.out.println("Wow you killed the Boss!"); //Alien 3 is the boss Alien
			}

			if(_SI4.hitBall(p)) {
				_SI4.explode();
			}
			if(_SI5.hitBall(p)) {
				_SI5.explode();
			}
			if(_SI6.hitBall(p)) {
				_SI6.explode();
			}
		} //end mouseClicked
	}
} //end SIPanel
















