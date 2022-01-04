package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{

    private PrintStream out;

    public LogGeometryVisitor() {
        this.out = System.out;
    }

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }

    @Override
    public void visit(Point point) {
        out.println( "Je suis un point avec x=" + point.getCoordinate().getX() +
            " et y=" + point.getCoordinate().getY());
    }

    @Override
    public void visit(LineString lineString) {
        out.println( "Je suis une polyligne défini par " + 
            lineString.getNumPoints() + " point(s).");
    }
}
