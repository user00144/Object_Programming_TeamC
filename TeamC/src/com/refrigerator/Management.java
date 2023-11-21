package com.refrigerator;

import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;
import ref_demo.GUIMain;

public class Management {
	private static Management engine = null;
	
	public static Management getInstance() {
		if(engine == null) {
			engine = new Management();
		}
		return engine;
	}

	
	Scanner scan = new Scanner(System.in);	
	public void run() {
		RefMgr.getInstance().readAll("ref.txt", new Factory<Refrigerator>() {
			public Refrigerator create() {
				return new Refrigerator();
			}
		});

		RecMgr.getInstance().readAll("rec.txt",new Factory<Recipe>() {
			public Recipe create() {
				return new Recipe();
			}
		});		
	}
	
	public void ManagerMenu() {
		int menu;
		System.out.println("<<관리자 모드 진입>>");
		while(true) {
			System.out.print("1. 레시피 관리 2. 냉장고 관리 3. 로그아웃 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:  break;
			case 2:  break;
			case 3: break;
			default : return;
			}
		}

	}
	public static void main(String[] args) {
		Management refMgr = new Management();
		refMgr.run();
		GUIMain.getInstance().startGUI();
	}

}