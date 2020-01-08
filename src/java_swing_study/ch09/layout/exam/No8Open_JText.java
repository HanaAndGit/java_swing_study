package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class No8Open_JText extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public No8Open_JText() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Word Input");
		add(btnNewButton);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

}
