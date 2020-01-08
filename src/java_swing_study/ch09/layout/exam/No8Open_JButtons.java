package java_swing_study.ch09.layout.exam;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class No8Open_JButtons extends JPanel {

	/**
	 * Create the panel.
	 */
	public No8Open_JButtons() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		setBackground(SystemColor.activeCaptionBorder);
		
		JButton btnNewButton = new JButton("열기");
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("닫기");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("나가기");
		add(btnNewButton_2);

	}

}
