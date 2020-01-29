package java_swing_study.ch13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	private int barSize = 0; //현재 그려져야 할 바의 크기
	private int maxBarSize; // 바의 최대 크기
	//private ConsumerThread cth = new ConsumerThread();
	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double)(this.getWidth()))/maxBarSize*barSize); 
		if(width==0) { //크기가 0 이면 바를 안 그림
			return; 
		}
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {
			try {
				wait(); //바가 최대이면, 바가 줄어들 때까지 대기
			}catch (InterruptedException e) {
				return;
			}
		}
		
		//System.out.println(cth.getState());
		barSize++;
		repaint(); //바의 크기가 늘어났기 때문에 다시 그리기
		notify(); // 다시 그렸기 때문에 기다리는 스레드 깨우기
		
	}
	
	synchronized public void consume() {
		if(barSize==0) {
			try {
				wait(); //바의 크기가 0이면 바 크기가 0보다 커질 때까지 대기
			}catch(InterruptedException e){
				return;
			}
		}
		//System.out.println(cth.getState());
		barSize--;
		repaint();
		notify();
		
	}
	
	
}


