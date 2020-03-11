package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage load(String path) {
		try {
			return ImageIO.read(new File("./assets/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
