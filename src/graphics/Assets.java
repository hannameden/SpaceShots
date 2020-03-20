package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets {

	private static Assets instance;
	
	private static ArrayList<BufferedImage> digitList;

	private static BufferedImage playerImage, meteorSmallImage, meteorLargeImage, lifeImage, laserGreenImage,
			laserGreenExplosionImage, laserRedImage, laserRedExplosionImage;
	private static BufferedImage[] numbers = new BufferedImage[10];
	private static final int width = 96, height = 154;


	private Assets() {
		init();
	}

	public static Assets getInstance() {
		if (instance == null) {
			instance = new Assets();
		}
		return instance;
	}

	private static void init() {
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

		lifeImage = ImageLoader.load("./assets/life.png");
		laserGreenImage = ImageLoader.load("./assets/laserGreen.png");
		laserGreenExplosionImage = ImageLoader.load("./assets/laserGreenShot.png");
		laserRedImage = ImageLoader.load("./assets/laserRed.png");
		laserRedExplosionImage = ImageLoader.load("./assets/laserRedShot.png");

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
	public BufferedImage getLifeImage() {
		return lifeImage;
	}

	public BufferedImage getLaserGreenImage() {
		return laserGreenImage;
	}

	public BufferedImage getLaserGreenExplosionImage() {
		return laserGreenExplosionImage;
	}

	public BufferedImage getLaserRedImage() {
		return laserRedImage;
	}

	public BufferedImage getLaserRedExplosionImage() {
		return laserRedExplosionImage;
	}

}
