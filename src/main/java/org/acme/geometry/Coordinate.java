package org.acme.geometry;

public class Coordinate {

    private final double x;
    private final double y;

    public Coordinate(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
