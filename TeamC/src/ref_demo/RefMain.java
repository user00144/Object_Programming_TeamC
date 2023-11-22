package ref_demo;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.RefMgr;
import com.refrigerator.Refrigerator;


import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class RefMain { 

   Refrigerator currentRf;
   JFrame frame;
   
   Food Selectedfd;
   JTable table;
                                                                         
   RefMain(Refrigerator rf){ 
      this.currentRf = rf;
      createAndShowGUI();
      updateTable();
   }
   
   public RefMain() {
	// TODO Auto-generated constructor stub
}

   void createAndShowGUI() {
      frame = new JFrame("식료품을 부탁해!");
      frame.setBounds(100, 100, 942, 724);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      addComponentsToPane(frame.getContentPane());
      frame.pack();
      frame.setVisible(true);

   }
   
   private void addComponentsToPane(Container pane) {
      JLabel tf_refcode;

      JPanel panel = new JPanel();
      
      JPanel panel_1 = new JPanel();
      
      JButton fd_detailview = new JButton("상세보기");
      
      JButton fd_menu = new JButton("식료품 관리");
      
      JButton rec_menu = new JButton("레시피 보기");
      
      JButton logout = new JButton("로그아웃");
      
      JLabel lblNewLabel = new JLabel("냉장고 번호: ");
      
      fd_detailview.addActionListener(new BtnEventListener());
      fd_menu.addActionListener(new BtnEventListener());
      rec_menu.addActionListener(new BtnEventListener());
      logout.addActionListener(new BtnEventListener());

      
      tf_refcode = new JLabel();
      tf_refcode.setText(""+currentRf.refcode);
      JScrollPane scrollPane = new JScrollPane();
      GroupLayout groupLayout = new GroupLayout(pane);
      groupLayout.setHorizontalGroup(
         groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
               .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                  .addGroup(groupLayout.createSequentialGroup()
                     .addContainerGap()
                     .addComponent(scrollPane))
                  .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                     .addGap(12)
                     .addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(ComponentPlacement.UNRELATED)
                     .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)))
               .addContainerGap())
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
               .addContainerGap(80, Short.MAX_VALUE))
      );
      
      table = new JTable();
      table.addMouseListener(new MouseEventListener());
      table.setRowHeight(30);
      scrollPane.setViewportView(table);
      GroupLayout gl_panel_1 = new GroupLayout(panel_1);
      gl_panel_1.setHorizontalGroup(
         gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel_1.createSequentialGroup()
               .addGap(119)
               .addComponent(fd_detailview, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
               .addGap(18)
               .addComponent(fd_menu)
               .addGap(18)
               .addComponent(rec_menu)
               .addGap(18)
               .addComponent(logout)
               .addGap(30))
      );
      gl_panel_1.setVerticalGroup(
         gl_panel_1.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel_1.createSequentialGroup()
               .addContainerGap()
               .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                  .addComponent(logout, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                  .addComponent(fd_detailview, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                  .addComponent(fd_menu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                  .addComponent(rec_menu, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
               .addContainerGap())
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
         case "상세보기":Detailfd();  break;
         case "식료품 관리":foodMgr(); break;
         case "레시피 보기":showRecipe(); break;
         case "로그아웃" :logout(); break;
         default : break;
         }
      }
      
   }
    
   class MouseEventListener implements MouseListener{

      @Override
      public void mouseClicked(MouseEvent e) { 
         // TODO Auto-generated method stub


      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub
         int row = table.getSelectedRow();
         Selectedfd = currentRf.foodMgr.mList.get(row);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }

      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub
         
      }
      
   }
   
   
   private void updateTable() {
      DefaultTableModel df = null;
      df = new DefaultTableModel(null,FoodMgr.getInstance().headers) {
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      };
      for(Food fd : currentRf.foodMgr.mList) {
         df.addRow(fd.getUiTexts());
      }
      table.setModel(df);
   }
    
   private void Detailfd() {
      String[] str = new String[5];
      if(Selectedfd != null) {
         int i = 0;
         for(String s:Selectedfd.getUiTexts()) {
            str[i] = s;
            i++;
         }
         str[4] = FoodMgr.getInstance().imagemap.get(Selectedfd.type);
         DetailFood dtf = new DetailFood(str);
      }
      
   }
   
   private static RefMain rmain = null;
	public static RefMain getInstance() {
		if (rmain == null)
			rmain = new RefMain();
		return rmain;
	}
	public JFrame getframe() {
		return frame;
	}
	
   private void foodMgr() {
	  frame.setVisible(false);
	  FoodMgrMenu fd = new FoodMgrMenu(currentRf);
   }
   
   public void foodMgrExit(Refrigerator currentRf) {
	   this.currentRf = currentRf;
	   createAndShowGUI();
	   updateTable();
   }
   
   private void showRecipe() {
	   new RecMenu(currentRf);
   }
   
   
   private void logout() {
      currentRf = null;
      frame.setVisible(false);
      GUIMain.getInstance().getframe().setVisible(true);
   }
   
   
}