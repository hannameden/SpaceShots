package state;

import java.awt.Graphics;

import model.Player;
import view.GUI;
import view.Game;

public class GameState extends State {

	private Game game;
	private Player player;

	private static GameState instance;

	private GameState(GUI gui) {
		player = new Player(gui);
		game = new Game(gui, player);
		startGame();
	}

	public static GameState getInstance(GUI gui) {
		if (instance == null)
			instance = new GameState(gui);
		return instance;
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

	public void startGame() {
		game.start();
	}

}
