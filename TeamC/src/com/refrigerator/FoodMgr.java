package com.refrigerator;

import java.util.HashMap;

import facade.DataEngineImpl;

public class FoodMgr extends DataEngineImpl<Food> {
	private static FoodMgr engine = null;
	private FoodMgr() {
		setLabels(headers);
	}
	public static FoodMgr getInstance() {
		if (engine == null)
			engine = new FoodMgr();
		return engine;
	}
	public HashMap<String, String> imagemap = new HashMap<String,String>(){{ //해시맵<키&값>
		put("3분카레","images/fd_img/3분카레.png");
		put("가래떡","images/fd_img/가래떡.png");
		put("감자","images/fd_img/감자.png");
		put("계란","images/fd_img/계란.png");
		put("고추장","images/fd_img/고추장.png");
		put("태양초고춧가루","images/fd_img/고춧가루.png");
		put("감귤","images/fd_img/감귤.png");
		put("광천김","images/fd_img/광천김.png");
		put("깻잎","images/fd_img/깻잎.png");
		put("닭가슴살페퍼","images/fd_img/닭가슴살페퍼.png");
		put("햇당근","images/fd_img/햇당근.png");
		put("대파","images/fd_img/대파.png");
		put("돼지고기","images/fd_img/돼지고기.png");
		put("해찬들된장","images/fd_img/된장.png");
		put("두부","images/fd_img/두부.png");
		put("들깨가루","images/fd_img/들깨가루.png");
		put("떡볶이떡","images/fd_img/떡볶이떡.png");
		put("레쓰비마일드커피","images/fd_img/레쓰비마일드커피.png");
		put("마요네즈","images/fd_img/마요네즈.png");
		put("배추","images/fd_img/배추.png");
		put("부추","images/fd_img/부추.png");
		put("불닭볶음면","images/fd_img/불닭볶음면.png");
		put("사과","images/fd_img/사과.png");
		put("삼다수","images/fd_img/삼다수.png");
		put("삼양라면", "images/fd_img/삼양라면.png");
		put("설탕","images/fd_img/설탕.png");
		put("소금","images/fd_img/소금.png");
		put("수박","images/fd_img/수박.png");
		put("슬라이스치즈","images/fd_img/슬라이스치즈.png");
		put("신라면","images/fd_img/신라면.png");
		put("신라면더레드","images/fd_img/신라면더레드.png");
		put("애호박","images/fd_img/애호박.png");
		put("양파","images/fd_img/양파.png");
		put("올리브오일","images/fd_img/올리브오일.png");
		put("서울우유","images/fd_img/우유.png");
		put("매일우유","images/fd_img/우유.png");
		put("이스트","images/fd_img/이스트.png");
		put("중력분","images/fd_img/중력분.png");
		put("청양고추","images/fd_img/청양고추.png");
		put("칠리소스","images/fd_img/칠리소스.png");
		put("케찹","images/fd_img/케찹.png");
		put("콘트라베이스","images/fd_img/콘트라베이스.png");
		put("토마토소스","images/fd_img/토마토소스.png");
		put("파슬리","images/fd_img/파슬리.png");
		put("페퍼로니","images/fd_img/페퍼로니.png");
		put("피자치즈","images/fd_img/피자치즈.png");
		put("흑당라떼","images/fd_img/흑당라떼.png");
		put("맛있는라면","images/fd_img/맛있는라면.png");
	}};
	public String[] headers = {"이름", "타입", "중량", "유통기한"};

}
