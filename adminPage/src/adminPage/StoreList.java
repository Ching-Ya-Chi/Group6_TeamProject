package adminPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StoreList extends JPanel{
    private JTable table;
    private JButton editButton, deleteButton, searchButton;

    public StoreList() {
        setLayout(new BorderLayout());

        // 欄位名稱
        String[] columnNames = {"店家名稱", "聯絡電話", "地址", "店家類別", "註冊日期"};  
        // 測試資料
        Object[][] data = {
            {"店家A", "0912-345678", "台中市中區建國路1號", "便當", "2025-04-01"},
            {"店家B", "0987-654321", "高雄市前金區中華路2號", "飲料", "2025-04-15"},
            {"店家C", "0922-333444", "台北市大安區忠孝東路3號", "火鍋", "2025-03-28"}
        };

        // 設定表格不可編輯
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        add(scrollPane, BorderLayout.CENTER); 
        
        // 點擊後查看店家詳細資訊
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 雙擊
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        String storeName = table.getValueAt(row, 0).toString(); 
                        new StoreApprovalDetail(storeName).setVisible(true);
                    }
                }
            }
        });

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("店家清單");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new StoreList()); 
            frame.setVisible(true);
        });
    }
}

