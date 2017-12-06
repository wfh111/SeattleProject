/*
 * Dino done did this shit mane. REEEEEEEEEEEE
 * 
 */

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ComparingFrame extends JFrame {
	//comment
	private JFrame compareFrame;
	//private EnergyHistory myHistory;
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
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private double costPerKWH = 0.1; 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparingFrame frame = new ComparingFrame();
					frame.compareFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ComparingFrame(EnergyHistory myHistory) {
		//myHistory.addObserver(this);
		Calculator calc = new Calculator(myHistory);
		initialize(calc);
		
	}
	
	private void initialize(Calculator calc) {
		compareFrame = new JFrame();
		compareFrame.setVisible(true);
		compareFrame.setTitle("Estimate Cost Savings");
		compareFrame.setBounds(100,100,865,487);
		compareFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//compareFrame.getContentPane().setLayout(new BoxLayout(compareFrame.getContentPane(),BoxLayout.X_AXIS));
		contentPane = new JPanel();
		compareFrame.getContentPane().add(contentPane);
	
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel current = new JLabel("Current material:");
		current.setBounds(10,62,150,20);
		contentPane.add(current);
		
		JLabel option1 = new JLabel("Option 1:");
		option1.setBounds(155,11,150,20);
		contentPane.add(option1);
		
		JLabel option2 = new JLabel("Option 2:");
		option2.setBounds(315,11,150,20);
		contentPane.add(option2);
		
		JLabel option3 = new JLabel("Option 3:");
		option3.setBounds(460,11,150,20);
		contentPane.add(option3);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select","Halogen", "Incandescent", "LED", "CFL"}));
		comboBox_1.setBounds(159, 53, 125,20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select","Halogen", "Incandescent","LED", "CFL"}));
		comboBox_2.setBounds(301, 53, 125, 20);
		contentPane.add(comboBox_2);
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Select","Halogen", "Incandescent", "LED", "CFL"}));
		comboBox_3.setBounds(450, 53, 125,20);
		contentPane.add(comboBox_3);
		

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compareFrame.setVisible(false);
				
			}
		});
		btnHome.setBounds(650, 62, 125, 50);;
		contentPane.add(btnHome);
		
		/*JToggleButton tglbtnCalc = new JToggleButton("Compute");
		tglbtnCalc.setBounds(683, 123, 97, 25);;
		contentPane.add(tglbtnCalc);*/
		
		
		JLabel label = new JLabel("Installation cost:");
		label.setBounds(155, 93, 125, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Installation cost:");
		label_1.setBounds(297, 93, 125, 14);
		contentPane.add(label_1);
		
		
		JLabel label_9 = new JLabel("Installation cost:");
		label_9.setBounds(446, 93, 125, 14);
		contentPane.add(label_9);
		
		JLabel lblEstYearlyOperating = new JLabel("Cost per month:");
		lblEstYearlyOperating.setBounds(10, 105, 150, 14);
		contentPane.add(lblEstYearlyOperating);
		
		JLabel label_2 = new JLabel("Cost per month:");
		label_2.setBounds(155, 136, 150, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Cost per month:");
		label_3.setBounds(297, 136, 150, 14);
		contentPane.add(label_3);
		
		JLabel label_10 = new JLabel("Cost per month:");
		label_10.setBounds(446, 136, 150, 14);
		contentPane.add(label_10);
		
		//option 1 installation cost
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 113, 125, 20);
		textField_1.setEnabled(false);
		contentPane.add(textField_1);
		
		//option 2 installation cost
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(297, 113, 125, 20);
		textField_2.setEnabled(false);
		contentPane.add(textField_2);
		
		//option 3 installation cost
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(446, 113, 125, 20);
		textField_3.setEnabled(false);
		contentPane.add(textField_3);
		
		//current est cost/yr
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 125, 125, 20);
		double currAvg = calc.getAverage()*costPerKWH;
		String avg = new Double(currAvg).toString();
		textField_11.setText("$"+avg);
		contentPane.add(textField_11);
		
		//option 1 est cost/yr
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 156, 125, 20);
		textField_4.setEnabled(false);
		contentPane.add(textField_4);
		
		//option 2 est cost/yr
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(297, 156, 125, 20);
		textField_5.setEnabled(false);
		contentPane.add(textField_5);
		
		//option 3 est cost/yr
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(446, 156, 125, 20);
		textField_9.setEnabled(false);
		contentPane.add(textField_9);
		
		//option 1 savings per year
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(155, 205, 125, 20);
		textField_7.setEnabled(false);
		contentPane.add(textField_7);
		
		//option 2 savings per year
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(297, 205, 125, 20);
		contentPane.add(textField_8);
		
		//option 3 savings per year
		textField_10 = new JTextField();
		textField_10.setBounds(446,205,125,20);
		contentPane.add(textField_10);
		
		JLabel label_4 = new JLabel("Savings per month:");
		label_4.setBounds(155, 180, 150, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Savings per month:");
		label_5.setBounds(297, 180, 150, 14);
		contentPane.add(label_5);
		
		JLabel label_11 = new JLabel("Savings per month:");
		label_11.setBounds(446, 180, 150, 14);
		contentPane.add(label_11);
		
		comboBox_3.addActionListener(new ActionListener () {
			double savings; 
			String print;
		    public void actionPerformed(ActionEvent e) {
		        int indexChosen = comboBox_1.getSelectedIndex();
		        textField_9.setEnabled(true);
		        textField_3.setEnabled(true);
		        switch (indexChosen) {
		        case 0:
		        		textField_3.setText("");
		        		textField_9.setText("");
		        		textField_10.setText("");
		        	break;
		        case 1:
		        		System.out.println("Box 3 Chose Halogen");
		        		textField_3.setText("$75.42");
			        textField_9.setText("$3.57");
			        savings = currAvg - 3.57;
			        print = String.format("%.2f",savings);
			        textField_10.setText(print);
		        	break;
		        case 2:
		        		System.out.println("Box 3 Chose Incandescent");
		        		textField_3.setText("$64.78");
			        textField_9.setText("$4.38");
			        savings = currAvg - 4.38;
			        print = String.format("%.2f",savings);
			        textField_10.setText(print);
		        	break;
		        case 3:
		        		System.out.println("Box 3 Chose LED");
		        		textField_3.setText("$112.00");
				    textField_9.setText("$4.57");
				    savings = currAvg - 4.57;
				    print = String.format("%.2f",savings);
			        textField_10.setText(print);
		        	break;
		        case 4:
		        		System.out.println("Box 3 Chose CFL");
		        		textField_3.setText("$55.67");
				    textField_9.setText("$1.45");
				    savings = currAvg - 1.45;
				    print = String.format("%.2f",savings);
			        textField_10.setText(print);
		        	break;
		        }
		    }
		});
		
		comboBox_2.addActionListener(new ActionListener () {
			double savings; 
			String print;
		    public void actionPerformed(ActionEvent e) {
		        int indexChosen = comboBox_2.getSelectedIndex();
		        textField_2.setEnabled(true);
		        textField_5.setEnabled(true);
		        switch (indexChosen) {
		        case 0:
		        		textField_2.setText("");
		        		textField_5.setText("");
		        		textField_8.setText("");
		        	break;
		        case 1:
		        		System.out.println("Box 2 Chose Halogen");
		        		textField_2.setText("$75.42");
			        textField_5.setText("$3.57");
			        savings = currAvg - 3.57;
			        print = String.format("%.2f",savings);
			        textField_8.setText(print);
		        	break;
		        case 2:
		        		System.out.println("Box 2 Chose Incandescent");
		        		textField_2.setText("$64.78");
			        textField_5.setText("$4.38");
			        savings = currAvg - 4.38;
			        print = String.format("%.2f",savings);
			        textField_8.setText(print);
		        	break;
		        case 3:
		        		System.out.println("Box 2 Chose LED");
		        		textField_2.setText("$112.00");
				    textField_5.setText("$4.57");
				    savings = currAvg - 4.57;
				    print = String.format("%.2f",savings);
			        textField_8.setText(print);
		        	break;
		        case 4:
		        		System.out.println("Box 2 Chose CFL");
		        		textField_2.setText("$55.67");
				    textField_5.setText("$1.45");
				    savings = currAvg - 1.45;
				    print = String.format("%.2f",savings);
			        textField_8.setText(print);
		        	break;
		        }
		    }
		});
		
		comboBox_1.addActionListener(new ActionListener () {
			double savings; 
			String print;
		    public void actionPerformed(ActionEvent e) {
		        int indexChosen = comboBox_1.getSelectedIndex();
		        textField_1.setEnabled(true);
		        textField_4.setEnabled(true);
		        switch (indexChosen) {
		        case 0:
			        	textField_1.setText("");
		        		textField_4.setText("");
		        		textField_7.setText("");
		        	break;
		        case 1:
		        		System.out.println("Box 1 Chose Halogen");
		        		textField_1.setText("$75.42");
			        textField_4.setText("$3.57");
			        savings = currAvg - 3.57;
			        print = String.format("%.2f",savings);
			        textField_7.setText(print);
		        	break;
		        case 2:
		        		System.out.println("Box 1 Chose Incandescent");
		        		textField_1.setText("$64.78");
			        textField_4.setText("$4.38");
			        savings = currAvg - 4.38;
			        print = String.format("%.2f",savings);
			        textField_7.setText(print);
		        	break;
		        case 3:
		        		System.out.println("Box 1 Chose LED");
		        		textField_1.setText("$112.00");
				    textField_4.setText("$4.57");
				    savings = currAvg - 4.57;
				    print = String.format("%.2f",savings);
			        textField_7.setText(print);
		        	break;
		        case 4:
		        		System.out.println("Box 1 Chose CFL");
		        		textField_1.setText("$55.67");
				    textField_4.setText("$1.45");
				    savings = currAvg - 1.45;
				    print = String.format("%.2f",savings);
			        textField_7.setText(print);
		        	break;
		        }
		    }
		});
		
		
	}
}
