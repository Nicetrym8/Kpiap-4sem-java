package com.labs.javalabs.cylinder;

public record Cylinder(double volume) {
    public Cylinder(double radius, double height) {
        this(Math.PI * radius * radius * height);
    }
}