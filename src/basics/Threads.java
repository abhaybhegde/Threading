package basics;

public class Threads extends Thread {
	
	@Override
	public	void run() {
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		
	}
	
	public static void main(String [] args) {
		
		Threads threadObj = new Threads();
		Thread one = new Thread(threadObj);
		one.setName("First Thread");
		one.start();
	
	}

}
