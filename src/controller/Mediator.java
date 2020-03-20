package controller;

import view.GUI;
import view.Game;
import view.Highscore;
import view.Menu;

public class Mediator {

	private GUI gui;
	private Game game;
	private Menu menu;
	private Highscore highscore;

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
		if (game == null) {
			game = new Game(this, gui);
			game.start();
		} else {
			game.resetGame();
		}
	}

	public void resetGame() {
		game.resetGame();
	}

	public void startHighscore() {
		highscore = new Highscore(this, gui);
	}

	public void goToMenu() {
		gui.getCanvas().setVisible(false);
		gui.getContainer().setVisible(true);
	}

}
