package controller;

import factory.AsteroidGenerator;
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
		
		// startGame();
		// new GUI();
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
		AsteroidGenerator.getInstance().start();
	}

	public void stop() {
		// game.stop();
		if (game != null)
			game.stopGame();
		
	}
	public void startHighscore() {
		highscore = new Highscore(this, gui);
	}
	public static void gameOver() {
		System.out.println("You lost");
	}
}
