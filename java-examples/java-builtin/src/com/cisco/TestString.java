package com.cisco;

public class TestString {
	public static void main(String[] args) {
		
		StringBuffer buf1 = new StringBuffer("hello");
		StringBuffer buf2 = new StringBuffer("hello");
		System.out.println("buf1 = "+buf1+", buf2 = "+buf2);
		System.out.println("compare = "+buf1.equals(buf2)); // equals method in string buffer compares the address
		buf1.append(" world");
		System.out.println("buf1 = "+buf1);
		
		
		String text = "hello world";
		String text2 = text.toUpperCase();
		System.out.println("text: "+text);
		System.out.println("text2: "+text2);
		
		String s1 = "hello"; // constant pool
		String s2 = "hello"; // constant pool
		String s3 = "he".concat("llo"); // non-constant pool
		String s4 = "he".concat("llo"); // non-constant pool
		System.out.println("s1 = "+ s1 +",s2= " +s2 + ",s3= " +s3+",s4= "+s4);
		System.out.println(s1 == s2); // s1 and s2 points to the same content
		System.out.println(s1 == s3); // s3 & s4 points to two different address
		System.out.println(s3 == s4); // it compares memory address
		System.out.println(s1.equals(s3)); // it compares content
	}
}