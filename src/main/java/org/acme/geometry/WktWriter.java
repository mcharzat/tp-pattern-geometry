package org.acme.geometry;

public class WktWriter implements GeometryWriter{

    public WktWriter() {
    }

    @Override
    public String getName(){
        return "WKT";
    }

    @Override
    public String write(Geometry geometry){
        String wkt = "";

        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            if (point.isEmpty()) wkt = "POINT EMPTY";
            else wkt = "POINT(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            if (lineString.isEmpty()) wkt = "LINESTRING EMPTY";
            else {
                Point firstPoint = lineString.getPointN(0);
                wkt = "LINESTRING(" + firstPoint.getCoordinate().getX() + " " + firstPoint.getCoordinate().getY();
                for (int k = 1; k < lineString.getNumPoints(); k++){
                    Point point = lineString.getPointN(k);
                    wkt += "," + point.getCoordinate().getX() + " " + point.getCoordinate().getY();
                }
                wkt += ")";
            }
        }else{
            throw new RuntimeException("geometry type not supported");
        }
        return wkt;
    }
}
