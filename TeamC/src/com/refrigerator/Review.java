package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import facade.DataEngineImpl;
import facade.UIData;
import mgr.Manageable;

public class Review implements Manageable,UIData{
	
	ArrayList<String> reviewList = new ArrayList<>();
	double score;

	@Override
	public void print() {
		// 평점 출력
				/*System.out.format("%s | %s | %.1f/5.0 \n", name, cookName, score);
				for (String s : reviewList) {
					System.out.print(s + "\n");
				}*/
	}

	@Override
	public void read(Scanner scan) {
		// 평점 입력 및 관리

		double n;
		String s;
		while (true) {
			System.out.print("이 레시피의 평점을 입력해 주세요. (0.0 ~ 5.0)");
			n = scan.nextDouble();
			if (n < 0.0 || n > 5.0) {
				System.out.print("입력할 수 없는 평점입니다!");
				continue;
			}
			score = 0.725 * score + 0.275 * n;
			break;
		}

		System.out.print("이 레시피의 한 줄 평을 입력해 주세요.");
		s = scan.next();
		reviewList.add(s);
		
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return false;
	}
	
	void printReview() {
		
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return null;
	}

}
