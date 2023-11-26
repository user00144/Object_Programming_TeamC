package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import facade.DataEngineImpl;
import facade.UIData;
import mgr.Manageable;

public class Review implements Manageable,UIData{
	
	String review;
	int score;

	private Recipe recipe;
	
	public Review(Recipe recipe) {
		this.recipe = recipe;
		recipe.rvList.add(this);
	}
	
	public Review(String string, String string2, String reviewText, String score2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		// 평점 출력
				System.out.format("%d\n", score);
				System.out.print(review + "\n");
	}

	@Override
	public void read(Scanner scan) {
		// 평점 입력 및 관리
		review = scan.nextLine();
		score = scan.nextInt();
	}
	
	public boolean matches(String kwd) {
		return false;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		review = (String)uitexts[0];
		score = Integer.parseInt((String)uitexts[1]);
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return new String[] {review, ""+score};
	}

	public Object getFoodName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getScore() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getReviewText() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setScore(String score2) {
		// TODO Auto-generated method stub
		
	}

	public void setReviewText(String reviewText) {
		// TODO Auto-generated method stub
		
	}



}
