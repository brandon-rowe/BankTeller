import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DebitCardChangeCancelGUI extends JFrame {

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
					DebitCardChangeCancelGUI frame = new DebitCardChangeCancelGUI();
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
	public DebitCardChangeCancelGUI() {
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
		
		JLabel label = new JLabel("Account #");
		label.setBounds(95, 82, 68, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(185, 78, 86, 20);
		contentPane.add(textField);
		
		JLabel lblNewPin = new JLabel("New Pin #");
		lblNewPin.setBounds(95, 112, 148, 14);
		contentPane.add(lblNewPin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 109, 86, 20);
		contentPane.add(textField_1);
		
      
      JButton btnResetPin = new JButton("Reset Pin");
		btnResetPin.setBounds(85, 165, 187, 23);
		contentPane.add(btnResetPin);
      
      
		JButton btnCancelDebitCard = new JButton("Cancel Debit Card");
		btnCancelDebitCard.setBounds(85, 199, 187, 23);
		contentPane.add(btnCancelDebitCard);
		
		
		
		JButton button = new JButton("Back");
		button.setBounds(85, 233, 187, 23);
		contentPane.add(button);
	}

}
