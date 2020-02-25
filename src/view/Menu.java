package view;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import state.MenuState;

public class Menu {

	private Canvas canvas;
	private JFrame frame;
	private JPanel panel;
	private JButton startBtn, highscoreBtn, exitBtn;

	public Menu(GUI gui) {
		init(gui);
	}

	private void init(GUI gui) {
		frame = gui.getFrame();
		canvas = gui.getCanvas();
		panel = new JPanel();

		startBtn = new JButton("Start game");
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuState.getInstance(gui).startGame();

			}
		});

		highscoreBtn = new JButton("High Score");
		highscoreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// HighscoreState set state kankse?

			}
		});

		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuState.getInstance(gui).stopGame();
				// GameState.getInstance(gui).stopGame();
				frame.dispose();
			}
		});

		canvas.setVisible(false);
		panel.add(startBtn);
		panel.add(highscoreBtn);
		panel.add(exitBtn);
		frame.add(panel);
		frame.setVisible(true);
	}

}