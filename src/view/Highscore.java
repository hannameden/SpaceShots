package view;

import javax.swing.JFrame;

import controller.Mediator;

public class Highscore {
	private Mediator mediator;
	private GUI gui;
	private JFrame frame;

	
	public Highscore(Mediator mediator, GUI gui) {
		super();
		this.mediator = mediator;
		this.gui = gui;
		init();
	}
	public void init() {
		
	}
}
