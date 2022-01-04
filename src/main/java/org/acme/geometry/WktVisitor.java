package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{

    private StringBuilder buffer;

    public WktVisitor() {
        this.buffer = new StringBuilder();
    }

    @Override
    public void visit(Point point) {
        if (point.isEmpty()) buffer.append("POINT EMPTY");
        else buffer.append("POINT(" + point.getCoordinate().getX() + 
            " " + point.getCoordinate().getY() + ")");
    }

    @Override
    public void visit(LineString lineString) {
        if (lineString.isEmpty()) buffer.append("LINESTRING EMPTY");
        else {
            Point firstPoint = lineString.getPointN(0);
            buffer.append("LINESTRING(" + firstPoint.getCoordinate().getX() + 
                " " + firstPoint.getCoordinate().getY());
            for (int k = 1; k < lineString.getNumPoints(); k++){
                Point point = lineString.getPointN(k);
                buffer.append("," + point.getCoordinate().getX() + 
                    " " + point.getCoordinate().getY());
            }
            buffer.append(")");
        }
    }

    public String getResult(){
        return buffer.toString();
    }
}
