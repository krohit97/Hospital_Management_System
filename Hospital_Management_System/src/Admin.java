import java.awt.BorderLayout;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

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
	//					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.yellow);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Serif", Font.PLAIN, 100));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		contentPane.add(lblAdmin, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblQuery = new JLabel("Query-1");
		lblQuery.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		
		
		GridBagConstraints gbc_lblQuery = new GridBagConstraints();
		gbc_lblQuery.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery.gridx = 1;
		gbc_lblQuery.gridy = 1;
		panel.add(lblQuery, gbc_lblQuery);

		JButton btnViewResult = new JButton("View Result");
		btnViewResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.adminq1();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_btnViewResult = new GridBagConstraints();
		gbc_btnViewResult.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult.gridx = 7;
		gbc_btnViewResult.gridy = 1;
		panel.add(btnViewResult, gbc_btnViewResult);

		JLabel lblQuery_1 = new JLabel("Query-2");
		lblQuery_1.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery_1 = new GridBagConstraints();
		gbc_lblQuery_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_1.gridx = 1;
		gbc_lblQuery_1.gridy = 2;
		panel.add(lblQuery_1, gbc_lblQuery_1);

		JButton btnViewResult_1 = new JButton("View Result");
		btnViewResult_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminQ2 frame = new AdminQ2();
					frame.setSize(720,480);

					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_1 = new GridBagConstraints();
		gbc_btnViewResult_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_1.gridx = 7;
		gbc_btnViewResult_1.gridy = 2;
		panel.add(btnViewResult_1, gbc_btnViewResult_1);

		JLabel lblQuery_2 = new JLabel("Query-3");
		
		lblQuery_2.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery_2 = new GridBagConstraints();
		gbc_lblQuery_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_2.gridx = 1;
		gbc_lblQuery_2.gridy = 3;
		panel.add(lblQuery_2, gbc_lblQuery_2);

		JButton btnViewResult_2 = new JButton("View Result");
		btnViewResult_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminQ3 frame = new AdminQ3();
					frame.setSize(720,480);

					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_2 = new GridBagConstraints();
		gbc_btnViewResult_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_2.gridx = 7;
		gbc_btnViewResult_2.gridy = 3;
		panel.add(btnViewResult_2, gbc_btnViewResult_2);
		
		JLabel lblQuery_3 = new JLabel("Query-4");
		lblQuery_3.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		GridBagConstraints gbc_lblQuery_3 = new GridBagConstraints();
		gbc_lblQuery_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_3.gridx = 1;
		gbc_lblQuery_3.gridy = 4;
		panel.add(lblQuery_3, gbc_lblQuery_3);
		
		JButton btnViewResult_3 = new JButton("View Result");
		btnViewResult_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminQ4 frame = new AdminQ4();
					frame.setSize(720,480);

					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_3 = new GridBagConstraints();
		gbc_btnViewResult_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_3.gridx = 7;
		gbc_btnViewResult_3.gridy = 4;
		panel.add(btnViewResult_3, gbc_btnViewResult_3);
		
		JLabel lblQuery_4 = new JLabel("Query-5");
		lblQuery_4.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		GridBagConstraints gbc_lblQuery_4 = new GridBagConstraints();
		gbc_lblQuery_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_4.gridx = 1;
		gbc_lblQuery_4.gridy = 5;
		panel.add(lblQuery_4, gbc_lblQuery_4);
		
		JButton btnViewResult_4 = new JButton("View Result");
		btnViewResult_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.adminq5();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_4 = new GridBagConstraints();
		gbc_btnViewResult_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_4.gridx = 7;
		gbc_btnViewResult_4.gridy = 5;
		panel.add(btnViewResult_4, gbc_btnViewResult_4);
		
		JLabel lblNewLabel = new JLabel("Query-6");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnViewResult_5 = new JButton("View Result");
		btnViewResult_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.adminq6();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_5 = new GridBagConstraints();
		gbc_btnViewResult_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_5.gridx = 7;
		gbc_btnViewResult_5.gridy = 6;
		panel.add(btnViewResult_5, gbc_btnViewResult_5);
		
		JLabel lblQuery_5 = new JLabel("Query-7");
		lblQuery_5.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery_5 = new GridBagConstraints();
		gbc_lblQuery_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuery_5.gridx = 1;
		gbc_lblQuery_5.gridy = 7;
		panel.add(lblQuery_5, gbc_lblQuery_5);
		
		JButton btnViewResult_6 = new JButton("View Result");
		btnViewResult_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.adminq7();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_6 = new GridBagConstraints();
		gbc_btnViewResult_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewResult_6.gridx = 7;
		gbc_btnViewResult_6.gridy = 7;
		panel.add(btnViewResult_6, gbc_btnViewResult_6);
		
		JLabel lblQuery_6 = new JLabel("Query-8");
		lblQuery_6.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		
		GridBagConstraints gbc_lblQuery_6 = new GridBagConstraints();
		gbc_lblQuery_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuery_6.gridx = 1;
		gbc_lblQuery_6.gridy = 8;
		panel.add(lblQuery_6, gbc_lblQuery_6);
		
		JButton btnViewResult_7 = new JButton("View Result");
		btnViewResult_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessStudentsCalls db = new AccessStudentsCalls();

				try {
					db.connectToDB();
					db.adminq8();
					db.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnViewResult_7 = new GridBagConstraints();
		gbc_btnViewResult_7.gridx = 7;
		gbc_btnViewResult_7.gridy = 8;
		panel.add(btnViewResult_7, gbc_btnViewResult_7);
	}
}
