package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor{

    protected Envelope envelope;

    public EnvelopeBuilder() {
        this.envelope = new Envelope();
    }

    public void insert(Coordinate coordinate){
        if (this.envelope.isEmpty()) this.envelope = new Envelope(coordinate, coordinate);
        else {
            if (this.envelope.getXmin() > coordinate.getX()){
                Coordinate topRight = new Coordinate(this.envelope.getXmax(),this.envelope.getYmax());
                if (this.envelope.getYmin() > coordinate.getY())
                this.envelope = new Envelope(coordinate, topRight);
                else {
                    Coordinate bottomLeft = new Coordinate(coordinate.getX(),this.envelope.getYmin());
                    this.envelope = new Envelope(bottomLeft, topRight);
                }
            }

            else if (this.envelope.getYmin() > coordinate.getY()){
                Coordinate topRight = new Coordinate(this.envelope.getXmax(),this.envelope.getYmax());
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(), coordinate.getY());
                this.envelope = new Envelope(bottomLeft, topRight);
            }

            if (this.envelope.getXmax() < coordinate.getX()) {
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(),this.envelope.getYmin());
                if (this.envelope.getYmax() < coordinate.getY())
                this.envelope = new Envelope(bottomLeft, coordinate);
                else {
                    Coordinate topRight = new Coordinate(coordinate.getX(),this.envelope.getYmax());
                    this.envelope = new Envelope(bottomLeft, topRight);
                }
            }

            else if (this.envelope.getYmax() < coordinate.getY()){
                Coordinate bottomLeft = new Coordinate(this.envelope.getXmin(),this.envelope.getYmin());
                Coordinate topRight = new Coordinate(this.envelope.getXmax(), coordinate.getY());
                this.envelope = new Envelope(bottomLeft, topRight);
            }
        }
    }

    public Envelope build(){
        return this.envelope;
    }

    @Override
    public void visit(Point point) {
        this.insert(point.getCoordinate());
    }

    @Override
    public void visit(LineString lineString) {
        for (int k = 0; k < lineString.getNumPoints(); k++){
            Point point = lineString.getPointN(k);
            this.insert(point.getCoordinate());
        }
    }
}
