package ref_demo;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.refrigerator.RecMgr;
import com.refrigerator.Recipe;
import com.refrigerator.Refrigerator;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

public class RecDialog {
	JFrame frame;
	JTable table;
	Recipe selectedRc;
	DefaultTableModel df;
	Refrigerator curRf;
	public RecDialog(String s, Refrigerator curRf){
		this.curRf = curRf;
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
		table = new JTable(){
            
            @Override
            public Class<?> getColumnClass(int column)  {
                 return getValueAt(0,  column).getClass();
            }};
            
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String kwd = null;
				int row = table.getSelectedRow();
				kwd = (String)table.getValueAt(row, 1);
				selectedRc = RecMgr.getInstance().find(kwd);
			}
		});
		table.setRowHeight(250);
		scrollPane.setViewportView(table);
		
		JButton btn_detailrec = new JButton("상세보기");
		GridBagConstraints gbc_btn_detailrec = new GridBagConstraints();
		gbc_btn_detailrec.insets = new Insets(0, 0, 5, 0);
		gbc_btn_detailrec.gridx = 0;
		gbc_btn_detailrec.gridy = 1;
		pane.add(btn_detailrec, gbc_btn_detailrec);

	}
	
	private void updateTable(String s) {
		
		df = null;
		
		df = new DefaultTableModel(null,RecMgr.getInstance().headers) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if(s.contentEquals("바로 만들 수 있는 레시피")) {
			for(Recipe r : RecMgr.getInstance().mList) {
				if(curRf.canmake(r))
					df.addRow(r.getImgContent());
			}
		}
		else {
			for(String str : curRf.userinfo) {
				for(Recipe r : RecMgr.getInstance().mList) {
					if(r.usermatch(str))
						df.addRow(r.getImgContent());
				}
			}
		}
		table.setModel(df);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
	}

}
