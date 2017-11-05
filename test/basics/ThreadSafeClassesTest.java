package basics;

public class ThreadSafeClassesTest {

	public static void main(String [] args) {
		final ThreadSafeClasses list = new ThreadSafeClasses();
		
		list.add("Thor");
		
		class NameRemover extends Thread {
			@Override
			public void run() {
				String name = list.removeFirst();
				System.out.println(Thread.currentThread().getName() + " received first name:" + name);
			}
		}
		
		Thread t1 = new NameRemover();
		t1.setName("First Thread");
		Thread t2 = new NameRemover();
		t2.setName("Second Thread");
		
		t1.start();
		t2.start();
		
	}


}

/*
 * When you run the above application , it will throw index out of bound exception.
 * Because,although the each individual methods 
 * of LinkedList() such as add(), remove() are synchronized, nothing prevents another thread from doing something else to List in between
 * add() and remove().
 * 
 * To avoid this, make the individual methods, add() and removeFirst() of ThreadSafeClasses, synchronized. 
 * 
 * Moral of the story - although we use methods of classes which are termed "thread-safe", it may not be sufficient.
 * It is desirable to have explicit synchronization in higher levels. These could be a wrapper method that internally calls the methods 
 * exposed by 'thread-safe' classes. In our example, add() and removeFirst() are such methods.
 */
