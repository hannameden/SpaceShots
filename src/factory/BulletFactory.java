package factory;

import model.Entity;
import view.GUI;

public class BulletFactory extends EntityFactory {

	private BulletFactory instance;
	private GUI gui;

	private BulletFactory() {
	}

	public BulletFactory getInstance(GUI gui) {
		if (instance == null) {
			this.instance = new BulletFactory();
			this.gui = gui;
		}

		return instance;

	}

	@Override
	public Entity create(int x, int y) {
		// return new Bullet(x, y, movementDirection, this.gui);
		return null;
	}

}
