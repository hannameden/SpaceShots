package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import factory.BulletFactory;
import factory.EntityFactory;
import graphics.Assets;
import view.GUI;

public class Player extends Entity {

	private double shootDirection = 0f;
	private EntityFactory bulletFactory = BulletFactory.getInstance();

	public Player() {
		radius = 20;
		diameter = radius * 2;
		entityFront = new Point();
		spawnAtLocation(x = GUI.getWidth() / 2 - diameter, y = GUI.getHeight() / 2 - diameter);
		image = Assets.getInstance().getPlayerImage();
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
		// Use args parameter to shot different types of bullets
		bulletFactory.create(entityFront.x, entityFront.y, null).setMovementDirection((int) shootDirection);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);
		// g2d.fillOval(x, y, diameter, diameter);
		g2d.fillRect(entityFront.x, entityFront.y, 12, 12);

		g2d.fillOval(x, y, diameter, diameter);
		g2d.drawImage(image, x, y, diameter, diameter, null);

		/*
		 * double rotationRequired = Math
		 * .toRadians(-Math.toDegrees(Math.atan2(entityFront.x - x, entityFront.y - y))
		 * + 180); double locationX = image.getWidth() / 2; double locationY =
		 * image.getHeight() / 2; AffineTransform tx =
		 * AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		 * AffineTransformOp op = new AffineTransformOp(tx,
		 * AffineTransformOp.TYPE_BILINEAR);
		 * 
		 * g2d.drawImage(op.filter(image, null), x, y, diameter, diameter, null);
		 */

	}

	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			x = -diameter;
		else if (x + diameter < 0)
			x = GUI.getWidth();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			y = -diameter;
		else if (y + diameter < 0)
			y = GUI.getHeight();
	}

	public void setMovementDirection(MouseEvent e) {
		movementDirection = getAngle(e);
	}

	public void setShootingDirection(MouseEvent e) {
		shootDirection = getAngle(e);
		if (x > e.getX())
			entityFront.x = x - radius / 2 + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));
		else
			entityFront.x = x + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));

		if (y > e.getY())
			entityFront.y = y - radius / 2 + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));
		else
			entityFront.y = y + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));
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

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
