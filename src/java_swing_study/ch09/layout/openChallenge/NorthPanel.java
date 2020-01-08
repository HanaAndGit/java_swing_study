package java_swing_study.ch09.layout.openChallenge;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NorthPanel extends JPanel {
	private JButton Read;
	private JButton Open;
	private JButton Close;

	/**
	 * Create the panel.
	 */
	public NorthPanel() {

		initialize();
	}
	private void initialize() {
		setBackground(Color.GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Open = new JButton("Open");
		add(Open);
		
		Read = new JButton("Read");
		add(Read);
		
		Close = new JButton("Close");
		add(Close);
	}

}
