import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class personalInfo extends JFrame {
    private static final int FRAME_WIDTH = 700, FRAME_HEIGHT = 500, TEXT_LENGTH = 20;
    JLabel title, intro, tip, name, tele, userName, password;
    JTextField nameTextField, teleTextField, userNameTextField, passwordTextField;
    JButton logoutButton, saveButton, orderQueryButton, basicInfoButton, responseButton;
    viewResponse frame;

    public personalInfo() {
        setTitle("政大校園訂餐系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame = new viewResponse();
        createLabel();
        createTextField();
        createButton();
        createLayout();
    }

    public void createLabel() {
        title = new JLabel("政大校園訂餐系統 - 使用者");
        intro = new JLabel("管理個人資料");
        tip = new JLabel("修改資料後按下儲存即可更新個人資料");
        name = new JLabel("姓名");
        tele = new JLabel("電話");
        userName = new JLabel("帳號");
        password = new JLabel("密碼");
    }

    public void createTextField() {
        nameTextField = new JTextField(TEXT_LENGTH);
        teleTextField = new JTextField(TEXT_LENGTH);
        userNameTextField = new JTextField(TEXT_LENGTH);
        passwordTextField = new JTextField(TEXT_LENGTH);
    }

    public void createButton () {
        logoutButton = new JButton("登出");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 關掉
            }
        });

        saveButton = new JButton("儲存變更");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 儲存更新資料到資料庫
            }
        });

        orderQueryButton = new JButton("查詢歷史訂單");
        orderQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                personalInfo.this.setVisible(false);
//                invoiceRough.setVisible(true);
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
        		frame.setVisible(true);
        		personalInfo.this.setVisible(false);
        	}
        });
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

        JPanel leftOnePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightOnePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftTwoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightTwoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel info = new JPanel(new GridLayout(2, 1, 20, 20));

        leftOnePanel.add(name);
        leftOnePanel.add(nameTextField);
        rightOnePanel.add(tele);
        rightOnePanel.add(teleTextField);
        leftTwoPanel.add(userName);
        leftTwoPanel.add(userNameTextField);
        rightTwoPanel.add(password);
        rightTwoPanel.add(passwordTextField);
        info.add(leftOnePanel);
        info.add(rightOnePanel);
        info.add(leftTwoPanel);
        info.add(rightTwoPanel);

        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.add(info);
        mainPanel.add(wrapperPanel, BorderLayout.CENTER);
        mainPanel.add(topButtonPanel, BorderLayout.NORTH);

        totalPanel.add(toppestPanel, BorderLayout.NORTH);
        totalPanel.add(mainPanel, BorderLayout.CENTER);
        totalPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        totalPanel.add(saveButton, BorderLayout.SOUTH);

        add(totalPanel);
    }

}