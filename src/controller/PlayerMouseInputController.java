package controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import model.Player;

public class PlayerMouseInputController implements MouseInputListener {

	private Player player;

	public PlayerMouseInputController(Player player) {
		this.player = player;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		player.setPoint(e);
	}

}
