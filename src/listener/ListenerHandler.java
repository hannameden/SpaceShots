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
	private PlayerMouseInputListener playerMourseInputController;

	public ListenerHandler(Game game, JFrame frame, Canvas canvas, Player player) {
		this.game = game;
		this.frame = frame;
		this.canvas = canvas;
		initInputListeners(player);
	}

	private void initInputListeners(Player player) {
		playerKeyboardInputController = new PlayerKeyboardInputListener(player);
		playerKeyboardPausedInputController = new PlayerKeyboardPausedInputListener(player);
		playerMourseInputController = new PlayerMouseInputListener(player);
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
