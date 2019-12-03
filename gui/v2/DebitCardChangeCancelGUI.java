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
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DebitCardChangeCancelGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldNewPin;

	/**
	 * Create the frame.
	 */
	public DebitCardChangeCancelGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDebitCardPin = new JLabel("Debit Card Options");
		lblDebitCardPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDebitCardPin.setBounds(110, 31, 237, 24);
		contentPane.add(lblDebitCardPin);
		
		JLabel lblNewPin = new JLabel("New Pin #");
		lblNewPin.setBounds(85, 82, 148, 14);
		contentPane.add(lblNewPin);
		
		txtFieldNewPin = new JTextField();
		txtFieldNewPin.setColumns(10);
		txtFieldNewPin.setBounds(166, 79, 86, 20);
		contentPane.add(txtFieldNewPin);
		
      
      JButton btnResetPin = new JButton("Reset Pin");
      btnResetPin.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
			try {
				if (!txtFieldNewPin.getText().equals(""))
				{
					driver.debitCardPinChange(driver.usern, txtFieldNewPin.getText());	
					errorBox("Debit card pin has been changed.", "Debit card pin changed");
					txtFieldNewPin.setText("");
				}
			}
		  catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		  }
      	}
      });
		btnResetPin.setBounds(85, 113, 187, 23);
		contentPane.add(btnResetPin);
      
      
		JButton btnCancelDebitCard = new JButton("Cancel Debit Card");
		btnCancelDebitCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						driver.debitCardCancellation(driver.usern);
						errorBox("Debit card has been cancelled.", "Debit card cancelled");
				}
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			  }
			}
		});
		btnCancelDebitCard.setBounds(85, 147, 187, 23);
		contentPane.add(btnCancelDebitCard);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI mainGUI = new MainGUI(driver);
				mainGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(85, 181, 187, 23);
		contentPane.add(btnBack);
		
		//source: https://stackoverflow.com/questions/7080205/popup-message-boxes
		
	}
	
    public static void errorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}
