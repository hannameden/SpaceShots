package model;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import view.GUI;

public class Player extends Entity {

	private int width = 20, height = 20, x = 0, y = 0;
	private BufferedImage image = null;
	private double shootDirection = 0f;

	private Point playerFront;

	public Player(GUI gui) {
		this.gui = gui;
		radius = 20;
		diameter = radius * 2;
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
		checkEdgeCollision();
	}

	public void render(Graphics g) {

		/*
		 * try { image = ImageIO.read(new File("assets\\rocket.png")); } catch
		 * (IOException e) { System.out.println("oupsie"); //e.printStackTrace(); }
		 * 
		 * //g.setColor(Color.white); g.drawImage(image, x, y, 20, 20 ,null);
		 * 
		 */

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);
		g2d.drawOval(x, y, diameter, diameter);
	}

	public void checkEdgeCollision() {
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

	@Override
	public void checkEntityCollisions() {
		// TODO Check asteroid collisions

	}

	@Override
	public boolean intersects(Entity e) {
		return false;

	}

}
