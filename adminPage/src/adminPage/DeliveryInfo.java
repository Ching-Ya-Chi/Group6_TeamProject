package adminPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class DeliveryInfo extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public DeliveryInfo() {
        setLayout(new BorderLayout());

        //測試資料
        String[] columnNames = {"訂單編號", "店家名稱", "配送地點", "送達時間", "配送狀態"};
        Object[][] data = {
            {"ORD001", "便當店A", "一號大樓門口", "12:00", "待配送"},
            {"ORD002", "飲料店B", "三號樓中庭", "12:00", "待配送"},
            {"ORD003", "火鍋店C", "學生宿舍入口", "12:30", "待配送"}
        };

        
     // 欄位不可編輯
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        //按鈕設置
        JButton last = new JButton("上一頁");
        JButton next = new JButton("下一頁");
        JButton markDeliveredBtn = new JButton("標記為已送達");
        markDeliveredBtn.addActionListener(e -> markAsDelivered());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(last);
        buttonPanel.add(markDeliveredBtn);
        buttonPanel.add(next);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //標註完成鍵
    private void markAsDelivered() {
        int[] selectedRows = table.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "請先選取要標記的訂單");
            return;
        }

        for (int row : selectedRows) {
            model.setValueAt("已送達", row, 4); 
        }
    }

    //測試用
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("外送訂單資訊");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new DeliveryInfo());
            frame.setVisible(true);
        });
    }
}


