package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import controller.Mediator;
import controller.PlayerInputController;
import model.Player;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	private GUI gui;
	private Player player;
	private Mediator mediator;
	private Canvas canvas;
	private PlayerInputController playerInputController;

	public Game( GUI gui) {
		this.mediator = mediator;
		this.gui = gui;

		System.out.println("this is fine game");

//		gameState = GameState.getInstance();

		// State.setState(gameState);

		player = new Player();

		playerInputController = new PlayerInputController(player);

		gui.getFrame().addKeyListener(playerInputController);
		gui.getCanvas().addKeyListener(playerInputController);
	}

	@Override
	public void run() {

		System.out.println("run game");
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;

		while (running) {

			now = System.nanoTime();
			timer += now - lastTime;
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();

				delta--;
			}

			if (timer >= 1000000000) {
				timer = 0;
			}
		}
		stop();
	}

	private void update() {

	//	if (State.getState() != null)
	//		State.getState().update();
	}

	private void render() {
		canvas = gui.getCanvas();
		canvas.setVisible(true);
		bs = canvas.getBufferStrategy();
		
		if (bs == null) {
			gui.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, gui.getWidth(), gui.getHeight());
		// Draw
//		if (State.getState() != null)
	//		State.getState().render(g);

		g.setColor(Color.white);
		player.render(g);
		// End Drawing
		bs.show();
		g.dispose();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopGame() {
		running = false;
	}
}
