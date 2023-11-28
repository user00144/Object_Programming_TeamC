package ref_demo;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.Recipe;
import com.refrigerator.Review;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class reviewmenu {
	JFrame frame;
	JTable table;
	DefaultTableModel tableModel;
	ButtonGroup buttonGroup;
	JButton btnNewButton;
	Recipe curRc;
    String[] rvheader = {"리뷰", "평점"};

	public reviewmenu(Recipe rc) {
		this.curRc = rc;
		createAndShowGUI();
		updateTable();
	}

	private void createAndShowGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 909, 560);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	private void addComponentsToPane(Container pane) {
		buttonGroup = new ButtonGroup();
		pane.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel = new JPanel();
		pane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 35, 73, 287, 30, 0 };
		gbl_panel.rowHeights = new int[] { 37, 28, 382, 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("음식이름");
		lblNewLabel.setText(curRc.name);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("제작자");
		lblNewLabel_1.setText(curRc.cookName);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		table = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, 
				new String[] { "한줄평", "평점" });
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);

		JPanel panel_1 = new JPanel();
		pane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 33, 50, 50, 50, 50, 155, 30, 0 };
		gbl_panel_1.rowHeights = new int[] { 65, 26, 173, 33, 23, 53, 49, 30, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("한줄평");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.gridwidth = 5;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		panel_1.add(textArea, gbc_textArea);

		JLabel lblNewLabel_3 = new JLabel("평점");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 4;
		panel_1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		buttonGroup.add(rdbtnNewRadioButton_1);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		panel_1.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		buttonGroup.add(rdbtnNewRadioButton_2);
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 3;
		gbc_rdbtnNewRadioButton_2.gridy = 4;
		panel_1.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		buttonGroup.add(rdbtnNewRadioButton_3);
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 4;
		gbc_rdbtnNewRadioButton_3.gridy = 4;
		panel_1.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		buttonGroup.add(rdbtnNewRadioButton_4);
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_4.gridx = 5;
		gbc_rdbtnNewRadioButton_4.gridy = 4;
		panel_1.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);

		JButton btnNewButton = new JButton("리뷰작성");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String reviewText = textArea.getText();
				int selectedRating = getSelectedRating();
				
				curRc.addReview(reviewText, selectedRating);
				
				updateTable();
				
			}

		});
	}
	public int getSelectedRating() {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
			if(button.isSelected()) {
				return Integer.parseInt(button.getText());
				
			}
		}
		return 0;
	}
	   public void updateTable() {
		      DefaultTableModel df = null;
		      
		      df = new DefaultTableModel(null,rvheader){
		    	  
		         public boolean isCellEditable(int row, int column) {
		        	 
		            return false;
		            
		         }
		      };
		      
		      for(Review rv : curRc.rvList) {
		    	  
		         df.addRow(rv.getUiTexts());
		         
		      }
		      table.setModel(df);
		   }

	
	
	
}
