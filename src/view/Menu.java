package view;

import java.awt.Canvas;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Mediator;

public class Menu {

	private GUI gui;
	private Mediator mediator;
	private Canvas canvas;
	private JFrame frame;
	private JPanel panel;
	private Graphics g;
	private JButton startBtn, highscoreBtn, exitBtn;

	public Menu(Mediator mediator, GUI gui) {
		super();
		this.mediator = mediator;
		this.gui = gui;
	}

	public void initButtons() {

		frame = gui.getFrame();
		canvas = gui.getCanvas();
		canvas.setVisible(false);
		frame.setLayout(null);
		
	//	panel = new JPanel();

		//JButton startBtn = new JButton("Start");
	/*	
		panel.add(startBtn);

		JButton btnHighscore = new JButton("Highscore");
		
		panel.add(btnHighscore);

		JButton btnExit = new JButton("Exit");
		
		panel.add(btnExit);
*/
		startBtn = new JButton("Start game");
		startBtn.setBounds(322, 300, 89, 23);
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(true);

		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediator.startGame();
			}
		});

		highscoreBtn = new JButton("High Score");
		highscoreBtn.setBounds(322, 350, 89, 23);
		highscoreBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// HighscoreState set state kankse?

			}
		});

		exitBtn = new JButton("Exit");
		exitBtn.setBounds(322, 400, 89, 23);
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// HighscoreState set state kankse?
				frame.dispose();
			}
		});

		
		frame.add(startBtn);
		frame.add(highscoreBtn);
		frame.add(exitBtn);

		frame.setVisible(true);
	}
}
