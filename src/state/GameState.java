package state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import model.Player;

public class GameState extends State {
	
	private static GameState instance = null;

	// Game objects, player etc.


	private BufferedImage image = null;
	private int x = 0, y = 0;
	private Player player;

	private GameState() {
		super();
		init();
	}

	public static GameState getInstance() {

		if (instance == null)
			instance = new GameState();
		return instance;
	}
	private void init() {
		player = new Player();
	
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);	
		player.render(g);
	}

	public Player getPlayer() {
		return player;

	}

}
