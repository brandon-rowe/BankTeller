import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PasswordResetGUI extends JFrame {

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
					PasswordResetGUI frame = new PasswordResetGUI();
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
	public PasswordResetGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassowr = new JLabel("Password Reset (Customer)");
		lblPassowr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassowr.setBounds(78, 32, 240, 14);
		contentPane.add(lblPassowr);
		
		textField = new JTextField();
		textField.setBounds(163, 84, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 115, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Account #");
		lblNewLabel.setBounds(78, 87, 134, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(78, 118, 148, 14);
		contentPane.add(lblNewPassword);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(163, 152, 89, 23);
		contentPane.add(btnReset);
	}

}
