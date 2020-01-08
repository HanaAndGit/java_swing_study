package java_swing_study.ch09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class No2BorderLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No2BorderLayout frame = new No2BorderLayout();
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
	public No2BorderLayout() {
		setTitle("BorderLayout Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 7));
		setContentPane(contentPane);
		
		JButton btnNorth = new JButton("North");
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnWest = new JButton("West");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		JButton btnSouth = new JButton("South");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
		
		JButton btnCenter = new JButton("Center");
		contentPane.add(btnCenter, BorderLayout.CENTER);
		
		JButton btnEast = new JButton("East");
		contentPane.add(btnEast, BorderLayout.EAST);
	}

}
