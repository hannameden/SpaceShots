package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static Assets instance;
	private static BufferedImage playerImage;
	private static final int width = 16, height = 16;

	private Assets() {

	}

	public static Assets getInstance() {
		if (instance == null) {
			instance = new Assets();
			init();
		}
		return instance;
	}

	private static void init() {
		// SpriteSheet sheet = new SpriteSheet(ImageLoader.load("path"));
		// playerImage = sheet.crop(0, 0, width, height);
		playerImage = ImageLoader.load("./assets/player.png");
	}

	public BufferedImage getPlayerImage() {
		return playerImage;
	}

}
