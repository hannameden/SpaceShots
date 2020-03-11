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
import model.Entity;
import model.Player;

import controller.PlayerKeyboardInputController;
import controller.PlayerMouseInputController;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	private GUI gui;

	private Player player;
	private JPanel panel;
	private Mediator mediator;
	private Canvas canvas;
	private Image background;

	public Game(Mediator mediator, GUI gui) {
		this.mediator = mediator;
		this.gui = gui;
				
		
		System.out.println("this is fine game");
		
		panel = gui.clearFrame();
		gui.initCanvas();
		
		
//	
//		JPanel panel = gui.getPanel();
//		gui.remove(panel);
//		gui.removeAll();
//		panel2 = new JPanel();
//		gui.getFrame().setContentPane(panel2);

		canvas = gui.getCanvas();
		initBackground();	
	
		
		
		
//		gameState = GameState.getInstance();

		// State.setState(gameState);

		player = new Player(gui);
		initInputListeners(player);
		Entity.spawnAsteroids();
		
		
		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}    

	}

	private void initInputListeners(Player player) {
		PlayerKeyboardInputController playerKeyboardInputController = new PlayerKeyboardInputController(player);
		PlayerMouseInputController playerMourseInputController = new PlayerMouseInputController(player);
		this.gui.getFrame().addKeyListener(playerKeyboardInputController);
		this.gui.getCanvas().addKeyListener(playerKeyboardInputController);
		this.gui.getFrame().addMouseListener(playerMourseInputController);
		this.gui.getCanvas().addMouseListener(playerMourseInputController);
		this.gui.getFrame().addMouseMotionListener(playerMourseInputController);
		this.gui.getCanvas().addMouseMotionListener(playerMourseInputController);

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
		canvas = gui.getCanvas();
		bs = gui.getCanvas().getBufferStrategy();
		if (bs == null) {
			gui.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
	
		// Clear screen
		g.clearRect(0, 0, gui.getWidth(), gui.getHeight());
		
		//Draw background
		g.drawImage(background, 0, 0, gui.getWidth(), gui.getHeight(), null);

		// Draw game objects
		Entity.getEntities().forEach(e -> e.render(g));
		
		//player.render(g);
		// End Drawing
		bs.show();
		g.dispose();
	}

	private void render2() {
	//	canvas = gui.getCanvas();
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
		Entity.getEntities().forEach(e -> e.render(g));

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
		
	//	canvas = gui.getCanvas();
//		canvas.setVisible(true);
	//	canvas.setBounds(0,0, gui.getWidth(), gui.getHeight());
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

	//	g.drawImage(background, 0, 0, gui.getWidth(), gui.getHeight(), null);
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
