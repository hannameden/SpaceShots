package state;

import java.awt.Graphics;

import model.Player;

public class GameState extends State {

	// Game objects, player etc.

	private Player player;

	public GameState() {
		super();
		init();
	}

	private void init() {
		player = new Player();
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

	public Player getPlayer() {
		return player;
	}

}
