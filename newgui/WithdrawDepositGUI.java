import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class WithdrawDepositGUI extends JFrame {

	private JPanel contentPane;
	private JTextField btnAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawDepositGUI frame = new WithdrawDepositGUI();
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
	public WithdrawDepositGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(124, 112, 89, 23);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(124, 149, 89, 23);
		contentPane.add(btnDeposit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(59, 73, 89, 14);
		contentPane.add(lblAmount);
		
		JLabel lblWithdrawDeposit = new JLabel("Withdraw & Deposit");
		lblWithdrawDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWithdrawDeposit.setBounds(98, 26, 182, 23);
		contentPane.add(lblWithdrawDeposit);
		
		btnAmount = new JTextField();
		btnAmount.setColumns(10);
		btnAmount.setBounds(124, 70, 86, 20);
		contentPane.add(btnAmount);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(250, 208, 72, 23);
		contentPane.add(btnBack);
	}
}
