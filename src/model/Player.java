package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import factory.BulletFactory;
import factory.EntityFactory;
import graphics.Assets;
import view.GUI;

public class Player extends Entity {

	private double shootDirection = 0f;
	private EntityFactory bulletFactory = BulletFactory.getInstance();

	public Player() {
		image = Assets.getInstance().getPlayerImage();
		width = image.getWidth() / 2;
		height = image.getHeight() / 2;
		entityFront = new Point();
		spawnAtLocation(x = GUI.getWidth() / 2 - width, y = GUI.getHeight() / 2 - height);
		bounds = new EntityBounds(x, y, width, height);
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
		bulletFactory.create(entityFront.x, entityFront.y, null).setMovementDirection(shootDirection);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);
		double rotationRequired = Math.toRadians(shootDirection);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(image, null), x, y, null);
		g2d.dispose();
	}

	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			x = -width;
		else if (x + width < 0)
			x = GUI.getWidth();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			y = -height;
		else if (y + height < 0)
			y = GUI.getHeight();
	}

	public void setMovementDirection(MouseEvent e) {
		movementDirection = getAngle(e);
	}

	public void setShootingDirection(MouseEvent e) {
		shootDirection = getAngle(e);
		if (x > e.getX())
			entityFront.x = x - width / 2 + width + (int) (width * Math.sin(Math.toRadians(shootDirection)));
		else
			entityFront.x = x + width + (int) (width * Math.sin(Math.toRadians(shootDirection)));

		if (y > e.getY())
			entityFront.y = y - height / 2 + height + (int) -(height * Math.cos(Math.toRadians(shootDirection)));
		else
			entityFront.y = y + height + (int) -(height * Math.cos(Math.toRadians(shootDirection)));
	}

	public double getAngle(MouseEvent e) {
		return -Math.toDegrees(Math.atan2(e.getPoint().x - bounds.getCenter().x, e.getPoint().y - bounds.getCenter().y))
				+ 180;
	}

	@Override
	public void checkEntityCollisions() {
		// TODO Check asteroid collisions

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
