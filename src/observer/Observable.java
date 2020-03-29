package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	protected List<Observer> observers = new ArrayList<>();

	public void add(Observer o) {
		observers.add(o);
	};

	public void remove(Observer o) {
		observers.remove(o);
	};

	public void notifyObservers() {
		for (Observer o : observers)
			o.updateObserver();
	};

}
