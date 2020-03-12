package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;

public class PlayerKeyboardInputController implements KeyListener {

	private Player player;

	public PlayerKeyboardInputController(Player player) {
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			player.shoot();

		/*
		 * if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		 * player.moveLeft(); if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()
		 * == KeyEvent.VK_D) player.moveRight(); if (e.getKeyCode() == KeyEvent.VK_DOWN
		 * || e.getKeyCode() == KeyEvent.VK_S) player.moveDown(); if (e.getKeyCode() ==
		 * KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) player.moveUp();
		 */
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}



/*
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;

public class PlayerKeyboardInputController implements KeyListener {

	private Player player;

	public PlayerKeyboardInputController(Player player) {
		this.player = player;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println("key pressed" + e.getKeyCode());

		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			player.shoot();

		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			player.pauseGame();
		
		
		 * if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
		 * player.moveLeft(); if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()
		 * == KeyEvent.VK_D) player.moveRight(); if (e.getKeyCode() == KeyEvent.VK_DOWN
		 * || e.getKeyCode() == KeyEvent.VK_S) player.moveDown(); if (e.getKeyCode() ==
		 * KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) player.moveUp();
		 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
*/