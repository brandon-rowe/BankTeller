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
		setBounds(100, 100, 572, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnWithdrawDeposit = new JButton("Withdraw & Deposit");
		btnWithdrawDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawDepositGUI withdrawDepositGUI = new WithdrawDepositGUI(driver);
				withdrawDepositGUI.setVisible(true);
				dispose();
			}
		});
		btnWithdrawDeposit.setBounds(188, 124, 218, 23);
		contentPane.add(btnWithdrawDeposit);
		
		JButton btnTransactionHistory = new JButton("Transaction History");
		btnTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionHistoryGUI transactionHistoryGUI = new TransactionHistoryGUI(driver);
				transactionHistoryGUI.setVisible(true);
				dispose();
			}
		});
		btnTransactionHistory.setBounds(188, 192, 218, 23);
		contentPane.add(btnTransactionHistory);
		
		JButton btnPasswordReset = new JButton("Password Reset");
		btnPasswordReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordResetGUI passwordResetGUI = new PasswordResetGUI(driver);
				passwordResetGUI.setVisible(true);
				dispose();
			}
		});
		btnPasswordReset.setBounds(188, 260, 218, 23);
		contentPane.add(btnPasswordReset);
		
		JButton btnChangeContactInformation = new JButton("Change Contact Information");
		btnChangeContactInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeOfContactGUI changeOfContactGUI = new ChangeOfContactGUI(driver);
				changeOfContactGUI.setVisible(true);
				dispose();
			}
		});
		btnChangeContactInformation.setBounds(188, 226, 218, 23);
		contentPane.add(btnChangeContactInformation);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOptions.setBounds(262, 84, 155, 29);
		contentPane.add(lblOptions);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(452, 342, 94, 23);
		contentPane.add(btnBack);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BalanceGUI balanceGUI  = new BalanceGUI (driver);
				balanceGUI.setVisible(true);
				dispose();
			}
		});
		btnBalance.setBounds(188, 158, 218, 23);
		contentPane.add(btnBalance);
	}

}
