package com.refrigerator;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public int addRef(String refcode, String[] userinfo, String filepath) {
		Scanner file = openFile(filepath);
		String temp = null;
		Refrigerator rf = new Refrigerator();
		rf.refcode = Integer.parseInt(refcode);
		for(String str : userinfo) {
			if(!str.equals("")) {
				rf.userinfo.add(str);
			}
		}
		try {
			while(file.hasNext()) {
				temp = file.next();
				Food fd = new Food(temp);
				fd.read(file);
				rf.foodMgr.addItem(fd);
			}
			mList.add(rf);
			rf.print();
		}catch(Exception e) {
			return 1;
		}
		
		return 0;
}
	
	private String[] headers = {"냉장고 번호","사용자 정보"};
}
