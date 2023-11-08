package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

class Recipe implements Manageable{

	String name;
	String cookName;
	ArrayList<String> recstr = new ArrayList<>();
	
	//Review 객체로 변경
	ArrayList<String> reviewList = new ArrayList<>();
	double score;

	

	ArrayList<RecFd> recList = new ArrayList<>();

	
	@Override
	public void print() {
		// 요리할 음식과 필요한 식재료 출력
		System.out.printf("요리할 음식 : %s \n", cookName);
		System.out.printf("= 재료 = \n");
		for (RecFd r : recList) {
			r.print();
		}
		System.out.printf("= 레시피 =\n");
		for(String str : recstr) {
			System.out.println(str);
		}
	}

	@Override
	public void read(Scanner scan) {
		
	}


	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return false;
	}

	void printReview() {
		// 평점 출력
		System.out.format("%s | %s | %.1f/5.0 \n", name, cookName, score);
		for (String s : reviewList) {
			System.out.print(s + "\n");
		}
	}

	void genertateNewReview(Scanner scan) {
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

			if (score == 0.0) {
				score = n;
				break;
			}

			score = 0.725 * score + 0.275 * n;
			break;
		}

		System.out.print("이 레시피의 한 줄 평을 입력해 주세요.");
		s = scan.next();
		reviewList.add(s);
	}



}