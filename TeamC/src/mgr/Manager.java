package mgr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Manager<T extends Manageable> {
	ArrayList<T> mList = new ArrayList<>();
	
	
	public void printAll() {
		for(T m : mList) {
			m.print();
		}
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
	
	
	Scanner openFile(String filename) {
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
	
	
	Manageable find(String kwd) {
		for(T m : mList) {
			if(m.matches(kwd)) {
				return m;
			}
		}
		return null;
	}
	
	
}

