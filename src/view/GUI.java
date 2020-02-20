package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {

	private JFrame frame;
	private JPanel panel;
	private GridBagConstraints gbc;

	private BufferedImage image;
	private Canvas canvas;
	private Dimension dimension;
	private int width = 800, height = 600;
	private Game game;

	public GUI() {
		initFrame();
		initCanvas();
		initGame();

		panel = new JPanel();

		try {
			image = ImageIO.read(new File("assets\\rocket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(image));

		Image dimg = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		picLabel = new JLabel(new ImageIcon(dimg));

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

	private void initGame() {
		game = new Game(this);
		game.start();
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}
}
