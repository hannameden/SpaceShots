package state;

import java.awt.Graphics;

import model.Player;
import view.GUI;

public class GameState extends State {

	// Game objects, player etc.

	private Player player;

	public GameState(GUI gui) {
		super();
		player = new Player(gui);
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
