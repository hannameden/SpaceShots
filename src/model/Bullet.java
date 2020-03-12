package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import graphics.Assets;
import view.GUI;

public class Bullet extends Entity {

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 8;
		radius = 5;
		diameter = radius * 2;
		image = Assets.getInstance().getLaserGreenImage();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.red);

		g2d.drawImage(image, x, y, null);
		g2d.dispose();

	}

	private BufferedImage rotateImageByDegrees(BufferedImage image, double degrees) {
		double rotationRequired = Math.toRadians(degrees);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		BufferedImage newImage = null;
		op.filter(image, newImage);

		return newImage;
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			destroy();
		else if (x + diameter < 0)
			destroy();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			destroy();
		else if (y + diameter < 0)
			destroy();
	}

	@Override
	public void checkEntityCollisions() {
		Entity.getEntities().stream().filter(Asteroid.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				Asteroid asteroid = (Asteroid) e;
				asteroid.shatter();
				new Explosion(x, y);
				Entity.removeEntity(this);
			}
		});
	}

	@Override
	public void destroy() {
		Entity.removeEntity(this);
	}

}
