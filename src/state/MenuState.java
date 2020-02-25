package state;

import java.awt.Graphics;

import view.GUI;
import view.Menu;

public class MenuState extends State {

	private Menu menu;
	private GUI gui;

	private static MenuState instance = null;

	private MenuState(GUI gui) {
		this.gui = gui;
		menu = new Menu(gui);
	}

	public static MenuState getInstance(GUI gui) {
		if (instance == null)
			instance = new MenuState(gui);
		return instance;
	}

	public void startGame() {
		GameState.getInstance(gui).startGame();
	}

	public void stopGame() {
		// GameState.getInstance().stopGame();
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

	}

}