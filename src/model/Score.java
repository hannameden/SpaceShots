package model;

import java.awt.image.BufferedImage;

public class Score {

	private int points;
	private BufferedImage[] numberImages;

	public Score() {

	}

	public void increasePoints(int pointsToAdd) {
		points += pointsToAdd;
	}

}
