import java.awt.BorderLayout;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class EmployeeQ2 extends JFrame {

	public JPanel contentPane;
	public JTextArea textArea;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeQ2 frame = new EmployeeQ2();
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
	public EmployeeQ2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPatientsWhoVisited = new JLabel("Patients who visited more than once");
		
		lblPatientsWhoVisited.setFont(new Font("Serif", Font.PLAIN, 40));
		
		
		lblPatientsWhoVisited.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPatientsWhoVisited, BorderLayout.NORTH);
		
		textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
