package adminPage;

import javax.swing.*;
import java.awt.*;

public class AdminHomePage extends JPanel {
    private JTabbedPane tabbedPane;
    private JButton loginOut;
    private JPanel northPanel;

    public AdminHomePage() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245)); // 背景色

        // 標題
        northPanel = new JPanel(new BorderLayout());
        northPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // 上左下右的邊距
        JLabel titleLabel = new JLabel("     政大校園訂餐系統 - 管理者");
        titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        loginOut = new JButton("登出");
        northPanel.add(titleLabel, BorderLayout.WEST);
        northPanel.add(loginOut, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);

        // TabbedPane 設定
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
     

        // 加入子頁籤
        tabbedPane.addTab("待審核清單", new ApprovalPanel());        
        tabbedPane.addTab("用戶清單", new InfoList());
        tabbedPane.addTab("今日外送訂單", new DeliveryInfo());
        tabbedPane.addTab("歷史訂單資訊", new HistoryOrder());
        tabbedPane.addTab("意見回饋資訊", new Feedback());
        tabbedPane.addTab("                      ", new Feedback());//還沒想到放甚麼


        tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 留白邊界
        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {    	
    	JFrame frame = new JFrame("管理者首頁");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 700, 500);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new AdminHomePage());
        frame.setVisible(true);	
    }
}


