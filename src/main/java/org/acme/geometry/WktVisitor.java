package org.acme.geometry;

public class WktVisitor implements GeometryVisitor<String>{

    private StringBuilder buffer;

    public WktVisitor() {
        this.buffer = new StringBuilder();
    }

    @Override
    public String visit(Point point) {
        if (point.isEmpty()) buffer.append("POINT EMPTY");
        else buffer.append("POINT(" + point.getCoordinate().getX() + 
            " " + point.getCoordinate().getY() + ")");
        return buffer.toString();
    }

    @Override
    public String visit(LineString lineString) {
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
        return buffer.toString();
    }

    public String getResult(){
        return buffer.toString();
    }

    @Override
    public String visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()) buffer.append("GEOMETRYCOLLECTION EMPTY");
        else {
            buffer.append("GEOMETRYCOLLECTION(");
            Geometry firstGeometry = geometryCollection.getGeometryN(0);
            firstGeometry.accept(this);
            for (int k = 1; k < geometryCollection.getNumGeometries(); k++){
                buffer.append(",");
                Geometry geometry = geometryCollection.getGeometryN(k);
                geometry.accept(this);
            }
            buffer.append(")");
        }
        return buffer.toString();
    }
}
