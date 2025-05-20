import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class invoiceDetail extends JFrame {
    private static final int FRAME_WIDTH = 700, FRAME_HEIGHT = 500, TEXT_LENGTH = 20;
    JLabel title, vendorName, conditionLabel, invoiceID, timeLabel, wayLabel, moneyLabel, tableLabel, complainLabel, problemLabel;
    JTextField invoiceIDTextField, timeTextField, wayTextField, moneyTextField, complainTextArea;
    JButton logoutButton, backButton, complainButton;
    JRadioButton complete, waitTake, waitDeliver, prepare, waitGet, reject;
    JRadioButton service, deliver, dishes;
    ButtonGroup buttonGroup, problemGroup;
    JTable orderTable;
    JTableHeader tableHeader;
    JScrollPane scrollPane;

    public invoiceDetail() {
        setTitle("政大校園訂餐系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        buttonGroup = new ButtonGroup();
        problemGroup = new ButtonGroup();
        createLabel();
        createText();
        createRadioButton();
        createButton();
        createTable();
        createLayout();
    }

    public void createLabel() {
        title = new JLabel("政大校園訂餐系統 - 使用者");
        vendorName = new JLabel("");
        vendorName.setText("店家名稱"); // 要設定成點擊的店家名稱
        conditionLabel = new JLabel("訂單狀態");
        invoiceID = new JLabel("訂單編號");
        timeLabel = new JLabel("取餐時間");
        wayLabel = new JLabel("取餐方式");
        moneyLabel = new JLabel("訂單金額");
        tableLabel = new JLabel("訂單內容：");
        complainLabel = new JLabel("填寫回饋：");
        problemLabel = new JLabel("回饋類型：");
        
    }

    public void createText() {
        invoiceIDTextField = new JTextField(TEXT_LENGTH);
        invoiceIDTextField.setEditable(false);

        timeTextField = new JTextField(TEXT_LENGTH);
        timeTextField.setEditable(false);

        wayTextField = new JTextField(TEXT_LENGTH);
        wayTextField.setEditable(false);

        moneyTextField = new JTextField(TEXT_LENGTH);
        moneyTextField.setEditable(false);
        
        complainTextArea = new JTextField(47);
        
    }

    public void createButton () {
        logoutButton = new JButton("登出");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton = new JButton("返回");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//              frame.setVisible(true);
//                invoiceDetail.this.setVisible(false);
            }
        });
        
        complainButton = new JButton("送出回饋");
        complainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
    }

    public void createRadioButton(){
        complete = new JRadioButton("已完成");
        complete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                complete.setSelected(true);
            }
        });

        waitTake = new JRadioButton("待取餐");
        waitTake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                waitTake.setSelected(true);
            }
        });

        waitDeliver = new JRadioButton("待送餐");
        waitDeliver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                waitDeliver.setSelected(true);
            }
        });

        prepare = new JRadioButton("準備中");
        prepare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prepare.setSelected(true);
            }
        });

        waitGet = new JRadioButton("待接單");
        waitGet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                waitGet.setSelected(true);
            }
        });

        reject = new JRadioButton("已拒絕");
        reject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reject.setSelected(true);
            }
        });
        
        service = new JRadioButton("服務問題");
        service.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	service.setSelected(true);
            }
        });
        
        deliver = new JRadioButton("送餐問題");
        deliver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	deliver.setSelected(true);
            }
        });
        
        dishes = new JRadioButton("菜品問題");
        dishes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dishes.setSelected(true);
            }
        });

        buttonGroup.add(complete);
        buttonGroup.add(waitTake);
        buttonGroup.add(waitDeliver);
        buttonGroup.add(prepare);
        buttonGroup.add(waitGet);
        buttonGroup.add(reject);
        
        problemGroup.add(service);
        problemGroup.add(deliver);
        problemGroup.add(dishes);
    }

    public void createTable() {
        String[] columnNames = {"商品名稱", "商品價格", "商品數量"};
        Object[][] data = {
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1},
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1},
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1},
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1},
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1},
                {"茄子餅", "$512", 1},
                {"香蕉蛋糕", "$256", 2},
                {"茄子餅", "$512", 1}
        };

        DefaultTableModel nonEditableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        orderTable = new JTable(nonEditableModel);
        orderTable.setRowHeight(20);
        orderTable.setFillsViewportHeight(true);

        // 設定表頭背景顏色
        tableHeader = orderTable.getTableHeader();
        tableHeader.setBackground(new Color(200, 230, 200));

        // 設定 preferred scrollable viewport size（會限制表格顯示高度）
        orderTable.setPreferredScrollableViewportSize(new Dimension(600, 300));
        scrollPane = new JScrollPane(orderTable);
    }

    public void createLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JPanel toppestPanel = new JPanel(new BorderLayout(20, 20));
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        toppestPanel.add(title, BorderLayout.WEST);
        toppestPanel.add(logoutButton, BorderLayout.EAST);
        mainPanel.add(toppestPanel);

        JPanel topperPanel = new JPanel(new BorderLayout(20, 20));
        topperPanel.add(vendorName, BorderLayout.WEST);
        topperPanel.add(backButton, BorderLayout.EAST);
        mainPanel.add(topperPanel);


        JPanel wayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wayPanel.add(wayLabel);
        wayPanel.add(complete);
        wayPanel.add(waitTake);
        wayPanel.add(waitDeliver);
        wayPanel.add(prepare);
        wayPanel.add(waitGet);
        wayPanel.add(reject);
        mainPanel.add(wayPanel);

        JPanel middlePanel = new JPanel();
        JPanel leftOnePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightOnePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftTwoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightTwoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel info = new JPanel(new GridLayout(2, 2, 20, 20));

        leftOnePanel.add(invoiceID);
        leftOnePanel.add(invoiceIDTextField);
        rightOnePanel.add(timeLabel);
        rightOnePanel.add(timeTextField);
        leftTwoPanel.add(wayLabel);
        leftTwoPanel.add(wayTextField);
        rightTwoPanel.add(moneyLabel);
        rightTwoPanel.add(moneyTextField);
        info.add(leftOnePanel);
        info.add(rightOnePanel);
        info.add(leftTwoPanel);
        info.add(rightTwoPanel);
        mainPanel.add(info);
        
        JPanel complainPanelOne = new JPanel(new FlowLayout(FlowLayout.LEFT));
        complainPanelOne.add(problemLabel);
        complainPanelOne.add(service);
        complainPanelOne.add(deliver);
        complainPanelOne.add(dishes);
        complainPanelOne.add(new JLabel("                                                     "));
        complainPanelOne.add(complainButton);
        
        JPanel complainPanelTwo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        complainPanelTwo.add(complainLabel);
        complainPanelTwo.add(complainTextArea);
        
        
        mainPanel.add(scrollPane);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(complainPanelOne);
        mainPanel.add(complainPanelTwo);
        add(mainPanel);
    }
    
//    public static void main(String[] args) {
//    	SwingUtilities.invokeLater(() -> {
//    	    invoiceDetail frame = new invoiceDetail();
//    	    frame.setVisible(true);
//    	});
//    }

}
