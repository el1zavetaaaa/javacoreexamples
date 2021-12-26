package javacoreexample.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CheckPasswordAndLogin extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame;
    private static JPasswordField passwordField;
    private static JPasswordField loginField;
    private static JTextField txtPasswrod;
    private static GridBagConstraints gbc_txtPassword;
    private static JTextField txtLogin;
    private static GridBagConstraints gbc_txtLogin;
    private static JButton okButton;
    private static JButton helpButton;


    protected void resetFocus() {
        passwordField.requestFocusInWindow();
        loginField.requestFocusInWindow();
        txtPasswrod.requestFocusInWindow();
        txtLogin.requestFocusInWindow();
    }


    public CheckPasswordAndLogin(JFrame f) {
        setBackground(Color.PINK);

        controllingFrame = f;


        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

        loginField = new JPasswordField(10);
        loginField.setActionCommand(OK);
        loginField.addActionListener(this);

        txtPasswrod = new JTextField();
        txtPasswrod.setEditable(false);
        txtPasswrod.setHorizontalAlignment(SwingConstants.CENTER);
        txtPasswrod.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtPasswrod.setForeground(Color.black);
        txtPasswrod.setBackground(Color.lightGray);
        txtPasswrod.setText("Contains only VOWEL (oAuEy)");
        gbc_txtPassword = new GridBagConstraints();
        gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPassword.gridx = 0;
        gbc_txtPassword.gridy = 7;

        txtLogin = new JTextField();
        txtLogin.setEditable(false);
        txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
        txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtLogin.setForeground(Color.black);
        txtLogin.setBackground(Color.lightGray);
        txtLogin.setText("Number of phone (+380931669705)");
        gbc_txtLogin = new GridBagConstraints();
        gbc_txtLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLogin.gridx = 0;
        gbc_txtLogin.gridy = 7;


        JLabel labelForPassword = new JLabel("Enter the password: ");
        labelForPassword.setBackground(Color.YELLOW);
        labelForPassword.setLabelFor(passwordField);


        JLabel labelForLogin = new JLabel("Enter the login: ");
        labelForLogin.setLabelFor(loginField);


        JComponent buttonPane = createButtonPanel();


        JPanel textPaneForPasswordAndLogin = new JPanel(new GridLayout(0, 2));

        textPaneForPasswordAndLogin.add(labelForLogin);
        textPaneForPasswordAndLogin.setBackground(Color.PINK);
        textPaneForPasswordAndLogin.add(loginField);


        textPaneForPasswordAndLogin.add(labelForPassword);
        textPaneForPasswordAndLogin.add(passwordField);


        textPaneForPasswordAndLogin.setVisible(true);

        JPanel textPaneForRightPasswordAndLogin = new JPanel(new GridLayout(0, 1));
        textPaneForRightPasswordAndLogin.setBackground(Color.PINK);

        textPaneForRightPasswordAndLogin.add(txtLogin);
        textPaneForRightPasswordAndLogin.add(txtPasswrod);

        add(textPaneForPasswordAndLogin);
        add(textPaneForRightPasswordAndLogin);
        add(buttonPane);
    }

    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        okButton = new JButton("OK");
        okButton.setBackground(new Color(255, 228, 196));
        helpButton= new JButton("Help");
        helpButton.setBackground(new Color(255, 228, 181));

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);


        p.add(okButton);
        p.add(helpButton);

        return p;
    }


    public void actionPerformed(ActionEvent e) {


        String cmd = e.getActionCommand();
        String password = String.valueOf(passwordField.getPassword());
        String login = String.valueOf(loginField.getPassword());

        Pattern patternForPassword = Pattern.compile("[aAeEyYoOuU]+");
        Pattern patternForLogin = Pattern.compile("(\\+\\d{1,3})\\d{10}");
        if (OK.equals(cmd)) { //Process the password.
            char[] passwordArray = password.toCharArray();
            char[] loginArray = login.toCharArray();
            if (password.matches(String.valueOf(patternForPassword)) && login.matches(String.valueOf(patternForLogin))) {

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame = new JFrame("PasswordAndLogin");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                        final GuessRiddle newContentPane = new GuessRiddle(frame);
                        newContentPane.setOpaque(true);
                        frame.setContentPane(newContentPane);

                        frame.addWindowListener(new WindowAdapter() {
                            public void windowActivated(WindowEvent e) {
                                newContentPane.resetFocus();
                            }
                        });


                        frame.pack();
                        frame.setVisible(true);
                    }
                });

                JOptionPane.showMessageDialog(controllingFrame,
                        "Добро пожаловать!");

            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "К сожалению, вы не зарегистрированы!",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }


            Arrays.fill(loginArray, '0');
            Arrays.fill(passwordArray, '0');

            passwordField.selectAll();
            loginField.selectAll();
            resetFocus();

        } else {
            JOptionPane.showMessageDialog(controllingFrame,
                    "Пароль должен содеражть только гласные буквы !\n"
                            + "Логин может содеражть только Ваш номер телефона !\n"
            );
        }
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Password&Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        final CheckPasswordAndLogin newContentPane = new CheckPasswordAndLogin(frame);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });


        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }


}
