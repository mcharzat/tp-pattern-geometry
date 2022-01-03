package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
    
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        LineString l = new LineString();
        Assert.assertEquals(0, l.getNumPoints());
		Assert.assertTrue(l.isEmpty());
    }

    @Test
    public void testConstructor() {
        LineString l = SampleFactory.createLineStringAB();

        Assert.assertEquals(2, l.getNumPoints());
        Assert.assertEquals(3.14, l.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(2.72, l.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(31.4, l.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(27.2, l.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(l.isEmpty());
    }

    @Test
    public void testTranslate() {
        LineString l = SampleFactory.createLineStringAB();

        l.translate(10, 10);
        Assert.assertEquals(13.14, l.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(12.72, l.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(41.4, l.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(37.2, l.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(l.isEmpty());
    }
}
