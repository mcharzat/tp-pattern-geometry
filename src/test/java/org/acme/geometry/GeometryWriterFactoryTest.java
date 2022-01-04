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
    }
}
