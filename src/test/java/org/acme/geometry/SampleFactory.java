package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class SampleFactory {

    public static Point createPointA(){
        Coordinate c = new Coordinate(3.14, 2.72);

        return new Point(c);
    }

    public static Point createPointB(){
        Coordinate c = new Coordinate(31.4, 27.2);

        return new Point(c);
    }

    public static LineString createLineStringAB(){
        List<Point> points = new ArrayList<Point>();
        points.add(createPointA());
        points.add(createPointB());

        return new LineString(points);
    }

    public static GeometryCollection createGeometryCollection(){
        List<Geometry> geometries = new ArrayList<Geometry>();
        geometries.add(createPointA());
        geometries.add(createPointB());
        geometries.add(createLineStringAB());
        
        return new GeometryCollection(geometries);
    }
    
}
