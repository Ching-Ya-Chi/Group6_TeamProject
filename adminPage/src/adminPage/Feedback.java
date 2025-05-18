package adminPage;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Feedback extends JPanel {
    private JTable table;
    
    public Feedback() {
        setLayout(new BorderLayout());
        
        // 回饋資料欄位
        String[] columnNames = {"回饋編號", "使用者名稱", "回饋內容", "問題類型", "回覆狀態"};
        
        // 測試用資料（可後續改成從資料庫讀入）
        Object[][] data = {
            {"F1001", "使用者A", "送餐延遲", "送餐問題", "未回覆"},
            {"F1002", "使用者B", "餐點不熱", "菜品問題", "已回覆"},
            {"F1003", "使用者C", "服務態度差", "服務問題", "未回覆"}
        };
        
        // 設定 JTable，並將資料與欄位名稱連結
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table); // 包裝表格以支持滾動
        
        // 回覆功能面板
        JPanel replyPanel = new JPanel();
        replyPanel.add(new JLabel("回覆:"));
        JTextArea replyArea = new JTextArea(3, 30);
        replyPanel.add(replyArea);
        
        // 回覆按鈕
        JButton replyButton = new JButton("回覆");
        replyPanel.add(replyButton);
        
        add(replyPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER); // 把表格加到面板的中心
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 創建 JFrame 並設定視窗大小
            JFrame frame = new JFrame("意見回饋");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // 視窗居中
            frame.setContentPane(new Feedback()); // 設定內容為 Feedback面板
            frame.setVisible(true);
        });
    }
}
