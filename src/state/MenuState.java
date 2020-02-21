package state;

import java.awt.Graphics;

import view.Game;

public class MenuState extends State{

	private Game game;
	private static MenuState instance = null;
	
	private MenuState() {
		
	}

	public static MenuState getInstance() {

		if (instance == null)
			instance = new MenuState();
		return instance;
	}
	
	public void startGame() {
		State.setState(GameState.getInstance());
	}
	
	
	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
	
	}

}
