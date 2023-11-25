package ref_demo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.refrigerator.Refrigerator;

public class Tab_Control_GUI extends JFrame{
	Refrigerator rf;
	
	
	
	public Tab_Control_GUI(Refrigerator rf)
	{
		this.rf = rf;
		createAndShowGUI();
	}
	
	public void run(Refrigerator rf) {
		this.rf = rf;
		createAndShowGUI();
	}
	
	   private static Tab_Control_GUI rmain = null;
		public static Tab_Control_GUI getInstance(Refrigerator ref) {
			if (rmain == null)
				rmain = new Tab_Control_GUI(ref);
			return rmain;
		}
	
		   void createAndShowGUI() {
			      setTitle("식료품을 부탁해!");
			      setBounds(100, 100, 942, 724);
			      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      JTabbedPane jtab = new JTabbedPane();
      
			      jtab.addTab("메인화면",   RefMain.getInstance(rf).run(rf));

			      jtab.addTab("식료품 관리", FoodMgrMenu.getInstance(rf).run(rf));

			      jtab.addTab("레시피 관리", RecMenu.getInstance(rf).run(rf));
			      
			      setContentPane(jtab);
			      pack();
			      setExtendedState(JFrame.MAXIMIZED_BOTH);
			      setVisible(true);

			   }
		   
}
