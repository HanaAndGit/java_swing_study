package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.SystemColor;

public class No7Cal_JButtons extends JPanel {

	/**
	 * Create the panel.
	 */
	public No7Cal_JButtons() {
		setLayout(new GridLayout(4, 4, 5, 5));
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("2");
		btnNewButton_8.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_8);
		
		JButton btnNewButton_12 = new JButton("3");
		btnNewButton_12.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_12);
		
		JButton btnNewButton_9 = new JButton("4");
		btnNewButton_9.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_9);
		
		JButton btnNewButton_7 = new JButton("5");
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("7");
		btnNewButton_5.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CE");
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		add(btnNewButton_3);
		
		JButton btnNewButton_10 = new JButton("계산");
		btnNewButton_10.setBackground(SystemColor.activeCaption);
		add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("+");
		btnNewButton_11.setBackground(SystemColor.activeCaption);
		add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("-");
		btnNewButton_13.setBackground(SystemColor.activeCaption);
		add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("x");
		btnNewButton_14.setBackground(SystemColor.activeCaption);
		add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("/");
		btnNewButton_15.setBackground(SystemColor.activeCaption);
		add(btnNewButton_15);

	}

}
