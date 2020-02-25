package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI {

	private JFrame frame;
	private Image background;
	private JPanel panel;
	private BufferStrategy bs;
	private Graphics g;
	private GridBagConstraints gbc;

	private Canvas canvas;
	private Dimension dimension;
	private int width = 800, height = 600;
	private Game game;

	
	public GUI() {
		initFrame();
		initCanvas();
	
		initBackground();
		//initGame();

		System.out.println("GUI  ");
		//State.setState(MenuState.getInstance());
		

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
		//canvas.setBackground(Color.BLACK);
		
		frame.getContentPane().add(canvas);
		
		
	}
	/**
	 * Main skapar GUI, GUI håller i ett state, och menu kanske bör vara en panel? som kan kastas vid state change. 
	 * 
	 * Nullcheck på canvas? visibility annars nullcheck
	 * 
	 * 
	 */

	private void initBackground(){
		
		canvas.setVisible(true);
		bs = canvas.getBufferStrategy();
		
		if (bs == null) {
			this.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		// Draw
//		if (State.getState() != null)
	//		State.getState().render(g);

		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
		
		g.setColor(Color.white);
		//player.render(g);
		// End Drawing
		bs.show();
		g.dispose();
	}
	private void initGame() {
	//	game = new Game(this);
	//	game.start();
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
	public GUI getGUI() {
		return this;
	}
}
