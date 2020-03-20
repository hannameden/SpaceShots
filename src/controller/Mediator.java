package controller;

import java.awt.Canvas;

import javax.swing.JFrame;

import view.GUI;
import view.Game;

public class Mediator {

	private GUI gui;
	private Game game;

	public Mediator() {

		init();
	}

	public void init() {

		gui = new GUI(this);

	}

	public void startGame() {

		if (game == null) {

			game = new Game(this);
			game.start();

		} else {
			game.resetGame();
		}
	}

	public void resetGame() {
		game.resetGame();
	}

	public void gameOverPopup() {
		game.getListenerHandler().clearAll();
		gui.gameoverPopup();

	}

	public void goToMenu() {
		gui.getCanvas().setVisible(false);
		gui.getContainer().setVisible(true);
	}

	public GUI getGui() {
		return gui;
	}

	public JFrame getFrame() {
		return gui.getFrame();
	}

	public Canvas getCanvas() {
		return gui.getCanvas();
	}
}
