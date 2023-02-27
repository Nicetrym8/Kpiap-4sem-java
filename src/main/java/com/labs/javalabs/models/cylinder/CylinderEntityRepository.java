package com.labs.javalabs.models.cylinder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CylinderEntityRepository extends CrudRepository<CylinderEntity, Long> {
    CylinderEntity getEntityById(long id);

    CylinderEntity findEntityByHeightAndRadius(Double height, Double radius);

}
