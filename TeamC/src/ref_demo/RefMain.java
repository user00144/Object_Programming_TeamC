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

   Refrigerator currentRf;
   JPanel frame;
   
   Food Selectedfd;
   JTable table;
                                                                         
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
	   pane.setBackground(Color.WHITE);
      JLabel tf_refcode;

      JPanel panel = new JPanel();
      
      JPanel panel_1 = new JPanel();

      JLabel user = new JLabel("사용자 정보");
      
      JButton logout = new JButton("로그아웃");
      
      JLabel lblNewLabel = new JLabel("냉장고 번호: ");
      

      logout.addActionListener(new BtnEventListener());

      
      tf_refcode = new JLabel();
      tf_refcode.setText(""+currentRf.refcode);
      JScrollPane scrollPane = new JScrollPane();
      
      JLabel recommendation = new JLabel();
      
      JScrollPane scrollPane_1 = new JScrollPane();
      GroupLayout groupLayout = new GroupLayout(pane);
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(12)
      					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
      					.addPreferredGap(ComponentPlacement.UNRELATED)
      					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addContainerGap()
      					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
      						.addComponent(recommendation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      						.addComponent(scrollPane_1, Alignment.LEADING))))
      			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGap(10)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
      				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
      			.addPreferredGap(ComponentPlacement.UNRELATED)
      			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
      			.addGap(18)
      			.addComponent(recommendation, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
      			.addGap(18)
      			.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
      			.addContainerGap())
      );
      
      table_1 = new JTable(){
          
          @Override
          public Class<?> getColumnClass(int column)  {
               return getValueAt(0,  column).getClass();
          }
      };
      table_1.setRowHeight(250);
      scrollPane_1.setViewportView(table_1);
      table = new JTable();
      table.setRowHeight(40);
      Font font = new Font("굴림", Font.BOLD, 18);
		table.setFont(font);
      scrollPane.setViewportView(table);
      scrollPane.setPreferredSize(new Dimension(800, Toolkit.getDefaultToolkit().getScreenSize().height));
      
      setRecommendation(recommendation);
      
      GroupLayout gl_panel_1 = new GroupLayout(panel_1);
      gl_panel_1.setHorizontalGroup(
         gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel_1.createSequentialGroup()
               .addComponent(logout)
               .addGap(40)
               .addComponent(user))
      );
      gl_panel_1.setVerticalGroup(
         gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel_1.createSequentialGroup()
               .addContainerGap()
               .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                  .addComponent(logout, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                  .addGap(40)
                  .addComponent(user, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
      );
      
      
      panel_1.setLayout(gl_panel_1);
      
      
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
         gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
               .addGap(18)
               .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(tf_refcode, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
               .addContainerGap())
      );
      gl_panel.setVerticalGroup(
         gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
               .addGap(13)
               .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                  .addComponent(tf_refcode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                  .addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
               .addContainerGap())
      );
      
      panel.setLayout(gl_panel);
      pane.setLayout(groupLayout);
      
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
      
      table.setModel(df);
   }

   private static RefMain rmain = null;
   private JTable table_1;
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
	   table_1.setModel(df);
	   table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
	   String s = sb.toString();
	   j.setText("이런 분들에게 추천합니다: "+s);
   }
   
   
}