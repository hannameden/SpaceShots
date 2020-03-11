package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import view.GUI;

public class AsteroidMedium extends Entity implements Asteroid {

	public AsteroidMedium() {
		init();
		spawnAtRandomEdgeLocation();
		setRandomDirection();
	}

	public AsteroidMedium(int x, int y) {
		init();
		spawnAtLocation(x, y);
		setRandomDirection();
	}

	private void init() {
		radius = 25;
		diameter = radius * 2;
		speed = 3;
		entityFront = new Point();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.WHITE);
		g2d.drawOval(x, y, diameter, diameter);
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	@Override
	public void checkEntityCollisions() {
		Entity.getEntities().stream().filter(Player.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				System.out.println("Asteroid collided with Player :)");
			}
		});
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			Entity.removeEntity(this);
		else if (x + diameter < 0)
			Entity.removeEntity(this);
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			Entity.removeEntity(this);
		else if (y + diameter < 0)
			Entity.removeEntity(this);

	}

	@Override
	public void destroy() {
		new AsteroidSmall(x, y);
		new AsteroidSmall(x, y);
		Entity.removeEntity(this);
	}

	@Override
	public void shatter() {
		destroy();
	}

}
