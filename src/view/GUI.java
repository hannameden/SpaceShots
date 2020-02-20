package view;

import java.awt.Canvas;
import java.awt.Color;
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
	
	JFrame frame;
	JPanel panel;
	GridBagConstraints gbc;
	Graphics g;
	Canvas canvas;
	private BufferedImage image;

	public GUI() {
		initFrame();
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
		canvas = new Canvas();

		frame.setTitle("SpaceShots");
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());

		panel = new JPanel();
		
		try {
			image = ImageIO.read(new File("assets\\rocket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(image));
		//frame.add(picLabel);
		
		Image dimg = image.getScaledInstance(30, 30,
		        Image.SCALE_SMOOTH);
		
		canvas.setBackground(Color.black);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		picLabel = new JLabel(new ImageIcon(dimg));
		
		
		panel.add(new JLabel("hello"));
		
		panel.add(canvas);
		//canvas.setBackground(Color.black);
		frame.add(canvas);
		
		panel.setBackground(Color.black);

		
		canvas.setSize(800, 600);
		
		
		panel.add(canvas);
		panel.add(picLabel);
		frame.add(panel);
		
		frame.add(picLabel);
		
		 
		
		
		frame.setVisible(true);
		
	}
}
