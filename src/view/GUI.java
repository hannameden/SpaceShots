package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Mediator;
import model.Player;

public class GUI {

	private Image backgroundImage;
	private JFrame frame;

	private JPanel container;
	private JLabel title;
	private JButton btnStart, btnHighscore, btnExit;

	private Mediator mediator;
	private Canvas canvas;
	private Dimension dimension;

	private static int width = 800, height = 600;

	public GUI(Mediator mediator) {
		this.mediator = mediator;

		initFrame();
		initMenu();
	}

	private void initFrame() {
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
		frame.setFocusable(true);
		frame.setVisible(true);
	}

	public void initMenu() {

		backgroundImage = new ImageIcon("assets\\spacemenu.jpg").getImage();

		container = new MyBackground();
		container.setBounds(0, 0, width, height);
		container.setLayout(null);

		title = new JLabel("SPACE SHOOTER");
		title.setFont(new Font("Monospaced", 1, 58));
		title.setForeground(Color.white);
		title.setBounds(150, 50, 500, 200);
		container.add(title);

		btnStart = new JButton("Start game");
		btnStart.setBounds(322, 300, 90, 25);

		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initCanvas();
				mediator.startGame();
			}
		});

		container.add(btnStart);

		btnHighscore = new JButton("High Score");
		btnHighscore.setBounds(322, 350, 90, 25);
		btnHighscore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediator.startHighscore();
			}
		});
		container.add(btnHighscore);

		btnExit = new JButton("Exit");
		btnExit.setBounds(322, 400, 90, 25);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		container.add(btnExit);

		frame.add(container);
		frame.setVisible(true);
	}

	private void initCanvas() {
		if (canvas == null) {
			canvas = new Canvas();
			canvas.setPreferredSize(dimension);
			canvas.setMinimumSize(dimension);
			canvas.setMaximumSize(dimension);
			canvas.setFocusable(true);
			canvas.setBackground(Color.BLACK);
			canvas.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			frame.add(canvas);
		}
		canvas.setVisible(true);
		container.setVisible(false);
	}

	public void gameoverPopup() {
		JDialog dialog = new JDialog(frame);
		dialog.setLayout(new FlowLayout());

		dialog.add(new JLabel("You lost!"));
		dialog.add(new JLabel("Points: " + Player.getScore()));
		dialog.setTitle("Game over");
		dialog.setBounds(500, 400, 300, 200);
		dialog.setLocationRelativeTo(null);

		JButton startover = new JButton("Restart game");
		startover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				mediator.resetGame();
			}
		});

		JButton menu = new JButton("Go to menu");
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				mediator.goToMenu();
			}
		});
		dialog.add(startover);
		dialog.add(menu);
		dialog.setUndecorated(true);
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		dialog.setVisible(true);

	}

	public void pauseGame() {

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

	public JPanel getContainer() {
		return container;
	}

	public GUI getGUI() {
		return this;
	}

	public class MyBackground extends JPanel {
		/**
		 * @author https://www.dreamincode.net/forums/topic/326837-add-a-button-on-top-of-background-image/
		 *         A class to set the background image for the menu.
		 */
		private static final long serialVersionUID = 1L;

		public MyBackground() {
			setBackground(new Color(0, true));
		}

		@Override
		public void paintComponent(Graphics g) {

			// Paint background first
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

			// Paint the rest of the component. Children and self etc.
			super.paintComponent(g);

		}
	}
}
