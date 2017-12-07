package Energy;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

/**
 * @author Walter Hanson
 * Class to allow User to add data to their history. 
 */
public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String myMonth;
	private int myYear;
	private int mykWh;
	private Choice mySelectYear;
	private Choice mySelectMonth;
	private EnergyHistory myHist;
	private int myIntMonth;
	JFormattedTextField mykWhField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddDialog dialog = new AddDialog(new EnergyHistory());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Walter Hanson
	 * Create the dialog.
	 */
	public AddDialog(EnergyHistory theHist) {
		myMonth = "January";
		myYear = 2000;
		mykWh = 0;
		myHist = theHist;
		myIntMonth = 1;
		mySelectMonth = new Choice();
		mySelectYear = new Choice();
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); 
		mykWhField = new JFormattedTextField(numberFormatter);
		mykWhField.setValue(0);
		initialize();
	}
	
	/**
	 * @author Walter Hanson
	 */
	public AddDialog(int theMonth, int theYear, int thekWh, EnergyHistory theHist) {
		myIntMonth = theMonth;
		myYear = theYear;
		mykWh = thekWh;
		myHist = theHist;
		mySelectMonth = new Choice();
		mySelectYear = new Choice();
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); 
		mykWhField = new JFormattedTextField(numberFormatter);
		mykWhField.setValue(0);
		initialize();
	}
	
	/**
	 * @author Walter Hanson
	 */
	private void initialize() {
		setTitle("Add to History");
		setBounds(100, 100, 571, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		contentPanel.setLayout(null);
		
		JLabel lblMonth = new JLabel("Select month:");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(36, 58, 109, 22);
		contentPanel.add(lblMonth);
		
		mySelectMonth.setBounds(150, 58, 99, 22);
		mySelectMonth = addMonths(mySelectMonth);
		mySelectMonth.select(myIntMonth - 1);
		contentPanel.add(mySelectMonth);
		
		JLabel lblYear = new JLabel("Select year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(275, 58, 91, 22);
		contentPanel.add(lblYear);
		
		mySelectYear.setBounds(378, 58, 74, 22);
		mySelectYear = addYears(mySelectYear);
		mySelectYear.select(myYear - 2000);
		contentPanel.add(mySelectYear);
		
		JLabel lblkWh = new JLabel("Enter electricity consumption in kWh:");
		lblkWh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblkWh.setBounds(126, 107, 294, 22);
		contentPanel.add(lblkWh);
		
		mykWhField.setBounds(201, 141, 165, 22);
		mykWhField.setValue(mykWh);
		contentPanel.add(mykWhField);
		
		JButton confirmButton = new JButton("CONFIRM");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myMonth = mySelectMonth.getSelectedItem();
				myYear = Integer.parseInt(mySelectYear.getSelectedItem());
				String txt = mykWhField.getText();
				txt = txt.replace(",", "");
				mykWh = Integer.parseInt(txt);
				myHist.add(myMonth, myYear, mykWh);
				setVisible(false);
			}
		});
		confirmButton.setActionCommand("OK");
		buttonPane.add(confirmButton);
		getRootPane().setDefaultButton(confirmButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	
	/**
	 * @author Walter Hanson
	 * Method to add the years 2000 to 2017 to a drop-down menu. 
	 * Precondition: Drop-down menu to add the years too
	 * Postcondition: Drop-down menu filled with the years 2000 to 2017 that the User can select.
	 */
	private Choice addYears(Choice theYears) {
		int year = 2000;
		for(; year < 2018; year++) {
			theYears.add(Integer.toString(year));
		}
		return theYears;
	}

	/**
	 * @author Walter Hanson
	 * Method to add months to a drop-down menu. 
	 * Precondition: Drop-down menu to add the months too
	 * Postcondition: Drop-down menu filled with all 12 months that the User can select.
	 */
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
	
	/**
	 * @author Walter Hanson
	 * Method to convert the string representation of a month to its int form. 
	 * Precondition: A String with the name of the month to convert
	 * Postcondition:The int representation of the String passed in
	 */
	private int findMonthInt(String theMonth) {
		int month = 1;
		switch (theMonth) {
        case "January":	
        		month = 1;
                 break;
        case "February":
        		month = 2;
                 break;
        case "March":  	
        		month = 3;
                 break;
        case "April":  	
        		month = 4;
                 break;
        case "May":  	
        		month = 5;
                 break;
        case "June":  	
        		month = 6;
                 break;
        case "July": 	
        		month = 7;
                 break;
        case "August":  
        		month = 8;
                 break;
        case "September":	
        		month = 9;
                 break;
        case "October":
        		 month = 10;
                 break;
        case "November":
        		 month = 11;
                 break;
        case "December":
        		 month = 12;
                 break;
		}
		return month;
	}

}
