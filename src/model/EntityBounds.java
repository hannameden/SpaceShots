package model;

import java.awt.Point;
import java.awt.Rectangle;

public class EntityBounds {

	private Rectangle bounds;
	public int width, height, x, y;

	public EntityBounds(int x, int y, int width, int height) {
		bounds = new Rectangle(x, y, width, height);
		this.width = width;
		this.height = height;
		this.x = bounds.x;
		this.y = bounds.y;
	}

	public void setLocation(int x, int y) {
		bounds.setLocation(x, y);
	}

	public Point getCenter() {
		Point point = new Point();
		point.setLocation(bounds.getCenterX(), bounds.getCenterY());
		return point;
	}

	public boolean intersects(EntityBounds entityBounds) {
		return bounds.intersects(entityBounds.getBounds());
	}

	public Rectangle getBounds() {
		return bounds;
	}

}
