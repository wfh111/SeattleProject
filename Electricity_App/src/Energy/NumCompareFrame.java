package Energy;

import java.awt.BorderLayout;
import java.awt.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;

public class NumCompareFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumCompareFrame frame2 = new NumCompareFrame();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumCompareFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblCurrentUse = new JLabel("Current energy cost per year:");
		lblCurrentUse.setBounds(127,26,246,14);
		contentPane.add(lblCurrentUse);
		
		JLabel lblSelectTheMaterials = new JLabel("Number of Materials to Compare:");
		lblSelectTheMaterials.setBounds(127, 54, 246, 14);
		contentPane.add(lblSelectTheMaterials);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setSelected(true);
		radioButton.setBounds(127, 80, 109, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(127, 100, 109, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setBounds(127, 120, 109, 23);
		contentPane.add(radioButton_2);
		
		//so can only choose one radio button at a time
		ButtonGroup num = new ButtonGroup();
		num.add(radioButton);
		num.add(radioButton_1);
		num.add(radioButton_2);
		
		/*JSpinner spinner = new JSpinner();
		spinner.setBounds(130, 170, 29, 20);
		contentPane.add(spinner);*/

	}
}
