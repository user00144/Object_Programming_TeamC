package com.refrigerator;

import facade.DataEngineImpl;

public class RefMgr extends DataEngineImpl<Refrigerator>{
	private static RefMgr engine = null;
	private RefMgr() {
		setLabels(headers);
	}
	public static RefMgr getInstance() {
		if (engine == null)
			engine = new RefMgr();
		return engine;
	}
	private String[] headers = {"냉장고 번호","사용자 정보"};
}
