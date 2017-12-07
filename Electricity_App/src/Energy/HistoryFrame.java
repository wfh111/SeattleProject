package Energy;
import java.awt.EventQueue;

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

/**
 * @author Walter Hanson
 * Class to display the User's energy history and allows them to add, delete, or edit their information.
 */
public class HistoryFrame extends JFrame implements Observer {

	private JFrame historyFrame;
	private EnergyHistory myHistory;
	private JTextArea myTextArea;
	private JButton myDelete;
	private JButton myEdit;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryFrame window = new HistoryFrame(new EnergyHistory());
					window.historyFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @author Walter Hanson
	 * Create the JFrame.
	 */
	public HistoryFrame(EnergyHistory theHistory) {
		myHistory = theHistory;
		myHistory.addObserver(this);
		myTextArea = new JTextArea();
		myDelete = new JButton("Delete...");
		myEdit = new JButton("Edit...");
		initialize();
	}

	/**
	 * @author Walter Hanson
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		historyFrame = new JFrame();
		historyFrame.setVisible(true);
		historyFrame.setTitle("Electricity History");
		historyFrame.setBounds(100, 100, 865, 487);
		historyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		historyFrame.getContentPane().setLayout(new BoxLayout(historyFrame.getContentPane(), BoxLayout.X_AXIS));
		historyFrame.setResizable(false);
		
		JPanel panel = new JPanel();
		historyFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		myEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditDialog edit = new EditDialog(myHistory);
				edit.setVisible(true);
				myHistory.addObserver(edit);
			}
		});
		myEdit.setBounds(683, 175, 97, 25);
		myEdit.setEnabled(false);
		panel.add(myEdit);
		
		myDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteDialog delete = new DeleteDialog(myHistory);
				delete.setVisible(true);
			}
		});
		myDelete.setBounds(683, 123, 97, 25);
		myDelete.setEnabled(false);
		panel.add(myDelete);
		
		JButton btnAdd = new JButton("Add...");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDialog add = new AddDialog(myHistory);
				add.setVisible(true);
				myDelete.setEnabled(true);
				myEdit.setEnabled(true);
			}
		});
		btnAdd.setBounds(683, 69, 97, 25);
		panel.add(btnAdd);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				historyFrame.setVisible(false);
			}
		});
		btnHome.setBounds(683, 224, 97, 25);
		panel.add(btnHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 60, 561, 275);
		panel.add(scrollPane);
		
		myTextArea.setEditable(false);
		scrollPane.setViewportView(myTextArea);
		displayData();
	}

	@Override
	public void update(Observable o, Object arg) {
		displayData();
	}
	
	/**
	 * @author Walter Hanson
	 * Method to display the users energy history to the screen. 
	 * Precondition: An instance of EnergyHistory has been instantiated
	 * Postcondition: User's energy history data displayed on screen in form Month,Year,kWh
	 */
	private void displayData() {
		int idx = 0;
		myTextArea.setText(null);
		ArrayList<Integer> months = myHistory.getMonths();
		ArrayList<Integer> years = myHistory.getYears();
		ArrayList<Integer> kWh = myHistory.getKwh();
		for(int el: months) {
			String text = convertMonth(months.get(idx)) + ", " + Integer.toString(years.get(idx)) + ", " + Integer.toString(kWh.get(idx)) + " kWh\n";
//			System.out.println(text);
			myTextArea.append(text);
			idx++;
		}
		if(kWh.isEmpty()) {
			myDelete.setEnabled(false);
			myEdit.setEnabled(false);
		} else {
			myDelete.setEnabled(true);
			myEdit.setEnabled(true);
		}
	}
	/**
	 * @author Walter Hanson
	 * Method to convert the int representation of a month to its String form. 
	 * Precondition: An integer with value in the range 1 through 12
	 * Postcondition:The String representation of the int passed in
	 */
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
