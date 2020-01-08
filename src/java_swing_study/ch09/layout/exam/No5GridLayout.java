package java_swing_study.ch09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;

public class No5GridLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No5GridLayout frame = new No5GridLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public No5GridLayout() {
		setTitle("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 4, 0, 0));
		
		JPanel p0 = new JPanel();
		p0.setBackground(Color.RED);
		p0.setToolTipText("");
		contentPane.add(p0);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.ORANGE);
		contentPane.add(panel_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.YELLOW);
		contentPane.add(panel_8);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.GREEN);
		contentPane.add(panel_12);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.CYAN);
		contentPane.add(panel_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		contentPane.add(panel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		contentPane.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		contentPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		contentPane.add(panel_7);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		contentPane.add(panel_11);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.ORANGE);
		contentPane.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.BLUE);
		contentPane.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_15);
	}

}
