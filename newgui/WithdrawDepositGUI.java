import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WithdrawDepositGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldAmount;

	/**
	 * Create the frame.
	 */
	public WithdrawDepositGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
							driver.withdraw(driver.usern, txtFieldAmount.getText());
							errorBox("You have withdrawn $" + txtFieldAmount.getText() + " successfully.", "Withdraw successful");
							txtFieldAmount.setText("");
						}
					  catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace(); 
					}
					
			}
		});
		btnWithdraw.setBounds(124, 112, 89, 23);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					driver.deposit(driver.usern, txtFieldAmount.getText());
					errorBox("You have deposited $" + txtFieldAmount.getText() + " successfully.", "Deposit successful");
					txtFieldAmount.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnDeposit.setBounds(124, 149, 89, 23);
		contentPane.add(btnDeposit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(59, 73, 89, 14);
		contentPane.add(lblAmount);
		
		JLabel lblWithdrawDeposit = new JLabel("Withdraw & Deposit");
		lblWithdrawDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWithdrawDeposit.setBounds(98, 26, 182, 23);
		contentPane.add(lblWithdrawDeposit);
		
		txtFieldAmount = new JTextField();
		txtFieldAmount.setColumns(10);
		txtFieldAmount.setBounds(124, 70, 86, 20);
		contentPane.add(txtFieldAmount);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainGUI mainGUI = new MainGUI(driver);
				mainGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(250, 208, 72, 23);
		contentPane.add(btnBack);
	}
	
	//source: https://stackoverflow.com/questions/7080205/popup-message-boxes
	
    public static void errorBox(String infoMessage, String titleBar)
{
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
}
    
}
