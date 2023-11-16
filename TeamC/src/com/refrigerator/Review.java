package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import facade.DataEngineImpl;
import facade.UIData;
import mgr.Manageable;

public class Review implements Manageable,UIData{
	
	ArrayList<String> reviewList = new ArrayList<>();
	int score;

	private Recipe recipe;
	
	public Review(Recipe recipe) {
		this.recipe = recipe;
	}
	@Override
	public void print() {
		// 평점 출력
				System.out.format("%s | %s | %d \n", recipe.name, recipe.cookName, score);
				for (String s : reviewList) {
					System.out.print(s + "\n");
				}
	}

	@Override
	public void read(Scanner scan) {
		// 평점 입력 및 관리
		
		String s;
		while (true) {
			System.out.print("이 레시피의 평점을 입력해 주세요. (0 ~ 5)");
			score = scan.nextInt();
			if (score < 0 || score > 5) {
				System.out.print("입력할 수 없는 평점입니다!");
				continue;
			}
			 
			break;
		}

		System.out.print("이 레시피의 한 줄 평을 입력해 주세요.");
		s = scan.next();
		reviewList.add(s);
		
	}
	
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	void printReview(ArrayList <String> mList) {
		System.out.println(" === 리뷰 === ");
		for (String review : mList) {
			System.out.println(review);
		}
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
