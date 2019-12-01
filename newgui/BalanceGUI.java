import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BalanceGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldBalance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceGUI frame = new BalanceGUI();
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
	public BalanceGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 199, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setBounds(60, 11, 182, 23);
		contentPane.add(lblBalance);
		
		txtFieldBalance = new JTextField();
		txtFieldBalance.setColumns(10);
		txtFieldBalance.setBounds(50, 45, 86, 20);
		contentPane.add(txtFieldBalance);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(50, 80, 76, 23);
		contentPane.add(btnBack);
	}

}
