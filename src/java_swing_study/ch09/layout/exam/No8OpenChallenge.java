package java_swing_study.ch09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class No8OpenChallenge extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No8OpenChallenge frame = new No8OpenChallenge();
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
	public No8OpenChallenge() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		No8Open_JButtons panel = new No8Open_JButtons();
		contentPane.add(panel, BorderLayout.NORTH);
		
		No8Open_JLabel panel_1 = new No8Open_JLabel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		No8Open_JText panel_2 = new No8Open_JText();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

}
