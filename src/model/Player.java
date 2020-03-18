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

import factory.BulletFactory;
import factory.EntityFactory;
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

	public Player() {
		score = new Score();
		radius = 20;
		diameter = radius * 2;
		entityFront = new Point();
		spawnAtLocation(x = GUI.getWidth() / 2 - diameter, y = GUI.getHeight() / 2 - diameter);
		image = Assets.getInstance().getPlayerImage();

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

		// Use args parameter to shot different types of bullets
		bulletFactory.create(entityFront.x, entityFront.y, null).setMovementDirection((int) shootDirection);

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
		g2d.fillOval(x, y, diameter, diameter);
		g2d.fillRect(entityFront.x, entityFront.y, 12, 12);

		g2d.drawImage(image, x, y, diameter, diameter, null);

		scoreList = null;
		scoreList = score.getScore(points);

		g2d.drawImage(scoreList.get(0), GUI.getWidth() - 40, 2, 20, 30, null);

		if (scoreList.size() > 1) 
			g2d.drawImage(scoreList.get(1), GUI.getWidth() - 60, 2, 20, 30, null);

		/*
		 * int x = 40;
		 * 
		 * 
		 * 
		 * for (int i = 0; i < scoreList.size(); i++) {
		 * System.out.println(scoreList.size()); g2d.drawImage(scoreList.get(i),
		 * GUI.getWidth() - x, 2, 20, 30, null); x = x + 20;
		 * 
		 * }
		 * 
		 * // while(scoreList != null ) { // // g2d.drawImage(scoreList.get(index),
		 * GUI.getWidth() - x ,2, 20, 30, null); // } // // int x = 40; // for
		 * (BufferedImage b : scoreList ){ // System.out.println(scoreList.size()); //
		 * // g2d.drawImage(b, GUI.getWidth() - x ,2, 20, 30, null); // x += 50; //
		 * //g2d.drawImage(b, 25, 2, 20, 30, null); // } //
		 * 
		 * /* double rotationRequired = Math
		 * .toRadians(-Math.toDegrees(Math.atan2(entityFront.x - x, entityFront.y - y))
		 * + 180); double locationX = image.getWidth() / 2; double locationY =
		 * image.getHeight() / 2; AffineTransform tx =
		 * AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		 * AffineTransformOp op = new AffineTransformOp(tx,
		 * AffineTransformOp.TYPE_BILINEAR);
		 * 
		 * g2d.drawImage(op.filter(image, null), x, y, diameter, diameter, null);
		 */

	}

	public void checkEdgeCollision() {
		checkEdgeCollisionX();
		checkEdgeCollisionY();
	}

	private void checkEdgeCollisionX() {
		if (x > GUI.getWidth())
			x = -diameter;
		else if (x + diameter < 0)
			x = GUI.getWidth();
	}

	private void checkEdgeCollisionY() {
		if (y > GUI.getHeight())
			y = -diameter;
		else if (y + diameter < 0)
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
			entityFront.x = x - radius / 2 + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));
		else
			entityFront.x = x + radius + (int) (radius * Math.sin(Math.toRadians(shootDirection)));

		if (y > e.getY())
			entityFront.y = y - radius / 2 + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));
		else
			entityFront.y = y + radius + (int) -(radius * Math.cos(Math.toRadians(shootDirection)));
	}

	public double getAngle(MouseEvent e) {
		return -Math.toDegrees(Math.atan2(e.getPoint().x - x, e.getPoint().y - y)) + 180;
	}

	@Override
	public void checkEntityCollisions() {
		// TODO Check asteroid collisions

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
		// TODO Auto-generated method stub

	}
}
