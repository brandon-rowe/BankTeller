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
	private JTextField textField;
	private JTextField textField_1;

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
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setBounds(124, 153, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(124, 187, 89, 23);
		contentPane.add(btnDeposit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(68, 114, 89, 14);
		contentPane.add(lblAmount);
		
		JLabel lblWithdrawDepsoit = new JLabel("Withdraw & Deposit");
		lblWithdrawDepsoit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWithdrawDepsoit.setBounds(98, 26, 182, 23);
		contentPane.add(lblWithdrawDepsoit);
		
		JLabel lblAccount = new JLabel("Account #");
		lblAccount.setBounds(68, 77, 89, 14);
		contentPane.add(lblAccount);
		
		textField = new JTextField();
		textField.setBounds(127, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 111, 86, 20);
		contentPane.add(textField_1);
	}
}
