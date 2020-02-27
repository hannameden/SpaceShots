package model;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Entity {

	public Bullet(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
		this.direction = direction;
		speed = 5;
	}

	@Override
	public void update() {
		x += (int) (speed * Math.sin(Math.toRadians(direction)));
		y += (int) -(speed * Math.cos(Math.toRadians(direction)));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(x, y, width, height);
	}

}
