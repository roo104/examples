package com.blogspot.jpdevelopment.datatypeconversion;

import org.junit.Test;

public class AutoBoxingTest {

	@Test(expected = NullPointerException.class)
	public void primitive_operation() {
		Integer intObj = null; // Assuming we did not know intObj is null and forgot to check
		intObj++; // Using a primitive operator normally doesn't throw a NullPointerException
	}

	@Test(expected = NullPointerException.class)
	public void constructor_exception() {
		Integer intObj = null; // Assuming we did not know intObj is null and forgot to check
		new MyInt(intObj); // The NullPointerException in this line is very hard to see
	}

	@Test(expected = NullPointerException.class)
	public void Integer_Autoboxing_Failure() {
		MyInt myInt = new MyInt(10);
		myInt.getIntegerValue(); // Stack trace will point inside the getIntegerValue() method, but no null check from this point is possible
	}

	private class MyInt {

		private int intValue = 0;
		private Integer integer = null;

		public MyInt(int intValue) {
			this.intValue = intValue;
		}

		public int getIntegerValue() {
			return this.integer;
		}
	}
}
