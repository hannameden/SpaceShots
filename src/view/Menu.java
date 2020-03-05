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
	private Image background;
	private Graphics g;
	private JButton startBtn, highscoreBtn, exitBtn;

	public Menu(Mediator mediator, GUI gui) {
		super();
		this.mediator = mediator;
		this.gui = gui;
		//initButtons();
	}

	public void initButtons() {
	
		frame = gui.getFrame();
		canvas = gui.getCanvas();
		panel = gui.getPanel();
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(322, 300, 89, 23);
		panel.add(btnStart);

		JButton btnHighscore = new JButton("Highscore");
		btnHighscore.setBounds(322, 350, 89, 23);
		panel.add(btnHighscore);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(322, 400, 89, 23);
		panel.add(btnExit);
		
		startBtn = new JButton("Start game");
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(true);
		
		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//MenuState.getInstance().startGame();

				mediator.startGame();
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
