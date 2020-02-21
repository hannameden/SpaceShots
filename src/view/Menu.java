package view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import state.MenuState;
import state.State;

public class Menu {
	
	private GUI gui;
	private JFrame frame;
	private JButton startBtn, highscoreBtn, exitBtn;
	
	public Menu(GUI gui) {
		this.gui = gui;
		
		MenuState menuState = MenuState.getInstance();
		
		State.setState(menuState);
		
		init();
	}
	public void init() {
		frame = gui.getFrame();
		
		startBtn = new JButton("Start game");
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuState.getInstance().startGame();
				
			}
		});
		frame.add(startBtn);

		
		
		frame = new JFrame();
		frame.setTitle("SpaceShots");
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		frame.setVisible(true);
		
		
		
	}
	

}
