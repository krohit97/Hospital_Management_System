import java.awt.BorderLayout;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					AdminLogin frame = new AdminLogin();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.setBackground(Color.orange);


		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdminLogin, BorderLayout.NORTH);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.orange);

		JLabel lblUname = new JLabel("uname");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("password");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();
				int i=0;
				try {
					db.connectToDB();
					i = db.login(textField.getText(), textField_1.getText());
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println("i = " + i);
				if(i == 1) {
					try {
						Admin frame = new Admin();
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
						
						
						
						
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else if(i == 0){
					System.out.println("Invalid credentials!\nLogin Fails");
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(41)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPassword)
												.addComponent(lblUname))
										.addGap(52)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(80)
										.addComponent(btnLogin)))
						.addContainerGap(199, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(75)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUname)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addComponent(btnLogin)
						.addGap(21))
				);
		panel.setLayout(gl_panel);
	}
}
