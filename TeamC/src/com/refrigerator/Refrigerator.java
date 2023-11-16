package com.refrigerator;
import java.util.Scanner;

import facade.DataEngineImpl;
import facade.UIData;

import java.util.Date;
import java.text.SimpleDateFormat;
import mgr.Manageable;
import mgr.Manager;
import java.util.ArrayList;


class Refrigerator implements Manageable,UIData{
	
	Manager<Food> foodMgr = new Manager<>();
	ArrayList<String> userinfo = new ArrayList<>();
	Date time;
	SimpleDateFormat simpletime;
	int refcode;
	
	
public void delFoods(Scanner scan) {
			foodMgr.delItem(scan);
		}

public boolean canmake(Recipe r) {
	int cnt = 0;
	boolean flag = false;
	for(RecFd rf : r.recList) {
		flag = false;
		for(Food fd : foodMgr.mList) {
			if(fd.checkRecFd(rf)&&flag==false) {
				cnt++;
				flag = true;
			}
		}
	}
	if(cnt == r.recList.size()) {
		return true;
	}
	return false;
}

public void findRecipe(Scanner scan,Management m) {
		System.out.println(refcode +" :<< 만들 수 있는 레시피 목록 >>");
		for (Recipe r: RecMgr.getInstance().mList) {
			if(canmake(r)) {
				r.print();
				System.out.println();
			}
	}
}
    
public void searchFoods(Scanner scan) {
		String kwd = null;
		while (true) {
			System.out.print("키워드: ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			for (Food m: foodMgr.mList) {
				if (m.matches(kwd)) {
					m.print();
					System.out.println();
				}
			}
		}
	}
	
	
	
	@Override
	public void print() {
		System.out.printf("냉장고 코드번호 : %d\t오늘 날짜 : %d\n", refcode,getCurrentTime());
		for(String str : userinfo) {
			System.out.print("#"+str+" ");
		}
		System.out.printf("\n\t\t= 식료품 목록 =\n");
		
		for(Food f : foodMgr.mList) {
			f.print();
			if(!f.caneat()) {
				System.out.print("\t!유통기한 지남!");
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
		while(true) {
			temp = scan.next();
			if(temp.equals("end")) {
				break;
			}
			userinfo.add(temp);
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

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return null;
	}


}