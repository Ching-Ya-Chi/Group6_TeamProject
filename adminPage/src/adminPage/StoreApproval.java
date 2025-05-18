package adminPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;



import java.awt.*;

public class StoreApproval extends JPanel {
    private JTable table;
    private JButton approveButton;
    private JButton rejectButton;
    private JButton executeButton;
    private JButton searchButton;
    private JTextField searchName;

    public StoreApproval() {
        setLayout(new BorderLayout());

        // 欄位名稱
        String[] columnNames = {"店家名稱", "申請日期", "地址", "聯絡電話", "審核狀態"};
        // 測試資料
        Object[][] data = {
            {"店家A", "2025-05-01", "台北市文山區XX路", "0912-345678", "已審核"},
            {"店家B", "2025-05-02", "台北市文山區XX路", "0987-654321", "未審核"},
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


        // 下方按鈕區域
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        approveButton = new JButton("通過");
        rejectButton = new JButton("拒絕");
        executeButton = new JButton("執行審核");
        searchButton = new JButton("搜尋");
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(executeButton);
        searchName = new JTextField(10);        
        buttonPanel.add(searchName);
        buttonPanel.add(searchButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // 測試用main method
    public static void main(String[] args) {
            JFrame frame = new JFrame("待審核店家");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null); 
            frame.setContentPane(new StoreApproval()); 
            frame.setVisible(true);
    }
}


