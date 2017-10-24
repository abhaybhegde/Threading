package basics;

public class SynchronizationExercise extends Thread {
	
	private StringBuffer testString = null;
	
	public SynchronizationExercise(StringBuffer theString) {
		testString = theString;
	}
	
	@Override
	public void run() {
		synchronized (testString) {
			for (int i = 0; i < 100; ++i) {
				System.out.println(testString);
			}
			char ch = testString.charAt(0);
			++ch;
			testString.setCharAt(0, ch);
		}
	}
			

	public static void main(String[] args) {
		StringBuffer initial = new StringBuffer("A");
		Thread one = new SynchronizationExercise(initial);
		Thread two = new SynchronizationExercise(initial);
		Thread three = new SynchronizationExercise(initial);
		one.start();
		two.start();
		three.start();
		
	}

}
