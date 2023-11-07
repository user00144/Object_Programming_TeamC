package com.refrigerator;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import mgr.Manageable;
import mgr.Manager;
class Refrigerator implements Manageable{
	Manager<Food> foodMgr = new Manager<>();
	Timestamp time;
	SimpleDateFormat simpletime;
	int curtime;
	int refcode;
	
	public Refrigerator() {
		
	}
	
	@Override
	public void print() {
		time = new Timestamp(System.currentTimeMillis());
		simpletime = new SimpleDateFormat("yyyymmdd");
		curtime = Integer.parseInt(simpletime.format(time));
		
		// TODO Auto-generated method stub
		for(Food m : foodMgr.mList) {
			if(m.chkexdate(curtime)) {
				
			}
		}
	}

	@Override
	public void read(Scanner scan) {

		// TODO Auto-generated method stub
		String temp = null;
		
		refcode = scan.nextInt();
		while(true) {
			temp = scan.next();
			if(temp.equals("end")) {
				break;
			}
			Food fd = new Food(temp);
			fd.read(scan);
			foodMgr.addItem(fd);
		}
		
	}
 
	public void addFoods(Scanner scan) {
		
	}
	
	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(refcode+"")) {
			return true;
		}
		return false;
	}


}