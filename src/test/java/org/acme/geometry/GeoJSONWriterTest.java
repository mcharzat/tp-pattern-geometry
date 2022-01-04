package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeoJSONWriterTest {

    public GeoJSONWriter geoJSONWriter = new GeoJSONWriter();

    @Test
    public void testWritePoint() {
        Point p = SampleFactory.createPointA();
        
        Assert.assertEquals("{'type':'Point'}", geoJSONWriter.write(p));
    }

    @Test
    public void testWriteLineString() {
        LineString l = SampleFactory.createLineStringAB();
        
        Assert.assertEquals("{'type':'LineString'}", geoJSONWriter.write(l));
    }

    @Test
    public void testWriteGeometryCollection() {
        GeometryCollection g = SampleFactory.createGeometryCollection();
        
        Assert.assertEquals("{'type':'GeometryCollection'}", geoJSONWriter.write(g));
    }
}
