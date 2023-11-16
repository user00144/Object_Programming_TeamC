package mgr;

import java.util.Scanner;

public interface Manageable {

	String name = "";
	String cookName= "";
	
	public void print();
	public void read(Scanner scan);
	public boolean matches(String kwd);
}
