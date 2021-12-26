package javacoreexample.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.BreakIterator;
import java.util.Locale;


public class ButtonListener implements ActionListener {
    private static JTextArea jTextArea1;
    private static JTextArea jTextArea2;
    private static JTextField jTextField1;
    private static JButton jButton1;
    private static String OK = "ok";
    private static JFrame frame;

    ButtonListener() {
        frame = new JFrame();
        jTextArea1 = new JTextArea("");
        jTextArea1.setBounds(10, 30, 100, 50);

        jTextArea2 = new JTextArea("");
        jTextArea2.setBounds(10, 100, 100, 50);

        jTextField1 = new JTextField();
        jTextField1.setBounds(10, 200, 100, 50);

        jButton1 = new JButton("OK");
        jButton1.setBounds(175, 50, 100, 50);
        jButton1.setBackground(new Color(255, 228, 196));

        jButton1.setActionCommand(OK);
        jButton1.addActionListener(this);

        frame.add(jTextArea1);
        frame.add(jTextArea2);
        frame.add(jTextField1);
        frame.add(jButton1);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new ButtonListener();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String getTextFromJTextarea1 = jTextArea1.getText();
        iterator.setText(getTextFromJTextarea1);


        if (OK.equals(cmd)) {

            int start = iterator.first();
            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {

                String splitedSentences = getTextFromJTextarea1.substring(start, end);
                if (splitedSentences.contains(jTextField1.getText())) {
                    jTextArea2.setText(splitedSentences);

                }
            }

            if (!getTextFromJTextarea1.contains(jTextField1.getText())) {
                JOptionPane.showMessageDialog(frame, "Такого слова нет в тексте!", "", JOptionPane.ERROR_MESSAGE);
            }


        }
    }
}


