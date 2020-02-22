package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class Player {

	private int width = 20, height = 20, x = 0, y = 0;
	private Polygon polygon;
	private double angle = 0f;
	private Point point;

	private int[] xpoints = { 0, 100, 50 }, ypoints = { 0, 0, 100 };

	public Player() {
		point = new Point();
		polygon = new Polygon(xpoints, ypoints, 3);
	}

	public void moveUp() {
		y -= 10;
	}

	public void moveDown() {
		y += 10;
	}

	public void moveRight() {
		x += 10;
	}

	public void moveLeft() {
		x -= 10;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) g.create();
		AffineTransform at = new AffineTransform();
		Dimension size = getTriangleSize();
		int x = point.x - (size.width / 2);
		int y = point.y - (size.height / 2);
		at.translate(x, y);
		at.rotate(Math.toRadians(angle), point.x - x, point.y - y);
		g2d.setTransform(at);
		g2d.drawPolygon(polygon);
		// Guide
		g2d.setColor(Color.RED);
		g2d.drawLine(size.width / 2, 0, size.width / 2, size.height / 2);
		g2d.dispose();
	}

	public void adjustFront(MouseEvent e) {
		polygon.xpoints[0] = e.getX();
	}

	protected Dimension getTriangleSize() {
		int maxX = 0;
		int maxY = 0;
		for (int index = 0; index < xpoints.length; index++) {
			maxX = Math.max(maxX, xpoints[index]);
		}
		for (int index = 0; index < ypoints.length; index++) {
			maxY = Math.max(maxY, ypoints[index]);
		}
		return new Dimension(maxX, maxY);
	}

	public void setPoint(MouseEvent e) {
		point = e.getPoint();
	}

}
