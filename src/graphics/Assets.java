package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static Assets instance;
	private static BufferedImage playerImage;

	private Assets() {

	}

	public static Assets getInstance() {
		if (instance == null) {
			instance = new Assets();
			Assets.init();
		}
		return instance;
	}

	private static void init() {
		// SpriteSheet sheet = new SpriteSheet(ImageLoader.load(path));
		playerImage = ImageLoader.load("./assets/player.png");
	}

	public BufferedImage getPlayerImage() {
		return playerImage;
	}

}
