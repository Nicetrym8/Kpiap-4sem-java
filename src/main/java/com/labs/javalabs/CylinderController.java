package com.labs.javalabs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Math;

@RestController
public class CylinderController {
    @GetMapping("/cylinder")
    public Cylinder cylinder(@RequestParam(value = "height", defaultValue = "1") double height,
            @RequestParam(value = "radius", defaultValue = "1") double radius) {
        return new Cylinder(Math.PI * radius * radius * height);
    }
}
