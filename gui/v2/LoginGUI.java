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
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUsername;
	private JPasswordField txtFieldPassword;

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
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				driver driver;
				driver = new driver(txtFieldUsername.getText(), txtFieldPassword.getText());

				try {
					dispose();
					driver.main(null);
					if (txtFieldUsername.getText().startsWith("E"))
					{
						CustomerSelectorGUI customerSelectorGUI = new CustomerSelectorGUI(driver);
						customerSelectorGUI.setVisible(true);
					}
					else
					{
						MainGUI mainGUI = new MainGUI(driver);
						mainGUI.setVisible(true);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				


				//try {
					//System.out.println(txtFieldPassword.getText());
					//driver.login(txtFieldUsername.getText(), txtFieldPassword.getText());
					//driver.login("C1000", "password");
				//} catch (IOException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
			}
		});
		btnLogin.setBounds(115, 188, 138, 23);
		contentPane.add(btnLogin);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setBounds(146, 114, 86, 20);
		contentPane.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(69, 117, 81, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(69, 151, 95, 14);
		contentPane.add(lblPassword);
		
		JLabel lblBankTellerLogin = new JLabel("BankTeller Login");
		lblBankTellerLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBankTellerLogin.setBounds(115, 57, 138, 23);
		contentPane.add(lblBankTellerLogin);
		
		txtFieldPassword = new JPasswordField();
		txtFieldPassword.setBounds(146, 148, 86, 20);
		contentPane.add(txtFieldPassword);
	}
	
}
