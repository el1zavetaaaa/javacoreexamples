package javacoreexample.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuessRiddle extends JPanel
        implements ActionListener {

    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame;
    private static JComboBox comboBox_1;
    private static GridBagConstraints gbc_comboBox_1;
    private static JTextField txtIfYouWant;
    private static GridBagConstraints gbc_txtIfYouWant;

    ImageIcon rightAnswer = new ImageIcon("images\\right.jpg");

    ImageIcon wrongAnswer = new ImageIcon("images\\wrong.png");


    protected void resetFocus() {

        comboBox_1.requestFocusInWindow();
    }

    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0, 1));
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(255, 228, 196));
        JButton helpButton = new JButton("Help");
        helpButton.setBackground(new Color(255, 228, 181));

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);


        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    public GuessRiddle(JFrame f) {
        setBackground(Color.PINK);

        controllingFrame = f;


        comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        comboBox_1.setBackground(new Color(245, 222, 179));
        gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.gridx = 0;
        gbc_comboBox_1.gridy = 3;

        comboBox_1.addItem("Выберите правильный вариант: ");
        comboBox_1.addItem("Книга");
        comboBox_1.addItem("Тетрадь");
        comboBox_1.addItem("Кот");

        JComponent buttonPane = createButtonPanel();

        txtIfYouWant = new JTextField();
        txtIfYouWant.setEditable(false);
        txtIfYouWant.setHorizontalAlignment(SwingConstants.CENTER);
        txtIfYouWant.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtIfYouWant.setForeground(Color.BLACK);
        txtIfYouWant.setBackground(Color.WHITE);
        txtIfYouWant.setText("Страну чудес откроем мы\n" +
                "и встретимся с героями\n" +
                "в строчках,\n" +
                "на листочках,\n" +
                "где станции на точках.");
        gbc_txtIfYouWant = new GridBagConstraints();
        gbc_txtIfYouWant.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIfYouWant.gridx = 0;
        gbc_txtIfYouWant.gridy = 7;


        JPanel textPaneForRiddleAndAnswer = new JPanel(new GridLayout(0, 1));

        textPaneForRiddleAndAnswer.add(txtIfYouWant, gbc_txtIfYouWant);
        textPaneForRiddleAndAnswer.add(comboBox_1, gbc_comboBox_1);

        add(textPaneForRiddleAndAnswer);
        add(buttonPane);


    }


    private static void createAndShowGUI() {

        JFrame frame = new JFrame("PasswordAndLogin");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String getSelectedAnswer = (String) comboBox_1.getSelectedItem();
        String cmd = e.getActionCommand();
        if (OK.equals(cmd)) { //Process the password.
            if (getSelectedAnswer.equals("Книга")) {

                JOptionPane.showMessageDialog(controllingFrame,
                        "",
                        "Правильный ответ!",
                        JOptionPane.ERROR_MESSAGE, rightAnswer);

            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "",
                        "Неправильный ответ!",
                        JOptionPane.ERROR_MESSAGE, wrongAnswer);
            }


            resetFocus();

        } else {
            JOptionPane.showMessageDialog(controllingFrame,
                    "Попробуй еще раз! У тебя обязательно получиться!"
            );
        }
    }
}
