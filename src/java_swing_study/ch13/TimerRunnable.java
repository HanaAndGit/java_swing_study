package java_swing_study.ch13;

import java.awt.Color;

import javax.swing.JLabel;

public class TimerRunnable implements Runnable {
	
	private JLabel leftLable;
	
	
	public TimerRunnable(JLabel leftLable) {
		this.leftLable = leftLable;
	}


	@Override
	public void run() {
		int n = 100;
		while(true) {
			leftLable.setText(Integer.toString(n));
			leftLable.setBackground(Color.RED);
			n--;
			//leftLable.setBackground(Color.gray);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				leftLable.setText("Stop");
				return;
			}
			leftLable.setBackground(Color.WHITE);
		}
	}

}
