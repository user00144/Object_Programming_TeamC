package ref_demo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.refrigerator.Recipe;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Container;

public class DetailRec {
	JFrame frame;
	Recipe curRec;
	
	Font lblFont = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15);
	Font titleFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 17);

	public DetailRec(Recipe r) {
		this.curRec = r;
		createAndShowGUI();
	}

	
	private void createAndShowGUI() {
		JFrame frame;
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 558);
		addComponentsToPane(frame.getContentPane());
		frame.setVisible(true);

	}
	private void addComponentsToPane(Container pane) {
		pane.setBackground(Color.white);
		Object[] obj = curRec.getImgContent();
		String[] str = curRec.getUiTexts();
		
		pane.setLayout(new GridLayout(1, 3, 0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		pane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{287, 0};
		gbl_panel.rowHeights = new int[] {341, 40, 44, 40, 23, 30, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(lblFont);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setIcon((ImageIcon)obj[0]);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("나눔스퀘어라운드 ExtraBold",Font.BOLD,25));
		lblNewLabel_3.setText(obj[1].toString());
		
		JLabel lblNewLabel_4 = new JLabel("제작자");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setFont(titleFont);
		lblNewLabel_4.setText(obj[2].toString());

	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1.setBackground(Color.white);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(lblFont);
		lblNewLabel_1.setText(str[0]);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.setBackground(Color.white);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(lblFont);
		lblNewLabel_2.setText(str[1]);
	}
	
}
