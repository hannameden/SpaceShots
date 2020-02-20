package state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameState extends State {

	// Game objects, player etc.

	private int x = 0, y = 0;
	private BufferedImage image = null;
	
	public GameState() {
		super();
		try {
			image = ImageIO.read(new File("assets\\rocket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		x++;
		y++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);	

		g.drawImage(image, x, y, 20, 20 ,null);
      
	}

}
