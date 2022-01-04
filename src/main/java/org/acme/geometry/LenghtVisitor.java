package org.acme.geometry;

public class LenghtVisitor implements GeometryVisitor<Double> {

    public LenghtVisitor() {
    }

    @Override
    public Double visit(Point point) {
        return 0.0;
    }

    @Override
    public Double visit(LineString lineString) {
        return null;        
    }

    @Override
    public Double visit(GeometryCollection geometryCollection) {
        return null;
    }
}