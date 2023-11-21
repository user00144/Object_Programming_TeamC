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
	public HashMap<String, String> imagemap = new HashMap<String,String>(){{
		put("우유","images/fd_img/우유.png");
		put("가래떡","images/fd_img/가래떡.png");
		put("감자","images/fd_img/감자.png");
		put("고추장","images/fd_img/고추장.png");
		put("고춧가루","images/fd_img/고춧가루.png");
		put("깻잎","images/fd_img/깻잎.png");
		put("돼지고기","images/fd_img/돼지고기.png");
		put("된장","images/fd_img/된장.png");
		put("두부","images/fd_img/두부.png");
		put("들깨가루","images/fd_img/들깨가루.png");
		put("떡볶이떡","images/fd_img/떡볶이떡.png");
		put("배추","images/fd_img/배추.png");
		put("애호박","images/fd_img/애호박.png");
		put("양파","images/fd_img/양파.png");
		put("청양고추","images/fd_img/청양고추.png");


	}};
	public String[] headers = {"식료품명", "타입", "중량","유통기한"};

}
