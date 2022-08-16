package loanassistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class LoanAssistant {
    //Project objects
    JFrame frame;
    JTextArea analysisTextArea;
    JLabel loanBalanceLabel, interestRateLabel, monthsLabel, paymentLabel, analysisLabel;
    JTextField loanBalanceTextField, interestRateTextField, monthsTextField, paymentTextField, incrementDecrementTextField;
    JButton computeButton, newLoanButton, monthsButton, paymentButton, exitButton, incrementButton, decrementButton;
    GridBagConstraints gridConstraints;
    ButtonGroup choice = new ButtonGroup();
    JRadioButton singleMode, multiMode;
    computeButtonActionPerformed action = new computeButtonActionPerformed();
    GuessGame obj = new GuessGame();

    //Properties
    boolean computePayment = true, computeBalance = false, mode = true;
    int increment;

    //Main method
    public static void main(String[] args) {
        LoanAssistant loanAssistant = new LoanAssistant();
        loanAssistant.go();
    }

    //Creating of frame with components
    public void go() {
        frame = new JFrame("Loan Assistant");
        GridBagLayout grid = new GridBagLayout();
        frame.getContentPane().setLayout(grid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * START OF lABEL
         */
        //loanBalanceLabel
        loanBalanceLabel = new JLabel("Loan Balance");
        loanBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(loanBalanceLabel, gridConstraints);

        //analysisLabel
        analysisLabel = new JLabel("Loan Analysis:");
        analysisLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 10, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(analysisLabel, gridConstraints);

        //interestRateLabel
        interestRateLabel = new JLabel("Interest Rate");
        interestRateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(interestRateLabel, gridConstraints);

        //monthsLabel
        monthsLabel = new JLabel("Number of Payments");
        monthsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(monthsLabel, gridConstraints);

        //paymentLabel
        paymentLabel = new JLabel("Monthly Payment");
        paymentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = GridBagConstraints.WEST;
        frame.getContentPane().add(paymentLabel, gridConstraints);
        /*
         * END OF lABEL
         */

        /*
         * START OF TEXT FIELD
         */
        //loanBalanceTextField
        loanBalanceTextField = new JTextField("");
        loanBalanceTextField.setPreferredSize(new Dimension(100, 30));
        loanBalanceTextField.setBackground(Color.WHITE);
        loanBalanceTextField.setForeground(new Color(117, 117, 117));
        loanBalanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        loanBalanceTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 10, 5, 10);
        frame.getContentPane().add(loanBalanceTextField, gridConstraints);
        loanBalanceTextField.addActionListener(new loanBalanceTextFieldActionPerformed());

        //interestRateTextField
        interestRateTextField = new JTextField("");
        interestRateTextField.setPreferredSize(new Dimension(100, 30));
        interestRateTextField.setBackground(Color.WHITE);
        interestRateTextField.setForeground(new Color(117, 117, 117));
        interestRateTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        interestRateTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 10, 5, 10);
        frame.getContentPane().add(interestRateTextField, gridConstraints);
        interestRateTextField.addActionListener(new interestRateTextFieldActionPerformed());

        //monthsTextField
        monthsTextField = new JTextField("");
        monthsTextField.setPreferredSize(new Dimension(100, 30));
        monthsTextField.setBackground(Color.WHITE);
        monthsTextField.setForeground(new Color(117, 117, 117));
        monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        monthsTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(5, 10, 5, 10);
        frame.getContentPane().add(monthsTextField, gridConstraints);
        monthsTextField.addActionListener(new monthsTextFieldActionPerformed());

        //paymentTextField
        paymentTextField = new JTextField("");
        paymentTextField.setPreferredSize(new Dimension(100, 30));
        paymentTextField.setBackground(new Color(255, 255, 128));
        paymentTextField.setForeground(new Color(117, 117, 117));
        paymentTextField.setFocusable(false);
        paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        paymentTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(5, 10, 5, 10);
        paymentTextField.setEditable(false);
        frame.getContentPane().add(paymentTextField, gridConstraints);
        paymentTextField.addActionListener(new paymentTextFieldActionPerformed());

        //analysisTextArea
        analysisTextArea = new JTextArea("");
        analysisTextArea.setPreferredSize(new Dimension(300, 150));
        analysisTextArea.setBackground(Color.WHITE);
        analysisTextArea.setForeground(new Color(117, 117, 117));
        analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 16));
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 4;
        gridConstraints.gridwidth = 3;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.insets = new Insets(0, 0, 0, 10);
        analysisTextArea.setEditable(false);
        analysisTextArea.setFocusable(false);
        frame.getContentPane().add(analysisTextArea, gridConstraints);

        //incrementDecrementTextField
        incrementDecrementTextField = new JTextField("1");
        incrementDecrementTextField.setPreferredSize(new Dimension(60, 30));
        incrementDecrementTextField.setBackground(new Color(255, 255, 128));
        incrementDecrementTextField.setForeground(new Color(117, 117, 117));
        incrementDecrementTextField.setFocusable(false);
        incrementDecrementTextField.setHorizontalAlignment(SwingConstants.CENTER);
        incrementDecrementTextField.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        incrementDecrementTextField.setEditable(false);
        frame.getContentPane().add(incrementDecrementTextField, gridConstraints);
        /*
         * END OF TEXT FIELD
         */

        /*
         * START OF BUTTON
         */

        //TODO: Change months and paymentButton to only one button with months, payment and single modes;

        //monthsButton
        monthsButton = new JButton("M");
        monthsButton.setPreferredSize(new Dimension(60, 30));
        monthsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        frame.getContentPane().add(monthsButton, gridConstraints);
        monthsButton.setFocusable(false);
        monthsButton.addActionListener(new changeModeButtonActionPerformed());

        //TODO: Add an increment and decrement button for single mode calculations;

        //incrementButton
        incrementButton = new JButton("+");
        incrementButton.setPreferredSize(new Dimension(60, 30));
        incrementButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(5, 0, 0, 10);
        frame.getContentPane().add(incrementButton, gridConstraints);
        incrementButton.setFocusable(false);
        incrementButton.setEnabled(false);
        incrementButton.addActionListener(new incrementButtonActionPerformed());

        //decrementButton
        decrementButton = new JButton("-");
        decrementButton.setPreferredSize(new Dimension(60, 30));
        decrementButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(5, 0, 5, 10);
        frame.getContentPane().add(decrementButton, gridConstraints);
        decrementButton.setFocusable(false);
        decrementButton.setEnabled(false);
        decrementButton.addActionListener(new decrementButtonActionPerformed());

        //computeButton
        computeButton = new JButton("Compute Monthly Payments");
        computeButton.setPreferredSize(new Dimension(250, 60));
        computeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(5, 10, 5, 10);
        frame.getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(new computeButtonActionPerformed());

        //newLoanButton
        newLoanButton = new JButton("New Loan Analysis");
        newLoanButton.setPreferredSize(new Dimension(250, 60));
        newLoanButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(5, 10, 10, 10);
        frame.getContentPane().add(newLoanButton, gridConstraints);
        newLoanButton.setEnabled(false);
        newLoanButton.addActionListener(new newLoanButtonActionPerformed());

        //exitButton
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(60, 30));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 5;
        gridConstraints.anchor = GridBagConstraints.SOUTHEAST;
        gridConstraints.insets = new Insets(10, 0, 10, 10);
        frame.getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new exitButtonActionPerformed());
        /*
         * END OF BUTTON
         */


        /*
         * START OF RADIO
         */
        //singleMode Radio Button
        singleMode = new JRadioButton("Single Mode");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 0;
        choice.add(singleMode);
        frame.getContentPane().add(singleMode, gridConstraints);
        singleMode.setFocusable(false);
        singleMode.addActionListener(new singleModeActionPerformed());

        //multiMode Radio Button
        multiMode = new JRadioButton("Multi Mode");
        multiMode.setSelected(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 5;
        gridConstraints.gridy = 0;
        choice.add(multiMode);
        frame.getContentPane().add(multiMode, gridConstraints);
        multiMode.setFocusable(false);
        multiMode.addActionListener(new multiModeActionPerformed());
        /*
         * END OF RADIO
         */

        frame.setResizable(false);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((int)(0.5*(screenSize.width - frame.getWidth())), (int)(0.5*(screenSize.height - frame.getHeight())), frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }
    class singleModeActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = false;
            monthsButton.setEnabled(false);
            computeButton.setEnabled(false);
            newLoanButton.setEnabled(false);
            incrementButton.setEnabled(true);
            decrementButton.setEnabled(true);
            incrementDecrementTextField.setEnabled(true);
            action.actionPerformed(e);
        }
    }
    class multiModeActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = true;
            incrementButton.setEnabled(false);
            decrementButton.setEnabled(false);
            computeButton.setEnabled(true);
            newLoanButton.setEnabled(false);
            monthsButton.setEnabled(true);
            incrementDecrementTextField.setEnabled(false);
        }
    }
    class incrementButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            increment = Integer.parseInt(incrementDecrementTextField.getText());
            int months;
            months = Integer.parseInt(monthsTextField.getText());
            if(increment < months){
                increment = increment + 1;
            }
            incrementDecrementTextField.setText(String.valueOf(increment));
            action.actionPerformed(event);
        }
    }
    class decrementButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            increment = Integer.parseInt(incrementDecrementTextField.getText());
            if(increment > 1){
                increment = increment - 1;
            }
            incrementDecrementTextField.setText(String.valueOf(increment));
            action.actionPerformed(event);
        }
    }
    class loanBalanceTextFieldActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            loanBalanceTextField.transferFocus();
        }
    }
    class interestRateTextFieldActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            interestRateTextField.transferFocus();
        }
    }
    class monthsTextFieldActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            monthsTextField.transferFocus();
        }
    }
    class paymentTextFieldActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            paymentTextField.transferFocus();
        }
    }
    class changeModeButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(monthsButton.getText() == "M"){
                computePayment = false;
//                monthsButton.setVisible(false);
//                paymentButton.setVisible(true);
                monthsButton.setText("P");
                paymentTextField.setEditable(true);
                paymentTextField.setFocusable(true);
                paymentTextField.setBackground(Color.WHITE);
                monthsTextField.setEditable(false);
                monthsTextField.setFocusable(false);
                monthsTextField.setBackground(new Color(255, 255, 128));
                computeButton.setText("Compute Number of Payments");
            } else if (monthsButton.getText() == "P") {
                computeBalance = true;
                monthsButton.setText("B");
                monthsTextField.setEditable(true);
                monthsTextField.setFocusable(true);
                monthsTextField.setBackground(Color.WHITE);
                loanBalanceTextField.setEditable(false);
                loanBalanceTextField.setFocusable(false);
                loanBalanceTextField.setBackground(new Color(255, 255, 128));
                computeButton.setText("Compute Balance");
            } else if (monthsButton.getText() == "B") {
                computePayment = true;
                computeBalance = false;
                monthsButton.setText("M");
                loanBalanceTextField.setEditable(true);
                loanBalanceTextField.setFocusable(true);
                loanBalanceTextField.setBackground(Color.WHITE);
                paymentTextField.setEditable(false);
                paymentTextField.setFocusable(false);
                paymentTextField.setBackground(new Color(255, 255, 128));
                computeButton.setText("Compute Monthly Payments");
                loanBalanceTextField.requestFocus();
            }
        }
    }
    class computeButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double balance, interest, payment, monthlyInterest, multiplier, loanBalance, finalPayment;
            int months;

            //TODO: Add the single mode method to compute for single months;

            if(mode){
                if(computePayment == true && computeBalance == false) {
                    if(validateDecimalNumber(loanBalanceTextField)) {
                        balance = Double.parseDouble(loanBalanceTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if(validateDecimalNumber(interestRateTextField)) {
                        interest = Double.parseDouble(interestRateTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    monthlyInterest = interest / 1200;
                    if (validateDecimalNumber(monthsTextField)) {
                        months = Integer.parseInt(monthsTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if(interest == 0) {
                        payment = balance /months;
                    } else {
                        multiplier = Math.pow(1 + monthlyInterest, months);
                        payment = (balance * monthlyInterest * multiplier) / (multiplier - 1);
                    }

                    paymentTextField.setText(new DecimalFormat("0.00").format(payment));
                } else if(computePayment == false && computeBalance == false){
                    if(validateDecimalNumber(loanBalanceTextField)) {
                        balance = Double.parseDouble(loanBalanceTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if(validateDecimalNumber(interestRateTextField)) {
                        interest = Double.parseDouble(interestRateTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    monthlyInterest = interest / 1200;
                    if(validateDecimalNumber(paymentTextField)) {
                        payment = Double.parseDouble(paymentTextField.getText());
                        if(payment <= (balance * monthlyInterest + 1.0)) {
                            if(JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                                paymentTextField.setText(new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)));
                                payment = Double.parseDouble(paymentTextField.getText());
                            } else {
                                paymentTextField.requestFocus();
                                return;
                            }
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if(interest == 0) {
                        months = (int)(balance / payment);
                    } else {
                        months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
                    }

                    monthsTextField.setText(String.valueOf(months));
                } else {
                    if(validateDecimalNumber(interestRateTextField)) {
                        interest = Double.parseDouble(interestRateTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    monthlyInterest = interest / 1200;
                    if (validateDecimalNumber(monthsTextField)) {
                        months = Integer.parseInt(monthsTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if(validateDecimalNumber(paymentTextField)) {
                        payment = Double.parseDouble(paymentTextField.getText());
                    } else {
                        JOptionPane.showConfirmDialog(null, "Invalid or empty monthly payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }


                    if(interest == 0){
                        balance = months * payment;
                        loanBalanceTextField.setText(new DecimalFormat("0.00").format(balance));
                    } else {
                        multiplier = Math.pow(1 + monthlyInterest, months);
                        balance = (payment * (multiplier - 1))/(multiplier * monthlyInterest);
                        loanBalanceTextField.setText(new DecimalFormat("0.00").format(balance));
                    }
                }
                payment = Double.parseDouble(paymentTextField.getText());
                analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
                analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
                loanBalance = balance;
                for(int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++) {
                    loanBalance += loanBalance * monthlyInterest - payment;
                }
                finalPayment = loanBalance;
                if(finalPayment > payment) {
                    loanBalance += loanBalance * monthlyInterest - payment;
                    finalPayment = loanBalance;
                    months++;
                    monthsTextField.setText(String.valueOf(months));
                }
                analysisTextArea.append("\n\n" + (months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
                analysisTextArea.append("\n" + "Final Payments: $" + new DecimalFormat("0.00").format(finalPayment));
                analysisTextArea.append("\n" + "Total Payments: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
                analysisTextArea.append("\n" + "Interest Paid: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
                computeButton.setEnabled(false);
                newLoanButton.setEnabled(true);
                newLoanButton.requestFocus();
            } else {
                if(validateDecimalNumber(loanBalanceTextField)) {
                    balance = Double.parseDouble(loanBalanceTextField.getText());
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(validateDecimalNumber(interestRateTextField)) {
                    interest = Double.parseDouble(interestRateTextField.getText());
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                monthlyInterest = interest / 1200;
                if (validateDecimalNumber(monthsTextField)) {
                    months = Integer.parseInt(monthsTextField.getText());
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if(validateDecimalNumber(paymentTextField)) {
                    payment = Double.parseDouble(paymentTextField.getText());
                } else {
                    JOptionPane.showConfirmDialog(null, "Invalid or empty monthly payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if(interest == 0) {
                    loanBalance = balance;
                    increment = Integer.parseInt(incrementDecrementTextField.getText());
                    for (int count = 1; count <= increment; count++){
                        loanBalance -= payment;
                    }
                } else {
                    loanBalance = balance;
                    increment = Integer.parseInt(incrementDecrementTextField.getText());
                    for (int count = 1; count <= increment; count++){
                        loanBalance += loanBalance * monthlyInterest - payment;
                    }
                }
                analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(loanBalance));
                analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
                analysisTextArea.append("\n\n" + (increment) + " Payment(s) of $" + new DecimalFormat("0.00").format(payment));
                analysisTextArea.append("\n" + "Interest Paid: $" + new DecimalFormat("0.00").format(loanBalance + payment*increment - balance));
                computeButton.setEnabled(false);
                newLoanButton.setEnabled(true);
                newLoanButton.requestFocus();
            }


        }
    }
    class newLoanButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
//            if(computePayment == true && computeBalance == false){
//                paymentTextField.setText("");
//            } else if(computePayment == false && computeBalance == false) {
//                monthsTextField.setText("");
//            } else {
//                loanBalanceTextField.setText("");
//            }
//            analysisTextArea.setText("");
//            computeButton.setEnabled(true);
//            newLoanButton.setEnabled(false);
//            loanBalanceTextField.requestFocus();
            obj.go();
            frame.dispose();
        }
    }
    class exitButtonActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
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
