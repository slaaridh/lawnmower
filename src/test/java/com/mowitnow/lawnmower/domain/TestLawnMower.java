package com.mowitnow.lawnmower.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLawnMower {

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInvalidCreation() {
		new LawnMower(5, 6, 'N', 4, 4);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testNotValidCommand() {
		new LawnMower(5, 6, 'N', 4, 4).execute("GAHG");
	}

	/**
	 * 55
	 * 12 N
	 * GAGAGAGAA
	 * 33 E
	 * AADAADADDA
	 * <p>
	 * results
	 * <p>
	 * 13 N
	 * 51 E
	 */

	@Test
	public void test1() {
		LawnMower lawnMower = new LawnMower(1, 2, 'N', 5, 5);
		assertEquals("1 3 N", lawnMower.execute("GAGAGAGAA"));
	}

	/**
	 * 33 E
	 * AADAADADDA
	 * results
	 * <p>
	 * 51 E
	 */
	@Test
	public void test2() {
		LawnMower lawnMower = new LawnMower(3, 3, 'E', 5, 5);
		assertEquals("5 1 E", lawnMower.execute("AADAADADDA"));
	}

	@Test
	public void testEmptyCommands() {
		LawnMower lawnMower = new LawnMower(3, 3, 'N', 5, 5);
		Assert.assertEquals("3 3 N", lawnMower.execute(""));
	}

}
