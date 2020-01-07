package java_swing_study.ch09;

import java.awt.EventQueue;

public class SwingMain {

	/*
	 * public static void main(String[] args) { MyFrame mf = new MyFrame();
	 * 
	 * }
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContentPaneExs frame = new ContentPaneExs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
