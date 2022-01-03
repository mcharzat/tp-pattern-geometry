package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Point p = new Point();
        Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
		Assert.assertTrue(p.isEmpty());
    }

    @Test
    public void testConstructor() {
        Point p = SampleFactory.createPointA();
        
        Assert.assertEquals(3.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(2.72, p.getCoordinate().getY(), EPSILON);
		Assert.assertFalse(p.isEmpty());
    }

    @Test
    public void testTranslate() {
        Point p = SampleFactory.createPointA();

        p.translate(10, 10);
        Assert.assertEquals(13.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(12.72, p.getCoordinate().getY(), EPSILON);
		Assert.assertFalse(p.isEmpty());
    }
}
