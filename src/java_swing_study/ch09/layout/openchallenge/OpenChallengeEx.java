package java_swing_study.ch09.layout.openchallenge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OpenChallengeEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenChallengeEx frame = new OpenChallengeEx();
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
	public OpenChallengeEx() {
		setTitle("간단한 스윙 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		NorthPanel pNorth = new NorthPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		CenterPanel pCenter = new CenterPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
	}

}
