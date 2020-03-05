package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Asteroid extends Entity {

	// TODO:
	/*
	 * Skapa Asteroider endast i utkanterna av skärmen. Varierande direction,
	 * beroende av vart asteroiden skapas. Variende storlek på Asteroider. Om man
	 * skjuter en stor asteroids ska den delas upp i mindre asteroider.
	 * 
	 * 
	 */

	private Point asteroidFront;

	public Asteroid() {
		radius = 25;
		diameter = radius * 2;
		speed = 3;
		spawnAtRandomEdgeLocation();
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
		if (x > 800)
			Entity.removeEntity(this);
		else if (x + diameter < 0)
			Entity.removeEntity(this);
	}

	private void checkEdgeCollisionY() {
		if (y > 600)
			Entity.removeEntity(this);
		else if (y + diameter < 0)
			Entity.removeEntity(this);

	}

	public void spawnAtRandomEdgeLocation() {
		asteroidFront = new Point();
		// Set x to left or right of screen, 2

		int random = randomWithRange(1, 20);

		// Spawn at left or right of screen, vary the y-value.
		if (random <= 10) {
			if (random <= 5) {
				x = 0 - diameter;
			} else {
				x = 800 + diameter;
			}
			y = randomWithRange(0 - diameter, 600 + diameter);
		}
		// Spawn above or below the screen, vary the x-value.
		else {
			if (random <= 15) {
				y = 0 - diameter;
			} else {
				y = 600 + diameter;
			}
			x = randomWithRange(0 - diameter, 800 + diameter);
		}

	}

	private int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	private void setRandomDirection() {
		asteroidFront.x = randomWithRange(0, 800);
		asteroidFront.y = randomWithRange(0, 600);
		movementDirection = -Math.toDegrees(Math.atan2(asteroidFront.x - x, asteroidFront.y - y)) + 180;
	}

	@Override
	public void checkEntityCollisions() {

		Entity.getEntities().stream().filter(Player.class::isInstance).forEach(e -> {
			if (this.intersects(e)) {
				System.out.println("Asteroid collided with Player :)");
			}
		});
	}

}
