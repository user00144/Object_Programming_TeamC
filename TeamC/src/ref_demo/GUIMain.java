package ref_demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUIMain {

	private static GUIMain main = null;
	private GUIMain() {}
	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}

	public static void startGUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIMain.getInstance().createAndShowGUI();
            }
        });
    }
	
	private void createAndShowGUI() {
		JFrame frame = new JFrame("식료품을 부탁해!");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);		
	}

	private void addComponentsToPane(Container pane) {
		pane.setBackground(Color.white);
		JTextField textField;
		JLabel lblProgramname = new JLabel();
		lblProgramname.setBounds(50,100,256,256);
		lblProgramname.setIcon(new ImageIcon("images/logo.png"));
		lblProgramname.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel loginpanel = new JPanel();
		loginpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		loginpanel.setBackground(Color.white);
		
		JLabel lblrefcode = new JLabel("냉장고 번호 : ");
		lblrefcode.setFont(new Font("굴림", Font.PLAIN, 14));
		loginpanel.add(lblrefcode);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 14));
		textField.setColumns(10);
		loginpanel.add(textField);
		
		JButton btn_login = new JButton("로그인");
		
		JButton btn_admin = new JButton("관리자 로그인");
		
		JButton btn_submit = new JButton("회원 가입");
		GroupLayout groupLayout = new GroupLayout(pane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_login, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblProgramname, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_admin, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_submit, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(loginpanel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblProgramname)
					.addGap(27)
					.addComponent(loginpanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_login)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_admin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_submit)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		pane.setLayout(groupLayout);
	}

}
