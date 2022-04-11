//Development of the actual space invader (SI that we need to make 6 instances of)

public class SI extends SmartEllipse implements Mover { //why not extends extends

	private int _changeX, _changeY;
	private final int MOVE_LEN = 2;

	private javax.swing.JPanel _panel;		//Container is a helpful word
	private javax.swing.Timer _timer;

	private boolean isClicked = false;
	private boolean isAlive = true;			//I thought this was already established but it wasn't need explicit delcaration

	private int nextX;
	private int nextY;

	public SI(java.awt.Color oneColor, javax.swing.JPanel onePanel) {   //java deals with color and javax deals with Panels and containers

		super(oneColor);
		_changeX = MOVE_LEN;
		_changeY = MOVE_LEN;
		_panel = onePanel;

	}

	public void move() { //User defined

		nextX = (int)this.getX() + _changeX;
		nextY = (int)this.getY() + _changeY;

		if(nextX <= this.getMinBoundX()) {							 //Left Side
			_changeX *= -1;
			nextX = this.getMinBoundX();
		}
		else if(nextX >= this.getMaxBoundX()) {						 //Right Side
			_changeX *= -1;
			nextX =  this.getMaxBoundX();
		}

		if(nextY <= this.getMinBoundY()) {							 //Bottom Side same as X
			_changeY *= -1;
			nextY = this.getMinBoundY();
		}
		else if(nextY >= this.getMaxBoundY()) {						 //Top
			_changeY *= -1;
			nextY =  this.getMaxBoundY();
		}

		this.setLocation(nextX, nextY); //myself.setLocation because Ellipses know how to place themselves on a canvas/JPanel

	} //END MOVE

	public int getMinBoundX() { return (int) _panel.getX(); } //panel's Top side
	public int getMinBoundY() { return (int) _panel.getY(); } //panel's bottom side
	public int getMaxBoundX() { return (int) (_panel.getX() + _panel.getWidth() - this.getWidth());}
	public int getMaxBoundY() { return (int) (_panel.getY() + _panel.getHeight() - this.getHeight());}

	public boolean hitBall(java.awt.Point H) { return this.contains(H);}

	public boolean AWALL () {

		if(isClicked) {

			if(nextX <= this.getMinBoundX()) {
				setFillColor(java.awt.Color.black);
				return true;
			}
			else if(nextX >= this.getMaxBoundX()) {
				return true;
			} else if (nextY <= this.getMinBoundY()) {
				return true;
			} else if (nextY >= this.getMaxBoundY()) {
				return true;
			}
		} else
			return false;

			return false;
	}

	public void explode() {
		setFillColor(java.awt.Color.white);
		setSize(100, 100);
		isClicked = true;
	}
}










