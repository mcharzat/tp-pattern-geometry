package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnveloppeBuilderTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testBuilder() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(0.0,1.0));
        builder.insert(new Coordinate(2.0,0.0));
        builder.insert(new Coordinate(1.0,3.0));
        Envelope result = builder.build();

        Assert.assertEquals(0.0, result.getXmin(), EPSILON);
        Assert.assertEquals(0.0, result.getYmin(), EPSILON);
        Assert.assertEquals(2.0, result.getXmax(), EPSILON);
        Assert.assertEquals(3.0, result.getYmax(), EPSILON);
    }

    @Test
    public void testVisitPoint(){
        Point point = SampleFactory.createPointA();
        EnvelopeBuilder builder = new EnvelopeBuilder();

        Envelope envelope = builder.visit(point);

        Assert.assertEquals(3.14, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmin(), EPSILON);
    }

    @Test
    public void testVisitLineString(){
        LineString lineString = SampleFactory.createLineStringAB();
        EnvelopeBuilder builder = new EnvelopeBuilder();

        Envelope envelope = builder.visit(lineString);

        Assert.assertEquals(3.14, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmin(), EPSILON);
        Assert.assertEquals(31.4, envelope.getXmax(), EPSILON);
        Assert.assertEquals(27.2, envelope.getYmax(), EPSILON);
    }

    @Test
    public void testVisitGeometryCollection(){
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();
        EnvelopeBuilder builder = new EnvelopeBuilder();

        Envelope envelope = builder.visit(geometryCollection);

        Assert.assertEquals(3.14, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmin(), EPSILON);
        Assert.assertEquals(31.4, envelope.getXmax(), EPSILON);
        Assert.assertEquals(27.2, envelope.getYmax(), EPSILON);
    }
}
