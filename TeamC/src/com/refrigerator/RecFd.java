package com.refrigerator;
import java.util.Scanner;

import mgr.Manageable;

public class RecFd implements Manageable{
	String type;
	int num;
	
	
	public void print() {
		System.out.println(type + " " + num);
	}


	@Override
	public void read(Scanner scan) {
		
	}


	@Override
	public boolean matches(String kwd) {
		return false;
	}
}
