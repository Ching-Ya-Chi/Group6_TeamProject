import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginRegister extends JFrame {
    private static final int FRAME_WIDTH = 700, FRAME_HEIGHT = 500, d = 100;
    private JLabel type, nameLabel, passwordLabel;
    private JTextField nameTextField, passwordTextField;
    private JRadioButton userButton, vendorButton, workerButton;
    private JButton loginButton, registerButton;
    private ButtonGroup userBtnGroup;
    private invoiceRough frame;
    private JPanel totalPanel = (JPanel) this.getContentPane();

    public LoginRegister() {
        frame = new invoiceRough();
        setTitle("政大校園訂餐系統");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createLabel();
        createTextField();
        createButton();
        createRadioButton();
        createLayout();
    }

    public void createTextField(){
        nameTextField = new JTextField(20);
        passwordTextField = new JTextField(20);
    }

    public void createRadioButton(){
        userButton = new JRadioButton("使用者");
        vendorButton = new JRadioButton("商家");
        workerButton = new JRadioButton("管理者");
        userBtnGroup = new ButtonGroup();
        userButton.setSelected(true);
        userBtnGroup.add(userButton);
        userBtnGroup.add(vendorButton);
        userBtnGroup.add(workerButton);
        userButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                userButton.setSelected(true);
            }
        });

        vendorButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                vendorButton.setSelected(true);
            }
        });

        workerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                workerButton.setSelected(true);
            }
        });
    }

    public void createLabel(){
        type = new JLabel("身份:");
        nameLabel = new JLabel("帳號:");
        passwordLabel = new JLabel("密碼:");
    }

    public void createButton(){
        loginButton = new JButton("登入");
        registerButton = new JButton("註冊");
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // 根據不同身份，去資料庫撈出對應身份的帳號密碼檢查
                if (userButton.isSelected()) {
                    frame.setVisible(true);
                    LoginRegister.this.setVisible(false);
                } else if (vendorButton.isSelected()) {

                } else if (workerButton.isSelected()) {

                }

            }
        });

        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // 根據不同身份，檢查是否存在相同帳密的帳號，無的話創建新帳號
                if (userButton.isSelected()) {

                } else if (vendorButton.isSelected()) {

                } else if (workerButton.isSelected()) {

                }

            }
        });

    }

    public void createLayout(){
        JLabel title = new JLabel("政大校園訂餐系統");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();
        JPanel thirdPanel = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JPanel fourthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        firstPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 80));
        secondPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 40));
        titlePanel.setPreferredSize(new Dimension(FRAME_WIDTH, 40));
        thirdPanel.setPreferredSize(new Dimension(FRAME_WIDTH, 40));
        fourthPanel.setPreferredSize(new Dimension(FRAME_WIDTH - 350, 40));

        firstPanel.add(userButton);
        firstPanel.add(vendorButton);
        firstPanel.add(workerButton);

        secondPanel.add(nameLabel);
        secondPanel.add(nameTextField);

        thirdPanel.add(passwordLabel);
        thirdPanel.add(passwordTextField);

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        fourthPanel.add(buttonPanel);

        mainPanel.add(titlePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);
        setLayout(new BorderLayout(20, 40));

        getContentPane().add(new JPanel(), BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(new JPanel(), BorderLayout.SOUTH);

        mainPanel.add(new Panel(), BorderLayout.SOUTH);
        mainPanel.add(new Panel(), BorderLayout.NORTH);
        mainPanel.add(new Panel(), BorderLayout.WEST);
        mainPanel.add(new Panel(), BorderLayout.EAST);
    }

}