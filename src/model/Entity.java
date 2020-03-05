package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import view.GUI;

public abstract class Entity {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int radius = 25;
	protected int diameter = radius * 2;
	protected double maxSpeed = 3;
	protected double speed = 0;
	protected double movementDirection = 0f;
	protected Rectangle2D bounds;
	protected GUI gui;
	public static List<Entity> entities = new CopyOnWriteArrayList<Entity>();

	public Entity() {
		entities.add(this);
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public abstract void checkEdgeCollision();

	public abstract void checkEntityCollisions();

	public static void removeEntity(Entity e) {
		entities.remove(e);
	}

	public static List<Entity> getEntities() {
		return entities;
	}

	public static void spawnAsteroids() {

		new java.util.Timer().scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				new Asteroid();
			}
		}, 0, 250);

	}

	protected boolean intersects(Entity e) {
		Point center = new Point(this.x + radius, this.y + radius);
		Point entityCenter = new Point(e.x + radius, e.y + radius);
		return center.distance(entityCenter) < radius;
	}

}
