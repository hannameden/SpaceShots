package view;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import state.GameState;
import state.State;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	private GUI gui;

	public Game(GUI gui) {
		this.gui = gui;
		State.setState(new GameState());
	}

	@Override
	public void run() {

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

		if (State.getState() != null)
			State.getState().update();
	}

	private void render() {
		bs = gui.getCanvas().getBufferStrategy();
		if (bs == null) {
			gui.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, gui.getWidth(), gui.getHeight());
		// Draw

		if (State.getState() != null)
			State.getState().render(g);

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

}
