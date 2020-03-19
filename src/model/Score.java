package model;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import graphics.Assets;

public class Score {

	private ArrayList<BufferedImage> digitList;
	private CopyOnWriteArrayList<BufferedImage> coollist;
	private HashMap<String, BufferedImage> hashMap;
	private String[] listOfStringPoints;
	private int points;
	private String pointsInString;

	public Score() {

		digitList = Assets.getInstance().getDigitList();
		hashMap = new HashMap<String, BufferedImage>();
		points = 0;
		initHashmap();

	}

	private void initHashmap() {
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

	public CopyOnWriteArrayList<BufferedImage> getScore() {

		coollist = new CopyOnWriteArrayList<BufferedImage>();
		pointsInString = points + "";

		listOfStringPoints = pointsInString.split("");
		for (String s : listOfStringPoints) {
			coollist.add(hashMap.get(s));
		}

		return coollist;

	}

	public void addPoint() {
		points++;
	}
}
