package controller;

import state.GameState;
import state.MenuState;
import state.State;
import view.GUI;

public class Main {

	public static void main(String[] args) {
		State.setState(GameState.getInstance());

		//new GUI();
	}
	


}
