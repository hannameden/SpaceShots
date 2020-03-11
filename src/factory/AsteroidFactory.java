package factory;

import model.Entity;

public class AsteroidFactory extends EntityFactory {

	private static AsteroidFactory instance;

	private AsteroidFactory() {
	}

	public static EntityFactory getInstance() {
		if (instance == null)
			instance = new AsteroidFactory();
		return instance;
	}

	@Override
	public Entity create(int x, int y, int movementDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}
