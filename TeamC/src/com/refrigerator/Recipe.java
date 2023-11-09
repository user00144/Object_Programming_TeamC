package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

class Recipe implements Manageable{

	String name;
	String cookName;
	ArrayList<String> recstr = new ArrayList<>();
	ArrayList<RecFd> recList = new ArrayList<>();

	
	@Override
	public void print() {
		// 요리할 음식과 필요한 식재료 출력
		System.out.printf("요리할 음식 : %s \n", name);
		System.out.printf("= 재료 = \n");
		for (RecFd r : recList) {
			r.print();
		}
		System.out.printf("= 레시피 =\n");
		for(String str : recstr) {
			System.out.println(str);
		}
	}

	@Override
	public void read(Scanner scan) {
		String s = null;
		RecFd rfd = null;
		name = scan.next();
		cookName = scan.next();
		while(true) {
			s = scan.nextLine();
			if(s.contentEquals("end"))
				break;
			recstr.add(s);
		}
		while(true) {
			s = scan.next();
			if(s.contentEquals("end"))
				break;
			rfd = new RecFd();
			rfd.type = s;
			rfd.num = scan.nextInt();
			recList.add(rfd);
		}
	}


	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(name))
			return true;
		if(kwd.contentEquals(cookName))
			return true;
		for(RecFd r : recList) 
			if(kwd.contentEquals(r.type)) 
				return true;
		return false;
	}

}