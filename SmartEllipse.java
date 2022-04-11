public class SmartEllipse extends java.awt.geom.Ellipse2D.Double {
	private java.awt.Color _borderColor, _fillColor;
	private int _rotation;
	private final int STROKE_WIDTH = 8;

	public SmartEllipse(java.awt.Color oneColor) {
		_borderColor = oneColor;
		_fillColor = oneColor;
		_rotation = 0;

	}

	public void setBorderColor(java.awt.Color oneColor) {_borderColor = oneColor;}
	public void setFillColor(java.awt.Color oneColor) {_fillColor = oneColor;}
	public void setRotation(int oneRotation) { _rotation = oneRotation;}

	public void setLocation(double x, double y) {this.setFrame(x, y, this.getWidth(), this.getHeight());}

	public void setSize(int aWidth, int aHeight) {
		this.setFrame(this.getX(), this.getY(), aWidth, aHeight);
	}

	public void move(int aChangeInX, int aChangeInY) {
		this.setFrame((int)this.getX() + aChangeInX, (int)this.getY() + aChangeInY, this.getWidth(), this.getHeight());
	}

	public void fill(java.awt.Graphics2D GreatBrush) {
		java.awt.Color savedColor = GreatBrush.getColor();
		GreatBrush.setColor(_fillColor);
		GreatBrush.fill(this);
		GreatBrush.setColor(savedColor);
	}

	public void draw(java.awt.Graphics2D myBrush) {
		java.awt.Color savedColor = myBrush.getColor();
		myBrush.setColor(_borderColor);
		java.awt.Stroke savedStroke = myBrush.getStroke();
		myBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
		myBrush.draw(this);
		myBrush.setStroke(savedStroke);
		myBrush.setColor(savedColor);
	}
}
