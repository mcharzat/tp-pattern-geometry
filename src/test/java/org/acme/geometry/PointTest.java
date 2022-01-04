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

    @Test
    public void testClone() {
        Point p = SampleFactory.createPointA();

        Point copy = (Point) p.clone();
        p.translate(10.0, 10.0);
        Assert.assertEquals(13.14, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(12.72, p.getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.14, copy.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(2.72, copy.getCoordinate().getY(), EPSILON);
        Assert.assertTrue(p != copy);
    }

    @Test
    public void testGetEnvelope() {
        Point p = SampleFactory.createPointA();

        Envelope envelope = p.getEnvelope();
        Assert.assertEquals(3.14, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmin(), EPSILON);
        Assert.assertEquals(3.14, envelope.getXmax(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmax(), EPSILON);
    }

    @Test
    public void testAsText(){
        Point p = SampleFactory.createPointA();

        Assert.assertEquals("POINT(3.14 2.72)", p.asText());
    }
}
