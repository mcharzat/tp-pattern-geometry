package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWriterFactoryTest {
    
    @Test
    public void testCreateGeometryWriter() {
        Point point = SampleFactory.createPointA();
        GeometryWriterFactory writerFactory = new GeometryWriterFactory();

        String formatName = "WKT";
        GeometryWriter writer = writerFactory.createGeometryWriter(formatName);
        Assert.assertEquals("POINT(3.14 2.72)", writer.write(point));

        String formatName2 = "GeoJSON";
        GeometryWriter writer2 = writerFactory.createGeometryWriter(formatName2);
        Assert.assertEquals("{'type':'Point'}", writer2.write(point));
    }
}
