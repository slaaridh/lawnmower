package com.mowitnow.lawnmower.domain;

import org.junit.Assert;
import org.junit.Test;

public class TestPosition {

	@Test
	public void testCreatePosition() {
		Position position = Position.create(1, 2, 'N');
		Assert.assertEquals("1 2 N", position.getPositionAsString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPosition() {
		Position.create(1, 2, 'U');
	}

}
