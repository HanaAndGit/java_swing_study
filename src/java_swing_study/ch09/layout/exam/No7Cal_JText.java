package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class No7Cal_JText extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public No7Cal_JText() {
		setBackground(new Color(192, 192, 192));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("수식입력");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}
}
