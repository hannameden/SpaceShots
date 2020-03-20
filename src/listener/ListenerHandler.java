package listener;

import java.awt.Canvas;

import javax.swing.JFrame;

import model.Player;
import view.Game;

public class ListenerHandler {

	private Game game;
	private JFrame frame;
	private Canvas canvas;

	private PlayerKeyboardInputListener playerKeyboardInputController;
	private PlayerKeyboardPausedInputListener playerKeyboardPausedInputController;
	private PlayerMouseInputListener playerMouseInputController;

	public ListenerHandler(Game game, JFrame frame, Canvas canvas, Player player) {
		this.game = game;
		this.frame = frame;
		this.canvas = canvas;
		initInputListeners(player);
	}

	private void initInputListeners(Player player) {
		playerKeyboardInputController = new PlayerKeyboardInputListener(player);
		playerKeyboardPausedInputController = new PlayerKeyboardPausedInputListener(player);
		playerMouseInputController = new PlayerMouseInputListener(player);
		resume();
	}

	public void resume() {
		if (!game.isPaused()) {
			frame.removeKeyListener(playerKeyboardPausedInputController);
			canvas.removeKeyListener(playerKeyboardPausedInputController);
		}
		frame.addKeyListener(playerKeyboardInputController);
		canvas.addKeyListener(playerKeyboardInputController);
		frame.addMouseListener(playerMouseInputController);
		canvas.addMouseListener(playerMouseInputController);
		frame.addMouseMotionListener(playerMouseInputController);
		canvas.addMouseMotionListener(playerMouseInputController);
	}

	public void pause() {
		if (game.isPaused()) {
			frame.addKeyListener(playerKeyboardPausedInputController);
			canvas.addKeyListener(playerKeyboardPausedInputController);
		}
		frame.removeKeyListener(playerKeyboardInputController);
		canvas.removeKeyListener(playerKeyboardInputController);
		frame.removeMouseListener(playerMouseInputController);
		canvas.removeMouseListener(playerMouseInputController);
		frame.removeMouseMotionListener(playerMouseInputController);
		canvas.removeMouseMotionListener(playerMouseInputController);
	}

	public void clearAll() {
		frame.removeKeyListener(playerKeyboardPausedInputController);
		canvas.removeKeyListener(playerKeyboardPausedInputController);
		frame.removeKeyListener(playerKeyboardInputController);
		canvas.removeKeyListener(playerKeyboardInputController);
		frame.removeMouseListener(playerMouseInputController);
		canvas.removeMouseListener(playerMouseInputController);
		frame.removeMouseMotionListener(playerMouseInputController);
		canvas.removeMouseMotionListener(playerMouseInputController);
	}

}
