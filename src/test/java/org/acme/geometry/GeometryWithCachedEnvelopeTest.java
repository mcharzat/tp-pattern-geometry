package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {

    @Test
    public void testCachedEnvelope() {
        Point point = SampleFactory.createPointB();
        Geometry cachedGeometry = new GeometryWithCachedEnvelope(point);
        Envelope a = cachedGeometry.getEnvelope();
        Envelope b = cachedGeometry.getEnvelope();
        Assert.assertSame(a,b);
    }
}
