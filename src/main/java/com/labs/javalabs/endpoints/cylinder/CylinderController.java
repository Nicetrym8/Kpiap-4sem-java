package com.labs.javalabs.endpoints.cylinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.labs.javalabs.endpoints.cylinder.data.CounterRequests;
import com.labs.javalabs.endpoints.cylinder.data.Cylinder;
import com.labs.javalabs.endpoints.cylinder.data.CylinderBulkResponse;
import com.labs.javalabs.endpoints.cylinder.data.CylinderRequestParams;
import com.labs.javalabs.endpoints.cylinder.data.StatsMapper;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
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
        List<Cylinder> calculations = new ArrayList<>();
        body.forEach((el) -> {
            calculations.add(repository.getByInputValues(el));
        });
        StatsMapper stats = new StatsMapper(calculations
                .stream()
                .map((x) -> x.volume())
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine));

        return new ResponseEntity<>(new CylinderBulkResponse(stats, calculations), HttpStatus.OK);
    }

}
