// Accesses a database with student and phone information

import java.awt.BorderLayout;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AccessStudentsCalls {

	private Connection connect = null;
	private Statement statement = null;
	@SuppressWarnings("unused")
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost";
	final private String user = "rohit";
	final private String passwd = "password";
	final private String database = "hospital_management";

	public void connectToDB() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);

			System.out.println("Database connection successful");

		} catch (Exception e) {
			throw e;
		}
	}

	public int login(String name, String pass) throws Exception {
		//System.out.println(name + pass);
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from " + database + ".admin WHERE uname = '"+name+"' AND password = '"+pass+"'");


			//System.out.println(resultSet.getInt("uname"));
			if(resultSet.isBeforeFirst()) {
				System.out.println("Successful login!");
				return 1;
			}
			else {
				return 0;
			}

			//                while (resultSet.next()) {
			//                        int Id = resultSet.getInt("pid");
			//                        String first_name = resultSet.getString("first_name");
			//                        String last_name = resultSet.getString("last_name");
			//
			//                        System.out.println(String.format(
			//                                        "PId: %d First Name: %5s  Last Name: %5s", Id, first_name, last_name));
			//                }
		} catch (Exception e) {
			throw e;
		}

	}

	public void adminq1() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT `pid`, `weight`/(`height`*`height`) AS `bmi` FROM `labreport` ORDER BY `weight`/(`height`*`height`)");

			try {
				AdminQ1 frame = new AdminQ1();
				frame.setSize(720,480);

				frame.setVisible(true);
				String str = "Patient ID		BMI\n";
				while (resultSet.next()) {
					int id = resultSet.getInt("pid");
					float bmi = resultSet.getFloat("bmi");
					System.out.println(String.format("PId: %d BMI: %5s", id, bmi));
					str = str + id + "		" + bmi + "\n";

				}
				frame.txtrHello.setText(str);
				frame.contentPane.add(frame.txtrHello, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void adminq2(JTextField textField, JTextField textField_1, JTextArea textArea,  JPanel contentPane) {

		//AdminQ2 frame = new AdminQ2();
		//frame.setVisible(true);
		String fname = textField.getText();
		String lname = textField_1.getText();
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT count(*) AS number FROM `labreport` JOIN `doctor` ON doctor.doctorId = labreport.doctorId WHERE doctor.first_name="+"'"+fname+"' AND doctor.last_name='"+lname+"'");

			try {
				String str = "Number of Patients\n";
				while (resultSet.next()) {
					int number = resultSet.getInt("number");
					str = str + number+ "\n";
					System.out.println(str);
				}
				textArea.setText(str);
				contentPane.add(textArea, BorderLayout.CENTER);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			try {
				throw e1;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

	public void adminq3(JTextField textField, JTextArea textArea,  JPanel contentPane) {

		//AdminQ2 frame = new AdminQ2();
		//frame.setVisible(true);
		String type = textField.getText();
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.first_name, patient.last_name FROM `patient` JOIN `admittedpatient` JOIN `room` ON patient.pid=admittedpatient.pid AND admittedpatient.roomNo=room.roomNo WHERE room.roomType='"+type+"'");

			try {
				String str = "First Name		Last Name\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					str = str + fname + "		" + lname + "\n";
					System.out.println(str);
				}
				textArea.setText(str);
				contentPane.add(textArea, BorderLayout.CENTER);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			try {
				throw e1;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	public void adminq4(JTextField textField, JTextArea textArea,  JPanel contentPane) {

		//AdminQ2 frame = new AdminQ2();
		//frame.setVisible(true);
		String type = textField.getText();
		int age = Integer.parseInt(type);
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.first_name, patient.last_name, diseaseinfo.disease FROM `patient` JOIN `diseaseinfo` ON patient.pid=diseaseinfo.pid WHERE patient.age < "+30);

			try {
				String str = "First Name		Last Name		Disease\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					String disease = resultSet.getString("disease");
					str = str + fname + "		" + lname + "		" + disease +"\n";
					System.out.println(str);
				}
				textArea.setText(str);
				contentPane.add(textArea, BorderLayout.CENTER);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			try {
				throw e1;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	public void adminq5() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.first_name, patient.last_name, decides.labNo FROM decides JOIN patient ON patient.pid=decides.pid");

			try {
				AdminQ5 frame = new AdminQ5();
				frame.setSize(720,480);

				frame.setVisible(true);
				String str = "First Name		Last Name		Lab No.\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					int lab = resultSet.getInt("labNo");
					
					str = str + fname + "		" + lname + "		" + lab + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public void adminq6() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.pid, bill.amount FROM `patient` JOIN `bill` ON patient.pid=bill.pid");

			try {
				AdminQ6 frame = new AdminQ6();
				frame.setSize(720,480);
				frame.setVisible(true);
				String str = "Patient ID		Bill Amount\n";
				while (resultSet.next()) {
					int pid = resultSet.getInt("pid");
					int amount = resultSet.getInt("amount");
					
					str = str + pid + "		" + amount + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public void adminq7() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT diseaseinfo.disease FROM diseaseinfo JOIN labreport ON diseaseinfo.pid=labreport.pid ORDER BY labreport.date DESC LIMIT 1");

			try {
				AdminQ7 frame = new AdminQ7();
				frame.setSize(720,480);

				frame.setVisible(true);
				String str = "Disease\n";
				while (resultSet.next()) {
					String disease = resultSet.getString("disease");
					
					str = str + disease + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public void adminq8() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT DISTINCT doctor.dept FROM `doctor` JOIN `labreport` ON doctor.doctorId=labreport.doctorId");

			try {
				AdminQ8 frame = new AdminQ8();
				frame.setSize(720,480);

				frame.setVisible(true);
				String str = "Department\n";
				while (resultSet.next()) {
					String department = resultSet.getString("dept");
					
					str = str + department + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	public void employeeq1() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT count(*) AS number, generalopdpatient.date FROM `generalopdpatient` GROUP BY generalopdpatient.date");

			try {
				EmployeeQ1 frame = new EmployeeQ1();
				
				
				frame.setVisible(true);
				frame.setSize(720,480);
				frame.setBackground(Color.orange);
				
				
				String str = "Number		Date\n";
				while (resultSet.next()) {
					int number = resultSet.getInt("number");
					String date = resultSet.getString("date");
					
					str = str + number + "		" + date + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	public void employeeq2() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.first_name, patient.last_name, patient.street FROM `patient` WHERE patient.pid IN (SELECT pid FROM `admittedpatient` GROUP BY `pid` HAVING COUNT(pid)>1)");

			try {
				EmployeeQ2 frame = new EmployeeQ2();
				
				
				frame.setVisible(true);
				frame.setSize(720 ,480);
				
				
				String str = "First Name		Last Name		Street\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					String street = resultSet.getString("street");
					
					str = str + fname + "		" + lname + "		" + street + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	public void employeeq3() {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT doctor.first_name, doctor.last_name FROM `doctor` WHERE doctor.doctorId NOT IN (SELECT appoint.doctorId FROM `appoint`)");

			try {
				EmployeeQ3 frame = new EmployeeQ3();
				
				frame.setVisible(true);
				
				frame.setSize(720,480);
				
				
				
				String str = "First Name		Last Name\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					
					str = str + fname + "		" + lname + "\n";

				}
				System.out.println(str);
				frame.textArea.setText(str);
				frame.contentPane.add(frame.textArea, BorderLayout.CENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	public void employeeq4(JTextField textField, JTextArea textArea,  JPanel contentPane) {
		String type = textField.getText();
		int lab = Integer.parseInt(type);
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT doctor.first_name, doctor.last_name FROM `doctor` WHERE doctor.doctorId IN (SELECT labreport.doctorId FROM `labreport` WHERE labreport.labNo="+lab+")");

			try {
				String str = "First Name		Last Name\n";
				while (resultSet.next()) {
					String fname = resultSet.getString("first_name");
					String lname = resultSet.getString("last_name");
					str = str + fname + "		" + lname + "\n";
					//System.out.println(str);
				}
				System.out.println(str);
				textArea.setText(str);
				contentPane.add(textArea, BorderLayout.CENTER);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			try {
				throw e1;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}
	
	public void employeeq5(JTextField textField, JTextField textField_1, JTextArea textArea,  JPanel contentPane) {
		String fname = textField.getText();
		String lname = textField_1.getText();
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("SELECT patient.first_name, patient.last_name FROM `patient` WHERE patient.pid IN (SELECT appoint.pid FROM `appoint` WHERE appoint.doctorId IN (SELECT doctor.doctorId FROM`doctor` WHERE doctor.first_name='"+fname+"' AND doctor.last_name='"+lname+"'))");

			try {
				String str = "First Name		Last Name\n";
				while (resultSet.next()) {
					String fname1 = resultSet.getString("first_name");
					String lname1 = resultSet.getString("last_name");
					str = str + fname1 + "		" + lname1 + "\n";
					//System.out.println(str);
				}
				System.out.println(str);
				textArea.setText(str);
				contentPane.add(textArea, BorderLayout.CENTER);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			try {
				throw e1;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}
	public void employeeq6() {
//		String fname = textField.getText();
//		String lname = textField_1.getText();
//		try {
//			statement = connect.createStatement();
//			resultSet = statement
//					.executeQuery("SELECT patient.first_name, patient.last_name FROM `patient` WHERE patient.pid IN (SELECT appoint.pid FROM `appoint` WHERE appoint.doctorId IN (SELECT doctor.doctorId FROM`doctor` WHERE doctor.first_name='"+fname+"' AND doctor.last_name='"+lname+"'))");
//
//			try {
//				String str = "First Name		Last Name\n";
//				while (resultSet.next()) {
//					String fname1 = resultSet.getString("first_name");
//					String lname1 = resultSet.getString("last_name");
//					str = str + fname1 + "		" + lname1 + "\n";
//					//System.out.println(str);
//				}
//				System.out.println(str);
//				textArea.setText(str);
//				contentPane.add(textArea, BorderLayout.CENTER);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		} catch (Exception e1) {
//			try {
//				throw e1;
//			} catch (Exception e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//		}

	}
	
	public void employeeq7() {
//		String fname = textField.getText();
//		String lname = textField_1.getText();
//		try {
//			statement = connect.createStatement();
//			resultSet = statement
//					.executeQuery("SELECT patient.first_name, patient.last_name FROM `patient` WHERE patient.pid IN (SELECT appoint.pid FROM `appoint` WHERE appoint.doctorId IN (SELECT doctor.doctorId FROM`doctor` WHERE doctor.first_name='"+fname+"' AND doctor.last_name='"+lname+"'))");
//
//			try {
//				String str = "First Name		Last Name\n";
//				while (resultSet.next()) {
//					String fname1 = resultSet.getString("first_name");
//					String lname1 = resultSet.getString("last_name");
//					str = str + fname1 + "		" + lname1 + "\n";
//					//System.out.println(str);
//				}
//				System.out.println(str);
//				textArea.setText(str);
//				contentPane.add(textArea, BorderLayout.CENTER);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		} catch (Exception e1) {
//			try {
//				throw e1;
//			} catch (Exception e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//		}

	}
	public void readStudents() throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from " + database + ".patient");
			while (resultSet.next()) {
				int Id = resultSet.getInt("pid");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");

				System.out.println(String.format(
						"PId: %d First Name: %5s  Last Name: %5s", Id, first_name, last_name));
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// You need to close the resultSet
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
