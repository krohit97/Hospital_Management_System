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

public class EmployeeQ1 extends JFrame {

	public JPanel contentPane;
	public JTextArea textArea;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeQ1 frame = new EmployeeQ1();
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
	public EmployeeQ1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPeopleEnteringOpd = new JLabel("People Entering OPD Everyday");
		
		lblPeopleEnteringOpd.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		contentPane.setBackground(Color.cyan);
		lblPeopleEnteringOpd.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPeopleEnteringOpd, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		
		panel.add(textArea, BorderLayout.CENTER);
	}

}
