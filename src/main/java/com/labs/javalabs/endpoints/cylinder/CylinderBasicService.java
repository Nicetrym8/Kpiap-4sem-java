package com.labs.javalabs.endpoints.cylinder;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.labs.javalabs.endpoints.cylinder.data.Cylinder;
import com.labs.javalabs.endpoints.cylinder.data.CylinderRequestParams;

import com.labs.javalabs.models.cylinder.CylinderEntity;
import com.labs.javalabs.models.cylinder.CylinderEntityRepository;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

@Service
public class CylinderBasicService {
    private static final Logger logger = LogManager.getLogger(CylinderBasicService.class);
    private final CylinderEntityRepository repository;

    public CylinderBasicService(CylinderEntityRepository repository) {
        this.repository = repository;
    }

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
        logger.info(String.format("Request params: height=%f radius=%f", params.height(), params.radius()));
        var cylinderEntity = repository.findEntityByHeightAndRadius(params.height(), params.radius());
        if (cylinderEntity == null) {
            cylinderEntity = new CylinderEntity(params);
            repository.save(cylinderEntity);
            logger.info("Cylinder value saved to DB");
        }
        logger.info("Cylinder value cached");
        return new Cylinder(cylinderEntity);
    }
}
