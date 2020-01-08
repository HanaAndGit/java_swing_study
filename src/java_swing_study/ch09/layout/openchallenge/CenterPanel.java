package java_swing_study.ch09.layout.openchallenge;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterPanel() {
		setLayout(null);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setBounds(103, 45, 57, 15);
		add(lblHello);
		
		JLabel lblJava = new JLabel("Java");
		lblJava.setBounds(54, 211, 57, 15);
		add(lblJava);
		
		JLabel lblLove = new JLabel("Love");
		lblLove.setBounds(327, 211, 57, 15);
		add(lblLove);

	}

}
