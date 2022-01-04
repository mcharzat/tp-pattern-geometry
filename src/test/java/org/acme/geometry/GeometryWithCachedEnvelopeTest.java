package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testCachedEnvelope() {
        Point point = SampleFactory.createPointB();
        Geometry cachedGeometry = new GeometryWithCachedEnvelope(point);
        Envelope a = cachedGeometry.getEnvelope();
        Envelope b = cachedGeometry.getEnvelope();
        Assert.assertSame(a,b);
    }

    @Test
    public void testListener(){
        LineString lineString = SampleFactory.createLineStringAB();

        GeometryWithCachedEnvelope cachedLineString = new GeometryWithCachedEnvelope(lineString);
        
        Envelope envelope1 = cachedLineString.getEnvelope();
        Assert.assertEquals(3.14, envelope1.getXmin(), EPSILON);

        lineString.translate(10.0, 10.0);
        Envelope envelope3 = cachedLineString.getEnvelope();
        Assert.assertEquals(13.14, envelope3.getXmin(), EPSILON);
    }
}