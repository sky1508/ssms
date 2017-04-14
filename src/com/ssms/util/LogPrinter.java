package com.ssms.util;

public class LogPrinter {
	public static void printClassAndMethod(){
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		System.out.println(elements[2]);
	}
}
