package com.labs.javalabs.endpoints.cylinder.data;

public record CylinderRequestParams(double radius, double height) {

    public Cylinder getCylinder() {
        return new Cylinder(radius, height);
    }
}
