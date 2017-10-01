package basics;

public class Threads extends Thread {
	
	@Override
	public	void run() {
		System.out.println(Thread.currentThread().getId());
		
	}

}
