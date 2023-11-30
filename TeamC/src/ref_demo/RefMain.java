package ref_demo;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.RecMgr;
import com.refrigerator.Recipe;
import com.refrigerator.RefMgr;
import com.refrigerator.Refrigerator;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class RefMain { 

	Font lblFont = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15);
	Font titleFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 17);

   Refrigerator currentRf;
   JPanel frame;
   
   Food Selectedfd;
   JTable fd_table;    
   JTable rec_table;

	
   RefMain(Refrigerator rf){ 
	      run(rf);
   }
   
   public JPanel run(Refrigerator rf) {
	      this.currentRf = rf;
	      frame = new JPanel();
	      addComponentsToPane(frame);
	      updateTable();
	      return frame;
   }
   
   public void addComponentsToPane(Container pane) {

		
		pane.setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{932, 932, 0};
		gridBagLayout.rowHeights = new int[]{100, 600, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		pane.setLayout(gridBagLayout);
		
		JPanel pan_upper = new JPanel();
		pan_upper.setBackground(Color.WHITE);
		GridBagConstraints gbc_pan_upper = new GridBagConstraints();
		gbc_pan_upper.fill = GridBagConstraints.HORIZONTAL;
		gbc_pan_upper.insets = new Insets(0, 0, 5, 5);
		gbc_pan_upper.gridx = 0;
		gbc_pan_upper.gridy = 0;
		pane.add(pan_upper, gbc_pan_upper);
		pan_upper.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblref = new JLabel("냉장고 번호 : ");
		pan_upper.add(lblref);
		lblref.setFont(titleFont);
		
		JLabel lblrefcode = new JLabel();
		pan_upper.add(lblrefcode);
		lblrefcode.setText(currentRf.refcode+"");
		lblrefcode.setFont(titleFont);
		
		JLabel lbluserinfo = new JLabel();
		pan_upper.add(lbluserinfo);
		lbluserinfo.setText(currentRf.getuserInfo());
		lbluserinfo.setFont(titleFont);
		
		JButton btnlogout = new JButton("로그아웃");
		pan_upper.add(btnlogout);
		btnlogout.addActionListener(new BtnEventListener());
		btnlogout.setFont(titleFont);
		
		JPanel pan_upper2 = new JPanel();
		GridBagConstraints gbc_pan_upper2 = new GridBagConstraints();
		gbc_pan_upper2.insets = new Insets(0, 0, 5, 0);
		gbc_pan_upper2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pan_upper2.gridx = 1;
		gbc_pan_upper2.gridy = 0;
		pan_upper2.setBackground(Color.white);
		pane.add(pan_upper2, gbc_pan_upper2);
		pan_upper2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_rec_ = new JLabel("추천 레시피 목록");
		lbl_rec_.setHorizontalAlignment(SwingConstants.CENTER);
		pan_upper2.add(lbl_rec_);
		lbl_rec_.setFont(titleFont);
		
		JLabel lbl_recommand = new JLabel();
		lbl_recommand.setHorizontalAlignment(SwingConstants.CENTER);
		pan_upper2.add(lbl_recommand);
		lbl_recommand.setFont(titleFont);

		
		JScrollPane fd_pane = new JScrollPane();
		GridBagConstraints gbc_fd_pane = new GridBagConstraints();
		gbc_fd_pane.insets = new Insets(0, 0, 5, 5);
		gbc_fd_pane.fill = GridBagConstraints.BOTH;
		gbc_fd_pane.gridx = 0;
		gbc_fd_pane.gridy = 1;
		pane.add(fd_pane, gbc_fd_pane);
		
	
		fd_table = new JTable();
		fd_pane.setViewportView(fd_table);
		fd_table.setRowHeight(40);
		
		JScrollPane recom_pane = new JScrollPane();
		GridBagConstraints gbc_recom_pane = new GridBagConstraints();
		gbc_recom_pane.fill = GridBagConstraints.BOTH;
		gbc_recom_pane.insets = new Insets(0, 0, 5, 0);
		gbc_recom_pane.gridx = 1;
		gbc_recom_pane.gridy = 1;
		pane.add(recom_pane, gbc_recom_pane);
		
		rec_table = new JTable(){
	          
	          @Override
	          public Class<?> getColumnClass(int column)  {
	               return getValueAt(0,  column).getClass();
	          }
	      };
	      rec_table.setRowHeight(250);
		recom_pane.setViewportView(rec_table);
		
		JPanel pan_bottom = new JPanel();
		pan_bottom.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_pan_bottom = new GridBagConstraints();
		gbc_pan_bottom.gridwidth = 2;
		gbc_pan_bottom.insets = new Insets(0, 0, 0, 5);
		gbc_pan_bottom.fill = GridBagConstraints.BOTH;
		gbc_pan_bottom.gridx = 0;
		gbc_pan_bottom.gridy = 2;
		pane.add(pan_bottom, gbc_pan_bottom);
		
		JLabel lbl_image = new JLabel("이미지");
		pan_bottom.add(lbl_image);
        setRecommendation(lbl_recommand);

   }
   
   
   class BtnEventListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         JButton source = (JButton)e.getSource();
         
         switch (source.getText()) {

         case "로그아웃" :logout(); break;
         default : break;
         }
      }
      
   }
   
   
   public void updateTable() {
      DefaultTableModel df = null;
      
      df = new DefaultTableModel(null,FoodMgr.getInstance().headers){
    	  
         public boolean isCellEditable(int row, int column) {
        	 
            return false;
            
         }
      };
      
      for(Food fd : currentRf.foodMgr.mList) {
    	  
         df.addRow(fd.getUiTexts());
         
      }
      
      fd_table.setModel(df);
   }

   private static RefMain rmain = null;
	public static RefMain getInstance(Refrigerator ref) {
		if (rmain == null)
			rmain = new RefMain(ref);
		return rmain;
	}

   private void logout() {
      Tab_Control_GUI.getInstance(currentRf).setVisible(false);
      GUIMain.getInstance().getframe().setVisible(true);
   }
   
   private void setRecommendation(JLabel j) {
	   String[] str = new String[4];
	      
	   for(int i=0;i<3;i++) {
		   str[i] = RecMgr.getInstance().headers[i];
	   }
	   str[3] = "추천";
	      
	   DefaultTableModel df = null;
	      
	   df = new DefaultTableModel(null, str){
	    	  
		   public boolean isCellEditable(int row, int column) {
	        	 
	            return false;
	            
	         }
	   };
	   StringBuilder sb = new StringBuilder();
	   boolean b = false;
	   for(String s : currentRf.userinfo) {
		   for(Recipe r : RecMgr.getInstance().mList) {
			   if(r.usermatch(s)) {
				   df.addRow(r.getRecommendContent(s));
				   b = true;
			   }
		   }
		   if(b) {
			   sb.append(s);
			   sb.append(" ");
		   }
	   }
	   rec_table.setModel(df);
	   rec_table.getColumnModel().getColumn(0).setPreferredWidth(200);
	   String s = sb.toString();
	   j.setText("이런 분들에게 추천합니다: "+s);
   }
   
   
}