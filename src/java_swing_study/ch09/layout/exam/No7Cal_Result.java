package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class No7Cal_Result extends JPanel {

	/**
	 * Create the panel.
	 */
	public No7Cal_Result() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("계산결과");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(SystemColor.window);
		add(lblNewLabel_1);

	}

}
