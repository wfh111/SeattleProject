package Energy;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;

public class DeleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EnergyHistory hist = new EnergyHistory();
			hist.add("April", 2001, 123);
			hist.add("June", 2004, 322);
			hist.add("December", 2001, 232);
			DeleteDialog dialog = new DeleteDialog(hist);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteDialog(EnergyHistory theHist) {
		initialize(theHist);
	}
	
	private void initialize(EnergyHistory theHist) {
		setTitle("Delete from History");
		setBounds(100, 100, 641, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDirection = new JLabel("Choose the month to delete:");
		lblDirection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDirection.setBounds(22, 24, 239, 29);
		contentPanel.add(lblDirection);
		
		Choice dataChoice = new Choice();
		addData(theHist, dataChoice);
		dataChoice.setBounds(267, 31, 222, 22);
		contentPanel.add(dataChoice);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton delButton = new JButton("DELETE");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = dataChoice.getSelectedIndex();
				theHist.delete(idx);
				setVisible(false);
			}
		});
		delButton.setActionCommand("OK");
		buttonPane.add(delButton);
		getRootPane().setDefaultButton(delButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	private void addData(EnergyHistory theEnergy, Choice theData) {
		int i = 0;
		ArrayList<Integer> month = theEnergy.getMonths();
		ArrayList<Integer> year = theEnergy.getYears();
		ArrayList<Double> kWh = theEnergy.getKwh();
		for(; i < month.size(); i++) {
			String strMonth = convertMonth(month.get(i));
			theData.add(strMonth + ", " + Integer.toString(year.get(i)) + ", " + Double.toString(kWh.get(i)) + " kWh");
		}
//		return theData;
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
}
