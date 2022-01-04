package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry{

    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        this.points = points;
    }
    
    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }

    @Override
    public String getType() {
        return "LineString";
    }

    @Override
    public boolean isEmpty() {
        return getNumPoints() == 0;
    }

    @Override
    public void translate(double dx, double dy) {
        for (Point point : points){
            point.translate(dx, dy);
        }

        this.triggerChange();
    }

    @Override
    public Geometry clone(){
        List<Point> newPoints = new ArrayList<Point>();
        for (Point point : points){
            Point newPoint = (Point) point.clone();
            newPoints.add(newPoint);
        }
        return new LineString(newPoints);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);        
    }
}
