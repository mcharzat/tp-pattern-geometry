package org.acme.geometry;

public class GeoJSONWriter implements GeometryWriter{

    public GeoJSONWriter() {
    }

    @Override
    public String getName() {
        return "GeoJSON";
    }

    @Override
    public String write(Geometry geometry) {
        String geoJson = "";

        if ( geometry instanceof Point ) geoJson = "{'type':'Point'}";
        else if ( geometry instanceof LineString ) geoJson = "{'type':'LineString'}";
        else if ( geometry instanceof GeometryCollection ) geoJson = "{'type':'GeometryCollection'}";
        return geoJson;
    }
}