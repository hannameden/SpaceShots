package model.shape;

import java.awt.Point;

public class Circle implements Shape {

	private double x, y;
	private int radius;

	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Point getCenter() {
		Point point = new Point();
		point.setLocation(x + radius, y + radius);
		return point;
	}

	@Override
	public boolean intersects(Shape shape) {
		return distanceTo(shape.getCenter()) < radius;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getWidth() {
		return radius * 2;
	}

	@Override
	public double getHeight() {
		return radius * 2;
	}

	@Override
	public double distanceTo(Point point) {
		double dx = this.getCenter().getX() - point.x;
		double dy = this.getCenter().getY() - point.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

}
