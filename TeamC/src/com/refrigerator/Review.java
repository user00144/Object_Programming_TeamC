package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class Review implements Manageable {
	
	ArrayList<String> reviewList = new ArrayList<>();
	int score;

	@Override
	public void print() {
		// 평점 출력
				System.out.format("%s | %s | %d \n", name, cookName, score);
				for (String s : reviewList) {
					System.out.print(s + "\n");
				}
	}

	@Override
	public void read(Scanner scan) {
		// 평점 입력 및 관리

		String s;
		while (true) {
			System.out.print("이 레시피의 평점을 입력해 주세요. (0.0 ~ 5.0)");
			score = scan.nextInt();
			if (score < 0.0 || score > 5.0) {
				System.out.print("입력할 수 없는 평점입니다!");
				continue;
			}
			
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

}
