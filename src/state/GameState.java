package state;

import java.awt.Graphics;

import model.Entity;
import model.Player;
import view.GUI;
import view.Game;

public class GameState extends State {

	private Game game;
	private Player player;
	private GUI gui;

	private static GameState instance;

	private GameState(GUI gui) {
		player = new Player(gui);
		game = new Game(gui, player);
		this.gui = gui;
		startGame();
	}

	public static GameState getInstance(GUI gui) {
		if (instance == null)
			instance = new GameState(gui);
		return instance;
	}

	@Override
	public void update() {
		Entity.getEntities().forEach(e -> e.update());
	}

	@Override
	public void render(Graphics g) {
		Entity.getEntities().forEach(e -> e.render(g));
	}

	public Player getPlayer() {
		return player;
	}

	public void startGame() {
		gui.getCanvas().setVisible(true);
		game.start();
	}

}
