package com.labs.javalabs.cylinder;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CylinderBasicRepository implements CylinderRepository {
    @Override
    @Cacheable("volumes")
    public Cylinder getByInputValues(double radius, double height) {
        // Slow down server
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return new Cylinder(radius, height);
    }
}
