package javacoreexample.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.regex.Pattern;

public class GettingPasswordWithOnlyVowels extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    private JFrame controllingFrame;
    private static JPasswordField passwordField;


    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }


    public GettingPasswordWithOnlyVowels(JFrame f) {
        setBackground(Color.PINK);

        controllingFrame = f;


        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(passwordField);

        JComponent buttonPane = createButtonPanel();


        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.setBackground(new Color(255, 228, 181));
        textPane.add(label);
        textPane.add(passwordField);

        add(textPane);
        add(buttonPane);
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

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String password = String.valueOf(passwordField.getPassword());

        Pattern pattern = Pattern.compile("[aAeEyYoOuU]+");
        if (OK.equals(cmd)) { //Process the password.
            char[] input = password.toCharArray();
            if (password.matches(String.valueOf(pattern))) {

                JOptionPane.showMessageDialog(controllingFrame,
                        "Success! Good password.");
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }


            Arrays.fill(input, '0');

            passwordField.selectAll();
            resetFocus();
        } else {
            JOptionPane.showMessageDialog(controllingFrame,
                    "You can type the password with vowel letters\n"
                            + "source code for the string \"correctPassword\".\n"
            );
        }
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("PasswordDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        final GettingPasswordWithOnlyVowels newContentPane = new GettingPasswordWithOnlyVowels(frame);
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