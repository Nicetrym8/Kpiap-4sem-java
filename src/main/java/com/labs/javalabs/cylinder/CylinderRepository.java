package com.labs.javalabs.cylinder;

public interface CylinderRepository {
    public Cylinder getByInputValues(double radius, double height);
}
