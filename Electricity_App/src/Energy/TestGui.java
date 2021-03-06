package Energy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestGui extends JFrame{
	//comment
	private JFrame frame;
	private boolean aTrigger = true;
	private EnergyHistory myHistory;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGui window = new TestGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} //comment
		});
	}

	/**
	 * Create the application.
	 */
	public TestGui() {
		myHistory = new EnergyHistory();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		

		JLabel lblCloudStatusOn = new JLabel("Cloud Status: ON");
		frame.getContentPane().add(lblCloudStatusOn);
		
		JButton btnNewButton = new JButton("History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryFrame frame1 = new HistoryFrame(myHistory);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Estimator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				ComparingFrame frame2 = new ComparingFrame(myHistory);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cloud Sync");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(aTrigger == true) {
					lblCloudStatusOn.setText("Cloud Status: OFF");
					aTrigger = false;
				}
				else {
					lblCloudStatusOn.setText("Cloud Status: ON");
					aTrigger = true;
				}
			}
		});
		menuBar.add(rdbtnNewRadioButton);
	}

}