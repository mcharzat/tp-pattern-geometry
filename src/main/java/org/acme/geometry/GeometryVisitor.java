package org.acme.geometry;

public interface GeometryVisitor<T> {

    public T visit(Point point);
    public T visit(LineString lineString);
    public T visit(GeometryCollection geometryCollection);
}
