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

    @Test
    public void testTranslate() {
        List<Point> points = new ArrayList<Point>();
        Coordinate c1 = new Coordinate(3.14, 2.72);
        Point p1 = new Point(c1);
        points.add(p1);
        Coordinate c2 = new Coordinate(31.4, 27.2);
        Point p2 = new Point(c2);
        points.add(p2);

        LineString l = new LineString(points);
        l.translate(10, 10);
        Assert.assertEquals(13.14, l.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(12.72, l.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(41.4, l.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(37.2, l.getPointN(1).getCoordinate().getY(), EPSILON);
		Assert.assertFalse(l.isEmpty());
    }
}
