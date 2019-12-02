import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PasswordResetGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdFieldPass;
	private JPasswordField pwdFieldVerifyPass;

	/**
	 * Create the frame.
	 */
	public PasswordResetGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassowr = new JLabel("Password Reset");
		lblPassowr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassowr.setBounds(105, 28, 240, 14);
		contentPane.add(lblPassowr);
		
		JLabel lblNewPassword = new JLabel("Verify New Password");
		lblNewPassword.setBounds(38, 107, 191, 14);
		contentPane.add(lblNewPassword);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					if (!pwdFieldPass.getText().equals("") && !pwdFieldVerifyPass.getText().equals(""))
					{
						if (pwdFieldPass.getText().equals(pwdFieldVerifyPass.getText())) {

								driver.resetPassword(driver.usern, pwdFieldPass.getText());
								pwdFieldPass.setText("");
								pwdFieldVerifyPass.setText("");
								errorBox("Password has been reset sucessfully.", "Password reset succesful");
							}

						}

					}
				 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReset.setBounds(163, 146, 89, 23);
		contentPane.add(btnReset);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI mainGUI = new MainGUI(driver);
				mainGUI.setVisible(true);
				dispose();
			}
		});
		button.setBounds(163, 179, 92, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("New Password");
		label.setBounds(38, 79, 191, 14);
		contentPane.add(label);
		
		pwdFieldPass = new JPasswordField();
		pwdFieldPass.setBounds(163, 76, 89, 20);
		contentPane.add(pwdFieldPass);
		
		pwdFieldVerifyPass = new JPasswordField();
		pwdFieldVerifyPass.setBounds(163, 104, 89, 20);
		contentPane.add(pwdFieldVerifyPass);
	}
	
    public static void errorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
