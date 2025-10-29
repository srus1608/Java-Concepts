package com.cisco;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCollections {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(8);		numbers.add(10);		numbers.add(7);
		numbers.add(5);		numbers.add(4);		numbers.add(9);
		printIntCollection(numbers);
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(8);			set.add(10);		set.add(7);
		set.add(20);			set.add(10);		set.add(7);
		printIntCollection(set);
	}
	
	public static void printIntCollection(Collection<Integer> collection) {
		System.out.println("Size = "+collection.size());
		System.out.println("Content = "+collection);
		System.out.println("____________iterating__________________");
		for(int element : collection) {
			System.out.println(element);
		}
		System.out.println("****************************");
	}
}