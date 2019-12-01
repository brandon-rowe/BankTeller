import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangeOfContactGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeOfContactGUI frame = new ChangeOfContactGUI();
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
	public ChangeOfContactGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangeOfContact = new JLabel("Change Contact Information");
		lblChangeOfContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChangeOfContact.setBounds(133, 24, 240, 24);
		contentPane.add(lblChangeOfContact);
		
		JButton button = new JButton("Search");
		button.setBounds(262, 58, 89, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 59, 86, 20);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Account #");
		label.setBounds(63, 63, 68, 14);
		contentPane.add(label);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(63, 96, 108, 14);
		contentPane.add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 93, 249, 20);
		contentPane.add(textField_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(63, 126, 144, 14);
		contentPane.add(lblPhoneNumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 121, 249, 20);
		contentPane.add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(156, 150, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton button_1 = new JButton("Back");
		button_1.setBounds(10, 11, 76, 23);
		contentPane.add(button_1);
	}
}
