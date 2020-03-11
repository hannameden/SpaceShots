package factory;

import model.AsteroidLarge;
import model.AsteroidMedium;
import model.AsteroidSmall;
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
	public Entity create(int x, int y, String[] args) {

		Entity asteroid = null;

		if (args != null && args[0].equalsIgnoreCase("RandomSpawnLocation")) {
			if (args[1].equalsIgnoreCase("AsteroidSmall")) {
				asteroid = new AsteroidSmall();
			} else if (args[1].equalsIgnoreCase("AsteroidMedium")) {
				asteroid = new AsteroidMedium();
			} else if (args[1].equalsIgnoreCase("AsteroidLarge")) {
				asteroid = new AsteroidLarge();
			}
		} else {
			if (args[1].equalsIgnoreCase("AsteroidSmall")) {
				asteroid = new AsteroidSmall(x, y);
			} else if (args[1].equalsIgnoreCase("AsteroidMedium")) {
				asteroid = new AsteroidMedium(x, y);
			} else if (args[1].equalsIgnoreCase("AsteroidLarge")) {
				asteroid = new AsteroidLarge(x, y);
			}
		}

		return asteroid;
	}

}
