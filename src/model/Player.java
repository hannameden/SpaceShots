package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import view.GUI;

public class Player {

	private double angle = 0f;
	private Dimension size;
	private Point playerCenter;

	/*
	 * Middle element in xpoints and ypoints represents the front of the spaceship.
	 */
	private int[] xpoints = new int[3];
	private int[] ypoints = new int[3];

	public Player(GUI gui) {

		/*
		 * xpoints[0] = screenWidth / 2; xpoints[1] = screenWidth / 2 + 25; xpoints[2] =
		 * screenWidth / 2 + 50;
		 * 
		 * ypoints[0] = screenHeight / 2 + 50; ypoints[1] = screenHeight / 2; ypoints[2]
		 * = screenHeight / 2 + 50;
		 */

		xpoints[0] = 0;
		xpoints[1] = 25;
		xpoints[2] = 50;

		ypoints[0] = 50;
		ypoints[1] = 0;
		ypoints[2] = 50;

		size = getTriangleSize();
		playerCenter = new Point(gui.getWidth() / 2 + size.width + size.width / 2, gui.getHeight() / 2 + size.height);

	}

	public void moveUp() {

	}

	public void moveDown() {

	}

	public void moveRight() {

	}

	public void moveLeft() {

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
		// Guide
		g2d.setColor(Color.GREEN);
		g2d.drawLine(size.width / 2, 0, size.width / 2, size.height / 2);
		g2d.dispose();
	}

	private Dimension getTriangleSize() {
		int maxX = 0;
		int maxY = 0;
		for (int index = 0; index < xpoints.length; index++) {
			if (xpoints[index] > maxX)
				maxX = xpoints[index];
		}
		for (int index = 0; index < ypoints.length; index++) {
			if (ypoints[index] > maxY)
				maxY = ypoints[index];
		}
		return new Dimension(maxX, maxY);
	}

	public void transform(MouseEvent e) {
		angle = -Math.toDegrees(Math.atan2(e.getPoint().x - playerCenter.x, e.getPoint().y - playerCenter.y)) + 180;
	}

}
