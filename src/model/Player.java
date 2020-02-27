package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import view.GUI;

public class Player extends Entity {

	private double angle = 0f;
	private Dimension size;
	private Point playerCenter;
	private int startX, startY;
	private Point spaceShipFront;

	/*
	 * Middle element in xpoints and ypoints represents the front of the spaceship.
	 */
	private int[] xpoints = new int[3];
	private int[] ypoints = new int[3];

	public Player(GUI gui) {

		xpoints[0] = 0;
		xpoints[1] = 25;
		xpoints[2] = 50;

		ypoints[0] = 50;
		ypoints[1] = 0;
		ypoints[2] = 50;

		size = getTriangleSize();

		// final Point2D.Double centroid = new Point2D.Double((p1.getX() + p2.getX() +
		// p3.getX()) / 3.0, (p1.getY() + p2.getY() + p3.getY()) / 3.0);
		playerCenter = new Point((xpoints[0] + xpoints[1] + xpoints[2]) / 3,
				(ypoints[0] + ypoints[1] + ypoints[2]) / 3);

	}

	public void accelerate() {
		// TODO: Travel in the direction of the front of the spaceship
		speed++;

	}

	public void stopAccelerating() {
		speed--;
	}

	public void shoot() {
		new Bullet(playerCenter.x, playerCenter.y, (int) angle);
	}

	public void update() {

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		AffineTransform at = new AffineTransform();

		int x = playerCenter.x - (size.width / 2);
		int y = playerCenter.y - (size.height / 2);
		at.translate(x, y);
		at.rotate(Math.toRadians(angle), playerCenter.x - x, playerCenter.y - y);

		g2d.setColor(Color.WHITE);
		g2d.setTransform(at);
		g2d.drawPolygon(xpoints, ypoints, 3);

	}

	private Dimension getTriangleSize() {
		int maxX = 0;
		int maxY = 0;
		for (int index = 0; index < xpoints.length; index++)
			if (xpoints[index] > maxX)
				maxX = xpoints[index];

		for (int index = 0; index < ypoints.length; index++)
			if (ypoints[index] > maxY)
				maxY = ypoints[index];

		return new Dimension(maxX, maxY);
	}

	public void transform(MouseEvent e) {
		angle = -Math.toDegrees(Math.atan2(e.getPoint().x - playerCenter.x, e.getPoint().y - playerCenter.y)) + 180;
	}

}
