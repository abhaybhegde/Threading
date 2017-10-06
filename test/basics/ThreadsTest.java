package basics;

import org.junit.Test;

import basics.Threads;

public class ThreadsTest {
	
	@Test
	public void run() {
		Threads t = new Threads();
		t.start();
	}

}