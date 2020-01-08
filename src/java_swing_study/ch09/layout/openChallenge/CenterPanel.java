package java_swing_study.ch09.layout.openChallenge;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel {
	private JLabel blbHello;
	private JLabel lblJava;
	private JLabel lblLove;

	/**
	 * Create the panel.
	 */
	public CenterPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		blbHello = new JLabel("Hello");
		blbHello.setBounds(139, 33, 57, 15);
		add(blbHello);
		
		lblJava = new JLabel("java");
		lblJava.setBounds(41, 198, 57, 15);
		add(lblJava);
		
		lblLove = new JLabel("Love");
		lblLove.setBounds(329, 130, 57, 15);
		add(lblLove);
	}
}
