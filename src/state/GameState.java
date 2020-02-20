package state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Player;

public class GameState extends State {

	// Game objects, player etc.


	private BufferedImage image = null;
	private int x = 0, y = 0;
	private Player player;

	public GameState() {
		super();
		init();
	}

	private void init() {
		player = new Player();
		try {
			image = ImageIO.read(new File("assets\\rocket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);	

		g.drawImage(image, x, y, 20, 20 ,null);
      

		player.render(g);
	}

	public Player getPlayer() {
		return player;

	}

}
