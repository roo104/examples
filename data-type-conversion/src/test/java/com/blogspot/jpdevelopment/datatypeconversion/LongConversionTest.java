package com.blogspot.jpdevelopment.datatypeconversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongConversionTest {

	@Test
	public void long_to_Long() {
		long l = 10L;
		Long longObj = Long.valueOf(l);

		assertEquals(new Long(10L), longObj);
	}

	@Test
	public void long_to_Integer() {
		long l = 10L;
		Integer intObj = Integer.valueOf(Long.valueOf(l).intValue());

		assertEquals(new Integer(10), intObj);
	}

	@Test
	public void long_to_String() {
		long l = 10L;
		String s = Long.toString(l);

		assertEquals("10", s);
	}

	@Test
	public void long_to_int() {
		long l = 10L;
		int i = (int) l;

		assertEquals(10, i);
	}

	@Test
	public void Long_to_long() {
		Long longObj = new Long(10L);
		long l = longObj.longValue();

		assertEquals(10L, l);
	}

	@Test(expected = NumberFormatException.class)
	public void Long_to_long_null_Long() {
		Long longObj = new Long(null);
		long l = longObj.longValue();
	}

	@Test
	public void Long_to_String() {
		Long longObj = new Long(10L);
		String s = longObj.toString();

		assertEquals("10", s);
	}

	@Test(expected = NumberFormatException.class)
	public void Long_to_String_null_Long() {
		Long longObj = new Long(null);
		String s = longObj.toString();
	}

	@Test
	public void Long_to_Integer() {
		Long longObj = new Long(10L);
		Integer intObj = Integer.valueOf(longObj.intValue());

		assertEquals(new Integer(10), intObj);
	}

	@Test(expected = NumberFormatException.class)
	public void Long_to_Integer_null_Long() {
		Long longObj = new Long(null);
		Integer intObj = Integer.valueOf(longObj.intValue());
	}

	@Test
	public void Long_to_int() {
		Long longObj = new Long(10L);
		int i = longObj.intValue();

		assertEquals(10, i);
	}

	@Test(expected = NumberFormatException.class)
	public void Long_to_int_null_Long() {
		Long longObj = new Long(null);
		int i = longObj.intValue();
	}
}
