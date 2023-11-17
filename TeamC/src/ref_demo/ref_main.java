package ref_demo;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;

public class ref_main {
	
	private void createAndShowGUI() {
		JFrame frame;
		frame = new JFrame();
		frame.setBounds(100, 100, 942, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);

	}
	
	private void addComponentsToPane(Container pane) {
		JTextField tf_refcode;
		JTable table;

		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton fd_detailview = new JButton("상세보기");
		
		JButton fd_menu = new JButton("식료품 관리");
		
		JButton rec_menu = new JButton("레시피 보기");
		
		JButton logout = new JButton("로그아웃");
		
		JLabel lblNewLabel = new JLabel("냉장고 번호: ");
		
		tf_refcode = new JTextField();
		tf_refcode.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(pane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
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
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(119)
					.addComponent(fd_detailview, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(fd_menu)
					.addGap(18)
					.addComponent(rec_menu)
					.addGap(18)
					.addComponent(logout)
					.addGap(30))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(logout, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addComponent(fd_detailview, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(fd_menu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(rec_menu, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tf_refcode, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tf_refcode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		pane.setLayout(groupLayout);
	}
}
