package controller;

import java.awt.Canvas;

import javax.swing.JFrame;

import model.Player;
import view.Game;

public class ListenerHandler {

	private Game game;
	private JFrame frame;
	private Canvas canvas;

	private PlayerKeyboardInputController playerKeyboardInputController;
	private PlayerKeyboardPausedInputController playerKeyboardPausedInputController;
	private PlayerMouseInputController playerMourseInputController;

	public ListenerHandler(Game game, JFrame frame, Canvas canvas, Player player) {
		this.game = game;
		this.frame = frame;
		this.canvas = canvas;
		initInputListeners(player);
	}

	private void initInputListeners(Player player) {
		playerKeyboardInputController = new PlayerKeyboardInputController(player);
		playerKeyboardPausedInputController = new PlayerKeyboardPausedInputController(player);
		playerMourseInputController = new PlayerMouseInputController(player);
		resume();
	}

	public void resume() {
		if (!game.isPaused()) {
			frame.removeKeyListener(playerKeyboardPausedInputController);
			canvas.removeKeyListener(playerKeyboardPausedInputController);
		}
		frame.addKeyListener(playerKeyboardInputController);
		canvas.addKeyListener(playerKeyboardInputController);
		frame.addMouseListener(playerMourseInputController);
		canvas.addMouseListener(playerMourseInputController);
		frame.addMouseMotionListener(playerMourseInputController);
		canvas.addMouseMotionListener(playerMourseInputController);
	}

	public void pause() {
		if (game.isPaused()) {
			frame.addKeyListener(playerKeyboardPausedInputController);
			canvas.addKeyListener(playerKeyboardPausedInputController);
		}
		frame.removeKeyListener(playerKeyboardInputController);
		canvas.removeKeyListener(playerKeyboardInputController);
		frame.removeMouseListener(playerMourseInputController);
		canvas.removeMouseListener(playerMourseInputController);
		frame.removeMouseMotionListener(playerMourseInputController);
		canvas.removeMouseMotionListener(playerMourseInputController);
	}

}
