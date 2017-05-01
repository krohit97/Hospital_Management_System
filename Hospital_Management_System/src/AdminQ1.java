import java.awt.BorderLayout;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class AdminQ1 extends JFrame {

	public JTextArea txtrHello;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					AdminQ1 frame = new AdminQ1();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public AdminQ1(int i) {

	}
	/**
	 * Create the frame.
	 */
	public AdminQ1() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblAscendingOrderOf = new JLabel("Ascending Order of Patients by their BMI");
		
		lblAscendingOrderOf.setFont(new Font("Serif", Font.PLAIN,30));

		lblAscendingOrderOf.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAscendingOrderOf, BorderLayout.NORTH);


		txtrHello = new JTextArea();
		//txtrHello.setText("Hello\nWorld!");
		//contentPane.add(txtrHello, BorderLayout.CENTER);
	}


}
