package com.refrigerator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import facade.DataEngineImpl;
import facade.UIData;
import mgr.Manageable;

public class Food implements Manageable,UIData{
	
	String fdname;
	public String type;
	int num;
	int exdate;
	Date time;
	SimpleDateFormat simpletime;
	int curTime;
	
	public Food(String name) {
		fdname = name;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("%s [%s] %d (유통기한 : %d)",fdname,type,num,exdate);
	}
	
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		type = scan.next();
		num = scan.nextInt();
		exdate = scan.nextInt();
	}

	public boolean checkRecFd(RecFd r) {
		if(type.equals(r.type)&&
				(num>=r.num)&& caneat()) {
					return true;
		}
		return false;
	}
	
	public int getCurrentTime() {
		time = new Date();
		simpletime = new SimpleDateFormat("yyyyMMdd");
		return (Integer.parseInt(simpletime.format(time)));
	}
	
	@Override
	public boolean matches(String kwd) {
		if(kwd.equals(""))
			return true;
		if(kwd.equals(fdname))
			return true;
		if(kwd.equals(type))
			return true;
		if(kwd.equals(""+num))
			return true;
		if(kwd.equals(""+exdate))
			return true;
		return false;
	}

	
	//유통기한 확인하는 함수(오늘 날짜값 받아서 확인)
    public boolean caneat() {
    	curTime = getCurrentTime();
    	if(exdate >= curTime) {
    		return true;
    	}
    	return false;
    }

	@Override
	public String[] getUiTexts() {
		String[] str = {fdname, type, num+"",exdate+""};
		return str;
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}
	
	
}