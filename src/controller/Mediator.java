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
		
	}
	public void init() {
		
		gui = new GUI();
		menu = new Menu(this, gui);
	}
	public void startGame() {
		game = new Game( gui);
		game.start();
	}
}
