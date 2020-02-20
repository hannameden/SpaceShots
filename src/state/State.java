package state;

import java.awt.Graphics;

public abstract class State {

	private static State currentState;

	public static State getState() {
		return currentState;
	}

	public static void setState(State state) {
		currentState = state;
	}

	public abstract void update();

	public abstract void render(Graphics g);

}
