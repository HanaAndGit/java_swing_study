package java_swing_study.ch09.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AbsoluteLayoutEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AbsoluteLayoutEx() {
		setTitle("Absolute Layout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); //absolute layout = null
		
		JLabel la = new JLabel("Hello Press buttons");
		la.setHorizontalAlignment(SwingConstants.LEFT);
		la.setForeground(Color.PINK);
		la.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		la.setBounds(130, 50, 229, 24);
		contentPane.add(la);
		
		for(int i=1; i<10; i++) {
			JButton btn = new JButton(Integer.toString(i)); 
			btn.setBounds(i*15, i*15, 50, 20);
			contentPane.add(btn);
			//-> contentPane에 추가하지 않으면 버튼이 나타나지 않음
		}
		
	}
}
