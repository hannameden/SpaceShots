package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	private int width = 16, height = 16;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage crop(int col, int row, int w, int h) {
		return sheet.getSubimage(col * width, row * height, w, h);
	}

}
