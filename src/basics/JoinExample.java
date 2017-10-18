package basics;

public class JoinExample extends Thread {
	
	@Override
	public void run() {
		try {
			for(int i=0; i < 100;++i) {
				System.out.println("Current thread running:" + Thread.currentThread().getName());
			}
			
		}catch ( Exception ex) {
			ex.printStackTrace();
		}
		
	}


	public static void main(String [] args) {
		JoinExample one = new JoinExample();
		JoinExample two = new JoinExample();
		JoinExample three = new JoinExample();
		one.setName("First Thread");
		two.setName("Second thread");
		three.setName("Third thread");
		System.out.println("Current Thread:" + Thread.currentThread().getName());
		
		one.start();
		System.out.println("Current Thread:" + Thread.currentThread().getName());
		try {
			one.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		two.start();
		System.out.println("Current Thread:" + Thread.currentThread().getName());
		try {
			two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		three.start();
		System.out.println("Current Thread:" + Thread.currentThread().getName());
	}




}


