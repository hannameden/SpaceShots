package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {

	private static Assets instance;
	private static BufferedImage playerImage, meteorSmallImage, meteorLargeImage;
	
	private static final int width = 16, height = 16;
	private static ArrayList<BufferedImage> digitList;

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
		meteorSmallImage = ImageLoader.load("./assets/meteorSmall.png");
		meteorLargeImage = ImageLoader.load("./assets/meteorBig.png");

		digitList = new ArrayList<BufferedImage>();
		digitList.add(ImageLoader.load("./assets/digit0.png"));
		digitList.add(ImageLoader.load("./assets/digit1.png"));
		digitList.add(ImageLoader.load("./assets/digit2.png"));
		digitList.add(ImageLoader.load("./assets/digit3.png"));
		digitList.add(ImageLoader.load("./assets/digit4.png"));
		digitList.add(ImageLoader.load("./assets/digit5.png"));
		digitList.add(ImageLoader.load("./assets/digit6.png"));
		digitList.add(ImageLoader.load("./assets/digit7.png"));
		digitList.add(ImageLoader.load("./assets/digit8.png"));
		digitList.add(ImageLoader.load("./assets/digit9.png"));

	}

	public BufferedImage getPlayerImage() {
		return playerImage;
	}

	public BufferedImage getMeteorSmallImage() {
		return meteorSmallImage;
	}

	public BufferedImage getMeteorLargeImage() {
		return meteorLargeImage;
	}

	public ArrayList<BufferedImage> getDigitList() {
		return digitList;
	}

}
