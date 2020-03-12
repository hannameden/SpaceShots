package model.shape;

import java.awt.Point;

public class Rectangle implements Shape {

	private java.awt.Rectangle rectangle;

	public Rectangle(int x, int y, int width, int height) {
		rectangle = new java.awt.Rectangle(x, y, width, height);
	}

	@Override
	public void setLocation(int x, int y) {
		rectangle.setLocation(x, y);
	}

	@Override
	public Point getCenter() {
		Point point = new Point();
		point.setLocation(rectangle.getCenterX(), rectangle.getCenterY());
		return point;
	}

	@Override
	public boolean intersects(Shape shape) {
		return rectangle.intersects(convertShapeToRectangle(shape));
	}

	private java.awt.Rectangle convertShapeToRectangle(Shape shape) {
		return new java.awt.Rectangle((int) shape.getX(), (int) shape.getY(), (int) shape.getWidth(),
				(int) shape.getHeight());
	}

	@Override
	public double getX() {
		return rectangle.getX();
	}

	@Override
	public double getY() {
		return rectangle.getY();
	}

	@Override
	public double getWidth() {
		return rectangle.getWidth();
	}

	@Override
	public double getHeight() {
		return rectangle.getHeight();
	}

	@Override
	public double distanceTo(Point point) {
		double dx = this.getCenter().getX() - point.x;
		double dy = this.getCenter().getY() - point.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

}
