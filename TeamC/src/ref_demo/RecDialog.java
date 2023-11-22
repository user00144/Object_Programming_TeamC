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
	public RecDialog(String s){
		createAndShowGUI(s);
		updateTable(s);
	}
	
	private void createAndShowGUI(String s) {
		frame = new JFrame(s);
		frame.setBounds(100, 100, 412, 510);
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
		scrollPane.setViewportView(table);
		
		JButton btn_detailrec = new JButton("상세보기");
		GridBagConstraints gbc_btn_detailrec = new GridBagConstraints();
		gbc_btn_detailrec.insets = new Insets(0, 0, 5, 0);
		gbc_btn_detailrec.gridx = 0;
		gbc_btn_detailrec.gridy = 1;
		pane.add(btn_detailrec, gbc_btn_detailrec);

	}
	
	private void updateTable(String s) {
		if(s.contentEquals("바로 만들 수 있는 레시피")) {
			
		}
		else {
			
		}
	}

}
