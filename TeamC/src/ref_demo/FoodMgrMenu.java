package ref_demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.refrigerator.Food;
import com.refrigerator.FoodMgr;
import com.refrigerator.Refrigerator;

import facade.IDataEngine;

public class FoodMgrMenu {

	Font lblFont = new Font("나눔스퀘어라운드 Light", Font.PLAIN, 15);
	Font titleFont = new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 17);
	
    JPanel frame;
    Refrigerator curRf;
    JTextField textField;
    JTable table;
    Food Selectedfd;
    IDataEngine<?> dataMgr;
    boolean isCheckBoxSelected = false;
    JRadioButton exdateCheckBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton fd_detailview;
    
    public FoodMgrMenu(Refrigerator rf) {
        this.curRf = rf;
    }
    
    public JPanel run(Refrigerator rf) {
        this.curRf = rf;
        frame = new JPanel();
        addComponentsToPane(frame);
        updateTable();
 	      return frame;
    }

    void addComponentsToPane(Container pane) {
 	   pane.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane();

        JPanel panel_2 = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        pane.add(panel_2);
        pane.setBackground(Color.white);
        panel_2.add(scrollPane);
        panel_2.setBackground(Color.white);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

        panel_2.setPreferredSize(new Dimension(800, 700));
        scrollPane.setPreferredSize(new Dimension(800, 300));
        table = new JTable();

        DefaultTableModel df = null;

        df = new DefaultTableModel(null, FoodMgr.getInstance().headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        for (Food f : curRf.foodMgr.mList) {
            df.addRow(f.getUiTexts());
        }
        table.setModel(df);
        table.setRowHeight(40);
        table.addMouseListener(new MouseEventListener());
        table.setFont(lblFont);
        scrollPane.setViewportView(table);

        JPanel panel_1 = new JPanel();
        pane.add(panel_1);
        panel_1.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 200));
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.white);
        panel_1.add(panel_3);
        panel_3.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 100)); // 패널 사이즈 조정

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBackground(Color.lightGray);

        btnNewButton = new JButton(new ImageIcon("images/ui_img/btn_add.png"));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(Color.white);
        btnNewButton.setOpaque(false);
        btnNewButton.setFont(titleFont);
        btnNewButton.addActionListener(new BtnEventListener());

        btnNewButton_1 = new JButton(new ImageIcon("images/ui_img/btn_delete.png"));
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBackground(Color.white);
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setFont(titleFont);
        btnNewButton_1.addActionListener(new BtnEventListener());
        
        exdateCheckBox = new JRadioButton("유통기한이 지난 식재료 삭제");
        exdateCheckBox.setBackground(Color.white);
        exdateCheckBox.setFont(titleFont);
        exdateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCheckBoxSelected = exdateCheckBox.isSelected();
            }
        });
        panel_3.add(exdateCheckBox);

        btnNewButton_2 = new JButton(new ImageIcon("images/ui_img/btn_search.png"));
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setBackground(Color.white);
        btnNewButton_2.setOpaque(false);
        btnNewButton_2.setFont(titleFont);

        btnNewButton_2.addActionListener(new BtnEventListener());

        fd_detailview = new JButton(new ImageIcon("images/ui_img/btn_detail.png"));
        fd_detailview.setBorderPainted(false);
        fd_detailview.setBackground(Color.white);
        fd_detailview.setOpaque(false);
        fd_detailview.setFont(titleFont);

        fd_detailview.addActionListener(new BtnEventListener());
        
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
            gl_panel_3.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
                    .addGap(350)
                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                    .addGap(40)
                    .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(40)
                    .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(40)
                    .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(40)
                    .addComponent(fd_detailview, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGap(40)
                    .addComponent(exdateCheckBox)
                    .addGap(40)
        );
        gl_panel_3.setVerticalGroup(
            gl_panel_3.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                    .addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
                            .addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(fd_detailview, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
                			.addComponent(exdateCheckBox)

                );
        
        panel_3.setLayout(gl_panel_3);

        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        pane.add(panel);

        ImageIcon image = new ImageIcon("images/food_bg.png");
        JLabel lblNewLabel = new JLabel(image, SwingConstants.CENTER);
        panel.add(lblNewLabel);
        lblNewLabel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 300));
    }

    class BtnEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if(source.equals(btnNewButton))
            	addRecord();
            if(source.equals(btnNewButton_1))
            	if (isCheckBoxSelected) {
                    deleteExpiredRecords();
                } else {
                    deleteRecord();
                }
            if(source.equals(btnNewButton_2))
            	updateTable();
            if(source.equals(fd_detailview))
            	Detailfd();
            /*switch (source.getText()) {
                case "추가":
                    addRecord();
                    break;
                case "삭제":
                	if (isCheckBoxSelected) {
                        deleteExpiredRecords();
                    } else {
                        deleteRecord();
                    }
                    break;
                case "검색":
                    updateTable();
                    break;
                case "상세보기":
                    Detailfd();
                    break;
                default:
                    break;
            }*/
            textField.setText("");
        }
    }

    class MouseEventListener implements MouseListener {

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
            Selectedfd = getselectedFood();
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

    private void addRecord() {
        String s = textField.getText();

        if (s == null || s.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "공백 값은 허용되지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] foodStr = s.split(",");

        if (foodStr.length != 4) {
            JOptionPane.showMessageDialog(null, "형식에 맞지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String name = foodStr[0];
            String type = foodStr[1];
            int num = Integer.parseInt(foodStr[2]);

            String exdateStr = foodStr[3];
            if (exdateStr.length() != 8) {
                JOptionPane.showMessageDialog(null, "유통기한은 8자리여야 합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String monthStr = exdateStr.substring(4, 6);
            int month = Integer.parseInt(monthStr);
            String dayStr = exdateStr.substring(6, 8);
            int day = Integer.parseInt(dayStr);

            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(null, "유통기한의 월은 01부터 12까지의 값이어야 합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int maxDay;
            switch (month) {
                case 2:
                    maxDay = 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    maxDay = 30;
                    break;
                default:
                    maxDay = 31;
                    break;
            }

            if (day < 1 || day > maxDay) {
                JOptionPane.showMessageDialog(null, month + "월은 " + maxDay + "일까지의 값이어야 합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int exdate = Integer.parseInt(exdateStr);
            Food newFood = new Food(name, type, num, exdate);
            curRf.foodMgr.mList.add(newFood);

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            df.addRow(newFood.getUiTexts());
            updateTable();
            table.setModel(df);
            RefMain.getInstance(curRf).updateTable();
            JOptionPane.showMessageDialog(null, "추가되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "숫자 형식이 올바르지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Food getselectedFood() {
    	Food fd = null;
    	

        int selectedRow = table.getSelectedRow();
        
        if(selectedRow == -1) {
        	return null;
        }
        
        String[] str = new String[4];
        str[0] = (String)table.getValueAt(selectedRow,0);
        str[1] = (String)table.getValueAt(selectedRow,1);
        str[2] = (String)table.getValueAt(selectedRow,2);
        str[3] = (String)table.getValueAt(selectedRow,3);
        
        for(Food m : curRf.foodMgr.mList) {
            if(m.Allmatches(str)) {
                fd = m;
            }
        }
    	
    	return fd;
    }
    
    private void deleteRecord() {
    	
        int selectedRow = table.getSelectedRow();
    	
        Food fd = getselectedFood();
        if (fd == null) {
            JOptionPane.showMessageDialog(null, "삭제할 행을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        curRf.foodMgr.mList.remove(fd);

        DefaultTableModel df = (DefaultTableModel) table.getModel();
        df.removeRow(selectedRow);

        updateTable();
        RefMain.getInstance(curRf).updateTable();
        JOptionPane.showMessageDialog(null, "선택된 행이 삭제되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteExpiredRecords() {

        int rowCount = table.getRowCount();
        DefaultTableModel df = (DefaultTableModel) table.getModel();

        for (int i = rowCount - 1; i >= 0; i--) {
            String exdateStr = (String) table.getValueAt(i, 3);
            int exdate = Integer.parseInt(exdateStr);

            if (exdate < curRf.foodMgr.mList.get(i).getCurrentTime()) {
                Food fd = curRf.foodMgr.mList.get(i);
                curRf.foodMgr.mList.remove(fd);
                df.removeRow(i);
            }
        }

      

        updateTable();
        RefMain.getInstance(curRf).updateTable();
        JOptionPane.showMessageDialog(null, "유통기한이 지난 식재료는 일괄 삭제되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateTable() {
        String s = null;
        try {
            s = textField.getText();
        } catch (NullPointerException e) {
            s = null;
        }

        DefaultTableModel df = null;

        df = new DefaultTableModel(null, FoodMgr.getInstance().headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (s == null) {
            for (Food f : curRf.foodMgr.mList) {
                df.addRow(f.getUiTexts());
            }
        } else {
            for (Food f : curRf.foodMgr.mList) {
                if (f.matches(s))
                    df.addRow(f.getUiTexts());
            }
        }
        table.setModel(df);
    }

    private void Detailfd() {
        String[] str = new String[5];
        if (Selectedfd != null) {
            int i = 0;
            for (String s : Selectedfd.getUiTexts()) {
                str[i] = s;
                i++;
            }
            str[4] = FoodMgr.getInstance().imagemap.get(Selectedfd.fdname);
            DetailFood dtf = new DetailFood(str);
        }

    }

    private static FoodMgrMenu fmm = null;

    public static FoodMgrMenu getInstance(Refrigerator rf) {
        if (fmm == null)
            fmm = new FoodMgrMenu(rf);
        return fmm;
    }

}
