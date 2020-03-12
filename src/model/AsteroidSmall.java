package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import graphics.Assets;
import model.shape.Rectangle;
import view.GUI;

public class AsteroidSmall extends Entity implements Asteroid {

	public AsteroidSmall() {
		init();
		spawnAtRandomEdgeLocation();
		setRandomDirection();
	}

	public AsteroidSmall(int x, int y) {
		init();
		spawnAtLocation(x, y);
		setRandomDirection();
	}

	private void init() {
		width = 24;
		height = 24;
		speed = 2.5;
		entityFront = new Point();
		image = Assets.getInstance().getMeteorSmallImage();
		// bounds = new Circle(x, y, radius);
		bounds = new Rectangle(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.WHITE);
		// g2d.fillOval(x, y, diameter, diameter);
		g2d.drawImage(image, x, y, width, height, null);
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			Entity.removeEntity(this);
		else if (x + width < 0)
			Entity.removeEntity(this);
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			Entity.removeEntity(this);
		else if (y + height < 0)
			Entity.removeEntity(this);

	}

	@Override
	public void checkEntityCollisions() {
		Entity.getEntities().stream().filter(Player.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				System.out.println("Asteroid collided with Player :)");
			}
		});
	}

	@Override
	public void destroy() {
		Entity.removeEntity(this);
	}

	@Override
	public void shatter() {
		destroy();
	}

}
