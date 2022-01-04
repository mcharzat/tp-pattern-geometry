package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryCollectionTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor(){
        GeometryCollection geometryCollection = new GeometryCollection();

        Assert.assertTrue(geometryCollection.isEmpty());
    }

    @Test
    public void testConstructor(){
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        Assert.assertFalse(geometryCollection.isEmpty());
        Assert.assertEquals(3, geometryCollection.getNumGeometries());
    }

    @Test
    public void testAdd() {
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        Assert.assertEquals(3, geometryCollection.getNumGeometries());

        

        geometryCollection.add(geometryCollection);
        Assert.assertEquals(4, geometryCollection.getNumGeometries());
    }

    @Test
    public void testClone() {
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        GeometryCollection copy = (GeometryCollection) geometryCollection.clone();

        Assert.assertEquals(geometryCollection.getNumGeometries(), copy.getNumGeometries());
        Assert.assertTrue(geometryCollection != copy);
    }

    @Test
    public void testRemove() {
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        Assert.assertEquals(3, geometryCollection.getNumGeometries());

        geometryCollection.remove(0);
        Assert.assertEquals(2, geometryCollection.getNumGeometries());

        geometryCollection.remove(geometryCollection.getGeometryN(0));
        Assert.assertEquals(1, geometryCollection.getNumGeometries());
    }

    @Test
    public void testTranslate() {
        GeometryCollection geometryCollection = SampleFactory.createGeometryCollection();

        Envelope envelope = geometryCollection.getEnvelope();
        Assert.assertEquals(3.14, envelope.getXmin(), EPSILON);
        Assert.assertEquals(2.72, envelope.getYmin(), EPSILON);
        Assert.assertEquals(31.4, envelope.getXmax(), EPSILON);
        Assert.assertEquals(27.2, envelope.getYmax(), EPSILON);

        geometryCollection.translate(10.0, 10.0);
        Envelope envelope2 = geometryCollection.getEnvelope();

        Assert.assertEquals(13.14, envelope2.getXmin(), EPSILON);
        Assert.assertEquals(12.72, envelope2.getYmin(), EPSILON);
        Assert.assertEquals(41.4, envelope2.getXmax(), EPSILON);
        Assert.assertEquals(37.2, envelope2.getYmax(), EPSILON);
    }
}
