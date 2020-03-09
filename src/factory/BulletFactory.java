package factory;

import model.Bullet;

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
	public Bullet create(int x, int y, int movementDirection) {
		return new Bullet(x, y, movementDirection);
	}

}
