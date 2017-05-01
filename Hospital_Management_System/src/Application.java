import java.awt.BorderLayout;
import java.awt.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Application extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();


					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.getContentPane().setBackground(Color.orange);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JLabel lblHospitalManagementSystem = new JLabel("Hospital Management System");
		lblHospitalManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);

		lblHospitalManagementSystem.setFont(new Font("Serif", Font.PLAIN, 80));


		getContentPane().add(lblHospitalManagementSystem, BorderLayout.NORTH);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		getContentPane().add(btnExit, BorderLayout.SOUTH);

		JLabel lblLoginAs = new JLabel("Login As: ");

		lblLoginAs.setFont(new Font("Serif", Font.PLAIN, 50));



		//getContentPane().add(lblLoginAs, BorderLayout.WEST);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(Color.orange);
		JLabel le4 = new JLabel("\n");
		panel_1.add(le4);

		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);


		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[61px][79px][][]", "[23px][][][][]"));

		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception p) {
					p.printStackTrace();
				}
			}
		});

		JLabel le1 = new JLabel("                                      \n  \n \n \n");
		panel.add(le1);
		JLabel le3 = new JLabel("                                      \n  \n \n \n");
		panel.add(le3);












		panel.add(lblLoginAs);

		JLabel le2 = new JLabel("           ");

		panel.add(le2);


		panel.add(btnAdmin, "cell 1 4,alignx center,aligny center");

		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Employee frame = new Employee();
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setBackground(Color.orange);
					
					
					frame.setVisible(true);
				} catch (Exception p) {
					p.printStackTrace();
				}
			}
		});
		panel.add(btnEmployee, "cell 3 4,alignx center,aligny center");

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
