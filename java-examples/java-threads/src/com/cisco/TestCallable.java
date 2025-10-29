package com.cisco;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class A implements Callable<String> {
	
	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		System.out.println("Thread name : "+name);
		return "Hello World";
	}
}

public class TestCallable {
	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		A a1 = new A();
		executor.submit(a1);
		executor.submit(a1);
		Future<String> future = executor.submit(a1);
		System.out.println("Future value = "+future.get());
		Thread.sleep(3000);
		future = executor.submit(a1);
		System.out.println("Future value = "+future.get());
	}
}