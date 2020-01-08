package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;

public class No8Open_JLabel extends JPanel {

	/**
	 * Create the panel.
	 */
	public No8Open_JLabel() {
		setBackground(SystemColor.window);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(99, 185, 57, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(276, 226, 57, 15);
		add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(212, 36, 57, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setBounds(99, 50, 57, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setBounds(12, 23, 57, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setBounds(253, 139, 57, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setBounds(164, 92, 57, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(327, 106, 57, 15);
		add(label_6);

	}

}
