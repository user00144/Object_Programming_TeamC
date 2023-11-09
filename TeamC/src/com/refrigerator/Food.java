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
		System.out.printf("%s[%s],\t%d\t유통기한 %d",fdname,type,num,exdate);
	}

	@Override
	public String toString() {
		return (fdname+" "+type+" "+num+" "+exdate+"\n");
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
		if(fdname.equals(kwd))
			return true;
		return false;
	}

	
	//유통기한 확인하는 함수(오늘 날짜값 받아서 확인)
    public boolean caneat(int today) {
    	if(exdate >= today) {
    		return true;
    	}
    	return false;
    }
}