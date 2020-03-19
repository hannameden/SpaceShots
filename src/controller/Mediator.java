package controller;

import factory.AsteroidGenerator;
import sun.tools.tree.ThisExpression;
import view.GUI;
import view.Game;
import view.Highscore;
import view.Menu;

public class Mediator {

	private GUI gui;
	private static Game game;
	private Menu menu;
	private Highscore highscore;

	public Mediator() {

		 init();
		 //gameover fr player destroy
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
		game.stopGame();
		
		
		
	}
}
