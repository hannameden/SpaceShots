package model;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Explosion extends Entity {

	private int frameAppearanceCount = 30;

	private float alpha = 0f;

	public Explosion(BufferedImage image, int x, int y) {
		this.x = x;
		this.y = y;
		this.image = image;
	}

	@Override
	public void render(Graphics g) {
		if (frameAppearanceCount > 0) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
			g2d.drawImage(image, x, y, null);
			g2d.dispose();
			alpha += 0.02;
			frameAppearanceCount--;
		} else {
			destroy();
		}

	}

	@Override
	public void checkEdgeCollision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkEntityCollisions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		Entity.removeEntity(this);
	}

}
