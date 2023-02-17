package com.labs.javalabs.endpoints.cylinder;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.labs.javalabs.models.cylinder.Cylinder;
import com.labs.javalabs.models.cylinder.CylinderRequestParams;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
public class CylinderBasicRepository {
    private static final Logger logger = LogManager.getLogger(Cylinder.class);

    @Cacheable("volumes")
    public Cylinder getByInputValues(CylinderRequestParams params) {

        // Slow down server
        /*
         * try {
         * long time = 3000L;
         * Thread.sleep(time);
         * } catch (InterruptedException e) {
         * throw new IllegalStateException(e);
         * }
         */
        logger.info("Cylinder value cached");
        return params.getCylinder();
    }
}
