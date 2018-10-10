package com.mowitnow.lawnmower.domain;

import org.junit.Assert;
import org.junit.Test;

public class TestOrientation {

	@Test
	public void testLeft() {
		Assert.assertEquals(Orientation.W, Orientation.N.left());
		Assert.assertEquals(Orientation.S, Orientation.W.left());
		Assert.assertEquals(Orientation.N, Orientation.E.left());
	}

	@Test
	public void testRight() {
		Assert.assertEquals(Orientation.N, Orientation.W.right());
		Assert.assertEquals(Orientation.E, Orientation.N.right());
		Assert.assertEquals(Orientation.S, Orientation.E.right());
	}
}
