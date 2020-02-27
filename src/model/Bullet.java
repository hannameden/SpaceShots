package model;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Entity {

	public Bullet(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.width = 10;
		this.height = 10;
	}

	@Override
	public void update() {
		x++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(x, y, width, height);
	}

}
