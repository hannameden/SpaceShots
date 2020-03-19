package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import graphics.Assets;
import view.GUI;

public class AsteroidLarge extends Entity implements Asteroid {

	public AsteroidLarge() {
		init();
		spawnAtRandomEdgeLocation();
		setRandomDirection();
	}

	public AsteroidLarge(int x, int y) {
		init();
		spawnAtLocation(x, y);
		setRandomDirection();
	}

	private void init() {
		width = 90;
		height = 90;
		speed = 1.5;
		entityFront = new Point();
		image = Assets.getInstance().getMeteorSmallImage();
		bounds = new EntityBounds(x, y, width, height);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.WHITE);
		g2d.drawImage(image, x, y, width, height, null);
	}

	@Override
	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			Entity.removeEntity(this);
		else if (x + width < 0)
			Entity.removeEntity(this);
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			Entity.removeEntity(this);
		else if (y + height < 0)
			Entity.removeEntity(this);

	}

	@Override
	public void checkEntityCollisions() {

	}

	@Override
	public void destroy() {

		Player.addPoint();

		new AsteroidMedium(bounds.getCenter().x, bounds.getCenter().y);
		new AsteroidMedium(bounds.getCenter().x, bounds.getCenter().y);

		Entity.removeEntity(this);
	}

	@Override
	public void shatter() {
		destroy();
	}

}
