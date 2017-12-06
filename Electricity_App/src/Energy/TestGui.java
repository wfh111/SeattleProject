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

	private JFrame frame;
	private boolean aTrigger = true;
	private boolean holdFrame = false;
	private HistoryFrame myHistory;


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
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestGui() {
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
				if(holdFrame == false) {
					myHistory = new HistoryFrame();
					holdFrame = true;
				} else {
					myHistory.setVisible(true);
				}
				HistoryFrame frame1 = new HistoryFrame();
				frame1.setVisible(true);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Estimator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				ComparingFrame frame2 = new ComparingFrame();
				frame2.setVisible(true);
				frame.setVisible(false);
				
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