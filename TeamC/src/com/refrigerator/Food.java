package com.refrigerator;
import java.util.Scanner;

import mgr.Manageable;
class Food implements Manageable{
	
	String fdname;
	String type;
	int num;
	int exdate;
	
	public Food(String name) {
		fdname = name;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		type = scan.next();
		num = scan.nextInt();
		exdate = scan.nextInt();
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return false;
	}

	
	//유통기한 확인하는 함수(오늘 날짜값 받아서 확인)
    public boolean chkexdate(int today) {
    	if(exdate >= today) {
    		return true;
    	}
    	return false;
    }
}