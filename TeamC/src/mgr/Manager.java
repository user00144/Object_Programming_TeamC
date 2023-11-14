package mgr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();
	
	
	public void printAll() {
		for(T m : mList) {
			m.print();
		}
	}
	
	public void addItem(T m) {
		mList.add(m);
	}
	
	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while(filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}
	
	public void read(Scanner scan, Factory<T> fac) {
		T m = null;
		m = fac.create();
		m.read(scan);
		mList.add(m);
	}
	
	
	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e)
		{
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}
	
	
	public T find(String kwd) {
		for(T m : mList) {
			if(m.matches(kwd)) {
				return m;
			}
		}
		return null;
	}
	
	public void delItem(Scanner scan) {
		String kwd = null;
		while(true) {
			System.out.print("키워드:");
			kwd = scan.next();
			if(kwd.contentEquals("end")) {
				break;
			}
			T m = find(kwd);
			if(m == null) {
				System.out.println("삭제 오류");
				return;
			}
			System.out.println("삭제 성공");
			mList.remove(m);
		}

	}
		
	public void search(Scanner scan) {
		String name = null;
		while (true) {
			System.out.print("키워드:");
			name = scan.next();
			if (name.equals("end"))
				break;
			for (Manageable m : mList) {
				if (m.matches(name))
					m.print();
			}
		}
	}
	
}

