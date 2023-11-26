package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import facade.DataEngineImpl;
import facade.UIData;
import mgr.Manageable;

public class Recipe implements Manageable,UIData{
	Scanner tmpscan = new Scanner(System.in);
	String name;
	String cookName;
	ImageIcon img;
	ArrayList<String> recstr = new ArrayList<>();
	ArrayList<RecFd> recList = new ArrayList<>();
	ArrayList<String> userinfo = new ArrayList<>();
	ArrayList<Review> rvList = new ArrayList<>();

	
	@Override
	public void print() {
		// 요리할 음식과 필요한 식재료 출력
		System.out.printf("\n=== %s === / 작성자 : %s\n", name,cookName);
		for(String str : userinfo) {
			System.out.print("#"+str+" ");
		}
		System.out.printf("\n<< 재료 >>\n");
		for (RecFd r : recList) {
			r.print();
		}
		System.out.printf("<< 레시피 >>");
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
			s = scan.next();
			if(s.contentEquals("end"))
				break;
			rfd = new RecFd(s);
			rfd.read(scan);
			recList.add(rfd);
		}
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
			userinfo.add(s);
		}
		s = scan.next();
		img = new ImageIcon(s);

	}


	public boolean usermatch(String kwd) {
		for(String str : userinfo) {
			if(str.contains(kwd)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean matches(String kwd) {
		if(name.contains(kwd)) {
			return true;
		}
		if(kwd.contentEquals(cookName)) {
			return true;
		}
		for(RecFd r : recList) {
			if(kwd.contentEquals(r.type)) 
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
		String[] result = new String[2];
		
		StringBuffer stbf = new StringBuffer();
		
		
		stbf.append("<HTML> =식재료 목록= <br>");
		for(RecFd r : recList) {
			stbf.append(r+"<br>");
		}
		stbf.append("</HTML>");
		result[0] = stbf.toString();

		
		stbf.delete(0, stbf.length());
		
		stbf.append("<HTML> =요리방법= <br>");

		for(String str : recstr) {
			stbf.append(str+"<br>");
		}
		stbf.append("</HTML>");

		result[1] = stbf.toString();

		return result;
	}
	
	public Object[] getImgContent() {
		Object[] temp = {img, name, cookName};
		return temp;
	}
	
	public Object[] getRecommendContent(String s) {
		Object[] temp = {img, name, cookName, s};
		return temp;
	}


}