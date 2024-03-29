import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOptions.setBounds(150, 15, 155, 29);
		contentPane.add(lblOptions);
		
		
		JButton btnWithdrawDeposit = new JButton("Withdraw & Deposit");
		btnWithdrawDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawDepositGUI withdrawDepositGUI = new WithdrawDepositGUI(driver);
				withdrawDepositGUI.setVisible(true);
				dispose();
			}
		});
		btnWithdrawDeposit.setBounds(75, 50, 218, 23);
		contentPane.add(btnWithdrawDeposit);
		
      
      
      
      JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceGUI balanceGUI  = new BalanceGUI (driver);
				balanceGUI.setVisible(true);
				dispose();
			}
		});
		btnBalance.setBounds(75, 75, 218, 23);
		contentPane.add(btnBalance);
      
      
      
		JButton btnTransactionHistory = new JButton("Transaction History");
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionHistoryGUI transactionHistoryGUI = new TransactionHistoryGUI(driver);
				transactionHistoryGUI.setVisible(true);
				dispose();
			}
		});
		btnTransactionHistory.setBounds(75, 100, 218, 23);
		contentPane.add(btnTransactionHistory);
		
      
      
      
      
		JButton btnPasswordReset = new JButton("Password Reset");
		btnPasswordReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordResetGUI passwordResetGUI = new PasswordResetGUI(driver);
				passwordResetGUI.setVisible(true);
				dispose();
			}
		});
		btnPasswordReset.setBounds(75, 125, 218, 23);
		contentPane.add(btnPasswordReset);
		
      
      
      
		JButton btnChangeContactInformation = new JButton("Change Contact Info");
		btnChangeContactInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeOfContactGUI changeOfContactGUI = new ChangeOfContactGUI(driver);
				changeOfContactGUI.setVisible(true);
				dispose();
			}
		});
		btnChangeContactInformation.setBounds(75, 150, 218, 23);
		contentPane.add(btnChangeContactInformation);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(137, 210, 94, 23);
		contentPane.add(btnBack);
		
		JButton btnDebitCardManagement = new JButton("Debit Card Management");
		btnDebitCardManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DebitCardChangeCancelGUI debitCardChangeCancelGUI = new DebitCardChangeCancelGUI(driver);
				debitCardChangeCancelGUI.setVisible(true);
				dispose();
			}
		});
		btnDebitCardManagement.setBounds(75, 175, 218, 23);
		contentPane.add(btnDebitCardManagement);
		
		
	}
}
