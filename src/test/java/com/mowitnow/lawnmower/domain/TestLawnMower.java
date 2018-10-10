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
		// Execute work
		lawnMower.execute("GAGAGAGAA");

		Position newPosition = lawnMower.getPosition();
		assertEquals(newPosition.getX(), 1);
		assertEquals(newPosition.getY(), 3);
		assertEquals(lawnMower.getPosition().getOrientation(), Orientation.N);
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
		// Execute work
		lawnMower.execute("AADAADADDA");
		Position newPosition = lawnMower.getPosition();
		assertEquals(5, newPosition.getX());
		assertEquals(1, newPosition.getY());
		assertEquals(lawnMower.getPosition().getOrientation(), Orientation.E);
	}

	@Test
	public void testEmptyCommands() {
		LawnMower lawnMower = new LawnMower(3, 3, 'N', 5, 5);
		// Execute work
		Assert.assertEquals("3 3 N", lawnMower.execute(""));
	}

}
