package basics;

import org.apache.log4j.Logger;

/*
 * A simple example demonstrating Synchronization issues in threading and how to handle it in Java.
 * 
 * Context- There is a shared bank account used by husband and wife to make withdrawals.
 * 1. Before making any withdrawal,we let the husband and wife check if the Account has sufficient money.
 * 2. If it does have sufficient money, we let them make the withdraw money. 
 * 
 * We will have two threads - one for husband and one for wife. We will use these threads to actually implement 
 * the withdrawal and check balance mechanism.
 * 
 * 
 * Problem- Problem arises when more than one thread tries to access a shared resource. In our case , it would 
 * be account balance.
 * 
 * SynchronizationExample.java - The class that holds the  Account information 
 */

public class SynchronizationExample {
	
	final static Logger logger = Logger.getLogger(SynchronizationExample.class);
	
	//Lets just start with balance as 100
	private int balance = 100;

	public boolean hasSufficientBalance() {
		//Lets maintain 10 as the minimum balance
		return (balance > 10) ? true : false;
	}

	public int withdraw(int theAmount) {
		return balance =( balance - theAmount );
	}
	
	public int getBalance() {
		return balance;
	}

}
