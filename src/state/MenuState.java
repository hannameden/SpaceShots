package state;

import java.awt.Graphics;

import view.GUI;
import view.Game;
import view.Menu;

public class MenuState extends State {

	private Game game;
	private Menu menu;
	private GUI gui;
	private static MenuState instance = null;
	
	private MenuState() {
		init();
		
	}

	public static MenuState getInstance() {

		if (instance == null)
			instance = new MenuState();
		return instance;
	}
	public void init() {
		gui = GUI.getInstance();
		menu = new Menu();
	}
	
	public void startGame() {
		State.setState(GameState.getInstance());
	}
	public void stopGame() {
		GameState.getInstance().stopGame();
	}
	
	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
	
	}

}
