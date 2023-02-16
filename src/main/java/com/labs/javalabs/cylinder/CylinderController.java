package com.labs.javalabs.cylinder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labs.javalabs.counter.CounterRequests;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
public class CylinderController {

    private static final Logger logger = LogManager.getLogger(CylinderController.class);
    private final CylinderRepository repository;
    private final CounterRequests counter;

    public CylinderController(CylinderRepository repository, CounterRequests counter) {
        this.repository = repository;
        this.counter = counter;
    }

    @GetMapping("/cylinder")
    public Cylinder cylinder(@RequestParam(value = "height", defaultValue = "1") double height,
            @RequestParam(value = "radius", defaultValue = "1") double radius) {
        counter.increment();
        final var cylinder = repository.getByInputValues(radius, height);

        if (Double.isNaN(cylinder.volume()) || Double.isInfinite(cylinder.volume()))
            throw new CylinderNumberBoundsException(
                    String.format("Out of calculations bounds: value=%f", cylinder.volume()));
        logger.info(String.format("Cylinder Response value: volume=%f", cylinder.volume()));
        return cylinder;
    }
}
