package com.cisco;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TestMap {
	public static void main(String[] args) {
		Map<Integer, Employee> map = ne HashMap<Integer, Employee>();
		Employee emp1 = new Employee(100, "Raj", LocalDate.parse("2000-10-10"), 45000);
		Employee emp2 = new Employee(102, "Vijay", LocalDate.parse("2001-10-10"), 55000);
		Employee emp3 = new Employee(103, "Manoj", LocalDate.parse("2002-10-10"), 65000);
		
		map.put(emp1.getId(), emp1);
		map.put(emp1.getId(), emp2);
		map.put(emp1.getId(), emp3);
		
		System.out.println(map);
		Set<Integer> keys = map.keySet();
		for(int key:keys) {
			Employee emp = map.get(key);
			System.out.println(emp);
		}
	}
	
	

}
