package factory;

import model.Entity;

public abstract class EntityFactory {

	abstract public Entity create(int x, int y, int movementDirection);

}
