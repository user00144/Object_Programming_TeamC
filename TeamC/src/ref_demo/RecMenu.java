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

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.Management;
import com.refrigerator.RecMgr;
import com.refrigerator.Recipe;
import com.refrigerator.RefMgr;
import com.refrigerator.Refrigerator;

import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RecMenu {
	
	JPanel frame;
	DefaultTableModel data;
	Recipe selectedRc;
	JTable table;
	JTextField txt_findrecipe;
	JButton btn_findrecipe;
	Refrigerator curRf;
	DefaultTableModel df;
	
	   private static RecMenu engine = null;
		public static RecMenu getInstance(Refrigerator ref) {
			if (engine == null)
				engine = new RecMenu(ref);
			return engine;
		}
	
	
	public RecMenu(Refrigerator rf) {
		this.curRf = rf;
	}
	

    public JPanel run(Refrigerator rf) {
        this.curRf = rf;
        frame = new JPanel();
        addComponentsToPane(frame);
        updateTable("");
 	      return frame;
    }
	/*
	private void createAndShowGUI() {
		frame = new JFrame("레시피 관리");
		frame.setBounds(100, 100, 859, 654);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	*/

	void addComponentsToPane(Container pane) {
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		pane.setLayout(new GridLayout(0, 2, 0, 0));
		pane.add(panel);
		pane.add(scrollPane);
		table = new JTable(){
            
            @Override
            public Class<?> getColumnClass(int column)  {
                 return getValueAt(0,  column).getClass();
            }};
        table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount()== 2) {
        			int row = table.getSelectedRow();
        			String kwd = (String) table.getValueAt(row,1);
        			selectedRc = RecMgr.getInstance().find(kwd);
        			
        			if(selectedRc != null) {
        				openReviewMenu(selectedRc);
        			}
        		}
        	}

			private void openReviewMenu(Recipe recipe) {
				// TODO Auto-generated method stub
						try {reviewmenu reviewMenu = new reviewmenu(recipe);
					} catch (Exception e) {
						e.printStackTrace();
					}
				

			}
        });    
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {34, 281, 60, 30};
		gbl_panel.rowHeights = new int[] {38, 47, 78, 78, 44, 78, 48, 78, 68, 23, 30, 0};
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
		
		btn_findrecipe = new JButton("검색");
		btn_findrecipe.addActionListener(new btnRecEvent());
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		panel.add(btn_findrecipe, gbc_btnNewButton);
		
		JButton btn_makenow = new JButton("바로 만들 수 있는 레시피");
		btn_makenow.addActionListener(new btnRecEvent());
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 3;
		panel.add(btn_makenow, gbc_btnNewButton_1);
		
		JButton btn_recommand = new JButton("레시피 추천 보기");
		btn_recommand.addActionListener(new btnRecEvent());
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1.gridwidth = 2;
		gbc_btnNewButton_1_1.gridx = 1;
		gbc_btnNewButton_1_1.gridy = 5;
		panel.add(btn_recommand, gbc_btnNewButton_1_1);
		
		JButton btn_deatilrecipe = new JButton("레시피 상세보기");
		btn_deatilrecipe.addActionListener(new btnRecEvent());
		GridBagConstraints gbc_btnNewButton_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_2.gridwidth = 2;
		gbc_btnNewButton_1_2.gridx = 1;
		gbc_btnNewButton_1_2.gridy = 7;
		panel.add(btn_deatilrecipe, gbc_btnNewButton_1_2);

		updateTable("");
	}
	
	class btnRecEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			String s = source.getText();
			switch(s) {
			case "검색":
				updateTable("");
				break;
			case "바로 만들 수 있는 레시피":
				updateTable(s);
				break;
			case "레시피 추천 보기":
				updateTable(s);
				break;
			case "레시피 상세보기":
				if(selectedRc != null) {
					new DetailRec(selectedRc);
				}
				break;
			}
		}
		
	}
	
	private void updateTable(String str) {
		String s = null;
		s = txt_findrecipe.getText();
		
		df = null;
		
		df = new DefaultTableModel(null,RecMgr.getInstance().headers) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		switch(str) {
		case "":
			if(s.contentEquals("")) {
				for(Recipe r : RecMgr.getInstance().mList) {
					df.addRow(r.getImgContent());
				}
			}
			else {
				for(Recipe r : RecMgr.getInstance().mList) {
					if(r.matches(s))
						df.addRow(r.getImgContent());
				}
			}
			break;
		case "바로 만들 수 있는 레시피":
			for(Recipe r : RecMgr.getInstance().mList) {
				if(curRf.canmake(r))
					df.addRow(r.getImgContent());
			}
			break;
		case "레시피 추천 보기":
			for(String string : curRf.userinfo) {
				for(Recipe r : RecMgr.getInstance().mList) {
					if(r.usermatch(string))
						df.addRow(r.getImgContent());
				}
			}
			break;
		}
		
		table.setModel(df);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
	}
	
}
