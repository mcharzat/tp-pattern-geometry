package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {
    
    public WktWriter wktWriter = new WktWriter();

    @Test
    public void testWriteEmptyPoint() {
        Point p = new Point();
        
        Assert.assertEquals("POINT EMPTY", wktWriter.write(p));
    }

    @Test
    public void testWritePoint() {
        Point p = SampleFactory.createPointA();
        
        Assert.assertEquals("POINT(3.14 2.72)", wktWriter.write(p));
    }

    @Test
    public void testWriteEmptyLineString() {
        LineString l = new LineString();
        
        Assert.assertEquals("LINESTRING EMPTY", wktWriter.write(l));
    }

    @Test
    public void testWriteLineString() {
        LineString l = SampleFactory.createLineStringAB();
        
        Assert.assertEquals("LINESTRING(3.14 2.72,31.4 27.2)", wktWriter.write(l));
    }
}
