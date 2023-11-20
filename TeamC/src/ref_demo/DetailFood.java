package ref_demo;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

public class DetailFood extends JDialog{
	String[] itemDetails;
	
	public DetailFood(String[] texts){
		this.itemDetails = texts;
	}
//	texts = new String[] {"우유","우유","100","20231101","images/fd_img/우유.png"};
	// format[식재료명, 타입, 중량, 유통기한, 이미지 위치]
	public void setup() {
		setTitle("식재료 상세보기");
		JPanel contentPanel = new JPanel();
		setBounds(100, 100, 585, 330);
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbldetail = new JLabel("식료품 상세보기");
		lbldetail.setFont(new Font("굴림", Font.BOLD, 17));
		lbldetail.setLabelFor(contentPanel);
		lbldetail.setHorizontalAlignment(SwingConstants.LEFT);
		lbldetail.setVerticalAlignment(SwingConstants.TOP);
		contentPanel.add(lbldetail);
		
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(250,250));
		content.setBackground(new Color(255, 255, 255));
		contentPanel.add(content);
		content.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel p_fdname = new JPanel();
		p_fdname.setPreferredSize(new Dimension(250, 250));
		p_fdname.setBackground(Color.WHITE);
		content.add(p_fdname);
		p_fdname.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_01_1 = new JLabel("식재료명 : ");
		lbl_01_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_01_1.setFont(new Font("굴림", Font.PLAIN, 15));
		p_fdname.add(lbl_01_1);
		
		JLabel lbl_fdname_1 = new JLabel(itemDetails[0]);
		lbl_fdname_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fdname_1.setFont(new Font("굴림", Font.PLAIN, 15));
		p_fdname.add(lbl_fdname_1);
		
		JPanel p_type = new JPanel();
		p_type.setPreferredSize(new Dimension(250, 250));
		p_type.setBackground(Color.WHITE);
		content.add(p_type);
		p_type.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_01_1_1 = new JLabel("타입 : ");
		lbl_01_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_01_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		p_type.add(lbl_01_1_1);
		
		JLabel lbl_type = new JLabel(itemDetails[1]);
		lbl_type.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_type.setFont(new Font("굴림", Font.PLAIN, 15));
		p_type.add(lbl_type);
		
		JPanel p_num = new JPanel();
		p_num.setPreferredSize(new Dimension(250, 250));
		p_num.setBackground(Color.WHITE);
		content.add(p_num);
		p_num.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_01_1_2 = new JLabel("중량 : ");
		lbl_01_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_01_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		p_num.add(lbl_01_1_2);
		
		JLabel lbl_num = new JLabel(itemDetails[2]);
		lbl_num.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_num.setFont(new Font("굴림", Font.PLAIN, 15));
		p_num.add(lbl_num);
		
		JPanel p_exdate = new JPanel();
		p_exdate.setPreferredSize(new Dimension(250, 250));
		p_exdate.setBackground(Color.WHITE);
		content.add(p_exdate);
		p_exdate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_010 = new JLabel("유통기한 : ");
		lbl_010.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_010.setFont(new Font("굴림", Font.PLAIN, 15));
		p_exdate.add(lbl_010);
		
		JLabel lbl_exdate = new JLabel(itemDetails[3]);
		lbl_exdate.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exdate.setFont(new Font("굴림", Font.PLAIN, 15));
		p_exdate.add(lbl_exdate);
		{
			JPanel p_img = new JPanel();
			getContentPane().add(p_img);
			p_img.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
			
			JLabel lbl_foodimg = new JLabel("이미지");
			lbl_foodimg.setVerticalAlignment(SwingConstants.TOP);
			lbl_foodimg.setAlignmentY(0.0f);
			lbl_foodimg.setIcon(new ImageIcon(itemDetails[4])); // Map에서 찾아서 넣기
			lbl_foodimg.setPreferredSize(new Dimension(250,250));
			lbl_foodimg.setHorizontalAlignment(SwingConstants.LEFT);
			p_img.add(lbl_foodimg);
		}
		setVisible(true);
	}
}
