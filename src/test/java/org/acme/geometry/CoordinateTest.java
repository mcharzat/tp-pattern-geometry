package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
		Assert.assertTrue(c.isEmpty());
	}

	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(3.14, 2.72);
		Assert.assertEquals(3.14, c.getX(), EPSILON);
		Assert.assertEquals(2.72, c.getY(), EPSILON);
		Assert.assertFalse(c.isEmpty());
	}
}
