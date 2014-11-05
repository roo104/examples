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
		//		Integer intObj = Long.valueOf(l);
	}
}
