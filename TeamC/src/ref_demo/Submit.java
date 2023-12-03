package ref_demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.refrigerator.RefMgr;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class Submit {
	JDialog frame;
	String filepath;
	File selectedfdfile;
	JTextField txt_fdfile;
	JTextField txt_refcode;
	JTextArea textArea;
	Font lblFont = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 14);
	Font titleFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 17);

	JButton btngetfood_1;
	JButton btngetfood;
	
	public Submit() {
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		frame = new JDialog(GUIMain.getInstance().getframe(),"회원가입");
		frame.setBounds(100, 100, 364, 326);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);

	}
	private void addComponentsToPane(Container pane) {
		pane.setBackground(Color.WHITE);

		JLabel lbluserinfo = new JLabel("사용자 정보(#로 구분해서 작성)");
		lbluserinfo.setFont(lblFont);
		
		textArea = new JTextArea();
		textArea.setColumns(45);
		textArea.setRows(3);
		textArea.setBackground(Color.lightGray);
		
		btngetfood_1 = new JButton(new ImageIcon("images/ui_img/btn_submit.png"));
		btngetfood_1.setFont(lblFont);
		pane.setLayout(new GridLayout(0, 1, 0, 0));
		btngetfood_1.setBorderPainted(false);
		btngetfood_1.setBackground(Color.white);
		btngetfood_1.setOpaque(false);
		
		JLabel lbl_submit = new JLabel("회원가입");
		lbl_submit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_submit.setFont(titleFont);
		pane.add(lbl_submit);
		
		JPanel panel_1 = new JPanel();
		pane.add(panel_1);
		
		JLabel lblref = new JLabel("냉장고 번호 : ");
		lblref.setFont(lblFont);
		panel_1.add(lblref);
		
		txt_refcode = new JTextField();
		txt_refcode.setFont(lblFont);
		txt_refcode.setColumns(10);
		panel_1.add(txt_refcode);
		pane.add(lbluserinfo);
		pane.add(textArea);
		
		JPanel panel = new JPanel();
		pane.add(panel);
		
		JLabel lblfood = new JLabel("식료품 정보 : ");
		lblfood.setFont(lblFont);
		panel.add(lblfood);
		
		txt_fdfile = new JTextField();
		txt_fdfile.setEditable(false);
		txt_fdfile.setColumns(10);
		panel.add(txt_fdfile);
		
		btngetfood = new JButton(new ImageIcon("images/ui_img/btn_find.png"));
		btngetfood.setBorderPainted(false);
		btngetfood.setBackground(Color.white);
		btngetfood.setOpaque(false);
		btngetfood.setFont(lblFont);
		panel.add(btngetfood);
		pane.add(btngetfood_1);
		
		panel.setBackground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		
		btngetfood.addActionListener(new btnSubmitEvent());
		btngetfood_1.addActionListener(new btnSubmitEvent());
	}
	
	class btnSubmitEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			JOptionPane j = new JOptionPane();
			if(source.equals(btngetfood)) {
				JFileChooser file = new JFileChooser();
				int result = file.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION) {
					selectedfdfile = file.getSelectedFile();
					filepath = selectedfdfile.toString();
					txt_fdfile.setText(filepath);
				}
			}
			if(source.equals(btngetfood_1)) {
				String refcode = txt_refcode.getText();
				String[] userinfo = textArea.getText().split("#");
				try {
					if(RefMgr.getInstance().find(refcode)==null) {
						int result = RefMgr.getInstance().addRef(refcode,userinfo,filepath);
						if(result == 0) {
							j.showMessageDialog(frame, "회원가입 완료", "", JOptionPane.PLAIN_MESSAGE);
							frame.setVisible(false);
						}else {
							j.showMessageDialog(null, "등록 실패", "오류", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						j.showMessageDialog(frame, "냉장고 번호 중복", "오류", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception ee) {
					j.showMessageDialog(null, "등록 실패", "오류", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
		
	}
	
}
