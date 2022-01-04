package org.acme.geometry;

public class GeometryWriterFactory {
    
    public GeometryWriterFactory() {
    }

    public GeometryWriter createGeometryWriter(String formatName){
        if (formatName == "WKT") return new WktWriter();
        else if (formatName == "GeoJSON") return new GeoJSONWriter();
        else throw new RuntimeException("format not supported");
    }
}
