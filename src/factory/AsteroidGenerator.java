package factory;

import java.util.Timer;
import java.util.TimerTask;

public class AsteroidGenerator {

	private static AsteroidGenerator instance;
	private static EntityFactory asteroidFactory = AsteroidFactory.getInstance();
	private static String[] asteroidSpawnArguments = { "RandomSpawnLocation", "AsteroidMedium" };
	private static int randomSizeOfAsteroid;
	private static Timer timer;
	private static TimerTask timerTask;

	private AsteroidGenerator() {
	}

	public static AsteroidGenerator getInstance() {
		if (instance == null)
			instance = new AsteroidGenerator();
		return instance;
	}

	public static void start() {
		if (timer == null && timerTask == null) {
			resume();
		}
	}

	public static void pause() {
		timer.cancel();
	}

	public static void resume() {
		timer = new Timer();
		timerTask = new TimerTask() {

			@Override
			public void run() {
				randomizeAsteroidSize();
				asteroidFactory.create(0, 0, asteroidSpawnArguments);
			}
		};
		timer.scheduleAtFixedRate(timerTask, 0, 250);
	}

	private static void randomizeAsteroidSize() {
		randomSizeOfAsteroid = randomWithRange(1, 10);

		if (randomSizeOfAsteroid < 5) {
			asteroidSpawnArguments[1] = "AsteroidSmall";
		} else if (randomSizeOfAsteroid < 8) {
			asteroidSpawnArguments[1] = "AsteroidMedium";
		} else {
			asteroidSpawnArguments[1] = "AsteroidLarge";
		}

	}

	private static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

}
