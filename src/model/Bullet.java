package model;

import java.awt.Color;
import java.awt.Graphics;

import view.GUI;

public class Bullet extends Entity {

	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 8;
		radius = 5;
		diameter = radius * 2;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, diameter, diameter);
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
				Entity.removeEntity(this);
			}
		});
	}

	@Override
	public void destroy() {
		Entity.removeEntity(this);
	}

}
