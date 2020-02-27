package model;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Entity {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected double maxSpeed = 3;
	protected double speed = 0;
	protected double movementDirection = 0f;
	protected Rectangle2D bounds;
	public static List<Entity> entities = new CopyOnWriteArrayList<Entity>();

	public Entity() {
		entities.add(this);
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public static void removeEntity(Entity e) {
		entities.remove(e);
	}

	public static List<Entity> getEntities() {
		return entities;
	}

}
