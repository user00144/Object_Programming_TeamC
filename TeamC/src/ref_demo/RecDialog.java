package ref_demo;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class RecDialog {
	JFrame frame;
	public RecDialog(){
		createAndShowGUI();
	}
	
	private void createAndShowGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addComponentsToPane(Container pane) {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1};
		gridBagLayout.rowHeights = new int[] {426};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0};
		pane.setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pane.add(scrollPane, gbc_scrollPane);
		JTable table = new JTable();

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
		
		JButton btn_detailrec = new JButton("상세보기");
		GridBagConstraints gbc_btn_detailrec = new GridBagConstraints();
		gbc_btn_detailrec.insets = new Insets(0, 0, 5, 0);
		gbc_btn_detailrec.gridx = 0;
		gbc_btn_detailrec.gridy = 1;
		pane.add(btn_detailrec, gbc_btn_detailrec);

	}

}
