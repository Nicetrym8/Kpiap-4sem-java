package com.labs.javalabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;

import java.lang.Math;

@RestController
public class CylinderController {

    private Logger logger = LogManager.getLogger(LogBuilder.class);

    @GetMapping("/cylinder")
    public Cylinder cylinder(@RequestParam(value = "height", defaultValue = "1") double height,
            @RequestParam(value = "radius", defaultValue = "1") double radius) {
        double volume = Math.PI * radius * radius * height;
        if (Double.isNaN(volume) || Double.isInfinite(volume))
            throw new CylinderNumberBoundsException(String.format("Out of calculations bounds: value=%f", volume));
        logger.info(String.format("Cylinder Response value: volume=%f", volume));
        return new Cylinder(volume);
    }
}
