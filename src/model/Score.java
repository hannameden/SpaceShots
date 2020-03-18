package model;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.HashMap;

import graphics.Assets;

public class Score {
	
	/**
	 * This is called brute force. Read a fkn book. :) 
	 */

	private ArrayList<BufferedImage> digitList;
	private ArrayList<BufferedImage> scoreList;
	private HashMap<String, BufferedImage> hashMap;

	public Score() {

		digitList = Assets.getInstance().getDigitList();
		scoreList = new ArrayList<BufferedImage>();
		hashMap = new HashMap<String, BufferedImage>();
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

	public ArrayList<BufferedImage> getScore(int points) {
		
		String pointsInString = points + "";
		
		String [] listOfStringPoints= pointsInString.split("");
		
		for (String s : listOfStringPoints) {
			scoreList.add(hashMap.get(s));
		}
/*		
		if (points > 19) {
			scoreList.add(1, digitList.get(2));
			points = points -10;
		}
		if(points > 9 ) {
			scoreList.add(1, digitList.get(1));
			points = points -10;
		}
		
		
		if(points == 1)
			scoreList.set(0, digitList.get(1));
		else if(points == 2)
			scoreList.set(0, digitList.get(2));
		else if(points == 3)
			scoreList.set(0, digitList.get(3));
		else if(points == 4)
			scoreList.set(0, digitList.get(4));
		else if(points == 5)
			scoreList.set(0, digitList.get(5));
		else if(points == 6)
			scoreList.set(0, digitList.get(6));
		else if(points == 7)
			scoreList.set(0, digitList.get(7));
		else if(points == 8)
			scoreList.set(0, digitList.get(8));
		else if(points == 9)
			scoreList.set(0, digitList.get(9));

	*/
		return scoreList;

	}
	
	private BufferedImage getBufferedImageFromValueAsString(String value) {
		

		
		return null;
	}
}
