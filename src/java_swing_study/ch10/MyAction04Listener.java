package java_swing_study.ch10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyAction04Listener implements ActionListener {
	private JPanel contentPane;
	
	public MyAction04Listener(JPanel contentPane) {
		this.contentPane = contentPane;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (contentPane.getBackground()==Color.YELLOW) {
			contentPane.setBackground(Color.RED);
		}else {
			contentPane.setBackground(Color.YELLOW);
		}
	}

}
