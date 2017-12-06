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

public class AnotherGui {

	private JFrame frame;
	private boolean mySync = true;

	/**
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
	 */
	public AnotherGui() {
		initialize();
	}

	/**
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Buttons");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Testing", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmNewMenuItem);
		
		JMenuItem mntmCreators = new JMenuItem("Info");
		mnHelp.add(mntmCreators);
		frame.getContentPane().setLayout(null);
		
		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistory.setBounds(0, 94, 428, 59);
		frame.getContentPane().add(btnHistory);
		
		JButton btnEstimator = new JButton("Estimator");
		btnEstimator.setBounds(0, 40, 428, 54);
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
					JOptionPane.showMessageDialog(null, "Data has been synced to the cloud.");
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
