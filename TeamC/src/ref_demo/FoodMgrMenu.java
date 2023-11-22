package ref_demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.Refrigerator;

import facade.IDataEngine;

public class FoodMgrMenu {
	JFrame frame;
	Refrigerator curRf;
	JTextField textField;
	JTable table;
	IDataEngine<?> dataMgr;
	public FoodMgrMenu(Refrigerator rf) {
		this.curRf = rf;
		createAndShowGUI();
	}
	
	void createAndShowGUI() {
		frame = new JFrame();
		frame.setTitle("식료품 관리");
		frame.setBounds(100, 100, 942, 724);
		addComponentsToPane(frame.getContentPane());
		frame.addWindowListener(new WindowClosingEvent());
		frame.pack();
		frame.setVisible(true);
		
	}
	void addComponentsToPane(Container pane) {

		JScrollPane scrollPane = new JScrollPane();
		JPanel panel_2 = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(panel_2);
		pane.setBackground(Color.white);
		panel_2.add(scrollPane);
		panel_2.setBackground(Color.white);

		panel_2.setPreferredSize(new Dimension(800,340));
		scrollPane.setPreferredSize(new Dimension(800,340));
		table = new JTable();
		
		DefaultTableModel df = null;
		
		df = new DefaultTableModel(null,FoodMgr.getInstance().headers) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		for(Food f : curRf.foodMgr.mList) {
			df.addRow(f.getUiTexts());
		}
		
		table.setModel(df);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		pane.add(panel_1);
		panel_1.setPreferredSize(new Dimension(800,50));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setPreferredSize(new Dimension(800,40)); // 패널 사이즈 조정
		panel_3.setBackground(Color.white);

		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new BtnEventListener());
		
		JButton btnNewButton_1 = new JButton("삭제");
		
		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.addActionListener(new BtnEventListener());
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel = new JPanel();
		pane.add(panel);
		
		ImageIcon image = new ImageIcon("images/food_bg.png");
		JLabel lblNewLabel = new JLabel("이미지",image,SwingConstants.CENTER);

		panel.add(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(800,150));
		
	}
	
   class BtnEventListener implements ActionListener{

	      @Override
	      public void actionPerformed(ActionEvent e) {
	         JButton source = (JButton)e.getSource();
	         switch (source.getText()) {
	         case "추가": addRecord(); break;
	         case "삭제": deleteRecord(); break;
	         case "검색": updateTable(); break;
	         default : break;
	         }
	      }
	   }
   
   private void addRecord() {
	   String s = null;
	   String[] mobS;
	   int cnt = 0;
	   Vector data = new Vector<>(); // 전체 데이터를 저장할 Vector 객체 생성
	   Vector rowData = new Vector<>(); // 1개 행 데이터를 저장할 Vector 객체 생성 및 데이터 저장
		
		try {
			s = textField.getText();
		}
		catch(NullPointerException e){
			s = null;
		}
		
		DefaultTableModel df = null;
		
		df = new DefaultTableModel(null,FoodMgr.getInstance().headers) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		if(s == null || s.equals(" ") || s.length() == 0) {
			try {
				mobS = s.split(",");
			}
			catch(NullPointerException e){
				mobS = null;
			}
			JOptionPane.showMessageDialog(null, "공백 값은 허용되지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			mobS = s.split(",");
			for(Food f : curRf.foodMgr.mList) {
				for(int i = 0; i < s.length(); i++) {
					if(s.contains(",")) {
						if(s.length() >= 14) { // 형식에 맞게 문자열 길이 처리하기 위함(이름 => 최소 1, 타입 => 최소 1, 중량 => 최소 1, 유통기한 => 8)
							JOptionPane.showMessageDialog(null, "추가되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
							for(i = 0; i < 4; i++) {
								rowData.add(mobS[i]);
							}
							for(Food food : curRf.foodMgr.mList) {
								df.addRow(food.getUiTexts());
							}
							df.addRow(rowData);
							updateTable();
							table.setModel(df);
							return;
						}
						else{
							JOptionPane.showMessageDialog(null, "형식에 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "형식에 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
			

		}
		table.setModel(df);
   }


private void deleteRecord() {
	
   }
	   
   private void updateTable() {
		String s = null;
		try {
			s = textField.getText();
		}
		catch(NullPointerException e){
			s = null;
		}
		
		DefaultTableModel df = null;
		
		df = new DefaultTableModel(null,FoodMgr.getInstance().headers) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		if(s==null) {
			for(Food f : curRf.foodMgr.mList) {
				df.addRow(f.getUiTexts());
			}
		}
		else {
			for(Food f : curRf.foodMgr.mList) {
				if(f.matches(s))
					df.addRow(f.getUiTexts());
			}
		}
		table.setModel(df);
	}
	
	class WindowClosingEvent extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			JFrame frame = (JFrame)e.getWindow();
			frame.setVisible(false);
			RefMain.getInstance().foodMgrExit(curRf);
		}
	}
	
}
