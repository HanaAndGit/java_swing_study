package java_swing_study.ch13;

public class SharedBoard {
	private int sum = 0;
	synchronized public void add() {
		int n = sum;
		
		Thread.yield();
		
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + " : " + sum);
		
		
	}
}
