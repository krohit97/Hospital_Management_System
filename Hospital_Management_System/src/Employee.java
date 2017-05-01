import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class Employee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Serif", Font.PLAIN, 100));
		
		
		lblEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setBackground(Color.yellow);
		contentPane.add(lblEmployee, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblQuery = new JLabel("Query-1");
		
		lblQuery.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery = new GridBagConstraints();
		gbc_lblQuery.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery.gridx = 0;
		gbc_lblQuery.gridy = 0;
		panel.add(lblQuery, gbc_lblQuery);
		
		JButton btnViewResult = new JButton("View Result");
		btnViewResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.employeeq1();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult = new GridBagConstraints();
		gbc_btnViewResult.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult.gridx = 3;
		gbc_btnViewResult.gridy = 0;
		panel.add(btnViewResult, gbc_btnViewResult);
		
		JLabel lblQuery_1 = new JLabel("Query-2");
		
		lblQuery_1.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery_1 = new GridBagConstraints();
		gbc_lblQuery_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_1.gridx = 0;
		gbc_lblQuery_1.gridy = 1;
		panel.add(lblQuery_1, gbc_lblQuery_1);
		
		JButton btnViewResult_1 = new JButton("View Result");
		btnViewResult_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.employeeq2();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_1 = new GridBagConstraints();
		gbc_btnViewResult_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_1.gridx = 3;
		gbc_btnViewResult_1.gridy = 1;
		panel.add(btnViewResult_1, gbc_btnViewResult_1);
		
		JLabel lblQuery_2 = new JLabel("Query-3");
		
		lblQuery_2.setFont(new Font("Serif", Font.PLAIN, 50));
		GridBagConstraints gbc_lblQuery_2 = new GridBagConstraints();
		gbc_lblQuery_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_2.gridx = 0;
		gbc_lblQuery_2.gridy = 2;
		panel.add(lblQuery_2, gbc_lblQuery_2);
		
		JButton btnViewResult_2 = new JButton("View Result");
		btnViewResult_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.employeeq3();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_2 = new GridBagConstraints();
		gbc_btnViewResult_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_2.gridx = 3;
		gbc_btnViewResult_2.gridy = 2;
		panel.add(btnViewResult_2, gbc_btnViewResult_2);
		
		JLabel lblQuery_3 = new JLabel("Query-4");
		
		lblQuery_3.setFont(new Font("Serif", Font.PLAIN, 50));
		GridBagConstraints gbc_lblQuery_3 = new GridBagConstraints();
		gbc_lblQuery_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_3.gridx = 0;
		gbc_lblQuery_3.gridy = 3;
		panel.add(lblQuery_3, gbc_lblQuery_3);
		
		JButton btnViewResult_3 = new JButton("View Result");
		btnViewResult_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EmployeeQ4 frame = new EmployeeQ4();
					frame.setVisible(true);
					frame.setSize(720,480);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_3 = new GridBagConstraints();
		gbc_btnViewResult_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_3.gridx = 3;
		gbc_btnViewResult_3.gridy = 3;
		panel.add(btnViewResult_3, gbc_btnViewResult_3);
		
		JLabel lblQuery_4 = new JLabel("Query-5");
		lblQuery_4.setFont(new Font("Serif", Font.PLAIN, 50));
		GridBagConstraints gbc_lblQuery_4 = new GridBagConstraints();
		gbc_lblQuery_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_4.gridx = 0;
		gbc_lblQuery_4.gridy = 4;
		panel.add(lblQuery_4, gbc_lblQuery_4);
		
		JButton btnViewResult_4 = new JButton("View Result");
		btnViewResult_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EmployeeQ5 frame = new EmployeeQ5();
					frame.setSize(720,480);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_4 = new GridBagConstraints();
		gbc_btnViewResult_4.gridx = 3;
		gbc_btnViewResult_4.gridy = 4;
		panel.add(btnViewResult_4, gbc_btnViewResult_4);
		

		
		 
	}

}
