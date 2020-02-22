package controller;

import state.MenuState;
import state.State;
import view.GUI;

public class Main {

	public static void main(String[] args) {
		State.setState(MenuState.getInstance());

		//new GUI();
	}

}
