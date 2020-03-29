package factory;

import model.Bullet;
import model.Entity;

public class BulletFactory extends EntityFactory {

	private static BulletFactory instance;

	private BulletFactory() {
	}

	public static EntityFactory getInstance() {
		if (instance == null)
			instance = new BulletFactory();
		return instance;
	}

	@Override
	public Entity create(int x, int y, String[] args) {
		return new Bullet(x, y);
	}
}
