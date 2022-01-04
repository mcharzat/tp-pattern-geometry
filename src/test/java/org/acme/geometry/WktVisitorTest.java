package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

    @Test
    public void testVisitEmptyPoint(){
        Point p = new Point();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals("POINT EMPTY", p.accept(visitor));
    }

    @Test
    public void testVisitPoint(){
        Point p = SampleFactory.createPointA();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals("POINT(3.14 2.72)", p.accept(visitor));
    }

    @Test
    public void testVisitEmptyLineString(){
        LineString l = new LineString();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals("LINESTRING EMPTY", l.accept(visitor));
    }

    @Test
    public void testVisitLineString(){
        LineString l = SampleFactory.createLineStringAB();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals("LINESTRING(3.14 2.72,31.4 27.2)", l.accept(visitor));
    }

    @Test
    public void testVisitEmptyGeometryCollection(){
        GeometryCollection g = new GeometryCollection();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", g.accept(visitor));
    }

    @Test
    public void testVisitGeometryCollection(){
        GeometryCollection g = SampleFactory.createGeometryCollection();

        WktVisitor visitor = new WktVisitor();

        Assert.assertEquals(
            "GEOMETRYCOLLECTION(POINT(3.14 2.72),POINT(31.4 27.2),LINESTRING(3.14 2.72,31.4 27.2))",
            g.accept(visitor));
    }
}