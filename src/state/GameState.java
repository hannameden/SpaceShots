package state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Player;
import view.GUI;
import view.Game;

public class GameState extends State {
	
	private GUI gui;
	private Game game;
	
	private static GameState instance;

	// Game objects, player etc.


	private BufferedImage image = null;
	private int x = 0, y = 0;
	private Player player;

	private GameState() {
		super();
		init();
	}

	public static GameState getInstance() {

		System.out.println("instance gamestate");
		if (instance == null) {
			instance = new GameState();
			System.out.println("ny instance game");
		}
			
		return instance;
	}
	
	public void init() {
	
	
		//gui = new GUI();
		player = new Player();
	//	game = new Game(gui);
	//	game.start();
	
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);	
		player.render(g);
	}

	public Player getPlayer() {
		return player;

	}
	public void stopGame() {
		System.out.println("innan stop");
		game.stopGame();
		System.out.println("efter stop");
	}

}
