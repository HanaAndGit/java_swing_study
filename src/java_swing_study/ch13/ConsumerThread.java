package java_swing_study.ch13;

public class ConsumerThread extends Thread {
	private MyLabel bar;

	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}

	public ConsumerThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume(); //0.2초마다 바를 1씩 줄임
			}catch(InterruptedException e) {
				return;
			}
		}
	}
	
	
}
