package model;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private int width = 20, height = 20, x = 0, y = 0;

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
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}

}
