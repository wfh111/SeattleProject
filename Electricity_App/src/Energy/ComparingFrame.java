package Energy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComparingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparingFrame frame = new ComparingFrame();
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
	public ComparingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 123, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(159, 11, 123, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(301, 11, 123, 20);
		contentPane.add(comboBox_2);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(335, 228, 89, 23);
		contentPane.add(btnHome);
		
		JToggleButton tglbtnCalc = new JToggleButton("Compute");
		tglbtnCalc.setBounds(10, 228, 121, 23);
		contentPane.add(tglbtnCalc);
		
		JLabel lblInstallationCost = new JLabel("Installation cost:");
		lblInstallationCost.setBounds(10, 42, 123, 14);
		contentPane.add(lblInstallationCost);
		
		textField = new JTextField();
		textField.setBounds(10, 62, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Installation cost:");
		label.setBounds(159, 42, 123, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Installation cost:");
		label_1.setBounds(301, 42, 123, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 62, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(301, 62, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblEstYearlyOperating = new JLabel("Est. cost/yr:");
		lblEstYearlyOperating.setBounds(10, 93, 86, 14);
		contentPane.add(lblEstYearlyOperating);
		
		JLabel label_2 = new JLabel("Est. cost/yr:");
		label_2.setBounds(159, 93, 86, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Est. cost/yr:");
		label_3.setBounds(301, 93, 86, 14);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 118, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 118, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(301, 118, 86, 20);
		contentPane.add(textField_5);
		
		JLabel lblEstSavingsyr = new JLabel("Est. savings/yr:");
		lblEstSavingsyr.setBounds(10, 149, 86, 14);
		contentPane.add(lblEstSavingsyr);
		
		JLabel label_4 = new JLabel("Est. savings/yr:");
		label_4.setBounds(159, 149, 86, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Est. savings/yr:");
		label_5.setBounds(301, 149, 86, 14);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 174, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(159, 174, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(301, 174, 86, 20);
		contentPane.add(textField_8);
	}
}
