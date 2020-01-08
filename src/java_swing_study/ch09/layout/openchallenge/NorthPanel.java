package java_swing_study.ch09.layout.openchallenge;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class NorthPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		
		JButton btnOpen = new JButton("Open");
		add(btnOpen);
		
		JButton btnRead = new JButton("Read");
		add(btnRead);
		
		JButton btnClose = new JButton("Close");
		add(btnClose);

	}

}
