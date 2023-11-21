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
			System.out.print("1. 레시피 관리 2. 냉장고 관리 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:recmenu();  break;
			case 2:refmenu();  break;
			default : return;
			}
		}

	}
	
	private void recmenu() {
		int menu;
		while(true) {
			System.out.print("1. 레시피 출력 2. 레시피 추가 3. 레시피 삭제 : ");
			menu = scan.nextInt();		
			switch(menu) {
			case 1:RecMgr.getInstance().printAll();  break;
			case 2:RecMgr.getInstance().read(scan, new Factory<Recipe>() {
			public Recipe create() {
				return new Recipe();
			}
		});  break;
			case 3: RecMgr.getInstance().delItem(scan); break;
			default : return;
			}
		}
		}
	
	private void refmenu() {
		int menu;
		while(true) {
			System.out.print("1. 냉장고 출력 2. 냉장고 추가 3. 냉장고 삭제 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:RefMgr.getInstance().printAll();  break;
			case 2:RefMgr.getInstance().read(scan, new Factory<Refrigerator>() {
			public Refrigerator create() {
				return new Refrigerator();
			}
		});  break;
			case 3:RefMgr.getInstance().delItem(scan); break;
			default : return;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Management refMgr = new Management();
		refMgr.run();
		GUIMain.getInstance().startGUI();
	}

}