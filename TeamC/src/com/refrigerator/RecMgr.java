package com.refrigerator;

import facade.DataEngineImpl;

public class RecMgr extends DataEngineImpl<Recipe>{
	private static RecMgr engine = null;
	private RecMgr() {
		setLabels(headers);
	}
	public static RecMgr getInstance() {
		if (engine == null)
			engine = new RecMgr();
		return engine;
	}
	public String[] headers = {"이미지", "레시피명", "제작자"};
}
