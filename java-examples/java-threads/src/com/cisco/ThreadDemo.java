package com.cisco;

class R implements Runnable { 
	public synchronized void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		for(int i = 1; i < 500; i++) {
			System.out.println("i inside run() = "+i+" executed by "+name);
		}
	}
}
public class ThreadDemo {
	// main method is called by main thread
	public static void main(String[] args) {
		R runnable = new R();
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		thread1.setName("A");
		thread2.setName("B");
		thread3.setName("C");
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("main ends");
	}
}