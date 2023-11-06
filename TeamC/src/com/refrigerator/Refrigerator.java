package com.refrigerator;
import java.util.Scanner;

import mgr.Manageable;
import mgr.Manager;
class Refrigerator implements Manageable{
	Manager<Food> foodMgr = new Manager<>();
	int refcode;
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
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