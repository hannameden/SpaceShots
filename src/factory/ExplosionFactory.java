package factory;

import graphics.Assets;
import model.Entity;
import model.Explosion;

public class ExplosionFactory extends EntityFactory {

	private static ExplosionFactory instance;

	private ExplosionFactory() {
	}

	public static ExplosionFactory getInstance() {
		if (instance == null)
			instance = new ExplosionFactory();
		return instance;
	}

	@Override
	public Entity create(int x, int y, String[] args) {
		if (args != null && args[0].equalsIgnoreCase("RedExplosion")) {
			return new Explosion(Assets.getInstance().getLaserRedExplosionImage(), x, y);
		} else {
			return new Explosion(Assets.getInstance().getLaserGreenExplosionImage(), x, y);
		}
	}

}
