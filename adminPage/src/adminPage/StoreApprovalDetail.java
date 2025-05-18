package adminPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class StoreApprovalDetail extends JFrame {

    public StoreApprovalDetail(String storeName) {
        setTitle("審核店家：「" + storeName + "」");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 店家資訊區塊
        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        infoPanel.setBorder(BorderFactory.createTitledBorder("店家資訊"));
        infoPanel.add(new JLabel("店家名稱：" + storeName));
        infoPanel.add(new JLabel("聯絡電話：0912-345678"));
        infoPanel.add(new JLabel("電子信箱：store@example.com"));
        infoPanel.add(new JLabel("註冊日期：2025-04-01"));

        // 按鈕區塊
        JPanel buttonPanel = new JPanel();
        JButton approveButton = new JButton("通過");
        JButton rejectButton = new JButton("拒絕");

        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);

        // 拒絕原因區塊
        JTextField rejectReasonField = new JTextField(20);
        JPanel rejectPanel = new JPanel();
        rejectPanel.add(new JLabel("拒絕原因："));
        rejectPanel.add(rejectReasonField);

       
        approveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "店家「" + storeName + "」已通過審核！");
            dispose(); // 關閉視窗
        });

        rejectButton.addActionListener(e -> {
            String reason = rejectReasonField.getText();
            if (reason.isEmpty()) {
                JOptionPane.showMessageDialog(this, "請輸入拒絕原因！");
            } else {
                JOptionPane.showMessageDialog(this, "店家「" + storeName + "」被拒絕，原因：" + reason);
                dispose();
            }
        });

        // 加入畫面
        add(infoPanel, BorderLayout.NORTH);
        add(rejectPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // 可單獨測試
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StoreApprovalDetail frame = new StoreApprovalDetail("測試店家");
            frame.setVisible(true);
        });
    }
}
