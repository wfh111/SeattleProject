import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private String myMonth;
	private int myYear;
	private double mykWh;
	private Choice mySelectYear;
	private Choice mySelectMonth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		myMonth = "January";
		myYear = 2000;
		mykWh = 0.0;
		mySelectMonth = new Choice();
		mySelectYear = new Choice();
		initialize();
	}
	
	private void initialize() {
		setTitle("Add to History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonth = new JLabel("Select month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(40, 89, 115, 26);
		contentPane.add(lblMonth);
		
		mySelectMonth.setBounds(176, 93, 130, 22);
		mySelectMonth = addMonths(mySelectMonth);
		contentPane.add(mySelectMonth);
		
		JLabel lblYear = new JLabel("Select year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(337, 94, 91, 21);
		contentPane.add(lblYear);
		
		mySelectYear.setBounds(445, 93, 103, 22);
		mySelectYear = addYears(mySelectYear);
		contentPane.add(mySelectYear);
		
		JLabel lblkWh = new JLabel("Enter electricity consumption in kWh:");
		lblkWh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblkWh.setBounds(40, 163, 306, 26);
		contentPane.add(lblkWh);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(151, 267, 130, 33);
		contentPane.add(btnCancel);
		
		JFormattedTextField kWhField = new JFormattedTextField();
		kWhField.setBounds(358, 156, 143, 33);
		contentPane.add(kWhField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myMonth = mySelectMonth.getSelectedItem();
				myYear = mySelectYear.getSelectedIndex();
				mykWh = Double.parseDouble(kWhField.getText());
				setVisible(false);
				dispose();
			}
		});
		
		btnConfirm.setBounds(337, 267, 130, 33);
		contentPane.add(btnConfirm);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 625, 26);
		contentPane.add(menuBar);
		
		JButton btnHome = new JButton("Home");
		menuBar.add(btnHome);
	}

	private Choice addYears(Choice theYears) {
		int year = 2000;
		for(; year < 2018; year++) {
			theYears.add(Integer.toString(year));
		}
		return theYears;
	}

	private Choice addMonths(Choice theMonths) {
		theMonths.add("January");
		theMonths.add("February");
		theMonths.add("March");
		theMonths.add("April");
		theMonths.add("May");
		theMonths.add("June");
		theMonths.add("July");
		theMonths.add("August");
		theMonths.add("September");
		theMonths.add("October");
		theMonths.add("Novemeber");
		theMonths.add("December");
		return theMonths;
	}

	public int getYear() {
		return myYear;
	}

	public String getMonth() {
		return myMonth;
	}

	public double getkWh() {
		return mykWh;
	}
}
