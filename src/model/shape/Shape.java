package model.shape;

import java.awt.Point;

public interface Shape {

	public void setLocation(int x, int y);

	public Point getCenter();

	public boolean intersects(Shape shape);

	public double getX();

	public double getY();

	public double getWidth();

	public double getHeight();

	public double distanceTo(Point point);

}
