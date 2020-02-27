package model;

import java.awt.Color;
import java.awt.Graphics;

import view.GUI;

public class Bullet extends Entity {

	private int radius = 5;
	private int diameter = radius * 2;

	public Bullet(int x, int y, int movementDirection, GUI gui) {
		this.x = x;
		this.y = y;
		this.movementDirection = movementDirection;
		this.gui = gui;
		speed = 5;
	}

	@Override
	public void update() {
		x += (int) (speed * Math.sin(Math.toRadians(movementDirection)));
		y += (int) -(speed * Math.cos(Math.toRadians(movementDirection)));
		checkEdgeCollision(this);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(x, y, diameter, diameter);
	}

	@Override
	public void checkEdgeCollision(Entity e) {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > gui.getWidth())
			Entity.removeEntity(this);
		else if (x + diameter < 0)
			Entity.removeEntity(this);
	}

	private void checkEdgeCollisionY() {
		if (y > gui.getHeight())
			Entity.removeEntity(this);
		else if (y + diameter < 0)
			Entity.removeEntity(this);

	}

}
