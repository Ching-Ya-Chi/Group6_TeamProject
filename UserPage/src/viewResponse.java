import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class viewResponse extends JFrame {
    private static final int FRAME_WIDTH = 700, FRAME_HEIGHT = 500;
    private JLabel title;
    private JButton orderQueryButton, basicInfoButton, logoutButton, responseButton;
    private JTable orderTable;
    private JTableHeader tableHeader;
    private JScrollPane scrollPane;

    public viewResponse() {
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
              
            }
        });
        
        responseButton = new JButton("查看管理員回覆");
        responseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
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
        String[] columnNames = {"回饋編號", "訂單編號", "傳送內容", "回覆內容"};
        Object[][] data = {
        		{"12345678", "12345678", "紙碗破掉", "我們會贈送您折價券補償"},
        		{"12345678", "12345678", "外送員遲到", "我們會贈送您折價券補償"},
        		{"12345678", "12345678", "牛肉麵沒有肉", "我們會贈送您折價券補償"}
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