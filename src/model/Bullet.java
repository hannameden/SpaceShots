package model;

import java.awt.Color;
import java.awt.Graphics;

import view.GUI;

public class Bullet extends Entity {

	public Bullet(int x, int y, int movementDirection) {
		this.x = x;
		this.y = y;
		this.movementDirection = movementDirection;
		speed = 5;
		radius = 5;
		diameter = radius * 2;
	}

	@Override
	public void update() {
		x += (int) (speed * Math.sin(Math.toRadians(movementDirection)));
		y += (int) -(speed * Math.cos(Math.toRadians(movementDirection)));
		checkEdgeCollision();
		checkEntityCollisions();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(x, y, diameter, diameter);
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
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
	public void checkEntityCollisions() {
		Entity.getEntities().stream().filter(Asteroid.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				Asteroid asteroid = (Asteroid) e;
				asteroid.shatter();
				Entity.removeEntity(this);
			}
		});
	}

}
