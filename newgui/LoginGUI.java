import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(115, 188, 138, 23);
		contentPane.add(btnLogin);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setBounds(115, 222, 138, 23);
		contentPane.add(btnResetPassword);
		
		textField = new JTextField();
		textField.setBounds(146, 114, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(69, 117, 81, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 151, 95, 14);
		contentPane.add(lblPassword);
		
		JLabel lblBanktellerLogin = new JLabel("BankTeller Login");
		lblBanktellerLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBanktellerLogin.setBounds(115, 57, 138, 23);
		contentPane.add(lblBanktellerLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 148, 86, 20);
		contentPane.add(passwordField);
	}
}
