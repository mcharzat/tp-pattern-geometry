package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry{

    private List<GeometryListener> listeners = new ArrayList<GeometryListener>();

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);

        return visitor.getResult();
    }

    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        this.accept(builder);

        return builder.build();
    }

    public abstract Geometry clone();

    @Override
    public void addListener(GeometryListener listener) {
        this.listeners.add(listener);
    }

    protected void triggerChange(){
        for (GeometryListener listener : listeners) listener.onChange(this);
    }
}
