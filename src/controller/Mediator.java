package controller;

import view.GUI;
import view.Game;
import view.Menu;

public class Mediator {

	private GUI gui;
	private Game game;
	private Menu menu;

	public Mediator() {

		init();
		// gameover fr player destroy
	}

	public void init() {

		gui = new GUI(this);
	}

	public void initButtons() {

		menu = new Menu(this, gui);
		menu.initButtons();
	}

	public void startGame() {
		
		game = new Game(this);
		game.start();
	}

	public void stop() {
		// game.stop();
		if (game != null)
			game.stopGame();

	}

	public void gameOver(int score) {
	//	game.stop();

		gui.gameoverPopup(score);
	}

	public void goToMenu() {
		
		gui.getCanvas().setVisible(false);
		gui.initMenu();

	}
	public GUI getGui() {
		return gui;
	}

}
