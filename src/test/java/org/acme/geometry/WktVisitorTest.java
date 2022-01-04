package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

    @Test
    public void testVisitEmptyPoint(){
        Point p = new Point();

        WktVisitor visitor = new WktVisitor();
        p.accept(visitor);

        Assert.assertEquals("POINT EMPTY", visitor.getResult());
    }

    @Test
    public void testVisitPoint(){
        Point p = SampleFactory.createPointA();

        WktVisitor visitor = new WktVisitor();
        p.accept(visitor);

        Assert.assertEquals("POINT(3.14 2.72)", visitor.getResult());
    }

    @Test
    public void testVisitEmptyLineString(){
        LineString l = new LineString();

        WktVisitor visitor = new WktVisitor();
        l.accept(visitor);

        Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
    }

    @Test
    public void testVisitLineString(){
        LineString l = SampleFactory.createLineStringAB();

        WktVisitor visitor = new WktVisitor();
        l.accept(visitor);

        Assert.assertEquals("LINESTRING(3.14 2.72,31.4 27.2)", visitor.getResult());
    }

    @Test
    public void testVisitEmptyGeometryCollection(){
        GeometryCollection g = new GeometryCollection();

        WktVisitor visitor = new WktVisitor();
        g.accept(visitor);

        Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", visitor.getResult());
    }

    @Test
    public void testVisitGeometryCollection(){
        GeometryCollection g = SampleFactory.createGeometryCollection();

        WktVisitor visitor = new WktVisitor();
        g.accept(visitor);

        Assert.assertEquals(
            "GEOMETRYCOLLECTION(POINT(3.14 2.72),POINT(31.4 27.2),LINESTRING(3.14 2.72,31.4 27.2))",
             visitor.getResult());
    }
}