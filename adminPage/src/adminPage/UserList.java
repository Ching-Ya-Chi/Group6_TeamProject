package adminPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class UserList extends JPanel{
	private JTable table;
	private JButton editButton, deleteButton, searchButton;
	
	public UserList() {
        setLayout(new BorderLayout());

        // 店家資料欄位
        String[] columnNames = {"使用者名稱", "聯絡電話", "電子信箱", "註冊日期"};
        
        // 測試用資料
        Object[][] data = {
            {"使用者A", "0912-345678", "便當", "2025-04-01"},
            {"使用者B", "0987-654321", "飲料", "2025-04-15"},
            {"使用者C", "0922-333444", "火鍋", "2025-03-28"}
        };

        //設定表格不可編輯
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
     // 設定 JTable
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        add(scrollPane, BorderLayout.CENTER); 
        
     // 設置按鈕
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        editButton = new JButton("修改");
        deleteButton = new JButton("刪除");
        searchButton = new JButton("搜尋");
        
     // 修改按鍵
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        
        // 刪除按鍵
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        
        // 搜尋按鍵
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });

        // 將按鈕加入面板
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(new JTextField(10));
        buttonPanel.add(searchButton);
        add(buttonPanel, BorderLayout.SOUTH);
	}
	
	  	//測試main method
        public static void main(String[] args) {              
                JFrame frame = new JFrame("使用者清單");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null); 
                frame.setContentPane(new UserList()); 
                frame.setVisible(true);       
    }
}
