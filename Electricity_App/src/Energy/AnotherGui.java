package Energy;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * @Author Brian Khang
 * The main GUI. This class will create a frame where the user can choose to create an estimate, look at their history
 * or sync their data to a cloud service. Application can be used offline.
 */
public class AnotherGui extends JFrame {

	private JFrame frame;
	private boolean mySync = true;
	private EnergyHistory myHistory;
	private String myUser;

	/**
	 * @author Brian Khang
	 * Main method of the class.
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnotherGui window = new AnotherGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @author Brian Khang
	 * Constructor for the class
	 */
	public AnotherGui() {
		myHistory = new EnergyHistory();
		myUser = System.getProperty("user.name");
		initialize();
	}

	/**
	 * @author Brian Khang
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sync");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmTurnSync = new JMenuItem("Turn Sync...");

		mnNewMenu.add(mntmTurnSync);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Buttons...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Estimator: Create an estimate for the cost of using different lightbulbs.\n"
						+ "Energy History: Add, delete, edit history bills.\nSync: Sync information to the cloud.\n"
						+ "Turn Sync...: Turn cloud sync on and off.", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmNewMenuItem);
		
		JMenuItem mntmCreators = new JMenuItem("About...");
		mntmCreators.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application to help DIYers with manging home energy.", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmCreators);
		frame.getContentPane().setLayout(null);
		
		JButton btnHistory = new JButton("Energy History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryFrame frame1 = new HistoryFrame(myHistory);
			}
		});
		btnHistory.setBounds(0, 43, 428, 59);
		frame.getContentPane().add(btnHistory);
		
		JButton btnEstimator = new JButton("Estimator");
		btnEstimator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComparingFrame frame2 = new ComparingFrame(myHistory);
			}
		});
		btnEstimator.setBounds(0, 100, 428, 54);
		frame.getContentPane().add(btnEstimator);
		
		JLabel lblCloudSyncIs = new JLabel("Cloud Sync is Currently: ON");
		lblCloudSyncIs.setBounds(0, 0, 428, 42);
		lblCloudSyncIs.setBackground(Color.WHITE);
		lblCloudSyncIs.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblCloudSyncIs);
		
		JButton btnSync = new JButton("Sync");
		btnSync.setBounds(0, 154, 428, 59);
		btnSync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mySync == true) {
					JOptionPane.showMessageDialog(null, "We apologize. Our cloud system is currently under repair.");
				} else {
					JOptionPane.showMessageDialog(null, "Please make sure Cloud Sync is turned on.");
				}
			}
		});
		frame.getContentPane().add(btnSync);
		
		mntmTurnSync.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mySync == true) {
					lblCloudSyncIs.setText("Cloud Sync is Currently: OFF");
					mySync = false;
				} else {
					lblCloudSyncIs.setText("Cloud Sync is Currently: ON");
					mySync = true;
				}
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
