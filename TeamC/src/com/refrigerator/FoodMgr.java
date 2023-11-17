package com.refrigerator;

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
	
	private String[] headers = {"식료품명", "타입", "중량","유통기한"};

}
