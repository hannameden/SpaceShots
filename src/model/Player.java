package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import view.GUI;

public class Player extends Entity {

	private double shootDirection = 0f;

	private Point playerFront;
	private int radius = 20;
	private int diameter = radius * 2;

	/*
	 * Middle element in xpoints and ypoints represents the front of the spaceship.
	 */
	private int[] xpoints = new int[3];
	private int[] ypoints = new int[3];

	public Player(GUI gui) {

		this.gui = gui;

		xpoints[0] = 0;
		xpoints[1] = 25;
		xpoints[2] = 50;

		ypoints[0] = 50;
		ypoints[1] = 0;
		ypoints[2] = 50;

		// final Point2D.Double centroid = new Point2D.Double((p1.getX() + p2.getX() +
		// p3.getX()) / 3.0, (p1.getY() + p2.getY() + p3.getY()) / 3.0);
		playerFront = new Point();

		x = gui.getWidth() / 2 - diameter;
		y = gui.getHeight() / 2 - diameter;

	}

	public void accelerate() {
		if (speed++ > maxSpeed)
			speed = maxSpeed;
		else if (speed <= maxSpeed)
			speed++;
	}

	public void stopAccelerating() {
		if (speed-- < 0)
			speed = 0;
		else if (speed >= 0)
			speed--;
	}

	public void shoot() {
		new Bullet(playerFront.x, playerFront.y, (int) shootDirection, gui);
	}

	public void update() {
		x += (int) (speed * Math.sin(Math.toRadians(movementDirection)));
		y += (int) -(speed * Math.cos(Math.toRadians(movementDirection)));
		checkEdgeCollision(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.WHITE);
		g2d.drawOval(x, y, diameter, diameter);
	}

	public void checkEdgeCollision(Entity e) {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > gui.getWidth())
			x = -diameter;
		else if (x + diameter < 0)
			x = gui.getWidth();
	}

	private void checkEdgeCollisionY() {
		if (y > gui.getHeight())
			y = -diameter;
		else if (y + diameter < 0)
			y = gui.getHeight();
	}

	public void setMovementDirection(MouseEvent e) {
		movementDirection = getAngle(e);
	}

	public void setShootingDirection(MouseEvent e) {
		shootDirection = getAngle(e);
		if (x > e.getX())
			playerFront.x = x - 10 + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));
		else
			playerFront.x = x + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));

		if (y > e.getY())
			playerFront.y = y - 10 + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));
		else
			playerFront.y = y + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));

	}

	public double getAngle(MouseEvent e) {
		return -Math.toDegrees(Math.atan2(e.getPoint().x - x, e.getPoint().y - y)) + 180;
	}

}
