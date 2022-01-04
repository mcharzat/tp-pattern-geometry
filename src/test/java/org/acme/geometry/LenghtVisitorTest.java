package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class LenghtVisitorTest {

    private LenghtVisitor visitor = new LenghtVisitor();
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testVisitPoint() {
        Point point = SampleFactory.createPointA();
        
        double lenght = visitor.visit(point);
        Assert.assertEquals(0.0, lenght, EPSILON);
    }

    @Test
    public void testVisitLineString() {
        LineString lineString = SampleFactory.createLineStringAB();

        Assert.assertNull(visitor.visit(lineString));
    }

    @Test
    public void testVisitGeometryCollection() {
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        Assert.assertNull(visitor.visit(geometryCollection));
    }
}
