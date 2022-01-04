package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener{

    private Geometry original;
    private Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original, Envelope cachedEnvelope) {
        this.original = original;
        this.cachedEnvelope = cachedEnvelope;
    }

    public GeometryWithCachedEnvelope(Geometry original) {
        this.original = original;
        this.cachedEnvelope = new Envelope();
    }

    @Override
    public String getType() {
        return original.getType();
    }

    @Override
    public boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        original.translate(dx, dy);        
    }

    @Override
    public Envelope getEnvelope() {
        if (this.cachedEnvelope.isEmpty()) this.cachedEnvelope = this.original.getEnvelope();
        return this.cachedEnvelope;
    }

    @Override
    public Geometry clone() {
        return new GeometryWithCachedEnvelope(original.clone(), cachedEnvelope.clone());
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        original.accept(visitor);        
    }

    @Override
    public void addListener(GeometryListener listener) {
        original.addListener(listener);
    }

    @Override
    public void onChange(Geometry geometry) {
        this.cachedEnvelope = this.original.getEnvelope();
    }
}
