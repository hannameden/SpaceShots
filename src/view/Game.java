package view;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Mediator;
import factory.AsteroidGenerator;
import listener.ListenerHandler;
import model.Entity;
import model.Player;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;
	private boolean paused;
	private BufferStrategy bs;
	private Graphics g;
	private GUI gui;

	private Player player;
	private Mediator mediator;

	private JFrame frame;
	private Canvas canvas;
	private Image background;

	// private PlayerKeyboardInputController playerKeyboardInputController;
	// private PlayerKeyboardPausedInputController
	// playerKeyboardPausedInputController;
	// private PlayerMouseInputController playerMourseInputController;

	private ListenerHandler listenerHandler;

	public Game(Mediator mediator) {
		this.mediator = mediator;

		this.gui = mediator.getGui();

		gui.initCanvas();
		canvas = gui.getCanvas();
		frame = gui.getFrame();
		init();
	}

	private void init() {
		player = new Player(this);
		listenerHandler = new ListenerHandler(this, frame, canvas, player);

		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		paused = false;
	}

	@Override
	public void run() {

		int fps = 100;

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

				if (!paused)
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
		Entity.getEntities().forEach(e -> e.update());
	}

	private void render() {

		bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		// Clear screen
		g.clearRect(0, 0, GUI.getWidth(), GUI.getHeight());

		// Draw background
		g.drawImage(background, 0, 0, GUI.getWidth(), GUI.getHeight(), null);

		// Draw game objects
		Entity.getEntities().forEach(e -> e.render(g));

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
		AsteroidGenerator.start();
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

	public synchronized void pause() {
		paused = true;
		AsteroidGenerator.pause();
		listenerHandler.pause();
	}

	public synchronized void resume() {
		paused = false;
		AsteroidGenerator.resume();
		listenerHandler.resume();
	}

	public void stopGame() {
		// stoppa thread
	}

	public void restartGame() {
		listenerHandler.pause();
		Entity.getEntities().clear();
		init();
	}

	public void gameOverPopup(int score) {

		mediator.gameOver(score);
		// mediator.stopGame();
	}

	public boolean isPaused() {
		return paused;
	}

}
