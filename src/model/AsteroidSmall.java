package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import view.GUI;

public class AsteroidSmall extends Entity implements Asteroid {

	public AsteroidSmall() {
		radius = 12;
		diameter = radius * 2;
		speed = 3;
		entityFront = new Point();
		spawnAtRandomEdgeLocation();
		setRandomDirection();
	}

	public AsteroidSmall(int x, int y) {
		radius = 12;
		diameter = radius * 2;
		speed = 3;
		entityFront = new Point();
		spawnAtLocation(x, y);
		setRandomDirection();
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
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.WHITE);
		g2d.drawOval(x, y, diameter, diameter);
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
		Entity.getEntities().stream().filter(Player.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				System.out.println("Asteroid collided with Player :)");
			}
		});
	}

	private void spawnAtLocation(int x, int y) {
		this.x = x;
		this.y = y;
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
