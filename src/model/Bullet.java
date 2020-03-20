package model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import factory.EntityFactory;
import factory.ExplosionFactory;
import graphics.Assets;
import view.GUI;

public class Bullet extends Entity {

	private EntityFactory explosionFactory = ExplosionFactory.getInstance();

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		image = Assets.getInstance().getLaserGreenImage();
		speed = 8;
		width = image.getWidth() / 2;
		height = image.getHeight() / 2;
		bounds = new EntityBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		double rotationRequired = Math.toRadians(movementDirection);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;

		double diff = Math.abs(image.getWidth() - image.getHeight());
		double unitX = Math.abs(Math.cos(rotationRequired));
		double unitY = Math.abs(Math.sin(rotationRequired));
		double correctUx = unitX;
		double correctUy = unitY;
		if (image.getWidth() < image.getHeight()) {
			correctUx = unitY;
			correctUy = unitX;
		}
		int posAffineTransformOpX = x - (int) (correctUx * diff);
		int posAffineTransformOpY = y - (int) (correctUy * diff);
		AffineTransform at = new AffineTransform();
		at.translate(correctUx * diff, correctUy * diff);
		at.rotate(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(image, null), posAffineTransformOpX, posAffineTransformOpY, null);
		g2d.dispose();
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			destroy();
		else if (x + width < 0)
			destroy();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			destroy();
		else if (y + height < 0)
			destroy();
	}

	@Override
	public void checkEntityCollisions() {
		Entity.getEntities().stream().filter(Asteroid.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				Asteroid asteroid = (Asteroid) e;
				asteroid.shatter();
				explosionFactory.create(e.bounds.getCenter().x - e.width / 2, e.bounds.getCenter().y - e.height / 2,
						null);
				Entity.removeEntity(this);
			}
		});
	}

	@Override
	public void destroy() {
		Entity.removeEntity(this);
	}

}
