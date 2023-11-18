package ref_demo;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class recipemenu {

	public static void main(String[] args) {
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("레시피 관리");
		frame.setBounds(100, 100, 859, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	

	private static void addComponentsToPane(Container pane) {
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		JTable table;
		JTextField txt_findrecipe;
		JButton btn_findrecipe;
		pane.setLayout(new GridLayout(0, 2, 0, 0));
		pane.add(panel);
		pane.add(scrollPane);
		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC0AC\uC9C4", "\uC774\uB984", "\uC81C\uC791\uC790"
			}
		));
		scrollPane.setViewportView(table);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {34, 281, 60, 30};
		gbl_panel.rowHeights = new int[]{38, 47, 78, 78, 44, 78, 48, 78, 68, 23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txt_findrecipe = new JTextField();
		txt_findrecipe.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(txt_findrecipe, gbc_textField);
		
		btn_findrecipe = new JButton("검색 ");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		panel.add(btn_findrecipe, gbc_btnNewButton);
		
		JButton btn_makenow = new JButton("바로 만들 수 있는 레시피");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 3;
		panel.add(btn_makenow, gbc_btnNewButton_1);
		
		JButton btn_recommand = new JButton("레시피 추천 보기");
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1.gridwidth = 2;
		gbc_btnNewButton_1_1.gridx = 1;
		gbc_btnNewButton_1_1.gridy = 5;
		panel.add(btn_recommand, gbc_btnNewButton_1_1);
		
		JButton btn_deatilrecipe = new JButton("레시피 상세보기");
		GridBagConstraints gbc_btnNewButton_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_2.gridwidth = 2;
		gbc_btnNewButton_1_2.gridx = 1;
		gbc_btnNewButton_1_2.gridy = 7;
		panel.add(btn_deatilrecipe, gbc_btnNewButton_1_2);
		
		JButton btn_goback = new JButton("돌아가기");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 9;
		panel.add(btn_goback, gbc_btnNewButton_2);

	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		
	}
}
