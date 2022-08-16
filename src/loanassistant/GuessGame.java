package loanassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessGame {
    JFrame frame;
    JTextArea infoTextArea;
    JLabel guessLabel;
    JTextField guessTextField, firstTextField, secondTextField, thirdTextField, fourthTextField, fifthTextField;
    JButton startButton, exitButton, chanceButton, submitButton;
    String guessNumber;
    int chance;
    char validateChar = 'A';


    public void go(){
        frame = new JFrame("Guess Game");
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gridConstraints;
        frame.getContentPane().setLayout(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //guess label
        guessLabel = new JLabel("Enter your guess:");
        guessLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        //guessLabel.setPreferredSize(new Dimension(250, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.insets = new Insets(5, 10, 10, 10);
        gridConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(guessLabel, gridConstraints);

        //Number fields
        //firstTextField
        firstTextField = new JTextField("690 - one dead");
        firstTextField.setPreferredSize(new Dimension(200 , 40));
        firstTextField.setBackground(Color.WHITE);
        firstTextField.setForeground(new Color(117, 117, 117));
        firstTextField.setHorizontalAlignment(SwingConstants.CENTER);
        firstTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 5, 10);
        firstTextField.setEditable(false);
        frame.getContentPane().add(firstTextField, gridConstraints);

        //secondTextField
        secondTextField = new JTextField("741 - one wounded");
        secondTextField.setPreferredSize(new Dimension(200 , 40));
        secondTextField.setBackground(Color.WHITE);
        secondTextField.setForeground(new Color(117, 117, 117));
        secondTextField.setHorizontalAlignment(SwingConstants.CENTER);
        secondTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        secondTextField.setEditable(false);
        frame.getContentPane().add(secondTextField, gridConstraints);

        //thirdTextField
        thirdTextField = new JTextField("504 - two wounded");
        thirdTextField.setPreferredSize(new Dimension(200 , 40));
        thirdTextField.setBackground(Color.WHITE);
        thirdTextField.setForeground(new Color(117, 117, 117));
        thirdTextField.setHorizontalAlignment(SwingConstants.CENTER);
        thirdTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        thirdTextField.setEditable(false);
        frame.getContentPane().add(thirdTextField, gridConstraints);

        //fourTextField
        fourthTextField = new JTextField("387 - none correct");
        fourthTextField.setPreferredSize(new Dimension(200 , 40));
        fourthTextField.setBackground(Color.WHITE);
        fourthTextField.setForeground(new Color(117, 117, 117));
        fourthTextField.setHorizontalAlignment(SwingConstants.CENTER);
        fourthTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        fourthTextField.setEditable(false);
        frame.getContentPane().add(fourthTextField, gridConstraints);

        //fifthTextField
        fifthTextField = new JTextField("219 - one wounded");
        fifthTextField.setPreferredSize(new Dimension(200 , 40));
        fifthTextField.setBackground(Color.WHITE);
        fifthTextField.setForeground(new Color(117, 117, 117));
        fifthTextField.setHorizontalAlignment(SwingConstants.CENTER);
        fifthTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 5, 10);
        fifthTextField.setEditable(false);
        frame.getContentPane().add(fifthTextField, gridConstraints);

        //guess textField
        guessTextField = new JTextField();
        guessTextField.setPreferredSize(new Dimension(200, 40));
        guessTextField.setBackground(Color.WHITE);
        guessTextField.setForeground(new Color(117, 117, 117));
        guessTextField.setHorizontalAlignment(SwingConstants.CENTER);
        guessTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.insets = new Insets(0, 10, 10, 10);
        guessTextField.setEditable(false);
        frame.getContentPane().add(guessTextField, gridConstraints);
        guessTextField.addActionListener(new SubmitButton());

        //Information TextArea
        infoTextArea = new JTextArea("Your results are displayed here");
        infoTextArea.setPreferredSize(new Dimension(250, 200));
        infoTextArea.setBackground(Color.WHITE);
        infoTextArea.setForeground(new Color(117, 117, 117));
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        infoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 2;
        gridConstraints.gridheight = 5;
        gridConstraints.insets = new Insets(10, 10, 5, 10);
        gridConstraints.fill = GridBagConstraints.BOTH;
        infoTextArea.setEditable(false);
        infoTextArea.setFocusable(false);
        frame.getContentPane().add(infoTextArea, gridConstraints);


        //Buttons
        //startButton
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(80, 40));
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        frame.getContentPane().add(startButton, gridConstraints);
        startButton.setFocusable(false);
        startButton.addActionListener(new StartButton());

        //exitButton
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(80, 40));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 5;
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        frame.getContentPane().add(exitButton, gridConstraints);
        exitButton.setFocusable(false);
        exitButton.addActionListener(new StopButton());

        //chanceButton
        chanceButton = new JButton("Opt.");
        chanceButton.setPreferredSize(new Dimension(80, 40));
        chanceButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 6;
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        frame.getContentPane().add(chanceButton, gridConstraints);
        chanceButton.setFocusable(false);
        chanceButton.setEnabled(false);
        chanceButton.addActionListener(new ChanceButton());

        //submitButton
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(90, 40));
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.insets = new Insets(0, 0, 10, 10);
        frame.getContentPane().add(submitButton, gridConstraints);
        submitButton.setFocusable(false);
        submitButton.setEnabled(false);
        submitButton.addActionListener(new SubmitButton());

        frame.setResizable(false);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int)(0.5*(screenSize.width - frame.getWidth())), (int)(0.5*(screenSize.height - frame.getHeight())), frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }
    public class SubmitButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validateDecimalNumber(guessTextField)) {
                guessNumber = guessTextField.getText();
            }
            else {
                JOptionPane.showConfirmDialog(null, "Invalid or empty guess number entry.\nPlease correct.", "Guess Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(guessNumber.length() == 3) {
                int x = 0;
                int y = 0;
                String correctNumber = "420";
                if (guessNumber.equals(correctNumber)) {
                    infoTextArea.setText("Congrats!!!\nYou entered the right answer!");
                }
                else {
                    for (int i = 0; i < correctNumber.length(); i++) {
                        String c = String.valueOf(guessNumber.charAt(i));
                        if (correctNumber.contains(c)) {
                            if (guessNumber.charAt(i) == correctNumber.charAt(i)) {
                                x++;
                            } else {
                                y++;
                            }
                        }
                    }
                    infoTextArea.setText("You have guessed " + x + "correct numbers\nin the right position and " + y + "correct numbers\nin the wrong position");
                }
            }
            else {
                JOptionPane.showConfirmDialog(null, "Your entered number is less or greater than three(3) digits.\nPlease correct.", "Guess Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public class StartButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (startButton.getText().equals("Start")) {
                guessTextField.setEditable(true);
                guessTextField.transferFocus();
                guessTextField.setFocusable(true);
                startButton.setText("Stop");
                exitButton.setEnabled(false);
                submitButton.setEnabled(true);
                chanceButton.setEnabled(true);
                //password - smile1
            }
            else {
                startButton.setText("Start");
                guessTextField.setEditable(false);
                guessTextField.setFocusable(false);
                exitButton.setEnabled(true);
                submitButton.setEnabled(false);
                chanceButton.setEnabled(false);
            }

        }
    }
    public class StopButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    public class ChanceButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (chance < 2) {
                Random rand = new Random();
                String guessNumber1 = "420";
                int randNum = rand.nextInt(3);
                if (validateChar == guessNumber1.charAt(randNum)) {
                    do {
                        randNum = rand.nextInt(3);
                    } while (validateChar == guessNumber1.charAt(randNum));
                    chance = chance + 1;
                    validateChar = guessNumber1.charAt(randNum);
                    infoTextArea.setText("One of the numbers is " + validateChar);
                }
                else if (validateChar != guessNumber1.charAt(rand.nextInt(3))) {
                    validateChar = guessNumber1.charAt(randNum);
                    infoTextArea.setText("One of the numbers is " + validateChar);
                    chance = chance + 1;
                }
            }
            else {
                JOptionPane.showConfirmDialog(null, "You have exhausted all your chances", "Chances", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public boolean validateDecimalNumber(JTextField tf) {
        String s = tf.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        if(s.length() == 0) {
            valid = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c >= '0' && c <= '9'){
                    continue;
                } else if(c == '.' && !hasDecimal) {
                    hasDecimal = true;
                } else {
                    valid = false;
                }
            }
        }
        tf.setText(s);
        if(!valid) {
            tf.requestFocus();
        }
        return (valid);
    }
}
