package model;

public class AsteroidDecorator {

	private Asteroid decoratee;

	public AsteroidDecorator(Asteroid decoratee) {
		this.decoratee = decoratee;
	}

	public void shatter() {
		decoratee.shatter();
	}

}
