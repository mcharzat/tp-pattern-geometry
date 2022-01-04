package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testClone(){
        Point point = SampleFactory.createPointA();

        Envelope envelope = new Envelope(point.getCoordinate(), point.getCoordinate());
        Envelope copy = envelope.clone();
        Assert.assertEquals(envelope.getXmin(), copy.getXmin(), EPSILON);
        Assert.assertEquals(envelope.getYmin(), copy.getYmin(), EPSILON);
        Assert.assertTrue(envelope != copy);
    }
}
