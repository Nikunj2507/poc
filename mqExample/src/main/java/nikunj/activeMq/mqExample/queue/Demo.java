package nikunj.activeMq.mqExample.queue;

public class Demo {
	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
	}
}
