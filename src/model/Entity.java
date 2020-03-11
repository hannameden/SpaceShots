package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import view.GUI;

public abstract class Entity {

	protected int x;
	protected int y;
	protected int radius;
	protected int diameter = radius * 2;
	protected double maxSpeed = 3;
	protected double speed = 0;
	protected double movementDirection = 0f;
	protected Point entityFront;
	public static List<Entity> entities = new CopyOnWriteArrayList<Entity>();

	public Entity() {
		entities.add(this);
	}

	public abstract void render(Graphics g);

	public abstract void checkEdgeCollision();

	public abstract void checkEntityCollisions();

	public abstract void destroy();

	public void update() {
		checkEdgeCollision();
		checkEntityCollisions();
		updateCoordinates();
	};

	public void updateCoordinates() {
		x += (int) (speed * Math.sin(Math.toRadians(movementDirection)));
		y += (int) -(speed * Math.cos(Math.toRadians(movementDirection)));
	}

	public static void removeEntity(Entity e) {
		entities.remove(e);
	}

	public static List<Entity> getEntities() {
		return entities;
	}

	protected boolean intersects(Entity e) {
		double dx = this.x - e.x;
		double dy = this.y - e.y;
		return radius > e.radius ? Math.sqrt(dx * dx + dy * dy) < radius : Math.sqrt(dx * dx + dy * dy) < e.radius;
	}

	public void setMovementDirection(double movementDirection) {
		this.movementDirection = movementDirection;
	}

	protected void setRandomDirection() {
		entityFront.x = randomWithRange(0, GUI.getWidth());
		entityFront.y = randomWithRange(0, GUI.getHeight());
		movementDirection = -Math.toDegrees(Math.atan2(entityFront.x - x, entityFront.y - y)) + 180;
	}

	protected void spawnAtLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected void spawnAtRandomEdgeLocation() {

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

	private static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

}
