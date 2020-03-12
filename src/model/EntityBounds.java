package model;

import java.awt.Point;
import java.awt.Rectangle;

public class EntityBounds {

	private Rectangle bounds;

	public EntityBounds(int x, int y, int width, int height) {
		bounds = new Rectangle(x, y, width, height);
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

	private Rectangle getBounds() {
		return bounds;
	}

}
