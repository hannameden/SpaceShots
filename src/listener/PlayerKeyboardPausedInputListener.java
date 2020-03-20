package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;

public class PlayerKeyboardPausedInputListener implements KeyListener {

	private Player player;

	public PlayerKeyboardPausedInputListener(Player player) {
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			player.togglePause();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
