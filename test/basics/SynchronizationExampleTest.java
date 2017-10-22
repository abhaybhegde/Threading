package basics;

import org.apache.log4j.Logger;

public class SynchronizationExampleTest implements Runnable  {
	
	final static Logger logger = Logger.getLogger(SynchronizationExampleTest.class);
	
	public SynchronizationExample account = new SynchronizationExample();

	@Override
	public void run() {
		for(int i=0; i < 5; ++i) {
			makeWithdrawal(20);
			
		}
		
	}
	
	private void makeWithdrawal(int amountToWithdraw) {
		
		if ( account.getBalance() >= amountToWithdraw ) {
			System.out.println("Thread " + Thread.currentThread().getName() + " is about to withdraw.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				logger.error("Thread " + Thread.currentThread().getName() + " interrupted");
			}
			account.withdraw(amountToWithdraw);
			System.out.println("Thread " + Thread.currentThread().getName() + " completes the withdrawal.");
			System.out.println("Remaining balance:" + account.getBalance());
		} else {
			System.out.println("Not enough balance in the account for  " + Thread.currentThread().getName() + " to withdraw");
		}
		
		
		
		
	}


	public static void main(String [] args) {
		
		SynchronizationExampleTest job = new SynchronizationExampleTest();
		
		Thread husband = new Thread(job);
		Thread wife = new Thread(job);
		husband.setName("Husband");
		wife.setName("Wife");
		husband.start();
		wife.start();
		
	}


}
