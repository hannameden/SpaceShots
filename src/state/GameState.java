package state;

import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State {

	// Game objects, player etc.

	private int x = 0, y = 0;

	public GameState() {
		super();
	}

	@Override
	public void update() {
		x++;
		y++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(x, y, 20, 20);
	}

}
