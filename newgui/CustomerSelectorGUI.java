import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CustomerSelectorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldCustomerID;


	/**
	 * Create the frame.
	 */
	public CustomerSelectorGUI(driver driver) {
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
			
		JScrollPane scrollPane_1 = new JScrollPane(txtAreaCustomerList);
		scrollPane_1.setBounds(90, 91, 323, 228);
		contentPane.add(scrollPane_1);

	    try
        {
            FileReader reader = new FileReader(driver.directory + "/Database/" + "customerlist.txt");
            BufferedReader br = new BufferedReader(reader);
            txtAreaCustomerList.read( br, null );
            br.close();
            txtAreaCustomerList.requestFocus();
        }
        catch(Exception e2) { System.out.println(e2); }
	    
	    
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(10, 351, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					driver.employee.selectCustomer(txtFieldCustomerID.getText());
					
					MainGUI mainGUI = new MainGUI(driver);
					mainGUI.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
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
