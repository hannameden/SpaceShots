package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	private int width = 20, height = 20, x = 0, y = 0;
	private BufferedImage image = null;

	public Player() {

	}

	public void moveUp() {
		y -= 10;
	}

	public void moveDown() {
		y += 10;
	}

	public void moveRight() {
		x += 10;
	}

	public void moveLeft() {
		x -= 10;
	}

	public void render(Graphics g) {
		try {
			image = ImageIO.read(new File("assets\\rocket.png"));
		} catch (IOException e) {
			System.out.println("oupsie");
			//e.printStackTrace();
		}
		
		//g.setColor(Color.white);
		g.drawImage(image, x, y, 20, 20 ,null);
	}

}
