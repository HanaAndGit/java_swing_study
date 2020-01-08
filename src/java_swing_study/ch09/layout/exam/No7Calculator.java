package java_swing_study.ch09.layout.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class No7Calculator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					No7Calculator frame = new No7Calculator();
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
	public No7Calculator() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(30, 30));
		
		No7Cal_JText panel = new No7Cal_JText();
		contentPane.add(panel, BorderLayout.NORTH);
		
		No7Cal_JButtons panel_1 = new No7Cal_JButtons();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		No7Cal_Result panel_2 = new No7Cal_Result();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
	}

}
