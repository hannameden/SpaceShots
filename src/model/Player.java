package model;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import controller.Mediator;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import factory.BulletFactory;
import factory.EntityFactory;
import factory.ExplosionFactory;
import graphics.Assets;
import graphics.ImageLoader;
import view.GUI;

public class Player extends Entity {

	private BufferedImage image = null, image3;
	private double shootDirection = 0f;
	private EntityFactory bulletFactory = BulletFactory.getInstance();

	private int lives = 3;
	static int points = 0;
	private ArrayList<BufferedImage> scoreList = null;
	private Score score;

	private EntityFactory explosionFactory = ExplosionFactory.getInstance();

	public Player() {
		score = new Score();
		image = Assets.getInstance().getPlayerImage();
		width = image.getWidth() / 2;
		height = image.getHeight() / 2;
		entityFront = new Point();
		spawnAtLocation(x = GUI.getWidth() / 2 - width, y = GUI.getHeight() / 2 - height);
		bounds = new EntityBounds(x + width / 2, y + height / 2, width / 2, height / 2);
	}

	public static void addPoint() {
		points++;
	}

	public void accelerate() {
		if (speed++ >= maxSpeed)
			speed = maxSpeed;
		else if (speed <= maxSpeed)
			speed++;
	}

	public void stopAccelerating() {
		if (speed-- < 0)
			speed = 0;
		else if (speed >= 0)
			speed--;

	}

	public void shoot() {

		bulletFactory.create(entityFront.x, entityFront.y, null).setMovementDirection(shootDirection);
	}

	@Override
	public void render(Graphics g) {

		/*
		 * try { image = ImageIO.read(new File("assets\\rocket.png")); } catch
		 * (IOException e) { System.out.println("oupsie"); //e.printStackTrace(); }
		 * 
		 * //g.setColor(Color.white); g.drawImage(image, x, y, 20, 20 ,null);
		 * 
		 */

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.GREEN);

	
		scoreList = null;
		scoreList = score.getScore(points);

		g2d.drawImage(scoreList.get(0), GUI.getWidth() - 40, 2, 20, 30, null);

		if (scoreList.size() > 1) 
			g2d.drawImage(scoreList.get(1), GUI.getWidth() - 60, 2, 20, 30, null);


		double rotationRequired = Math.toRadians(shootDirection);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		double diff = Math.abs(image.getWidth() - image.getHeight());
		double unitX = Math.abs(Math.cos(rotationRequired));
		double unitY = Math.abs(Math.sin(rotationRequired));
		double correctUx = unitX;
		double correctUy = unitY;
		if (image.getWidth() < image.getHeight()) {
			correctUx = unitY;
			correctUy = unitX;
		}
		int posAffineTransformOpX = x - (int) (correctUx * diff);
		int posAffineTransformOpY = y - (int) (correctUy * diff);
		AffineTransform at = new AffineTransform();
		at.translate(correctUx * diff, correctUy * diff);
		at.rotate(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		g2d.drawImage(op.filter(image, null), posAffineTransformOpX, posAffineTransformOpY, null);
		g2d.dispose();

	}

	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			x = -width;
		else if (x + width < 0)
			x = GUI.getWidth();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			y = -height;
		else if (y + height < 0)
			y = GUI.getHeight();
	}

	public void moveUp() {
		movementDirection = 10.0;
	}

	public void setMovementDirection(MouseEvent e) {
		movementDirection = getAngle(e);
	}

	public void setShootingDirection(MouseEvent e) {
		shootDirection = getAngle(e);
		if (x > e.getX())
			entityFront.x = x - width / 2 + width + (int) (width * Math.sin(Math.toRadians(shootDirection)));
		else
			entityFront.x = x + width + (int) (width * Math.sin(Math.toRadians(shootDirection)));

		if (y > e.getY())
			entityFront.y = y - height / 2 + height + (int) -(height * Math.cos(Math.toRadians(shootDirection)));
		else
			entityFront.y = y + height + (int) -(height * Math.cos(Math.toRadians(shootDirection)));
	}

	public double getAngle(MouseEvent e) {
		return -Math.toDegrees(Math.atan2(e.getPoint().x - bounds.getCenter().x, e.getPoint().y - bounds.getCenter().y))
				+ 180;
	}

	@Override
	public void checkEntityCollisions() {

	}

	@Override
	public boolean intersects(Entity e) {
		return false;

	}

	public void pauseGame() {
		// gui.pauseGame();
	}

	public void loseLife() {
		if (lives > 0)
			lives--;
		if (lives == 0)
			Mediator.gameOver();

		System.out.println("losing life!!!!!!!!!!");

	}

	@Override
	public void destroy() {
		explosionFactory.create(x, y, new String[] { "RedExplosion" });
		Entity.removeEntity(this);
		gameOver();

	}

	private void gameOver() {
		System.out.println("GameOver");
	}
}
