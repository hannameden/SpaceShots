package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import state.MenuState;
import state.State;

public class GUI {

	private JFrame frame;
	private GridBagConstraints gbc;
	private Canvas canvas;
	private Dimension dimension;
	private int width = 800, height = 600;

	public GUI() {
		initFrame();
		initCanvas();
		setState(MenuState.getInstance(this));
	}

	public void initFrame() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;

		frame = new JFrame();

		dimension = new Dimension(width, height);

		frame.setTitle("SpaceShots");
		frame.setSize(dimension);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.setVisible(true);

	}

	private void initCanvas() {
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setFocusable(false);
		canvas.setBackground(Color.BLACK);
		frame.getContentPane().add(canvas);
	}

	private void setState(State state) {
		State.setState(state);
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}
}
