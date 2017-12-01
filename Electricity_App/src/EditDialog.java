import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import java.awt.Choice;

public class EditDialog extends JDialog implements Observer{

	private final JPanel contentPanel = new JPanel();
	private int myMonth;
	private int myYear;
	private double mykWh;
	private Choice myData;
	private EnergyHistory myEnergy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EnergyHistory hist = new EnergyHistory();
			hist.add("April", 2001, 123);
			hist.add("June", 2004, 322);
			hist.add("December", 2001, 232);
			EditDialog dialog = new EditDialog(hist);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditDialog(EnergyHistory theEnergy) {
		myData = new Choice();
		myEnergy = theEnergy;
		initialize();
	}
	private void initialize() {
		setTitle("Edit History");
		setBounds(100, 100, 591, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDescription = new JLabel("Choose Month to Edit:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescription.setBounds(12, 24, 193, 37);
		contentPanel.add(lblDescription);
		
		myData.setBounds(211, 35, 247, 65);
		addData();
		contentPanel.add(myData);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton changeButton = new JButton("CHANGE...");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = myData.getSelectedIndex();
				myMonth = myEnergy.getMonths().get(idx);
				myYear = myEnergy.getYears().get(idx);
				mykWh = myEnergy.getKwh().get(idx);
				myEnergy.delete(idx);
				AddDialog add = new AddDialog(myMonth, myYear, mykWh, myEnergy);
				add.setVisible(true);
			}
		});
		changeButton.setActionCommand("OK");
		buttonPane.add(changeButton);
		getRootPane().setDefaultButton(changeButton);
		
		JButton cancelButton = new JButton("BACK");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}

	private void addData() {
		int i = 0;
		myData.removeAll();
		ArrayList<Integer> month = myEnergy.getMonths();
		ArrayList<Integer> year = myEnergy.getYears();
		ArrayList<Double> kWh = myEnergy.getKwh();
		for(; i < month.size(); i++) {
			String strMonth = convertMonth(month.get(i));
			myData.add(strMonth + ", " + Integer.toString(year.get(i)) + ", " + Double.toString(kWh.get(i)) + " kWh");
		}
	}

	private String convertMonth(int theMonth) {
		String month = "";
		switch (theMonth) {
        case 1:	
        		month = "January";
                 break;
        case 2:
        		month = "February";
                 break;
        case 3:  	
        		month = "March";
                 break;
        case 4:  	
        		month = "April";
                 break;
        case 5:  	
        		month = "May";
                 break;
        case 6:  	
        		month = "June";
                 break;
        case 7: 	
        		month = "July";
                 break;
        case 8:  
        		month = "August";
                 break;
        case 9:	
        		month = "September";
                 break;
        case 10:
        		 month = "October";
                 break;
        case 11:
        		 month = "November";
                 break;
        case 12:
        		 month = "December";
                 break;
		}
		return month;
	}

	@Override
	public void update(Observable o, Object arg) {
		addData();
	}
}
