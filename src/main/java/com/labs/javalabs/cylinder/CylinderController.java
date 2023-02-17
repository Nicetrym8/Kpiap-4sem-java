package com.labs.javalabs.cylinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.labs.javalabs.counter.CounterRequests;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CylinderController {

    private final CylinderBasicRepository repository;
    private final CounterRequests counter;

    public CylinderController(CylinderBasicRepository repository, CounterRequests counter) {
        this.repository = repository;
        this.counter = counter;
    }

    @GetMapping("/cylinder")
    public Cylinder cylinder(@RequestParam(value = "height", defaultValue = "1") double height,
            @RequestParam(value = "radius", defaultValue = "1") double radius) {
        counter.increment();
        final var cylinder = repository.getByInputValues(new CylinderRequestParams(radius, height));
        return cylinder;
    }

    @PostMapping("/cylinder")
    public ResponseEntity<?> cylinderBulk(@RequestBody List<CylinderRequestParams> body) {
        counter.increment();
        List<Cylinder> result = new ArrayList<>();
        body.forEach((el) -> {
            result.add(repository.getByInputValues(el));
        });

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
