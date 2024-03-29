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
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ChangeOfContactGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldAddress;
	private JTextField txtFieldPhoneNumber;


	/**
	 * Create the frame.
	 */
	public ChangeOfContactGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangeOfContact = new JLabel("Change Contact Information");
		lblChangeOfContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChangeOfContact.setBounds(93, 24, 240, 24);
		contentPane.add(lblChangeOfContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(20, 78, 108, 14);
		contentPane.add(lblAddress);
		
		txtFieldAddress = new JTextField();
		txtFieldAddress.setColumns(10);
		txtFieldAddress.setBounds(80, 75, 249, 20);
		contentPane.add(txtFieldAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(20, 113, 144, 14);
		contentPane.add(lblPhoneNumber);
		
		txtFieldPhoneNumber = new JTextField();
		txtFieldPhoneNumber.setColumns(10);
		txtFieldPhoneNumber.setBounds(135, 106, 194, 20);
		contentPane.add(txtFieldPhoneNumber);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						driver.changeContact(driver.usern, txtFieldAddress.getText(), txtFieldPhoneNumber.getText());

					txtFieldAddress.setText("");
					txtFieldPhoneNumber.setText("");
					errorBox("Contact information updated successfully.", "Update successful");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(20, 150, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainGUI mainGUI = new MainGUI(driver);
				mainGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(125, 150, 76, 23);
		contentPane.add(btnBack);
	}
	
    public static void errorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
