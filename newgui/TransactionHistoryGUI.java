import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;

public class TransactionHistoryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionHistoryGUI frame = new TransactionHistoryGUI();
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
	public TransactionHistoryGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTextGoesHere = new JTextArea();
		txtrTextGoesHere.setEditable(false);
		txtrTextGoesHere.setBounds(90, 91, 323, 228);
		contentPane.add(txtrTextGoesHere);
		
		JLabel lblTransactionHistory = new JLabel("Transaction History");
		lblTransactionHistory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransactionHistory.setBounds(179, 22, 184, 24);
		contentPane.add(lblTransactionHistory);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(295, 57, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(199, 60, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAcc = new JLabel("Account #");
		lblAcc.setBounds(129, 66, 68, 14);
		contentPane.add(lblAcc);
		
		JButton button = new JButton("Back");
		button.setBounds(10, 11, 68, 23);
		contentPane.add(button);
	}
}
