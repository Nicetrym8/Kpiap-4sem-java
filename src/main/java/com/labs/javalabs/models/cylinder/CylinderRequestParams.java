package com.labs.javalabs.models.cylinder;

public record CylinderRequestParams(double radius, double height) {

    public Cylinder getCylinder() {
        return new Cylinder(radius, height);
    }
}
