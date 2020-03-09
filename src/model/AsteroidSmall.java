package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import view.GUI;

public class AsteroidSmall extends Entity implements Asteroid {

	private Point asteroidFront;

	public AsteroidSmall() {
		radius = 12;
		diameter = radius * 2;
		speed = 3;
		asteroidFront = new Point();
		spawnAtRandomEdgeLocation();
		setRandomDirection();
	}

	public AsteroidSmall(int x, int y) {
		radius = 12;
		diameter = radius * 2;
		speed = 3;
		asteroidFront = new Point();
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

	private void spawnAtRandomEdgeLocation() {

		int random = randomWithRange(1, 20);

		// Spawn at left or right of screen, vary the y-value.
		if (random <= 10) {
			if (random <= 5) {
				x = 0 - diameter;
			} else {
				x = GUI.getWidth() + diameter;
			}
			y = randomWithRange(0 - diameter, GUI.getHeight() + diameter);
		}
		// Spawn above or below the screen, vary the x-value.
		else {
			if (random <= 15) {
				y = 0 - diameter;
			} else {
				y = GUI.getHeight() + diameter;
			}
			x = randomWithRange(0 - diameter, GUI.getWidth() + diameter);
		}

	}

	private void spawnAtLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	private void setRandomDirection() {
		asteroidFront.x = randomWithRange(0, GUI.getWidth());
		asteroidFront.y = randomWithRange(0, GUI.getHeight());
		movementDirection = -Math.toDegrees(Math.atan2(asteroidFront.x - x, asteroidFront.y - y)) + 180;
	}

	@Override
	public void shatter() {
		Entity.removeEntity(this);
	}

}
