package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor<Void>{

    private PrintStream out;

    public LogGeometryVisitor() {
        this.out = System.out;
    }

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }

    @Override
    public Void visit(Point point) {
        out.println( "Je suis un point avec x=" + point.getCoordinate().getX() +
            " et y=" + point.getCoordinate().getY());
        return null;
    }

    @Override
    public Void visit(LineString lineString) {
        out.println( "Je suis une polyligne défini par " + 
            lineString.getNumPoints() + " point(s).");
        return null;
    }

    @Override
    public Void visit(GeometryCollection geometryCollection) {
        out.println( "Je suis une collection de géométries contenant " + 
            geometryCollection.getNumGeometries() + " géométrie(s).");
        return null;
    }
}
