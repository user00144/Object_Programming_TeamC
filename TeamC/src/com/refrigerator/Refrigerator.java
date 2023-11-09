package com.refrigerator;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


import mgr.Manageable;
import mgr.Manager;
class Refrigerator implements Manageable{
	Manager<Food> foodMgr = new Manager<>();
	Date time;
	SimpleDateFormat simpletime;
	int curtime;
	int refcode;

	
	@Override
	public void print() {

		curtime = getCurrentTime();
		
		System.out.printf("냉장고 코드번호 : %d\t오늘 날짜 : %d\n"
				+ "\t\t= 식료품 목록 =\n", refcode,curtime);
		
		for(Food f : foodMgr.mList) {
			f.print();
			if(!f.caneat(curtime)) {
				System.out.print("\t(경고 : 유통기한 지남)");
			}
			System.out.println();
		}
	}
	
	public int getCurrentTime() {
		time = new Date();
		simpletime = new SimpleDateFormat("yyyyMMdd");
		return (Integer.parseInt(simpletime.format(time)));
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
		String temp = null;
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
	
	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(refcode+"")) {
			return true;
		}
		return false;
	}


}