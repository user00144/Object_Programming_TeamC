package com.refrigerator;

import mgr.Manager;

public class Management{

	Manager<Refrigerator> rMgr = new Manager<>();
	
	public void run() {
		
	}
	
	
	public static void main(String[] args) {
		Management refMgr = new Management();
		refMgr.run();
	}
}