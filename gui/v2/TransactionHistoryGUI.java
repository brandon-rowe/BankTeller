import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TransactionHistoryGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TransactionHistoryGUI(driver driver) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtAreaTransactionHistory = new JTextArea();
		txtAreaTransactionHistory.setColumns(1);
		txtAreaTransactionHistory.setRows(50);
		txtAreaTransactionHistory.setLineWrap(true);
		txtAreaTransactionHistory.setEditable(false);
		txtAreaTransactionHistory.setBounds(20, 70, 300, 200);
		contentPane.add(txtAreaTransactionHistory);
		
		
		JLabel lblTransactionHistory = new JLabel("Transaction History");
		lblTransactionHistory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransactionHistory.setBounds(106, 35, 184, 24);
		contentPane.add(lblTransactionHistory);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainGUI mainGUI = new MainGUI(driver);
				mainGUI.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 11, 68, 23);
		contentPane.add(btnBack);
		
		
		JScrollPane scrollPane = new JScrollPane(txtAreaTransactionHistory);
		scrollPane.setBounds(20, 70, 300, 200);
		contentPane.add(scrollPane);

		
	    try
        {
	    	FileReader reader;
	        reader = new FileReader(driver.directory + driver.usern + ".txt");
            BufferedReader br = new BufferedReader(reader);
            txtAreaTransactionHistory.read( br, null );
            br.close();
            txtAreaTransactionHistory.requestFocus();
        }
        catch(Exception e2) { System.out.println(e2); }

	}	
}

