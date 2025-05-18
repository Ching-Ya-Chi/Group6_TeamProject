package adminPage;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class HistoryOrder extends JPanel {
    private JTable table;
    
    public HistoryOrder() {
        setLayout(new BorderLayout());
        
        // 訂單資料欄位
        String[] columnNames = {"訂單編號", "店家名稱", "使用者名稱", "送達時間", "訂單狀態"};
        
        // 測試用資料（可後續改成從資料庫讀入）
        Object[][] data = {
            {"1001", "店家A", "使用者A", "2025-04-01 12:00", "已送達"},
            {"1002", "店家B", "使用者B", "2025-04-02 13:00", "待送達"},
            {"1003", "店家C", "使用者C", "2025-04-03 14:00", "已取消"}
        };
        
        // 設定 JTable，並將資料與欄位名稱連結
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); // 包裝表格以支持滾動
        
        // 訂單篩選功能面板
        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("選擇日期:"));
        JTextField timeField = new JTextField(10);
        filterPanel.add(timeField);
        
        // 篩選按鈕
        JButton filterButton = new JButton("篩選");
        filterPanel.add(filterButton);
        
        add(filterPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER); // 把表格加到面板的中心
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 創建 JFrame 並設定視窗大小
            JFrame frame = new JFrame("歷史訂單");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // 視窗居中
            frame.setContentPane(new HistoryOrder()); // 設定內容為 HistoryOrder面板
            frame.setVisible(true);
        });
    }
}

