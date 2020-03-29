package observer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import graphics.Assets;
import model.Entity;

public class ScoreView extends Entity implements Observer {

	private ArrayList<BufferedImage> digitList;
	private CopyOnWriteArrayList<BufferedImage> scoreList;
	private HashMap<String, BufferedImage> hashMap;
	private String[] listOfStringPoints;
	private Score score;

	public ScoreView(Score score) {
		this.score = score;
		digitList = Assets.getInstance().getDigitList();
		scoreList = new CopyOnWriteArrayList<BufferedImage>();
		initHashmap();
	}

	private void initHashmap() {
		hashMap = new HashMap<String, BufferedImage>();
		hashMap.put("0", digitList.get(0));
		hashMap.put("1", digitList.get(1));
		hashMap.put("2", digitList.get(2));
		hashMap.put("3", digitList.get(3));
		hashMap.put("4", digitList.get(4));
		hashMap.put("5", digitList.get(5));
		hashMap.put("6", digitList.get(6));
		hashMap.put("7", digitList.get(7));
		hashMap.put("8", digitList.get(8));
		hashMap.put("9", digitList.get(9));
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		int offsetScore = 2;
		for (BufferedImage digit : scoreList) {
			g2d.drawImage(digit, offsetScore, 2, 20, 30, null);
			offsetScore += 20;
		}
	}

	@Override
	public void checkEdgeCollision() {

	}

	@Override
	public void checkEntityCollisions() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void updateObserver() {
		scoreList.clear();
		String scoreString = score.getScoreAsString();

		listOfStringPoints = scoreString.split("");
		for (String s : listOfStringPoints) {
			scoreList.add(hashMap.get(s));
		}

	}

}
