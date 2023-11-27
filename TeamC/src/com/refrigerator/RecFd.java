package com.refrigerator;
import java.util.Scanner;

import mgr.Manageable;

public class RecFd implements Manageable{ //레시피에 필요한 재료의 타입&중량
	public String type;
	public int num;
	
	public RecFd(String str){
		type = str;
	}
	
	public void print() {
		System.out.println(type + " " + num);
	}


	@Override
	public void read(Scanner scan) {
		num = scan.nextInt();
	}

	@Override
	public String toString() {
		return type+" "+num;
	}
	
	@Override
	public boolean matches(String kwd) {
		return false;
	}
}
