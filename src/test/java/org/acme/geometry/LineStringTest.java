package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

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
        List<Point> points = new ArrayList<Point>();
        Coordinate c = new Coordinate(3.14, 2.72);
        Point p = new Point(c);
        points.add(p);

        LineString l = new LineString(points);
        Assert.assertEquals(1, l.getNumPoints());
        Assert.assertEquals(p, l.getPointN(0));
		Assert.assertFalse(l.isEmpty());
    }
}
