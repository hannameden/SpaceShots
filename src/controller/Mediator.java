package controller;

import view.GUI;
import view.Game;
import view.Menu;

public class Mediator {

	private GUI gui;
	private Game game;

	public Mediator() {

		init();
	}

	public void init() {

		gui = new GUI(this);
	}
/*
	public void initButtons() {

		menu = new Menu(this, gui);
		menu.initButtons();
	}
*/
	public void startGame() {

		if (game == null) {
			game = new Game(this);
			game.start();
		} else {
			game.resetGame();
		}

	}
	public void restartGame() {
		startGame();
	}

	public void resetGame() {
		game.resetGame();
	}

	public void gameOver() {
		
		//clear listener handler
	//	game.stop();
		
		gui.gameoverPopup();

	}


	public void goToMenu() {
		gui.getCanvas().setVisible(false);
		gui.getContainer().setVisible(true);
	}
	public GUI getGui() {
		return gui;
	}

}
