package loanassistant;


import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;


public class LoanAssistant extends JFrame
{
	
	JLabel balanceLabel = new JLabel("Loan Balance");
	JLabel interestLabel = new JLabel("Interest Rate");
	JLabel paymentLabel = new JLabel("Monthly Payment");
	JLabel monthsLabel = new JLabel("Number of Payments");
	JLabel analysisLabel = new JLabel("Loan Analysis");
	
	JButton exitButton = new JButton("Exit");
	JButton computeButton = new JButton("Compute Monthly Payment");
	JButton newLoanButton = new JButton("New Loan Analysis");
	JButton monthsButton = new JButton("X");
	JButton paymentButton = new JButton("X");
	
	JTextField balanceTextField = new JTextField();
	JTextField interestTextField = new JTextField();
	JTextField paymentTextField = new JTextField();
	JTextField monthsTextField = new JTextField();
	
	JPanel panel = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JTextArea analysisTextArea = new JTextArea();
	
	Font myFont = new Font("Arial",Font.PLAIN,16);
	
	Color lightYellow = new Color(255,255,128);
	boolean computePayment;
	
	///********MAIN METHOD*********///
	public static void main(String[] args) {
		
		new LoanAssistant();
		
	}
	
	//constuctor
	LoanAssistant() {	
			
		//balanceLabel
		balanceLabel.setFont(myFont);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 0);
		panel.add(balanceLabel,gbc);
		//balanceTextField
		balanceTextField.setPreferredSize(new Dimension(100,25));
		balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		balanceTextField.setFont(myFont);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 10);
		panel.add(balanceTextField,gbc);
		
		balanceTextField.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				balanceTextFieldActionPerformed(e);
			}
			
		});
		
		//interestLabel
		interestLabel.setFont(myFont);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 0);
		panel.add(interestLabel,gbc);
		//interestTextField
		interestTextField.setPreferredSize(new Dimension(100,25));
		interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		interestTextField.setFont(myFont);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 10);
		panel.add(interestTextField,gbc);
		
		interestTextField.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{		
				interestTextFieldActionPerformed(e);
			}
			
		});
		
		// monthsLabel
		monthsLabel.setFont(myFont);	
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 0);
		panel.add(monthsLabel,gbc);
		//monthsTextField
		monthsTextField.setPreferredSize(new Dimension(100,25));
		monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		monthsTextField.setFont(myFont);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 10);
		panel.add(monthsTextField,gbc);
		
		monthsTextField.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				monthsTextFieldActionPerformed(e);
			}
			
		});
		
		//paymentLabel
		paymentLabel.setFont(myFont);
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 0);
		panel.add(paymentLabel,gbc);
		//paymentTextField
		paymentTextField.setPreferredSize(new Dimension(100,25));
		paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentTextField.setFont(myFont);
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 0, 10);
		panel.add(paymentTextField,gbc);
					
		paymentTextField.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				paymentTextFieldActionPerformed(e);
			}
			
		});
	
///----------------------- Buttons-------------------------------------///
	
		//computeButton
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,0,0,0);
		panel.add(computeButton, gbc);
		//actionListener
		computeButton.addActionListener(new ActionListener()  {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			computeButtonActionPerformed(e);
			}
		});
		
		//newLoanButton
		newLoanButton.setEnabled(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,0,10,0);
		panel.add(newLoanButton, gbc);
		//actionListener		
		newLoanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newLoanButtonActionPerformed(e);
			}
		});
		
		//monthsButton
		monthsButton.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.insets = new Insets(10,0,0,0);
		panel.add(monthsButton, gbc);
		//actionListener
		monthsButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				monthsButtonActionPerformed(e);
			}
		});
		
		//paymentButton
		paymentButton.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,0,0,0);
		panel.add(paymentButton, gbc);
		//actionListener
		paymentButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentButtonActionPerformed(e);
			}
		});
///----------------------- Loan Analysis-------------------------------///
		analysisLabel.setFont(myFont);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0,10,0,0);
		panel.add(analysisLabel,gbc);
			
		analysisTextArea.setPreferredSize(new Dimension(250,150));
		analysisTextArea.setFocusable(false);
		
		analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
		analysisTextArea.setFont(new Font("Courier New", Font.PLAIN,14));
		analysisTextArea.setEditable(false);
		analysisTextArea.setBackground(Color.white);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		gbc.insets = new Insets(0,10,0,10);
		panel.add(analysisTextArea,gbc);
		
		//exitButton	
		exitButton.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 5;
		panel.add(exitButton,gbc);
		
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				exitButtonActionPerformed(e);
			}
		});
		
		pack();
		
		paymentButton.doClick();
		
///-----------------------Frame---------------------------------------///
		//frame
		setTitle("Loan Assistant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(610,300);
		setResizable(false); 
		setLayout(new GridBagLayout());
		add(panel);
		setVisible(true);
			
	}// endOf Constructor
	
	//Buttons Functionality
	private void computeButtonActionPerformed(ActionEvent e) {
	
		double balance, payment, interest;
		double multiplier, monthlyInterest;
		double loanBalance, finalPayment;
		int months;
		
		if(validateDecimalNumber(balanceTextField)) {
			balance = Double.valueOf(balanceTextField.getText()).doubleValue();
		}
		else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry."
				+ "\nPlease Correct.","Balance Input Error",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		
		if (validateDecimalNumber(interestTextField)) {
			interest = Double.valueOf(interestTextField.getText()).doubleValue();
		}
		else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry."
				+ "\nPlease Correct.","Interest Input Error",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		
		monthlyInterest = interest/1200;
		
		if(computePayment) {
		//calculate Loan Payment
			if (validateDecimalNumber(monthsTextField)) {
				
				months = Integer.valueOf(monthsTextField.getText()).intValue();
			}
			else {	
					JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry."
					+ "\nPlease Correct.","Number of Payments Input Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					return;
				 }
		
			if(interest==0) {
				payment = balance/months;
			}
			else {
				multiplier = Math.pow(1+monthlyInterest, months);
				payment = balance*monthlyInterest*multiplier/(multiplier-1);
			}
		
			paymentTextField.setText(new DecimalFormat("0.00").format(payment));
		}
		else {
			//calculate number of Payments
			if (validateDecimalNumber(paymentTextField)) {
				payment = Double.valueOf(paymentTextField.getText()).doubleValue();
				//minimum balance
				if(payment <= (balance * monthlyInterest + 1.0)) {
					
					if(JOptionPane.showConfirmDialog(null, "Minimum payment must be $"
							+ new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0))
							+"\n"+"Do you want to use the minimum payment?","Input Error",JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_NO_OPTION)
						{
							paymentTextField.setText(new DecimalFormat("0.00").format((int)(balance * monthlyInterest + 1.0)));
							
							payment = Double.valueOf(paymentTextField.getText()).doubleValue();
						}
					else 
					{
						paymentTextField.requestFocus();
						return;
					}
				}
			}
			else {
					JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry."
					+ "\nPlease Correct.","Payment Input Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					return;
				 }
			
			if(interest==0) {
				
				months =(int)(balance / payment);
			}
			else {
				months = (int)((Math.log(payment)-Math.log(payment-balance*monthlyInterest))/Math.log(1+monthlyInterest));
				
			}
			monthsTextField.setText(String.valueOf(months));
		}

		payment = Double.valueOf(paymentTextField.getText()).doubleValue();
		//show analysis
		analysisTextArea.setText("Loan Balance: $"+new DecimalFormat("0.00").format(balance));
		analysisTextArea.append("\n"+"Interest Rate: "+new DecimalFormat("0.00").format(interest)+"%");
		//
		loanBalance = balance;
		
		for (int paymentNumber = 1; paymentNumber <= months-1; paymentNumber++) {
			
			loanBalance += loanBalance * monthlyInterest - payment;
		}
		//find final payment
		finalPayment = loanBalance;
		
		if(finalPayment > payment) {
			
			//apply one more payment
			loanBalance += loanBalance * monthlyInterest - payment;
			finalPayment = loanBalance;
			months++;
			monthsTextField.setText(String.valueOf(months));
		}
		
		analysisTextArea.append("\n\n"+String.valueOf(months-1)+" Payments of $"+
		new DecimalFormat("0.00").format(payment));
		
		analysisTextArea.append("\n"+"Final Payments of: $"+
				new DecimalFormat("0.00").format(finalPayment));
		
		analysisTextArea.append("\n"+"Total Payments: $"+
				new DecimalFormat("0.00").format((months-1) * payment + finalPayment));
		
		analysisTextArea.append("\n"+"Interest Paid $"+
				new DecimalFormat("0.00").format((months-1) * payment + finalPayment - balance));
		
		computeButton.setEnabled(false);
		newLoanButton.setEnabled(true);
		newLoanButton.requestFocus();
		
	}
	
	private void newLoanButtonActionPerformed(ActionEvent e) {
		
		if(computePayment) {
			paymentTextField.setText("");
		}
		else {
			monthsTextField.setText("");
		}
		
		analysisTextArea.setText("");
		computeButton.setEnabled(true);
		newLoanButton.setEnabled(false);
		balanceTextField.requestFocus();
		
	}
	
	private void monthsButtonActionPerformed(ActionEvent e) {
		//calculate months
		computePayment = false;
		paymentButton.setVisible(true);
		monthsButton.setVisible(false);
		monthsTextField.setText("");
		monthsTextField.setEditable(false);
		monthsTextField.setBackground(lightYellow);
		monthsTextField.setFocusable(false);
	
		paymentTextField.setEditable(true);
		paymentTextField.setBackground(Color.WHITE);
		paymentTextField.setFocusable(true);
		computeButton.setText("Compute Number of Payments");
		balanceTextField.requestFocus();
		
	}
	
	private void paymentButtonActionPerformed(ActionEvent e) {
		//calculate payment
		computePayment = true;
		paymentButton.setVisible(false);
		monthsButton.setVisible(true);
		monthsTextField.setEditable(true);
		monthsTextField.setBackground(Color.white);
		monthsTextField.setFocusable(true);
		
		paymentTextField.setText("");
		paymentTextField.setEditable(false);
		paymentTextField.setBackground(lightYellow);
		paymentTextField.setFocusable(false);
		computeButton.setText("Compute Monthly Payment");
		balanceTextField.requestFocus();
	}
	
	private void exitButtonActionPerformed(ActionEvent e) {
		
		System.exit(0);
	}

	private void balanceTextFieldActionPerformed(ActionEvent e) {
		
		balanceTextField.transferFocus();
		
	}
	
	private void interestTextFieldActionPerformed(ActionEvent e) {
		
		interestTextField.transferFocus();
		
	}
	
	private void monthsTextFieldActionPerformed(ActionEvent e) {
		
		monthsTextField.transferFocus();
		
	}
	
	private void paymentTextFieldActionPerformed(ActionEvent e) {
		
		paymentTextField.transferFocus();
		
	}
	
	private boolean validateDecimalNumber(JTextField textField) {
		
		String string = textField.getText().trim();
		boolean hasDecimal = false;
		boolean valid = true;
		
		if(string.length()==0) {
			
			valid = false;
		}
		else {
			for (int i = 0; i < string.length(); i++) {
				
				char c = string.charAt(i);
				
				if (c >= '0' && c <= '9') {
					
					continue;
				}
				else if( c=='.'&& !hasDecimal) {
					
					hasDecimal = true;
				}
				
				else {
					//invalid character found
					valid  = false;
				}
			}
		}
		
		textField.setText(string);
		
		if(!valid) {
			
			textField.requestFocus();
		}
		
		return(valid);
	}
	
}