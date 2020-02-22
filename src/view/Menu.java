package view;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import state.MenuState;

public class Menu {

	private GUI gui;
	private Canvas canvas;
	private JFrame frame;
	private JButton startBtn, highscoreBtn, exitBtn;

	public Menu() {
		gui = GUI.getInstance();
		init();
	}

	public void init() {
		frame = gui.getFrame();
		canvas = gui.getCanvas();

		startBtn = new JButton("Start game");
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuState.getInstance().startGame();

			}
		});
		
		highscoreBtn = new JButton("High Score");
		highscoreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//HighscoreState set state kankse? 

			}
		});
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuState.getInstance().stopGame();
				frame.dispose();

			}
		});
		
		
		
		canvas.setVisible(false);
		frame.add(startBtn);
		frame.add(highscoreBtn);
		frame.add(exitBtn);

		frame.setVisible(true);

	}

}
