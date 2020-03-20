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
		
		game = new Game(this, gui);
		game.start();
	}

	public void stop() {
		// game.stop();
		if (game != null)
			game.stopGame();

	}

	public void startHighscore() {
		highscore = new Highscore(this, gui);
	}


	public void gameOver() {
		game.stop();

		gui.gameoverPopup();
	}

	public void goToMenu() {
		
		gui.getCanvas().setVisible(false);
		gui.initMenu();

	}

}
