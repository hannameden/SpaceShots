package observer;

public class Score extends Observable {

	private int points;

	public Score() {

	}

	public void addPoint() {
		points++;
		notifyObservers();
	}

	public int getScore() {
		return points;
	}

	public String getScoreAsString() {
		return points + "";
	}

}
