import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWithdrawDeposit = new JButton("Withdraw & Deposit");
		btnWithdrawDeposit.setBounds(188, 124, 218, 23);
		contentPane.add(btnWithdrawDeposit);
		
		JButton btnTransactionHistory = new JButton("Transaction History");
		btnTransactionHistory.setBounds(188, 192, 218, 23);
		contentPane.add(btnTransactionHistory);
		
		JButton btnPasswordReset = new JButton("Password Reset");
		btnPasswordReset.setBounds(188, 260, 218, 23);
		contentPane.add(btnPasswordReset);
		
		JButton btnChangeContactInformation = new JButton("Change Contact Information");
		btnChangeContactInformation.setBounds(188, 226, 218, 23);
		contentPane.add(btnChangeContactInformation);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOptions.setBounds(262, 84, 155, 29);
		contentPane.add(lblOptions);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(452, 342, 94, 23);
		contentPane.add(btnBack);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setBounds(188, 158, 218, 23);
		contentPane.add(btnBalance);
	}
}
