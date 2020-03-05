package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
	private JPanel panel2;
	private Mediator mediator;
	private Canvas canvas;
	private Image background;
	private PlayerInputController playerInputController;

	public Game(Mediator mediator, GUI gui) {
		this.mediator = mediator;
		this.gui = gui;

		System.out.println("this is fine game");

	
		JPanel panel = gui.getPanel();
		gui.remove(panel);
		gui.removeAll();
		panel2 = new JPanel();
		gui.getFrame().setContentPane(panel2);
		
		gui.initCanvas();
		initBackground();	
		
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

		// if (State.getState() != null)
		// State.getState().update();
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
		// State.getState().render(g);

		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(background, 0, 0, gui.getWidth(), gui.getHeight(), null);

		g.setColor(Color.white);
		player.render(g);
		// End Drawing
		bs.show();
		g.dispose();

	}

	public void initBackground() {
		canvas = gui.getCanvas();
		canvas.setVisible(true);
		canvas.setBounds(0,0, gui.getWidth(), gui.getHeight());
		bs = canvas.getBufferStrategy();
		System.out.println("hola 22");

		if (bs == null) {
			canvas.createBufferStrategy(3);
			bs = canvas.getBufferStrategy();
		}
		
		g = bs.getDrawGraphics();
		System.out.println("bg 2");
		g.clearRect(0, 0, gui.getWidth(), gui.getHeight());

		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(background, 0, 0, gui.getWidth(), gui.getHeight(), null);
		bs.show();

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
		if (running)
			running = false;
		thread.stop();
	}
}
