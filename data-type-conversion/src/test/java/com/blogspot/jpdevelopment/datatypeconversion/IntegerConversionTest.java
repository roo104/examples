package com.blogspot.jpdevelopment.datatypeconversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerConversionTest {

	@Test
	public void int_to_Integer() {
		int i = 10;
		Integer intObj = Integer.valueOf(i);

		assertEquals(new Integer(10), intObj);
	}

	@Test
	public void int_to_Long() {
		int i = 10;
		Long longObj = Long.valueOf(i);

		assertEquals(new Long(10L), longObj);
	}

	@Test
	public void int_to_long() {
		int i = 10;
		long l = i;

		assertEquals(10L, l);
	}

	@Test
	public void int_to_String() {
		int i = 10;
		String s = Integer.toString(i);

		assertEquals("10", s);
	}

	@Test
	public void Integer_to_int() {
		Integer intObj = new Integer(10);
		int i = intObj.intValue();

		assertEquals(10, i);
	}

	@Test(expected = NumberFormatException.class)
	public void Integer_to_int_null_Integer() {
		Integer intObj = new Integer(null);
		int i = intObj.intValue();
	}

	@Test
	public void Integer_to_String() {
		Integer intObj = new Integer(10);
		String s = intObj.toString();

		assertEquals("10", s);
	}

	@Test(expected = NumberFormatException.class)
	public void Integer_to_String_null_integer() {
		Integer intObj = new Integer(null);
		String s = intObj.toString();
	}

	@Test
	public void Integer_to_long() {
		Integer intObj = new Integer(10);
		long l = intObj.longValue();

		assertEquals(10L, l);
	}

	@Test(expected = NumberFormatException.class)
	public void Integer_to_long_null_integer() {
		Integer intObj = new Integer(null);
		long l = intObj.longValue();
	}

	@Test
	public void Integer_to_Long() {
		Integer intObj = new Integer(10);
		Long longObj = Long.valueOf(intObj.longValue());

		assertEquals(new Long(10L), longObj);
	}

	@Test(expected = NumberFormatException.class)
	public void Integer_to_Long_null_Integer() {
		Integer intObj = new Integer(null);
		Long longObj = Long.valueOf(intObj.longValue());
	}

}
