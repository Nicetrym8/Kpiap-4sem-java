package com.labs.javalabs.cylinder;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public record Cylinder(double volume) {
    private static final Logger logger = LogManager.getLogger(Cylinder.class);

    public Cylinder(double radius, double height) {
        this(Math.PI * radius * radius * height);
        if (Double.isNaN(this.volume) || Double.isInfinite(this.volume))
            throw new CylinderNumberBoundsException(
                    String.format("Out of calculations bounds: value=%f", this.volume));
        logger.info("Cylinder Response Calculation Succeed");
    }
}