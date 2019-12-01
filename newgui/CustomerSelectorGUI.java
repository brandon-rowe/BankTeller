import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CustomerSelectorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldCustomerID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSelectorGUI frame = new CustomerSelectorGUI();
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
	public CustomerSelectorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectACustomer = new JLabel("Select a Customer");
		lblSelectACustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectACustomer.setBounds(199, 38, 240, 24);
		contentPane.add(lblSelectACustomer);
		
		JTextArea txtAreaCustomerList = new JTextArea();
		txtAreaCustomerList.setBounds(84, 83, 384, 238);
		contentPane.add(txtAreaCustomerList);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 351, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(439, 351, 89, 23);
		contentPane.add(btnContinue);
		
		txtFieldCustomerID = new JTextField();
		txtFieldCustomerID.setBounds(273, 341, 86, 24);
		contentPane.add(txtFieldCustomerID);
		txtFieldCustomerID.setColumns(10);
		
		JLabel lblCustomerID = new JLabel("Customer ID");
		lblCustomerID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustomerID.setBounds(177, 345, 168, 14);
		contentPane.add(lblCustomerID);
	}
}
