import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class invoiceRough extends JFrame {
    private static final int FRAME_WIDTH = 700, FRAME_HEIGHT = 500;
    private JLabel title;
    private JButton orderQueryButton, basicInfoButton, logoutButton, responseButton;
    private JTable orderTable;
    private JTableHeader tableHeader;
    private JScrollPane scrollPane;
    private invoiceDetail frameDetail;
    private personalInfo personalInfo;

    public invoiceRough() {
        frameDetail = new invoiceDetail();
        personalInfo = new personalInfo();
        setTitle("政大校園訂餐系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        createButton();
        createTable();
        createLayout();
    }

    public void createButton () {
        orderQueryButton = new JButton("查詢歷史訂單");
        orderQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        basicInfoButton = new JButton("更改基本資料");
        basicInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personalInfo.setVisible(true);
                invoiceRough.this.setVisible(false);
            }
        });
        
        responseButton = new JButton("查看管理員回覆");
        responseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//
        	}
        });

        logoutButton = new JButton("登出");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void createTable() {
        String[] columnNames = {"訂單編號", "取餐時間", "取餐方式", "訂單狀態"};
        Object[][] data = {
                {"12345678", "2025/5/30 12:15", "自取", "待接單"},
                {"12345677", "2025/5/29 12:05", "校門口取餐處", "準備中"},
                {"12345676", "2025/5/28 12:05", "校門口取餐處", "已拒絕"},
                {"12345675", "2025/5/28 12:00", "校門口取餐處", "待送餐"},
                {"12345674", "2025/5/28 12:00", "自取", "待取餐"},
                {"12345673", "2025/5/27 12:00", "自取", "已完成"},
                {"12345678", "2025/5/30 12:15", "自取", "待接單"},
                {"12345677", "2025/5/29 12:05", "校門口取餐處", "準備中"},
                {"12345676", "2025/5/28 12:05", "校門口取餐處", "已拒絕"},
                {"12345675", "2025/5/28 12:00", "校門口取餐處", "待送餐"},
                {"12345674", "2025/5/28 12:00", "自取", "待取餐"},
                {"12345673", "2025/5/27 12:00", "自取", "已完成"},
                {"12345678", "2025/5/30 12:15", "自取", "待接單"},
                {"12345677", "2025/5/29 12:05", "校門口取餐處", "準備中"},
                {"12345676", "2025/5/28 12:05", "校門口取餐處", "已拒絕"},
                {"12345675", "2025/5/28 12:00", "校門口取餐處", "待送餐"},
                {"12345674", "2025/5/28 12:00", "自取", "待取餐"},
                {"12345673", "2025/5/27 12:00", "自取", "已完成"},
                {"12345678", "2025/5/30 12:15", "自取", "待接單"},
                {"12345677", "2025/5/29 12:05", "校門口取餐處", "準備中"},
                {"12345676", "2025/5/28 12:05", "校門口取餐處", "已拒絕"},
                {"12345675", "2025/5/28 12:00", "校門口取餐處", "待送餐"},
                {"12345674", "2025/5/28 12:00", "自取", "待取餐"},
                {"12345673", "2025/5/27 12:00", "自取", "已完成"}
        };

        DefaultTableModel nonEditableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        orderTable = new JTable(nonEditableModel);
        orderTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frameDetail.setVisible(true);
                invoiceRough.this.setVisible(false);
            }

        });
        orderTable.setRowHeight(20);
        orderTable.setFillsViewportHeight(true);
        tableHeader = orderTable.getTableHeader();
        tableHeader.setBackground(new Color(200, 230, 200));
        orderTable.setPreferredScrollableViewportSize(new Dimension(600, 300));
        scrollPane = new JScrollPane(orderTable);
    }

    public void createLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 頂部按鈕區域
        JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel toppestPanel = new JPanel(new BorderLayout(20, 20));
        JPanel totalPanel = new JPanel(new BorderLayout(20, 20));

        topButtonPanel.add(orderQueryButton);
        topButtonPanel.add(basicInfoButton);
        topButtonPanel.add(responseButton);

        title = new JLabel("政大校園訂餐系統 - 使用者");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        toppestPanel.add(title, BorderLayout.WEST);
        toppestPanel.add(logoutButton, BorderLayout.EAST);

        mainPanel.add(topButtonPanel, BorderLayout.NORTH);
        JPanel tablePanel = new JPanel(new BorderLayout());
        JPanel scrollWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        scrollWrapper.add(scrollPane);
        tablePanel.add(scrollWrapper, BorderLayout.CENTER);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        totalPanel.add(toppestPanel, BorderLayout.NORTH);
        totalPanel.add(mainPanel, BorderLayout.CENTER);
        totalPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        add(totalPanel);
    }

}