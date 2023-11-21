package ref_demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class FoodMgrMenu {
	JFrame frame;
	public FoodMgrMenu() {
		createAndShowGUI();
	}
	
	void createAndShowGUI() {
		frame = new JFrame("식료품 관리");
		frame.setBounds(100, 100, 942, 724);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); -> 프로그램 강제 종료됨
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		
	}
	static void addComponentsToPane(Container pane) {
		JTextField textField;
		JTable table;
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"매일우유", "우유", 100, "20231106"},
				{"소라빵", "소라빵", 150, "20231105"},
				{"해찬들된장", "된장", 1000, "20241111"},
				{"고추장", "고추장", 1500, "20241212"},
				{"삼양라면", "라면", 500, "20261111"},
				{"깻잎", "깻잎", 200, "20231201"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"이름", "타입", "중량", "유통기한"
			}
		));
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
		
		JButton btnNewButton_1 = new JButton("삭제");
		
		JButton btnNewButton_2 = new JButton("검색");
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
	
}
