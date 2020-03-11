package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controller.Mediator;

public class GUI extends JFrame {

	private JFrame frame;
	private Image background;
	private JPanel menuPanel, basePanel;
	private JLabel backgroundLabel, title;
	private JButton btnStart, btnHighscore, btnExit;

	private BufferStrategy bs;
	private Graphics g;
	private GridBagConstraints gbc;

	private Mediator mediator;
	private ImagePanel imagePanel;
	private Canvas canvas;
	private Dimension dimension;
	private static int width = 800, height = 600;

	private Game game;

	Image image = Toolkit.getDefaultToolkit().getImage("assets\\space.jfif");

	public GUI(Mediator mediator) {

		this.mediator = mediator;
		// initNoMenu();
		// mediator.startGame();
		// initFrame();
		initFrame2();
		initMenu();

//		try {
//			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("assets\\space.jfif")))));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		frame.setBounds(0, 0, width, height);
//		frame.setSize(width, height);
//		frame.pack();
//		frame.setVisible(true);

		// initFrame();
		// initCanvas();

		// initBackground();
		// initGame();

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

		imagePanel = new ImagePanel(new ImageIcon("assets\\space.jfif").getImage());

		frame.setContentPane(imagePanel);

		// frame.getContentPane().add(panel);

		frame.setVisible(true);

	}

	private void initFrame2() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		dimension = new Dimension(width, height);
		frame.setTitle("SpaceShots");
		frame.setSize(dimension);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void initNoMenu() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		dimension = new Dimension(width, height);
		frame.setTitle("SpaceShots");
		frame.setSize(dimension);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setBounds(100, 100, 988, 678);
		basePanel = new JPanel();
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(basePanel);
		basePanel.setLayout(null);

		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 800, 600);
		basePanel.add(menuPanel);
		menuPanel.setLayout(null);

		title = new JLabel("SPACE SHOOTER");
		title.setFont(new Font("Monospaced", 1, 58));
		title.setForeground(Color.white);
		title.setBounds(150, 50, 500, 200);
		menuPanel.add(title);

	}

	private void initMenu() {

		// setBounds(100, 100, 988, 678);
		basePanel = new JPanel();
		basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(basePanel);
		basePanel.setLayout(null);

		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 800, 600);
		basePanel.add(menuPanel);
		menuPanel.setLayout(null);

		title = new JLabel("SPACE SHOOTER");
		title.setFont(new Font("Monospaced", 1, 58));
		title.setForeground(Color.white);
		title.setBounds(150, 50, 500, 200);
		menuPanel.add(title);

		btnStart = new JButton("Start game");
//		btnStart.setOpaque(true);
//		btnStart.setContentAreaFilled(false);
//		btnStart.setBorderPainted(true);
//		btnStart.setBackground(Color.white);
//		
		btnStart.setBounds(322, 300, 90, 25);

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mediator.startGame();
			}
		});

		menuPanel.add(btnStart);

		btnHighscore = new JButton("High Score");
		btnHighscore.setBounds(322, 350, 90, 25);
		btnHighscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mediator.startHighscore();

			}
		});
		menuPanel.add(btnHighscore);

		btnExit = new JButton("Exit");
		btnExit.setBounds(322, 400, 90, 25);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				mediator.stop();
			}
		});
		menuPanel.add(btnExit);

//		btnStart = new JButton("Start");
//		btnStart.setBounds(322, 300, 89, 23);
//		panel.add(btnStart);
//
//		btnHighscore = new JButton("Highscore");
//		btnHighscore.setBounds(322, 350, 89, 23);
//		panel.add(btnHighscore);
//
//		btnExit = new JButton("Exit");
//		btnExit.setBounds(322, 400, 89, 23);
//		panel.add(btnExit);

		try {
			backgroundLabel = new JLabel(new ImageIcon(ImageIO.read(new File("assets\\spacemenu.jpg"))));
			backgroundLabel.setBounds(0, 0, 800, 600);
			menuPanel.add(backgroundLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(521, 11, 441, 361);
		// contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 383, 952, 246);
		// contentPane.add(panel_2);

	}

	public void initCanvas() {
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setFocusable(false);
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(0, 0, 800, 600);

		canvas.setVisible(true);
		frame.getContentPane().add(canvas);

	}

	public JPanel clearFrame() {
		JPanel newPanel = new JPanel();
		frame.setContentPane(newPanel);

		return newPanel;
	}

	/**
	 * Main skapar GUI, GUI håller i ett state, och menu kanske bör vara en panel?
	 * som kan kastas vid state change.
	 * 
	 * Nullcheck på canvas? visibility annars nullcheck
	 * 
	 * 
	 */

	public void pauseGame() {

	}

	private void initBackground() {

		System.out.println("init back");
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
		// State.getState().render(g);

		try {
			background = ImageIO.read(new File("assets\\space.jfif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);

		g.setColor(Color.white);
		// player.render(g);
		// End Drawing
		bs.show();

		g.dispose();

	}

	private void initGame() {
		// game = new Game(this);
		// game.start();

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}

	public JPanel getPanel() {
		return menuPanel;
	}

	public GUI getGUI() {
		return this;
	}

}

class ImagePanel extends JPanel {

	private int width = 800, height = 600;

	private Image img;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);

		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
