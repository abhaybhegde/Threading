package basics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Are "thread-safe" classes really thread-safe?
 * 
 * Java libraries provide lot of classes which are thread-safe.This is achieved by making the methods
 * available in such classes as synchronized.
 * 
 * But how thread-safe really are they?
 * 
 * Lets consider example.
 * 
 * 
 */


public class ThreadSafeClasses {

	private List names = (List) Collections.synchronizedList(new LinkedList<>());
	
	public void add(String name) {
		names.add(name);
	}
	
	public String removeFirst() {
		if ( names.size() > 0) {
			System.out.println("List size > 0");
			return (String) names.remove(0);
		} else {
			System.out.println("List size < 0");
			return null;
		}
	}
}

/* 
 * In the above class, the data i.e., names get a List whose methods are all synchronized and 'thread-safe'
 * 
 * Can the class ThreadSafeClasses be used safely from multiple threads? To find out check , ThreadSafeClassesTest.java
 */


