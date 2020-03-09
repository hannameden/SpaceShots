package factory;

import model.Entity;

public abstract class EntityFactory {

	public static EntityFactory getInstance() {
		return null;
	};

	abstract public Entity create(int x, int y);

}
